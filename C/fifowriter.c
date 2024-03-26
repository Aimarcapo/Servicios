#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>

int main() {
    const char* pipePath = "/path/to/nameOfThePipe";
    int pipeFd;

    // Create the named pipe
    if (mkfifo(pipePath, 0666) == -1) {
        perror("mkfifo");
        return 1;
    }

    // Open the named pipe for writing
    pipeFd = open(pipePath, O_WRONLY);
    if (pipeFd == -1) {
        perror("open");
        return 1;
    }

    // Write data to the pipe
    const char* message = "Hello, Process B!";
    ssize_t bytesWritten = write(pipeFd, message, strlen(message) + 1);
    if (bytesWritten == -1) {
        perror("write");
        return 1;
    }

    // Close the pipe
    close(pipeFd);

    // Remove the named pipe
    if (unlink(pipePath) == -1) {
        perror("unlink");
        return 1;
    }

    return 0;
}