#include <stdio.h>
#include <string.h>

int main(){
	char line[12];
	char c;
	while(scanf("%[^\n]",line) != EOF){
		getc(stdin);
		if(line[0] != '_'){
			c=0;
			c+= 64*((line[2]=='o')? 1:0);
			c+= 32*((line[3]=='o')? 1:0);
			c+= 16*((line[4]=='o')? 1:0);
			c+= 8*((line[5]=='o')? 1:0);
			c+= 4*((line[7]=='o')? 1:0);
			c+= 2*((line[8]=='o')? 1:0);
			c+= 1*((line[9]=='o')? 1:0);
			printf("%c", c);
		}
	}
	return 0;
}
