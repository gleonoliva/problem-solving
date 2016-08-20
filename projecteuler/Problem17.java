
/**
 *
 * Problem: https://projecteuler.net/problem=
 */
public class Problem17 {

    public static int countLetters(int n){
        if(n >= 1000){
            return countLetters(n/1000) + "thousand".length() + (n%1000 != 0? "and".length():0) + countLetters(n-((n/1000)*1000));
        }
        if(n >= 100){
            return countLetters(n/100) + "hundred".length() + (n%100 != 0? "and".length():0) + countLetters(n-((n/100)*100));
        }
        if(n >= 10){
            if(n <= 19){
                switch(n){
                    case 10: return "ten".length();
                    case 11: return "eleven".length();
                    case 12: return "twelve".length();
                    case 13: return "thirteen".length();
                    case 14: return "fourteen".length();
                    case 15: return "fifteen".length();
                    case 16: return "sixteen".length();
                    case 17: return "seventeen".length();
                    case 18: return "eighteen".length();
                    case 19: return "nineteen".length();
                }
            }
            
            int letters = countLetters(n-((n/10)*10));
            
            switch(n/10){
                case 2: return "twenty".length() + letters;
                case 3: return "thirty".length() + letters;
                case 4: return "forty".length() + letters;
                case 5: return "fifty".length() + letters;
                case 6: return "sixty".length() + letters;
                case 7: return "seventy".length() + letters;
                case 8: return "eighty".length() + letters;
                case 9: return "ninety".length() + letters;
            }
        }
        
        switch(n){
            case 1: return "one".length();
            case 2: return "two".length();
            case 3: return "three".length();
            case 4: return "four".length();
            case 5: return "five".length();
            case 6: return "six".length();
            case 7: return "seven".length();
            case 8: return "eight".length();
            case 9: return "nine".length();
        }
        return 0;
    }
    
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i <= 1000; i++){
            sum += countLetters(i);
        }
        System.out.println(sum);
    }
}
