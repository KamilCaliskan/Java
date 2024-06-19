import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Sorgu sayısını oku
        for(int i=0; i<t; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            // Her sorgu için seriyi oluştur ve yazdır
            int sum = a;
            for(int j=0; j<n; j++){
                sum += b * (1 << j); // 1 << j ifadesi 2^j anlamına gelir
                System.out.print(sum + " ");
            }
            System.out.println(); // Yeni satır
        }
        in.close();
    }
}



/*
n a, b ve n değerleriyle, a + b * (2^0 + 2^1 + 2^2 + ... + 2^(n-1))

in.close(); ile Scanner nesnesi kapatılır. 
Bu, kaynak sızıntılarını önlemek için iyi bir uygulamadır


sum += b * (1 << j); ifadesi, serinin bir sonraki terimini hesaplar
1 << j ifadesi, 2^j anlamına gelir.
Örneğin, j 0 ise 1 << 0 -> 2^0 = 1
j=1 ise 1 << 1 -> 2^1 = 2
j=2 ise 1 << 2 -> 2^2 = 4 
*/
