#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(){
	char *str = malloc(4);
	printf("%c\n", str[4]);
	free(str);

	return 0;
}
