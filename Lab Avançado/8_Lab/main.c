#include <stdio.h>

#include <stdlib.h>

int main(int argc, char *argv[])
{

    int i = 1;
    unsigned char buffer[3];

    FILE *mpg_file = fopen(argv[1], "rb");
    if (mpg_file == NULL)
    {
        printf("ERRO! O arquivo não foi aberto!\n");
        return 0;
    }

    FILE *mpg = NULL;
    for (; !feof(mpg_file); i++)
    {
        fread(buffer, 3, 1, mpg_file);

        if (buffer[0] == '\x00' && buffer[1] == '\x00' && buffer[2] == '\x01')
        {
            unsigned char byte[1];
            fread(byte, 1, 1, mpg_file);

            if (byte[0] == 0xB3)
            {

                unsigned char byte1 = fgetc(mpg_file);
                unsigned char byte2 = fgetc(mpg_file);
                unsigned char byte3 = fgetc(mpg_file);
                unsigned char byte4 = fgetc(mpg_file);
                unsigned int largura = byte1 * 16 + (byte2 >> 4);
                unsigned int altura = (byte2 & 0x0F) * 256 + byte3;
                unsigned int frame_rate = byte4 & 0x0f;
                float fr = 0.0;

                printf("--> Código: %.2x ", byte[0]);
                printf("--  Sequence Header  ");
                printf("--  Width = %d  ", largura);

                printf("--  Height = %d  ", altura);
                if (frame_rate == 1)
                {
                    fr == 23.976;
                }

                if (frame_rate == 2)
                {
                    fr = 24.000;
                }
                if (frame_rate == 3)
                {
                    fr = 25.000;
                }
                if (frame_rate == 4)
                {
                    fr = 29.970;
                }
                if (frame_rate == 5)
                {
                    fr = 30.000;
                }
                if (frame_rate == 6)
                {
                    fr = 50.000;
                }
                if (frame_rate == 7)
                {
                    fr = 59.940;
                }
                if (frame_rate == 8)
                {
                    fr = 30.000;
                }
                printf("--  Frame rate = %.3lffps\n", fr);
            }
            else if (byte[0] == 0xB8)
            {
                printf("--> Codigo: %.2x -- Group of Pictures \n", byte[0]);
            }

            else if (byte[0] == 0x00)
            {
                unsigned char byte1 = fgetc(mpg_file);
                unsigned char byte2 = fgetc(mpg_file);

                unsigned char tipo = (byte2 >> 3);
                //tipo = tipo >> 5;
                tipo = tipo & 0x0f;
                printf("--> Código: %.2x ", byte[0]);
                printf("-- Picture -- Tipo = ");

                if (tipo == 1)
                {
                    printf("I\n");
                }
                else if (tipo == 1)
                {
                    printf("P\n");
                }
                else
                {
                    printf("B\n"); /* code */
                }
            }

            else if (byte[0] >= 0x01 && byte[0] <= 0xAF)
            {
                printf("--> Codigo: %.2x -- Slice\n", byte[0]);
            }
            else
            {
                printf("--> Código: %.2x -- Tipo de stream não implementado\n", byte[0]);
            }
        }
        else
        {
            fseek(mpg_file, -2, SEEK_CUR);
        }
    }

    return 0;
}
