public class Scramblies {

    public static boolean scramble(String str1, String str2) {
        // Karakterlerin sayısını tutacak dizi (a'dan z'ye)
        int[] charCount = new int[26];

        // str1'deki karakterlerin sayısını sayma
        for (char c : str1.toCharArray()) {
            charCount[c - 'a']++;
        }

        // str2'nin karakterlerini str1'den oluşturup oluşturamayacağımızı kontrol etme
        for (char c : str2.toCharArray()) {
            if (charCount[c - 'a'] <= 0) {
                return false; // Yeterli karakter yok
            }
            charCount[c - 'a']--; // Bir karakter kullanıldı
        }

        return true; // str2'deki tüm karakterler oluşturulabilir
    }

    // Test örnekleri
    public static void main(String[] args) {
        System.out.println(scramble("rkqodlw", "world")); // true
        System.out.println(scramble("cedewaraaossoqqyt", "codewars")); // true
        System.out.println(scramble("katas", "steak")); // false
    }
}
