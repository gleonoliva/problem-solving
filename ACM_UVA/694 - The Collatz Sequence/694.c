#include <stdio.h>

typedef unsigned long ui;

int main(){
	ui limit, A, A1;
	unsigned int cont = 0, keis = 1;
	while(scanf("%lu %lu", &A, &limit) != EOF){
		A1 = A;
		if(A == -1) break;
		while(A != 0 && A <= limit){
			cont++;
			if(A%2 == 0 || A == 1)
				A >>= 1;
			else
				A = A*3+1;
		}
		printf("Case %u: A = %lu, limit = %lu, number of terms = %u\n", keis, A1, limit, cont);
		cont = 0;
		keis++;
	}
	return 0;
}
