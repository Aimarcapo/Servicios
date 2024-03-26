#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>

int main() {
    const char* pipePath = "/path/to/nameOfThePipe";
    int pipeFd;
    char buffer[100];
    ssize_t bytesRead;

    // Open the named pipe for reading
    pipeFd = open(pipePath, O_RDONLY);
    if (pipeFd == -1) {
        perror("open");
        return 1;
    }

    // Read data from the pipe
    bytesRead = read(pipeFd, buffer, sizeof(buffer));
    if (bytesRead == -1) {
        perror("read");
        return 1;
    }

    printf("Received message: %s\n", buffer);

    // Close the pipe
    close(pipeFd);

    return 0;
}