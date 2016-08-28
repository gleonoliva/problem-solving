#include <stdio.h>

typedef unsigned long long ull;
#define SIZ 1000

int main(){
	int l = 0, i;
	ull fib[SIZ];
	fib[0] = 0LLU;
	fib[1] = 1LLU;
	for(i = 2; i < SIZ; i++){
		fib[i] = fib[i-1] + fib[i-2];
		printf("%i = %llu\n", i, fib[i]);
	}
	while(scanf("%i", &l) != EOF){
		printf("%llu\n", fib[l]);
	}
	return 0;
}
