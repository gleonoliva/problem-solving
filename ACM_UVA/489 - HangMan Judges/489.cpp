#include <cstdio>
#include <map>

using namespace std;

int main(){
	int n, count, s;
	char c;
	bool f;
	map<char, char> m, acert, er;
	scanf("%i", &n);
	while(n != -1){
		count = 0;
		s = 0;
		scanf("%c", &c);
		scanf("%c", &c);
		while(c != '\n'){
			m[c] = c;
			scanf("%c", &c);
		}
		scanf("%c", &c);
		s = m.size();
		while(c != '\n'){
			if(m[c]) acert[c] = c;
			else if(!er[c]) er[c];
			scanf("%c", &c);
		}
		printf("Round %i\n", n);
//		printf("Acert Size: %li\nM size: %li\nError: %li\n", acert.size(), m.size(), er.size());
		if(acert.size() >= s) 	printf("You win.\n");
		else if(er.size() >= 7) printf("You lose.\n");
		else printf("You chickened out.\n");
			
		scanf("%i", &n);
		acert.clear();
		m.clear();
	}
	return 0;
}
