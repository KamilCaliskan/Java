public class Kata {
    public static String createPhoneNumber(int[] numbers) {
        // İlk olarak, telefon numarasının formatı için bir StringBuilder kullanıyoruz
        StringBuilder phoneNumber = new StringBuilder();

        // Telefon numarasının başlangıcını ekliyoruz
        phoneNumber.append("(");
        
        // İlk üç sayıyı ekliyoruz
        for (int i = 0; i < 3; i++) {
            phoneNumber.append(numbers[i]);
        }
        
        // Parantezi kapatıp bir boşluk ekliyoruz
        phoneNumber.append(") ");
        
        // Sonraki üç sayıyı ekliyoruz
        for (int i = 3; i < 6; i++) {
            phoneNumber.append(numbers[i]);
        }
        
        // Tire işaretini ekliyoruz
        phoneNumber.append("-");
        
        // Son dört sayıyı ekliyoruz
        for (int i = 6; i < 10; i++) {
            phoneNumber.append(numbers[i]);
        }

        // Sonuç olarak oluşan dizeyi döndürüyoruz
        return phoneNumber.toString();
    }

    // Test metodu
    public static void main(String[] args) {
        // Örnek test
        int[] exampleNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(createPhoneNumber(exampleNumbers));  // "(123) 456-7890" döndürür
    }
}





/*
import org.junit.Test;: JUnit kütüphanesinden @Test anotasyonunu içe aktarır. 
Bu anotasyon, bir metodun test metodu olduğunu belirtir.
import static org.junit.Assert.assertEquals;: JUnit kütüphanesinden assertEquals metodunu içe aktarır. 
Bu metod, iki değerin eşit olup olmadığını kontrol etmek için kullanılır.
*/
