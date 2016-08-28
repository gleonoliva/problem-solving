#include <stdio.h>
#include <string.h>

int p(char c){
	short s = c -'0';
	while(s--){
		printf("%c", c);
	}
	printf("\n");
}

int main(){
	int n, a, f;
	short f1;
	char c;
	scanf("%i", &n);
	while(n--){
		scanf("%i", &a);
		scanf("%i", &f);
		while(f--){
			f1 = 0;
			c = '1';
			for(;c-'0'<= a; c++) p(c);
			c-=2;
			for(;c >= '1'; c--) p(c);
			if(f>=1 || n>=1) printf("\n");
		}
	}
	return 0;
}
