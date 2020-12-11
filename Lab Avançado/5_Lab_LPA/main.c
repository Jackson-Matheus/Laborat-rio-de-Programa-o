#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <math.h>

int main(int argc, char *argv[])
{

    int size = atoi(argv[1]);
    int tamanho_palavra = strlen(argv[2]);


    for (int x = 1; x <= size; x++)
    {
        int poss = pow(tamanho_palavra, x);
        for (int i = 0; i < poss; i++)
        {

            int val = i;
            for (int j = 0; j < x; j++)
            {

                printf("%c", argv[2][val % tamanho_palavra]);
                val = val / tamanho_palavra;
            }

            printf("\n");
        }
    }

    printf("\n");

    return 0;
}
