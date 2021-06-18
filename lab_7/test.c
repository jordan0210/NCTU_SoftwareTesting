#include <stdlib.h>
#include <stdio.h>
#include <string.h>

char str[4] = {'a', 'b', 'c', 'd'};// = malloc(4);

int main(){
	// str = malloc(4);
	// str[4] = 'a';
	printf("%c\n", str[4]);
	// free(str);

	return 0;
}
