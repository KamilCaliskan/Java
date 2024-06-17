/*
Bu Java sınıfı, Result adında bir sınıftır ve içerisinde findDay adında bir metot bulunmaktadır
Bu metot, verilen bir tarih için haftanın hangi günü olduğunu belirlemek için Calendar sınıfını kullanır

İşlevin detaylı açıklaması şu şekildedir:

    public static String findDay(int month, int day, int year): Bu metodun amacı, verilen bir tarih için haftanın hangi günü olduğunu belirlemektir
    Bu metot, üç parametre alır: month (ay), day (gün) ve year (yıl). Metot bir String değeri döndürür, bu değer ise haftanın hangi gününe denk geldiğini ifade eder

    Calendar calendar = Calendar.getInstance();: Bu satır, Calendar sınıfından bir örneği alır. 
    getInstance() metodu, mevcut tarih ve saat bilgisiyle bir Calendar örneği döndürür.

    calendar.set(year, month - 1, day);: Bu satır, Calendar nesnesinin tarihini belirli bir yıl (year), ay (month), ve gün (day) olarak ayarlar
    month - 1 ifadesi, çünkü Calendar sınıfında aylar sıfır tabanlıdır (Ocak ayı 0 olarak temsil edilir).

    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);: Bu satır, belirtilen tarihin haftanın hangi gününe d
    enk geldiğini belirlemek için Calendar sınıfının DAY_OF_WEEK alanını kullanır.

    String[] daysOfWeek = {"", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};: 
    Bu satır, haftanın günlerini içeren bir dizi oluşturur.

    return daysOfWeek[dayOfWeek];: Bu satır, belirlenen tarihin haftanın hangi gününe denk geldiğini temsil eden bir dizeyi döndürür.
    Örneğin, "WEDNESDAY" gibi bir değer dönebilir.

Bu kod örneği, bir tarih verildiğinde haftanın hangi gününe denk geldiğini belirleyen basit bir fonksiyonu içermektedir.

*/
import java.util.Calendar;

class Result {
    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day); // Calendar months are zero-based, so we subtract 1 from the provided month

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // Convert day of the week to a string (e.g., SUNDAY, MONDAY, etc.)
        String[] daysOfWeek = {"", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};

        return daysOfWeek[dayOfWeek];
    }
}

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int month = Integer.parseInt(firstMultipleInput[0]);
            int day = Integer.parseInt(firstMultipleInput[1]);
            int year = Integer.parseInt(firstMultipleInput[2]);

            String res = Result.findDay(month, day, year);

            bufferedWriter.write(res);
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
