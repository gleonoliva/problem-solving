#include <stdio.h>
#include <string.h>

int main(){
	char s1[100],s2[100],s3[100],s4[100],s5[100], line[100], come[10];
	int n, cont;
	scanf("%i", &n);
	getc(stdin);
	while(n--){
		s1[0] = '\0';
		s2[0] = '\0';
		s3[0] = '\0';
		s4[0] = '\0';
		s5[0] = '\0';
		scanf("%[^<]",s1);
		scanf("<%[^>]",s2);
		scanf(">%[^<]",s3);
		scanf("<%[^>]",s4);
		scanf(">%[^\n]",s5);
		getc(stdin);
		cont = scanf("%[^(...)]", line);
		scanf("...\n");
		printf("%s%s%s%s%s\n", s1,s2,s3,s4,s5);
		if(cont)
			printf("%s%s%s%s%s\n", line, s4, s3, s2, s5);
		else
			printf("%s%s%s%s\n", s4, s3, s2, s5);
		
	}
	return 0;
}
