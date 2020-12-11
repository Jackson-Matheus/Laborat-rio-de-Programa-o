#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

#include <netinet/in.h>

typedef struct
{
    uint8_t daddr[6];
    uint8_t saddr[6];
    uint16_t protocol;
} ethernet_hdr_t;

typedef struct
{
    uint8_t hdr_len : 4, version : 4;
    uint8_t tos;
    uint16_t tot_len;
    uint16_t id;
    uint16_t frag_off;
    uint8_t ttl;
    uint8_t protocol;
    uint16_t check;
    uint8_t saddr[4];
    uint8_t daddr[4];
} ip_hdr_t;

typedef struct
{
    uint16_t sport;
    uint16_t dport;
    uint32_t seq;
    uint32_t ack_seq;
    uint8_t reservado : 4, hdr_len : 4;
    uint8_t flags;
    uint16_t window;
    uint16_t check;
    uint16_t urg_ptr;
} tcp_hdr_t;

int main(int argc, char *argv[])
{

    ethernet_hdr_t *ethernet = malloc(sizeof(ethernet_hdr_t));
    ip_hdr_t *ip_hdr = malloc(sizeof(ip_hdr_t));
    tcp_hdr_t *tcp_hdr = malloc(sizeof(tcp_hdr_t));

    FILE *http_file = fopen(argv[1], "rb");
    if (http_file == NULL)
    {
        printf("ERRO! O arquivo não foi aberto!\n");
        return 0;
    }

    printf("Lendo Ethernet ..\n");
    fread(ethernet, sizeof(ethernet_hdr_t), 1, http_file);
    printf("--> MAC de Origem:   ");
    for (int i = 0; i < 6; i++)
    {
        printf("%.2x", ethernet->saddr[i]);
        if (i != 5)
            printf(":");
    }
    printf("\n");
    printf("--> MAC de Destino:   ");

    for (int i = 0; i < 6; i++)
    {
        printf("%.2x", ethernet->daddr[i]);
        if (i != 5)
            printf(":");
    }

    printf("\n");
    printf("\n\nLendo IP ..\n");

    fread(ip_hdr, sizeof(ip_hdr_t), 1, http_file);

    printf("--> Versão do IP:   %d\n", ip_hdr->version);
    printf("--> Tamanho do cabeçalho:   %d  bytes\n", ip_hdr->hdr_len * 4);
    printf("--> Tamanho do pacote:   %d  bytes \n", ntohs(ip_hdr->tot_len));

    printf("--> Endereço IP de Origem:   ");

    for (int i = 0; i < 4; i++)
    {
        printf("%d", ip_hdr->saddr[i]);
        if (i != 3)
            printf(".");
    }
    printf("\n");
    printf("--> Endereço IP de Destino:   ");

    for (int i = 0; i < 4; i++)
    {
        printf("%d", ip_hdr->daddr[i]);
        if (i != 3)
            printf(".");
    }
    printf("\n");
    fseek(http_file, ip_hdr->hdr_len * 4 - sizeof(ip_hdr_t), SEEK_CUR);
    printf("\n\nLendo TCP ..\n");

    fread(tcp_hdr, sizeof(tcp_hdr_t), 1, http_file);
    printf("--> Porta de Origem:  %d\n", ntohs(tcp_hdr->sport));
    printf("--> Porta de Destino:   %d\n", ntohs(tcp_hdr->dport));
    printf("--> Tamanho do cabeçalho:   %d   bytes\n", tcp_hdr->hdr_len * 4);

    fseek(http_file, tcp_hdr->hdr_len * 4 - sizeof(tcp_hdr_t), SEEK_CUR);

    int tam_dados = ntohs(ip_hdr->tot_len) - (ip_hdr->hdr_len * 4) - (tcp_hdr->hdr_len * 4);

    printf("\n\nLendo Dados (HTTP) ..\n");
    printf("--> Tamanho dos dados:   %d  bytes\n", tam_dados);
    printf("--> Dados:..\n");

    char c;
    int i = 0;
    do
    {
        c = fgetc(http_file);
        i++;
        printf("%c", c);
    } while (i < tam_dados);
    fclose(http_file);
    free(ethernet);
    free(ip_hdr);
    free(tcp_hdr);

    return 0;
}
