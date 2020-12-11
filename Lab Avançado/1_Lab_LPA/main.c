#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

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

bool lista_eventos_adicionar_inicio(evento_t *evento, lista_eventos_t **lista)
{

    lista_eventos_t *item_novo = malloc(sizeof(lista_eventos_t));
    if (item_novo == NULL)
        return false;

    item_novo->evento = evento;
    item_novo->prox_evento = *lista;
    *lista = item_novo;

    return true;
}

void lista_eventos_listar(lista_eventos_t *lista)
{

    if (lista == NULL)
    {
        printf("Lista vazia");
    }
    else
    {

        lista_eventos_t *novo = lista;
        for (; novo->prox_evento != NULL; novo = novo->prox_evento)
        {
            printf("TEMPO = %lf - ", novo->evento->tempo);
            printf("ALVO = %d - ", novo->evento->alvo);
            printf("TEMPO = %d\n", novo->evento->tipo);
        }

        printf("TEMPO = %lf - ", novo->evento->tempo);
        printf("ALVO = %d - ", novo->evento->alvo);
        printf("TEMPO = %d\n", novo->evento->tipo);
    }
}

bool lista_eventos_adicionar_fim(evento_t *evento, lista_eventos_t **lista)
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

    lista_eventos_t *novo = *lista;

    for (; novo->prox_evento != NULL; novo = novo->prox_evento)
        ;

    lista_eventos_t *item_novo = malloc(sizeof(lista_eventos_t));
    if (item_novo == NULL)
    {
        printf("Falha ao alocar memória");
        return false;
    }
    item_novo->evento = evento;
    item_novo->prox_evento = NULL;
    novo->prox_evento = item_novo;
    return true;
}

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

    lista_eventos_t *item_atual = *lista;

    for (; item_atual->prox_evento != NULL && item_atual->prox_evento->evento->tempo < evento->tempo; item_atual = item_atual->prox_evento)
        ;

    lista_eventos_t *item_novo = malloc(sizeof(lista_eventos_t));
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

bool gerar_arquivo()
{
    FILE *pont_arq;
    char *arquivo = "eventos.txt";
    //abrindo o arquivo
    pont_arq = fopen(arquivo, "w+");
    if (pont_arq == NULL)
    {
        printf("ERRO! O arquivo não foi aberto!\n");
        return false;
    }
    else
    {
        printf("O arquivo foi aberto com sucesso!");
    }

    for (int i = 0; i < 100; i++)
    {
        double a = (double)i;
        int b = i;
        int c = i;
        fprintf(pont_arq, "%3.6f\t%d\t%d\n", a, b, c);
    }
    return true;
    fclose(pont_arq);
}

int main(int argc, char *argv[])
{

    FILE *pont_arq_read;

    pont_arq_read = fopen(argv[1], "r");
    if (pont_arq_read == NULL)
    {
        printf("ERRO! O arquivo não foi aberto!\n");
    }
    else
    {
        printf("Questão 1\n");

        lista_eventos_t **p = (lista_eventos_t **)malloc(sizeof(lista_eventos_t));
        *p = NULL;
        double a = 0.0;
        int b = 0;
        int c = 0;

        //Inserção no final a partir de um arquivo
        while ((fscanf(pont_arq_read, "%lf %d %d\n", &a, &b, &c)) != EOF)
        {
            evento_t *novo = (evento_t *)malloc(sizeof(evento_t));

            novo->tempo = a;
            novo->alvo = b;
            novo->tipo = c;
            lista_eventos_adicionar_inicio(novo, p);
        }
        fclose(pont_arq_read);
        lista_eventos_listar(*p);
    }

    pont_arq_read = fopen(argv[1], "r");
    if (pont_arq_read == NULL)
    {
        printf("ERRO! O arquivo não foi aberto!\n");
    }
    else
    {
        printf("Questão 2\n");
        lista_eventos_t **p = (lista_eventos_t **)malloc(sizeof(lista_eventos_t));
        *p = NULL;
        double a = 0.0;
        int b = 0;
        int c = 0;

        //Inserção no final a partir de um arquivo
        while ((fscanf(pont_arq_read, "%lf %d %d\n", &a, &b, &c)) != EOF)
        {
            evento_t *novo = (evento_t *)malloc(sizeof(evento_t));

            novo->tempo = a;
            novo->alvo = b;
            novo->tipo = c;
            lista_eventos_adicionar_fim(novo, p);
        }
        fclose(pont_arq_read);
        lista_eventos_listar(*p);
    }

    pont_arq_read = fopen(argv[1], "r");
    if (pont_arq_read == NULL)
    {
        printf("ERRO! O arquivo não foi aberto!\n");
    }
    else
    {
        printf("Questão 2\n");
        lista_eventos_t **p = (lista_eventos_t **)malloc(sizeof(lista_eventos_t));
        *p = NULL;
        double a = 0.0;
        int b = 0;
        int c = 0;

        //Inserção no final a partir de um arquivo
        while ((fscanf(pont_arq_read, "%lf %d %d\n", &a, &b, &c)) != EOF)
        {
            evento_t *novo = (evento_t *)malloc(sizeof(evento_t));

            novo->tempo = a;
            novo->alvo = b;
            novo->tipo = c;
            lista_eventos_adicionar_ordenado(novo, p);
        }
        fclose(pont_arq_read);
        lista_eventos_listar(*p);
    }

    return 0;
}
