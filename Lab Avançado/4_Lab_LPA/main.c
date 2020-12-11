#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>

//Grafo
struct tlista_vizinhos_t
{
    int id;
    struct tlista_vizinhos_t *prox;
};
typedef struct tlista_vizinhos_t lista_vizinhos_t;

struct tNo
{
    int id;
    double x, y;
    bool pacote_enviado;

    lista_vizinhos_t **lista;
};

typedef struct tNo no_t;
typedef no_t *grafo_t;

//Evento

struct tevento_t
{
    double tempo;
    int alvo;
    int tipo;
};

typedef struct tevento_t evento_t;

struct tlista_eventos_t
{
    evento_t *evento;
    struct tlista_eventos_t *prox_evento;
};
typedef struct tlista_eventos_t lista_eventos_t;

bool lista_eventos_adicionar_ordenado(evento_t *evento, lista_eventos_t **lista)
{
    if (*lista == NULL)
    {

        lista_eventos_t *item_novo = malloc(sizeof(lista_eventos_t));
        if (item_novo == NULL)
            return false;

        item_novo->evento = evento;
        item_novo->prox_evento = NULL;
        *lista = item_novo;
        return true;
    }
    /*
        Corrigido inserção ordenada:
        - Com apenas um elemento [OK]
        
    */
    lista_eventos_t *item_atual = *lista;
    lista_eventos_t *item_novo = malloc(sizeof(lista_eventos_t));
    if (item_atual->prox_evento == NULL)
    {
        if (item_novo == NULL || item_atual == NULL)
        {
            printf("Falha ao alocar memória");
            return false;
        }
        item_novo->evento = evento;
        if (evento->tempo < item_atual->evento->tempo)
        {
            item_novo->prox_evento = item_atual;
            *lista = item_novo;
            item_atual->prox_evento = NULL;

            return true;
        }

        item_atual->prox_evento = item_novo;
        return true;
    }

    for (; item_atual->prox_evento != NULL && item_atual->prox_evento->evento->tempo < evento->tempo; item_atual = item_atual->prox_evento)
        ;

    if (item_novo == NULL)
    {
        printf("Falha ao alocar memória");
        return false;
    }
    item_novo->evento = evento;
    item_novo->prox_evento = item_atual->prox_evento;
    item_atual->prox_evento = item_novo;

    return true;
}

bool lista_vizinhos_adicionar(int vizinho, lista_vizinhos_t **lista)
{

    //Aloca novo item
    lista_vizinhos_t *item_novo = malloc(sizeof(lista_vizinhos_t));
    if (item_novo == NULL)
    {
        return false;
    }

    //Adiciona no inicio da lista
    item_novo->id = vizinho;
    item_novo->prox = *lista;
    *lista = item_novo;

    return true;
}

grafo_t grafo_criar(int tam)
{
    grafo_t GRAFO = malloc(sizeof(no_t) * tam);

    if (GRAFO == NULL)
    {
        printf("Falha ao alocar memória");

        return NULL;
    }
    return GRAFO;
}

bool grafo_atualizar_vizinhos(int tam, double raio_comunicacao, grafo_t grafo)
{
    for (int i = 0; i < tam; i++)
    {
        for (int j = 0; j < tam; j++)
        {
            if (i != j)
            {
                double distancia = pow(grafo[i].x - grafo[j].x, 2) + pow(grafo[i].y - grafo[j].y, 2);
                distancia = sqrt(distancia);

                if (distancia < raio_comunicacao)
                {

                    //Verifica se ainda não existe lista de adjacências
                    if (grafo[j].lista == NULL)
                    {
                        lista_vizinhos_t **l = (lista_vizinhos_t **)malloc(sizeof(lista_vizinhos_t **));
                        if (l == NULL)
                        {
                            return false;
                        }
                        grafo[j].lista = l;
                    }
                    int id = grafo[i].id;

                    //Garante que um item foi inserido
                    bool inseriu = lista_vizinhos_adicionar(id, grafo[j].lista);
                    while (!inseriu)
                    {
                        inseriu = lista_vizinhos_adicionar(id, grafo[j].lista);
                    }
                }
            }
        }
    }

    return true;
}

