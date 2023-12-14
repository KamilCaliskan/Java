/*Bu Java programı,bir tag tabanlı dildeki metni işleyen bir çözümdür
  Özellikle, girilen metindeki geçerli tag'lerin içeriğini çıkartır
  */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();
            extractValidContent(line);
            testCases--;
        }
    }

    private static void extractValidContent(String line) {
        
        String regex = "<([^/][^>]*)>([^<]+)</\\1>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        
        while (matcher.find()) {
            System.out.println(matcher.group(2));
        }
        if (!matcher.matches()) {
            System.out.println("None");
        }
    }
}
