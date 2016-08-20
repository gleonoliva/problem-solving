import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

/**
 * 
 * Problem: http://projecteuler.net/problem=59
 * 
 *XOR decryption
Problem 59
Each character on a computer is assigned a unique code and the preferred 
* standard is ASCII (American Standard Code for Information Interchange). 
* For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.

A modern encryption method is to take a text file, convert the bytes to ASCII, 
* then XOR each byte with a given value, taken from a secret key. The advantage
* with the XOR function is that using the same encryption key on the cipher 
* text, restores the plain text; for example, 65 XOR 42 = 107, 
* then 107 XOR 42 = 65.

For unbreakable encryption, the key is the same length as the plain text
* message, and the key is made up of random bytes. The user would keep the 
* encrypted message and the encryption key in different locations, and without 
* both "halves", it is impossible to decrypt the message.

Unfortunately, this method is impractical for most users, so the modified method
* is to use a password as a key. If the password is shorter than the message, 
* which is likely, the key is repeated cyclically throughout the message. The 
* balance for this method is using a sufficiently long password key for 
* security, but short enough to be memorable.

Your task has been made easy, as the encryption key consists of three lower case
* characters. Using cipher1.txt (right click and 'Save Link/Target As...'), a 
* file containing the encrypted ASCII codes, and the knowledge that the plain 
* text must contain common English words, decrypt the message and find the sum 
* of the ASCII values in the original text.

 */
public class Problem59 {

    public static String decodeMessage(char[] password, String encryptedMessage){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(char c : encryptedMessage.toCharArray()){
            sb.append((char) (c ^ password[i++ % password.length]));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        String answer = "";
        String message = null;

        try {
            Scanner in = new Scanner(new File("problem59.in"));
            message = in.next();
            in.close(); // Let others use it.
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
        }

       String chars[] = message.split(",");
       char[] encrypted = new char[chars.length];
       
       for(int i = 0; i < encrypted.length; i++){
           encrypted[i] = (char) Byte.parseByte(chars[i]);
       }
       
       String encryptedMessage = new String(encrypted);

       HashMap<String, String> decodedMessages = new HashMap<String, String>();
       
       for(char i = 'a'; i <= 'z'; i++){
           for(char j = 'a'; j <= 'z'; j++){
               for(char k = 'a'; k <= 'z'; k++){
                   char []c = new char[]{i, j, k};
                   String res = decodeMessage(c, encryptedMessage);
                   decodedMessages.put(new String(c), res);
               }
           }
       }

       String[] possibleWords = { "give", "existed"};

       for (Map.Entry<String, String> msgEntry : decodedMessages.entrySet()) {
           String key = msgEntry.getKey();
           String msg = msgEntry.getValue();

           int count = 0;
           for(String word : possibleWords) {
               count += msg.contains(word)? 1 : 0;
           }

           if(count == possibleWords.length) {
                answer = msg;
                System.out.println(msg);
                break;
           }
       }

        int sum = 0;
        for(char c : answer.toCharArray()){
            sum += c;
        }
        System.out.println(sum);
        System.out.printf("Completed in: %d milliseconds.\n", (System.currentTimeMillis()-start));
    }

}
