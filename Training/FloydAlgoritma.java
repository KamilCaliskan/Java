// Node sınıfının varsayımsal tanımı
class Node {
    private Node next;  // Bağlı listedeki bir sonraki düğüm

    // Bir sonraki düğümü döndüren metod
    public Node getNext() {
        return next;
    }

    // Bu metod, bağlı listede bir sonraki düğümü ayarlamak için (opsiyonel)
    public void setNext(Node next) {
        this.next = next;
    }
}

public class LoopInspector {

    public int loopSize(Node node) {
        // Tavşan-Kaplumbağa (Floyd's Cycle Detection) algoritması ile döngüyü bul
        Node slow = node;
        Node fast = node;

        // Döngüyü bulana kadar iki göstericiyle ilerle
        do {
            if (fast == null || fast.getNext() == null) {
                return 0;  // Eğer fast null'a ulaşırsa, döngü yok
            }
            slow = slow.getNext();       // Yavaş gösterici bir adım atar
            fast = fast.getNext().getNext(); // Hızlı gösterici iki adım atar
        } while (slow != fast);          // Göstericiler karşılaşana kadar devam

        // Döngü bulunduğunda, döngü uzunluğunu ölçmek için işlemleri başlat
        int loopLength = 0;
        do {
            slow = slow.getNext();
            loopLength++;
        } while (slow != fast); // Yine karşılaşana kadar adım say

        return loopLength;  // Döngü uzunluğunu döndür
    }
}
