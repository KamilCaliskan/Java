public class PigLatin {
    public static String pigIt(String str) {
        // Split the input string by spaces to get each word
        String[] words = str.split(" ");
        
        // StringBuilder to store the final result
        StringBuilder result = new StringBuilder();
        
        // Iterate through each word
        for (String word : words) {
            // Check if the word is a punctuation mark
            if (word.matches("[a-zA-Z]+")) {
                // Move the first letter to the end and add "ay"
                String pigLatinWord = word.substring(1) + word.charAt(0) + "ay";
                result.append(pigLatinWord).append(" ");
            } else {
                // If it's punctuation, just append it unchanged
                result.append(word).append(" ");
            }
        }
        
        // Return the final string, trimming any extra spaces at the end
        return result.toString().trim();
    }
}
