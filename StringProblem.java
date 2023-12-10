/* 
Bu Java programı, bir tamsayıyı bir dizeye dönüştürmeyi 
ve ardından bu dizeyi tekrar tamsayıya dönüştürerek kullanıcının girdiği sayının 
doğru bir şekilde işlendiğini kontrol etmeyi amaçlar

Programın genel akışı şu şekildedir:

    Kullanıcıdan bir tamsayı alınır (n).
    Bu tamsayı, Integer.toString(n) kullanılarak bir dizeye dönüştürülür ve s adlı değişkene atanır
    Ardından, bu dize tekrar tamsayıya dönüştürülerek orijinal tamsayı ile karşılaştırılır (n == Integer.parseInt(s))
    Eğer dönüşümler başarılıysa, yani kullanıcının girdiği sayı ile dizeye dönüştürülen 
    ve tekrar tamsayıya dönüştürülen sayı aynı ise, "Good job" yazdırılır. Aksi takdirde "Wrong answer." yazdırılır.
    Eğer program beklenmeyen bir şekilde sonlandırılmaya çalışılırsa, 
    yasaklanmış bir çıkış kullanıldığını belirten bir mesaj ("Unsuccessful Termination!!") yazdırılır.

Programın temel amacı, tamsayıyı dizeye dönüştürme ve bu dizeyi 
tekrar tamsayıya dönüştürme işlemlerini doğru bir şekilde gerçekleştirebilmektir.

DoNotTerminate sınıfının içinde, programın çıkışını kontrol etmek amacıyla bir güvenlik yöneticisi 
(SecurityManager) oluşturulmuştur
Bu yönetici, exitVM izni ile ilgili bir istisna fırlatır

public static void forbidExit() {
    final SecurityManager securityManager = new SecurityManager() {
        @Override
        public void checkPermission(Permission permission) {
            if (permission.getName().contains("exitVM")) {
                throw new ExitTrappedException();
            }
        }
    };
    System.setSecurityManager(securityManager);
}
*/

import java.util.*;
import java.security.*;

public class Solution {
    public static void main(String[] args) {

        DoNotTerminate.forbidExit();

        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            in.close();
            String s = Integer.toString(n); // Convert integer to string

            

            if (n == Integer.parseInt(s)) {
                System.out.println("Good job");
            } else {
                System.out.println("Wrong answer.");
            }
        } catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }
}

// The following class will prevent you from terminating the code using exit(0)!
class DoNotTerminate {

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}
