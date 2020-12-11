#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[])
{

    int i = 0;
    int j = 48;
    unsigned char *buffer;
    int size_saida = 0;
    int size_buffer = 0;

    FILE *mpg_file = fopen(argv[1], "rb");
    if (mpg_file == NULL)
    {
        printf("ERRO! O arquivo não foi aberto!\n");
        return 0;
    }
    int size = atoi(argv[1]);

    fseek(mpg_file, 0L, SEEK_END);
    int size_entrada = ftell(mpg_file);
    rewind(mpg_file);

    buffer = malloc(sizeof(size * sizeof(char)));
    if (buffer == NULL)
    {
        return 0;
    }
    char saida[100] = "video_parte_0";
    char ext[4] = ".mpg";

    FILE *saida_arquivo = fopen(strcat(saida, ext), "wb");

    if (saida_arquivo == NULL)
    {
        printf("ERRO! O arquivo não foi aberto!\n");
        return 0;
    }

    unsigned char byte[4];

    while (1)
    {
        fread(byte, 4, 1, mpg_file);
        if (!memcmp("\x00\x00\x01\xB3", byte, 4) && !feof(mpg_file))
        {

            buffer[i] = byte[0];
            size_buffer++;

            fseek(mpg_file, -3, SEEK_CUR);
            continue;
        }
        else if (memcmp("\x00\x00\x01\xB3", byte, 4))
        {

            if (size_buffer + size_saida > size_entrada)
            {
                fclose(saida_arquivo);
                j++;
                saida[12] = j;
                saida_arquivo = fopen(saida, "wb");
                if (saida_arquivo == NULL)
                {
                    printf("ERRO! O arquivo de saida não foi aberto!\n");
                    return 0;
                }

                fwrite(buffer, sizeof(char), size_buffer, saida_arquivo);

                buffer = " ";
                size_buffer = size_saida;
            }
            else
            {
                fwrite(buffer, sizeof(char), size_buffer, saida_arquivo);
                size_saida += size_buffer;
            }
        }
        else if (feof(mpg_file))
        {
            fclose(saida_arquivo);
            break;
        }
        else
        {
            memcpy(buffer, byte, 4);
            size_buffer += 4;
        }
    }

    fclose(mpg_file);
    free(buffer);

    return 0;
};
