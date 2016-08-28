#include <stdio.h>
int main(){
	char b[1024];
	char a;
	int c = 0, co;
	while((co = scanf("%[a-z|A-Z]", b))!= EOF){
		scanf("%c", &a);
		if(co) c++;
		if(a=='\n'){
			printf("%i\n", c);
			c= 0;
		}
	}
	return 0;
}
