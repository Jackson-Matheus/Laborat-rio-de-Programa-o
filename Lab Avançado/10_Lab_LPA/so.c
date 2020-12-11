#include <stdio.h>
#include <unistd.h>
#include <assert.h>
#include <pthread.h>
#include <stdlib.h>
#include <semaphore.h>
#include <stdatomic.h>

int max;
int loops;
int *buffer1, *buffer2;

int consome1 = 0;
int produz1 = 0;
int consome2 = 0;
int produz2 = 0;

atomic_int count;

#define MAX (10)
int consumidores = 1;
int produtores = 1;
int nambos = 1;

pthread_mutex_t mutex;
pthread_cond_t empty, fill;

void produz(int valor, int buf)
{
    buffer1[produz1] = valor;
    produz1 = (produz1 + 1) % max;
}

int consome(int buf)
{

    int tmp;
    tmp = buffer1[consome1];
    consome1 = (consome1 + 1) % max;

    return tmp;
}

void *produtor(void *arg)
{
    int i;
    for (i = 0; i < loops; i++)
    {
        pthread_mutex_lock(&mutex);

        while (count == max)
            pthread_cond_wait(&empty, &mutex);

        produz(i, 1);
        atomic_fetch_add(&count, 1);

        pthread_cond_signal(&fill);
        pthread_mutex_unlock(&mutex);
        printf("Produtor %lld produziu %d\n", (long long int)arg, i);
    }
    printf("Produtor %d finalizado\n", *((int *)arg));
    return NULL;
}

void *consumidor(void *arg)
{
    int tmp = 0;
    while (1)
    {

        pthread_mutex_lock(&mutex);
        while (count == 0)
            pthread_cond_wait(&fill, &mutex);
        tmp = consome(1);
        atomic_fetch_sub(&count, 1);

        pthread_cond_signal(&empty);
        pthread_mutex_unlock(&mutex);

        printf("Consumidor %lld consumiu %d\n", (long long int)arg, tmp);
    }
    return NULL;
}

void *ambos(void *arg)
{
    int tmp = 0;
    while (1)
    {
        pthread_mutex_lock(&mutex);

        while (count == 0)
            pthread_cond_wait(&fill, &mutex);
        tmp = consome(1);
        printf("Ambos %lld consumiu %d\n", (long long int)arg, tmp);
        produz(tmp, 2);
    }
    return NULL;
}

int main(int argc, char *argv[])
{
    if (argc != 6)
    {
        fprintf(stderr, "uso: %s <tambuffer> <loops> <produtores> <consumidores> <ambos>\n", argv[0]);
        exit(1);
    }
    max = atoi(argv[1]);
    loops = atoi(argv[2]);
    produtores = atoi(argv[3]);
    consumidores = atoi(argv[4]);
    nambos = atoi(argv[5]);
    assert(consumidores <= MAX);

    buffer1 = (int *)malloc(max * sizeof(int));
    buffer2 = (int *)malloc(max * sizeof(int));
    int i;
    for (i = 0; i < max; i++)
    {
        buffer1[i] = 0;
        buffer2[i] = 0;
    }

    pthread_t pid[MAX], cid[MAX], aid[MAX];
    for (i = 0; i < produtores; i++)
        pthread_create(&pid[i], NULL, produtor, NULL);

    for (i = 0; i < consumidores; i++)
        pthread_create(&cid[i], NULL, consumidor, (void *)(long long int)i);

    for (i = 0; i < nambos; i++)
        pthread_create(&aid[i], NULL, ambos, NULL);



    for (i = 0; i < produtores; i++)
        pthread_join(pid[i], NULL);

    for (i = 0; i < consumidores; i++)
        pthread_join(cid[i], NULL);

    for (i = 0; i < nambos; i++)
        pthread_create(&aid[i], NULL, ambos, NULL);

    return 0;
}
