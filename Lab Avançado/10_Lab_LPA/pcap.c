#include <stdio.h>
#include <time.h>
#include <pcap.h>
#include <netinet/in.h>
#include <netinet/if_ether.h>

void print_packet_info(const u_char *packet, struct pcap_pkthdr packet_header);
void my_packet_handler(
    u_char *args,
    const struct pcap_pkthdr *packet_header,
    const u_char *packet_body)
{
    print_packet_info(packet_body, *packet_header);
    return;
}

void print_packet_info(const u_char *packet, struct pcap_pkthdr packet_header)
{
    printf("Packet capture length: %d\n", packet_header.caplen);
    printf("Packet total length %d\n", packet_header.len);
}
int main(int argc, char *argv[])
{
    char error[PCAP_ERRBUF_SIZE];
    pcap_t *handle;
    const u_char *packet;
    struct pcap_pkthdr packet_header;
    char error_buffer[PCAP_ERRBUF_SIZE];

    int packet_count_limit = 1;
    int timeout_limit = 10000; /* In milliseconds */
    pcap_if_t *interfaces, *temp;
    int i = 0;
    if (pcap_findalldevs(&interfaces, error) == -1)
    {
        printf("\nerror in pcap findall devs");
        return -1;
    }
    for (temp = interfaces; temp; temp = temp->next)
    {
        printf("\n%d  :  %s", i++, temp->name);
    }

    if (interfaces == NULL)
    {
        printf("Error finding device: %s\n", error);
        return 1;
    }
    //descr = pcap_open_live(dev, BUFSIZ, 0, -1, errbuf);

    handle = pcap_open_live(
        interfaces[0].name,
        BUFSIZ,
        0,
        10000,
        error_buffer);

    if (handle == NULL)
    {
        fprintf(stderr, "Could not open device %s: %s\n", interfaces[0].name, error_buffer);
        return 2;
    }

    pcap_loop(handle, 0, my_packet_handler, NULL);
    return 0;
}
