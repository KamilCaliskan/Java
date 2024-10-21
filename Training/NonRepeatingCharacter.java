public class Kata {
    public static String firstNonRepeatingLetter(String s) {
        // String'in karakterlerini sırayla kontrol et
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Büyük-küçük harf farkını ortadan kaldırmak için string'i küçük harfe çevir
            String lowerCaseString = s.toLowerCase();
            char lowerC = Character.toLowerCase(c);
            
            // Eğer karakter sadece bir kez geçiyorsa, yani ilk ve son yeri aynıysa
            if (lowerCaseString.indexOf(lowerC) == lowerCaseString.lastIndexOf(lowerC)) {
                return Character.toString(c);  // Karakteri orijinal haliyle döndür
            }
        }
        // Eğer hiç tekrar etmeyen karakter yoksa, boş string döndür
        return "";
    }
}
