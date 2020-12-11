#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    // criando a variável ponteiro para o arquivo
    FILE *pont_arq;
    FILE *pont_arq_read;

    //abrindo o arquivo
    pont_arq = fopen("eventos.txt", "w+");
    if (pont_arq == NULL)
    {
        printf("ERRO! O arquivo não foi aberto!\n");
    }
    else
    {
        printf("O arquivo foi aberto com sucesso!");
    }

    for (int i = 0; i < 20; i++)
    {
        fprintf(pont_arq, "%3.6f\t%d\t%d\n", 0.2, i, i);
    }

    for (int i = 0; i < 20; i++)
    {
        fprintf(pont_arq, "%3.6f\t%d\t%d\n", 0.2, i, i);
    }
    fclose(pont_arq);

    pont_arq_read = fopen("eventos.txt", "r");
    if (pont_arq_read == NULL)
    {
        printf("ERRO! O arquivo não foi aberto!\n");
    }
    else
    {
        printf("O arquivo foi aberto com sucesso!");
        double a = 0.0;
        int b = 0;
        int c = 0;
        while ((fscanf(pont_arq_read, "%lld %d %d\n", &a, &b, &c)) != EOF)
            printf("%lf %d %d\n", a, b, c);
    }
    fclose(pont_arq_read);

    return (0);
}
