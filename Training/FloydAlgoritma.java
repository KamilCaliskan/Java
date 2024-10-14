public class LoopInspector {

    public int loopSize(Node node) {
        Node slow = node;
        Node fast = node;
        
        // 1. Tavşan-Kaplumbağa algoritması ile döngü bulma
        do {
            slow = slow.getNext();       // Yavaş bir adım ilerler
            fast = fast.getNext().getNext(); // Hızlı iki adım ilerler
        } while (slow != fast);          // İkisi karşılaşana kadar devam et
        
        // 2. Döngü uzunluğunu bulmak için bir adım daha atıyoruz
        int loopLength = 0;
        do {
            slow = slow.getNext();
            loopLength++;
        } while (slow != fast); // Tekrar karşılaşana kadar devam et
        
        return loopLength;
    }
}
