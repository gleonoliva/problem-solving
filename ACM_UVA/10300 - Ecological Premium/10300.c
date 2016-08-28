#include <stdio.h>
int main(){
	int n, m, o, p, q, s = 0;
	scanf("%i", &n);
	while(n--){
		scanf("%i", &m);
		while(m--){
			scanf("%i %i %i", &o, &p, &q);
			s += o*q;
		}
		printf("%i\n", s);
		s=0;
	}
	return 0;
}
