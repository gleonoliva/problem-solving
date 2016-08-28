#include <stdio.h>
int main(){
	char b[101][101];
	int c = 0, i = 0;
	while(scanf("%s", b[c++])!= EOF){
		if(c == 3) break;
	}
	while(c--){
		printf("%s", b[c]);
		for(;b[i] != '\0';i++){
			printf("%c", b[i][c]);
		}
	}
	return 0;
}
