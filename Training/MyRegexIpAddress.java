/*
Bu Java sınıfı, IP adreslerini doğrulamak için kullanılabilecek bir regular expression (düzenli ifade) içerir
Regular expression, bir metin dizisini belirli bir desene göre eşleştirmek için kullanılır
Bu durumda, IP adreslerinin belirli bir formatta olup olmadığını kontrol etmek için bir desen tanımlanmıştı
    ^: Dizinin başlangıcını belirtir.

    ([01]?\\d\\d?|2[0-4]\\d|25[0-5]): Bu parça, A, B, C veya D değerlerini kontrol eder.
        ([01]?\\d\\d?): Bu ifade, 0 veya 1 ile başlayan ve ardından 0 ile 9 arasında bir veya iki rakam içeren sayıları ifade eder
        Yani, 0'dan başlayan ve en fazla iki rakam içeren sayılar
        |: Alternatif bir ifadeyi belirtir. Yani, önceki ifadenin veya sonraki ifadenin olmasını sağlar
        2[0-4]\\d: Bu ifade, 200 ile 249 arasındaki sayıları ifade eder
        |: Yine alternatif bir ifade
        25[0-5]: Bu ifade, 250 ile 255 arasındaki sayıları ifade eder

    \.: Nokta karakterini ifade eder. 
    IP adreslerinde noktalarla ayrılmış dört bölüm olduğu için bu bölümleri birbirinden ayırmak için kullanılır.

    Bu adımlar dört kez tekrarlanır, çünkü IP adresi dört bölümden oluşur.

    $: Dizinin sonunu belirtir.
Sample Input                            sample Ouput

000.12.12.034                           true
121.234.12.12                           true
23.45.12.56                             true
00.12.123.123123.123                    false
122.23                                  false 
Hello.IP                                false

*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class Solution{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}


class MyRegex {
    // The regular expression for validating an IP address
    String pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
}
