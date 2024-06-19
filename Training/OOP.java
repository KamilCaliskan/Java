// Soyut Shape sınıfı
abstract class Shape {
    // Alanı hesaplayan soyut metod
    abstract double area();
    
    // Çevreyi hesaplayan soyut metod
    abstract double perimeter();
}

// Circle sınıfı, Shape sınıfından türetilmiştir
class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    double area() {
        return Math.PI * radius * radius;
    }
    
    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle sınıfı, Shape sınıfından türetilmiştir
class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    double area() {
        return width * height;
    }
    
    @Override
    double perimeter() {
        return 2 * (width + height);
    }
}

// Main sınıfı
public class Main {
    public static void main(String[] args) {
        // Circle ve Rectangle nesneleri oluşturuluyor
        Shape circle = new Circle(5); // Yarıçapı 5 olan bir daire
        Shape rectangle = new Rectangle(4, 6); // Genişliği 4 ve yüksekliği 6 olan bir dikdörtgen
        
        // Circle nesnesinin alanı ve çevresi hesaplanıp yazdırılıyor
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Perimeter: " + circle.perimeter());
        
        // Rectangle nesnesinin alanı ve çevresi hesaplanıp yazdırılıyor
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Rectangle Perimeter: " + rectangle.perimeter());
    }
}
