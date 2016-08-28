#include <stdio.h>
#include <string.h>

short ismirr(char a, char b){
	if(a == b){
		return (a == 'A' || a == 'I' ||
		   a == 'H' || a == 'M' ||
		   a == 'T' || a == 'U' ||
		   a == 'V' || a == 'W'	||   
		   a == 'X' || a == 'Y' ||
		   a == '1' || a == '8' || a == 'O'
		   );
	}
	return ((a == 'E' && b == '3') || (a == '3' && b == 'E') ||
				 (a == 'J' && b == 'L')	|| (a == 'L' && b == 'J') ||
				 (a == 'S' && b == '2')	|| (a == '2' && b == 'S') ||
				 (a == '5' && b == 'Z')	|| (a == 'Z' && b == '5')
				 );
}


int main(){
	char line[10000];
	int i, j, l;
	short pal, mirr;
	
	while(scanf("%s", line)!= EOF){
		l = strlen(line)-1;
		pal = mirr = 1;
		for(i = 0, j=l; i <= j; i++, j--){
			if(line[i] != line[j]){
				pal = 0;
				if(!ismirr(line[i], line[j])){
					mirr = 0;
				}
			} else {
				if(!ismirr(line[i], line[j])){
					mirr = 0;
				}
			}
		}
		if(pal){
			if(mirr)
				printf("%s -- is a mirrored palindrome.\n\n", line);
			else
				printf("%s -- is a regular palindrome.\n\n", line);
			
		}else{
			if(mirr)
				printf("%s -- is a mirrored string.\n\n", line);
			else
				printf("%s -- is not a palindrome.\n\n", line);
		}
		
	}
	return 0;
}
