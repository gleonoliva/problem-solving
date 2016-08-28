#include <stdio.h>
#include <string.h>

int main(){
	char r[26], l[26];
	int n = 1, max = -1, le = 0, ri= 0, i = 0;
	int count[13], sum = 0;
	while(1){
		scanf("%i", &n);
		if(!n) break;
		while(n--){
			scanf("%s", l);
			le = strlen(l);
			if(le < 24){
				scanf("%s", r);
				ri = strlen(r);
				count[i] = le+ri;
				max = (max>count[i])? max:count[i];
				i++;
			}else{
				count[i++] = le;
				max = le;
			}
		}
		i--;
		for(;i>=0;i--){
			sum += max-count[i];
		}
		printf("%i\n", sum);
		sum=i=0;
		max=-1;
	}
	return 0;
}
