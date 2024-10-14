import java.util.HashMap;
import java.util.Map;

public class Kata {
    
    public static String firstNonRepeatingLetter(String s) {
       
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            char lowerC = Character.toLowerCase(c); 
            charCount.put(lowerC, charCount.getOrDefault(lowerC, 0) + 1); 
        }

        
        for (char c : s.toCharArray()) {
            char lowerC = Character.toLowerCase(c); 
            if (charCount.get(lowerC) == 1) {  
                return String.valueOf(c); 
            }
        }

        return "";
    }

    public static void main(String[] args) {
       
        System.out.println(firstNonRepeatingLetter("stress"));  //  "t"
        System.out.println(firstNonRepeatingLetter("sTreSS"));  //  "T"
        System.out.println(firstNonRepeatingLetter("aabbcc"));  //  ""
    }
}
