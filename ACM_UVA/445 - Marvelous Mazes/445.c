#include <stdio.h>
#include <string.h>

int main(){
	char c = '1', p;
	int sum;
	while(1){
		sum = 0;
		while(1){
			if(scanf("%c", &c) == EOF)
				return 0;
			if(isdigit(c))
				sum += c-'0';
			else
				break;
		}
		switch(c){
			case 'b':
				p = ' ';
				break;
			case '!':
			case '\n':
				printf("%c", '\n');
				break;
			case EOF:
				return 0;
			default:
				p = c;
		}
		while(sum--){
			printf("%c", p);
		}
		c = '1';
	}
	return 0;
}
