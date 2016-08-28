#include <stdio.h>
#include <stdlib.h>

int gbase(char *c){
	int max = 2, aux = 2;
	for(;*c;c++){
		if((*c) != '0') 
			aux = ((*c)>='A' && (*c)<='Z')? (*c)-'A'+11:(*c)-'0'+1;
		max = (aux> max)? aux: max;
	}
	return max;
}

int main(){
	char a[1024];
	char b[1024];
	long uno, dos;
	int b1, b2, i, j;
	short boo = 0;
	unsigned long ul1 = 0UL, ul2 = 0UL;
	while(scanf("%s", a)!= EOF){
		scanf("%s", b);
		b1 = gbase(a);
		b2 = gbase(b);
		for(i = b1;i < 37;i++){
			for(j = b2;j < 37;j++){
				ul1 = strtoul(a, NULL, i);
				ul2 = strtoul(b, NULL, j);
				if(ul1 < ul2) break;
				if(ul1 == ul2){
					boo = 1;
					b1 = i;
					b2 = j;
					break;
				}
			}
			if(boo) break;
		}
		if(boo) printf("%s (base %i) = %s (base %i)\n", a, b1, b, b2);
		else printf("%s is not equal to %s in any base 2..36\n", a, b);
		boo = 0;
	}
	return 0;
}
