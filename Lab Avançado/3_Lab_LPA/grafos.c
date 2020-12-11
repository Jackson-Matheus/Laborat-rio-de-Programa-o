#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>

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

    lista_vizinhos_t **lista;
};
typedef struct tNo no_t;
typedef no_t *grafo_t;

/*
    Declaração antecipada das funções  a serem utilizdas
*/

grafo_t grafo_criar(int tam);
bool lista_vizinhos_adicionar(int vizinho, lista_vizinhos_t **lista);
bool grafo_atualizar_vizinhos(int tam, double raio_comunicacao, grafo_t grafo);
void lista_vizinhos_imprimir(lista_vizinhos_t *lista);
void grafo_imprimir(int tam, grafo_t grafo);

bool lista_vizinhos_adicionar(int vizinho, lista_vizinhos_t **lista)
{

    //Aloca novo item
    lista_vizinhos_t *item_novo = malloc(sizeof(lista_vizinhos_t));
    if (item_novo == NULL)
    {
        return false;
    }

    //Adiciona no inici da lista
    item_novo->id = vizinho;
    item_novo->prox = *lista;
    *lista = item_novo;

    return true;
}

//Imprime a lista de vizinhos de um indice  [i]
void lista_vizinhos_imprimir(lista_vizinhos_t *lista)
{

    int i = 0;
    lista_vizinhos_t *novo = malloc(sizeof(lista_vizinhos_t));

    if (novo == NULL)
    {
        printf("ERRO ao alocar memoria\n");
    }
    else
    {
        for (novo = lista; novo != NULL; novo = novo->prox)
        {
            printf("%d ", novo->id);
        }
        printf("\n");

        free(novo);
    }
}

//Criar grafo com tamanho: tam
grafo_t grafo_criar(int tam)
{
    grafo_t GRAFO = malloc(sizeof(no_t) * tam);

    if (GRAFO == NULL)
    {
        return NULL;
    }
    return GRAFO;
}

//Inserir viziznhos pra cada elemento do grafo
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

void grafo_imprimir(int tam, grafo_t grafo)
{

    for (int i = 0; i < tam; i++)
    {
        if (grafo[i].lista != NULL)
        {
            printf("NO %d:  ", grafo[i].id);
            lista_vizinhos_imprimir(*grafo[i].lista);
        }
        else
        {
            printf("NO %d:  VAZIO\n", i);
        }
    };
}

//Desaloca memoria utiliziada
void free_(int tam, grafo_t grafo)
{

    for (int i = 0; i < tam; i++)
    {
        if (grafo[i].lista != NULL)
        {
            lista_vizinhos_t *novo = *grafo[i].lista;

            while (novo != NULL)
            {
                lista_vizinhos_t *f = novo;
                novo = novo->prox;
                free(f);
            }
        }
        free(grafo[i].lista);
    }

    free(grafo);
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

        if (GRAFO != NULL)
        {

            printf("Tam %d\t Raio %.2lf \n", tam, raio);
            for (int i = 0; i < tam; i++)
            {
                no_t a;
                int id = 0;
                double x = 0, y = 0;
                fscanf(pont_arq_read, "%d\t%lf\t%lf\n", &id, &x, &y);
                a.id = id;
                a.x = x;
                a.y = y;
                GRAFO[i] = a;
                GRAFO[i].lista = NULL;
            }

            bool atualizou = grafo_atualizar_vizinhos(tam, raio, GRAFO);
            if (!atualizou)
            {
                printf("ERRO ao alocar memoria\n");
                return 0;
            }

            grafo_imprimir(tam, GRAFO);
            free_(tam, GRAFO);
        }
        else
        {
            printf("ERRO ao alocar memoria\n");
        }
    }

    return 0;
}
