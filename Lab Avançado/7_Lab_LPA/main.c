#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

#include <netinet/in.h>

struct chunk
{

    int length;
    char type[4];
};

struct png_chunk_hdr
{

    int width;
    int height;
    char bit_depth;
    char colour_type;
    char compression_method;
    char filter_method;
    char interlace_method;
}
__attribute__((packed));

int main(int argc, char *argv[])
{

    int i = 1;
    struct chunk *chunk_ = malloc(sizeof(struct chunk));
    struct png_chunk_hdr *png_chunk = malloc(sizeof(struct png_chunk_hdr));

    FILE *png_file = fopen(argv[1], "rb");
    if (png_file == NULL)
    {
        printf("ERRO! O arquivo não foi aberto!\n");
        return 0;
    }

    fseek(png_file, 8, SEEK_CUR);
    for (; !feof(png_file); i++)
    {

        fread(chunk_, sizeof(struct chunk), 1, png_file);
        printf("Lendo chunk: %d\n", i);
        printf("\t--> Tamanho: %d\n", ntohl(chunk_->length));
        printf("\t--> Tipo: %s\n", chunk_->type);

        if (!strcmp(chunk_->type, "IHDR"))
        {
            fread(png_chunk, sizeof(struct png_chunk_hdr), 1, png_file);
            printf("\t\t--> Largura: %d\n", ntohl(png_chunk->width));
            printf("\t\t--> Altura: %d\n", ntohl(png_chunk->height));
            fseek(png_file, 4, SEEK_CUR);
        }
        else if (!strcmp(chunk_->type, "IEND"))
        {
            break;
        }

        else
        {
            fseek(png_file, ntohl(chunk_->length) + 4, SEEK_CUR);
        }
    }

    fclose(png_file);
    free(chunk_);
    free(png_chunk);

    return 0;
}