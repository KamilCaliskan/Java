import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;


class Student {
    
    int id; 
    String name; 
    double cgpa;
    
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    
    }
    
    public int getID() {
        return id;
    }
    public String getName() {
       return name;
    }
    public double getCGPA() {
        return cgpa;
    }

}

class Priorities {
    
    Queue<Student> queue = new PriorityQueue<>((s1, s2) -> 
    
    Comparator.comparing(Student::getCGPA, Comparator.reverseOrder())
    .thenComparing(Student::getName)
    .thenComparing(Student::getID).compare(s1, s2));
    
    List<Student> order = new ArrayList<>();
    
    List<Student> getStudents(List<String> events) {
         events.forEach(e -> processEvent(e));
         
         
         List<Student> remaining = new ArrayList<>();
         
         while(!queue.isEmpty()) {
             remaining.add(queue.poll());
         }
         
         return remaining;
     }
     
     void processEvent(String event) {
         if (event.startsWith("ENTER")) {
            
            int id = Integer.decode(event.split(" ")[3]); 
            String name = event.split(" ")[1]; 
            double cgpa = Double.parseDouble(event.split(" ")[2]); 
            queue.add(new Student(id, name, cgpa));
         } else {
             order.add(queue.poll());
         }
         
         
     }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
