// 1. Sınıf Bildirimi (Class Declaration)
public class Student {
    // 2. Değişkenler (Fields)
    // - private: Sadece bu sınıf içerisinden erişilebilir.
    private String name;
    private int age;
    private String studentID;

    // 3. Constructor
    // - Parametre olarak öğrenci adı, yaş ve öğrenci numarası alır.
    // - Constructor çağrıldığında, öğrenci bilgilerini set eder.
    public Student(String name, int age, String studentID) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
    }

    // 4. Metodlar
    // - public: Diğer sınıflardan erişilebilir.
    // - void: Geri dönüş tipi yok.

    // Öğrenci bilgilerini yazdıran metod
    public void displayStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + studentID);
    }

    // Öğrencinin yaşını bir yıl artıran metod
    public void celebrateBirthday() {
        age++;
        System.out.println(name + "'s birthday celebrated! Now " + name + " is " + age + " years old.");
    }
}

// 5. Ana Metod (main method)
public class Main {
    public static void main(String[] args) {
        // Öğrenci sınıfından iki örnek oluşturuluyor.
        Student student1 = new Student("John Doe", 20, "S12345");
        Student student2 = new Student("Jane Smith", 22, "S67890");

        // Öğrenci bilgileri ekrana yazdırılıyor.
        System.out.println("Student 1:");
        student1.displayStudentInfo();

        System.out.println("\nStudent 2:");
        student2.displayStudentInfo();

        // Öğrenci1'in yaşını bir yıl artırma
        student1.celebrateBirthday();
        System.out.println("\nUpdated Student 1:");
        student1.displayStudentInfo();
    }
}
