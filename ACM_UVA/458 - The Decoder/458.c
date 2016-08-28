#include <stdio.h>
int main(){
	char b[100000];
	char *c;
	while(scanf("%s", b) != EOF){
		c = b;
		while(*c){
			(*c) -= 7;
			c++;
		}
		printf("%s\n", b);
	}
	return 0;
}
