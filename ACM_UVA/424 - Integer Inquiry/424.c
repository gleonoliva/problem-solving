#include <stdio.h>
#include <string.h>

char* suma(char *a, char *b){
	int la = strlen(a)-1;
	int lb = strlen(b)-1;
	int s;
	for(;lb >= 0;lb--, la--){
		s = b[lb]-'0' + a[la]-'0';
		a[la-1] = a[la-1] + (s/10);
		a[la] = (s%10)+'0';
	}
}

void psum(char* sum){
	char *c = sum;
	while(!((*c) >= '1' && (*c) <= '9')){
		c++;
	}
	printf("%s\n", c);
}



int main(){
	char sum[300], sumer[105];
	int n = 299;
	while(n--){
		sum[n] = '0';
	}
	sumer[0] = '\0';
	sum[299] = '\0';
	while(sumer[0] != '0'){
		scanf("%s", sumer);
		suma(sum, sumer);
	}
	psum(sum);
	return 0;
}