void free_(int tam, grafo_t grafo)
{

    for (int i = 0; i < tam; i++)
    {
        if (grafo[i].lista != NULL)
        {
            lista_vizinhos_t *novo = *grafo[i].lista;

            while (novo != NULL)
            {
                lista_vizinhos_t *vizinho = novo;
                novo = novo->prox;
                free(vizinho);
            }
        }
        free(grafo[i].lista);
    }
    free(grafo);
}

void simulacao_iniciar(lista_eventos_t **lista, int tam, grafo_t grafo)
{
    while (*lista != NULL)
    {
        lista_eventos_t *elemento_inicio_lista = malloc(sizeof(lista_eventos_t));

        if (elemento_inicio_lista == NULL)
        {
            printf("ERRO ao alocar memoria\n");
            return;
        }

        elemento_inicio_lista = *lista;
        *lista = elemento_inicio_lista->prox_evento;
        elemento_inicio_lista->prox_evento = NULL;

        double tempo = elemento_inicio_lista->evento->tempo;
        int alvo = elemento_inicio_lista->evento->alvo;
        printf("[%3.6f] Nó %d recebeu pacote\n", tempo, alvo);

        lista_vizinhos_t *vizinho = malloc(sizeof(lista_vizinhos_t));
        if (vizinho == NULL)
        {
            printf("ERRO ao alocar memoria\n");
            return;
        }

        if (!grafo[alvo].pacote_enviado)
        {
            for (vizinho = *grafo[alvo].lista; vizinho != NULL; vizinho = vizinho->prox)
            {
                printf("--> Repassando pacote para o nó %d ... \n", vizinho->id);
                evento_t *novo = (evento_t *)malloc(sizeof(evento_t));
                if (novo == NULL)
                {
                    printf("ERRO ao alocar memoria\n");
                    return;
                }
                novo->alvo = vizinho->id;
                novo->tipo = 1;
                novo->tempo = tempo + (0.1 + (vizinho->id * 0.01));

                bool inseriu = lista_eventos_adicionar_ordenado(novo, lista);

                while (!inseriu)
                {
                    inseriu = lista_eventos_adicionar_ordenado(novo, lista);
                }
            }
            grafo[alvo].pacote_enviado = true;
        }

        free(vizinho);
        free(elemento_inicio_lista);
    }
}

int main(int argc, char *argv[])
{

    FILE *pont_arq_read = fopen(argv[1], "r");
    if (pont_arq_read == NULL)
    {
        printf("ERRO! O arquivo não foi aberto!\n");
    }
    else
    {
        int tam = 0;
        double raio = 0.0;

        fscanf(pont_arq_read, "%d\t%lf\n", &tam, &raio);
        grafo_t GRAFO = grafo_criar(tam);

        if (GRAFO == NULL)
        {
            printf("ERRO ao alocar memoria\n");
            return 0;
        }
        for (int i = 0; i < tam; i++)
        {
            no_t novo_elemento;
            int id = 0;
            double x = 0, y = 0;
            fscanf(pont_arq_read, "%d\t%lf\t%lf\n", &id, &x, &y);
            novo_elemento.id = id;
            novo_elemento.x = x;
            novo_elemento.y = y;
            novo_elemento.pacote_enviado = false;

            GRAFO[i] = novo_elemento;
            GRAFO[i].lista = NULL;
        }

        bool atualizou = grafo_atualizar_vizinhos(tam, raio, GRAFO);
        if (!atualizou)
        {
            printf("ERRO ao alocar memoria\n");
            return 0;
        }
        //grafo_imprimir(tam, GRAFO);
        evento_t *novo = (evento_t *)malloc(sizeof(evento_t));
        lista_eventos_t **lista_eventos = (lista_eventos_t **)malloc(sizeof(lista_eventos_t));
        *lista_eventos = NULL;
        if (novo == NULL)
            return false;

        novo->alvo = 0;
        novo->tipo = 1;
        novo->tempo = 1.0;

        bool inseriu = lista_eventos_adicionar_ordenado(novo, lista_eventos);

        while (!inseriu)
        {
            inseriu = lista_eventos_adicionar_ordenado(novo, lista_eventos);
        }
        simulacao_iniciar(lista_eventos, tam, GRAFO);

        free_(tam, GRAFO);
    }

    return 0;
}