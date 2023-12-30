

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
        // Regular expression to match valid tags and extract content
        String regex = "<([^/][^>]*)>([^<]+)</\\1>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        // Check for valid content or print "None" if not found
        if (matcher.find()) {
            do {
                System.out.println(matcher.group(2));
            } while (matcher.find());
        } else {
            System.out.println("None");
        }
    }
}
