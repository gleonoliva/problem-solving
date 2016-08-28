#include <stdio.h>
int main(){
	int uno, dos;
	while(scanf("%i %i", &uno, &dos) != EOF){
		printf("%i\n", 2*uno*dos);
	}
	return 0;
}
