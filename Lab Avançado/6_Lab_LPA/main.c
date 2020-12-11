#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

struct zip_file_hdr
{
    int signature;
    short version;
    short flags;
    short compression;
    short mod_time;
    short mod_date;
    int crc;
    int compressed_size;
    int uncompressed_size;
    short name_length;
    short extra_field_length;
} __attribute__((packed));

int main(int argc, char *argv[])
{
    FILE *zip_file = fopen(argv[1], "rb");
    if (zip_file == NULL)
    {
        printf("ERRO! O arquivo não foi aberto!\n");
        return 0;
    }

    int i = 1;
    struct zip_file_hdr *file_hdr = malloc(sizeof(struct zip_file_hdr));
    char *texto;
    for (; !feof(zip_file); i++)
    {

        fread(file_hdr, sizeof(struct zip_file_hdr), 1, zip_file);
        texto = malloc((sizeof(char) * file_hdr->name_length));

        if (file_hdr->signature != 0x04034b50)
        {
            break;
        }

        while (texto == NULL)
        {
            texto = malloc((sizeof(char) * file_hdr->name_length));
        }

        fread(texto, file_hdr->name_length, 1, zip_file);
        texto[file_hdr->name_length + 1] = '\n';

        printf("\nArquivo %d .. \n", i);
        printf(" --> Nome do Arquivo: %s\n", texto);
        printf(" --> Tamanho Compactado: %d\n", file_hdr->compressed_size);
        printf(" --> Tamanho Descompactado: %d\n\n", file_hdr->uncompressed_size);
        free(texto);

        fseek(zip_file, file_hdr->extra_field_length + file_hdr->compressed_size, SEEK_CUR);
    }
    fclose(zip_file);
    free(file_hdr);

    return 0;
}