#include <stdio.h>
typedef long ui;
int main(){
	ui uno, dos;
	while(scanf("%ld %ld", &uno, &dos) != EOF){
		printf("%ld\n", (uno-dos>0)? uno-dos:dos-uno);
	}
	return 0;
}
