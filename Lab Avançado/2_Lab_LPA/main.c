#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

struct tpessoa
{
    char nome[50];
    long long int cpf;
    int idade;
};
typedef struct tpessoa pessoa;

struct tlista_pessoa
{
    pessoa *pessoa;
    struct tlista_pessoa *prox;
};
typedef struct tlista_pessoa lista_pessoa;

typedef lista_pessoa ***tabela_hash_t;

tabela_hash_t tabela_hash_pessoas_criar(int TAM);
bool tabela_hash_pessoas_adicionar(pessoa *pessoa, tabela_hash_t tabela_hash, int indice);
void lista_pessoas_listar(lista_pessoa *lista);
void tabela_hash_pessoas_listar(tabela_hash_t tabela_hash, int TAM);
bool lista_pessoas_adicionar_inicio(pessoa *p, lista_pessoa **lista_hash);
int tabela_hash_pessoas_funcao(pessoa *pessoa, int tabela_hash_tam);

//Alocando memória para HASH
tabela_hash_t tabela_hash_pessoas_criar(int TAM)
{
    tabela_hash_t tabela_hash = (tabela_hash_t)malloc(sizeof(tabela_hash_t) * TAM);

    if (tabela_hash == NULL)
    {
        printf("Memoria insuficiente.\n");
        exit(1);
    }

    for (int i = 0; i < TAM; i++)
    {

        lista_pessoa **l = NULL;
        tabela_hash[i] = l;
    };

    return tabela_hash;
}

bool tabela_hash_pessoas_adicionar(pessoa *pessoa, tabela_hash_t tabela_hash, int indice)
{

    if (tabela_hash[indice] == NULL)
    {
        lista_pessoa **lista = (lista_pessoa **)malloc(sizeof(lista_pessoa));
        if (lista == NULL)
        {
            return false;
        }
        tabela_hash[indice] = lista;

        lista_pessoas_adicionar_inicio(pessoa, tabela_hash[indice]);
        return true;
    }

    lista_pessoas_adicionar_inicio(pessoa, tabela_hash[indice]);
    return true;
}

bool lista_pessoas_adicionar_inicio(pessoa *pessoa, lista_pessoa **lista_hash)
{

    lista_pessoa *item_novo = malloc(sizeof(lista_pessoa));
    if (item_novo == NULL)
    {
        return false;
    }

    item_novo->pessoa = pessoa;
    item_novo->prox = *lista_hash;
    *lista_hash = item_novo;

    return true;
}

int tabela_hash_pessoas_funcao(pessoa *pessoa, int tabela_hash_tam)
{
    return pessoa->cpf % tabela_hash_tam;
}

void lista_pessoas_listar(lista_pessoa *lista)
{

    if (lista == NULL)
    {
        printf("Lista vazia");
    }
    else
    {

        int i = 0;
        lista_pessoa *novo = malloc(sizeof(lista_pessoa));
        novo = lista;
        for (; novo != NULL; novo = novo->prox)
        {
            printf("Nome = %s - ", novo->pessoa->nome);
            printf("CPF = %lld - ", novo->pessoa->cpf);
            printf("Idade = %d \n", novo->pessoa->idade);
        }

        free(novo);
    }
}

void tabela_hash_pessoas_listar(tabela_hash_t tabela_hash, int TAM)
{

    for (int i = 0; i < TAM; i++)
    {
        if (tabela_hash[i] != NULL)
        {
            printf("i = %d\n", i);
            lista_pessoas_listar(*tabela_hash[i]);
        }
        else
        {
            printf("i = %d  VAZIO\n", i);
        }
    };
}

void free_(tabela_hash_t tabela_hash, int TAM)
{

    for (int i = 0; i < TAM; i++)
    {
        if (tabela_hash[i] != NULL)
        {
            lista_pessoa *novo = *tabela_hash[i];

            while (novo != NULL)
            {
                lista_pessoa *f = novo;
                novo = novo->prox;
                free(f);
            }
        }
        free(tabela_hash[i]);
    }

    free(tabela_hash);
}

int main(int argc, char *argv[])
{

    char file[100];
    int TAM = 0;

    sscanf(argv[1], "%d", &TAM);

    FILE *pont_arq_read = fopen(argv[2], "r");

    if (pont_arq_read == NULL)
    {
        printf("ERRO! O arquivo não foi aberto!\n");
    }
    else
    {

        tabela_hash_t hash = tabela_hash_pessoas_criar(TAM);

        int index = 0;

        char a[50];
        long long int b = 0;
        int c = 0;

        while (fscanf(pont_arq_read, "%50[^\t]\t%lld\t%d\n", a, &b, &c) != EOF)
        {
            pessoa *novo = (pessoa *)malloc(sizeof(pessoa));
            strcpy(novo->nome, a);

            novo->cpf = b;
            novo->idade = c;
            index = tabela_hash_pessoas_funcao(novo, TAM);
            tabela_hash_pessoas_adicionar(novo, hash, index);
        }
        fclose(pont_arq_read);
        printf("HASH\n");

        tabela_hash_pessoas_listar(hash, TAM);

        free_(hash, TAM);
    }

    return 0;
}
