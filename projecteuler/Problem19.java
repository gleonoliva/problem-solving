
import java.util.Calendar;
import java.util.Date;

/**
 * http://projecteuler.net/problem=19
Counting Sundays
Problem 19
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class Problem19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calendar cd = Calendar.getInstance();
        cd.set(1901, 1, 1); // January 1st, 1901
        int sum = 0;
        while(cd.get(Calendar.YEAR) < 2000){
            int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
            if(dayOfWeek == Calendar.MONDAY){
                sum++;
            }
            cd.add(Calendar.MONTH, 1);
        }
        System.out.println(sum);
    }
}
