import java.util.List;

public class PaginationHelper<I> {

    private List<I> collection; // Koleksiyon (liste)
    private int itemsPerPage;   // Her sayfada kaç eleman olacak

    // Constructor: Koleksiyon ve sayfa başına eleman sayısını alır
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    // Toplam sayfa sayısını döndürür
    public int pageCount() {
        return (int) Math.ceil((double) collection.size() / itemsPerPage);
    }

    // Koleksiyondaki toplam eleman sayısını döndürür
    public int itemCount() {
        return collection.size();
    }

    // Verilen sayfa indeksinde kaç eleman olduğunu döndürür
    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || pageIndex >= pageCount()) {
            return -1; // Geçersiz sayfa indeksi
        }
        // Son sayfa mı kontrol ediliyor?
        if (pageIndex == pageCount() - 1) {
            return collection.size() % itemsPerPage == 0 ? itemsPerPage : collection.size() % itemsPerPage;
        }
        return itemsPerPage;
    }

    // Verilen eleman indeksinin hangi sayfada olduğunu döndürür
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= collection.size()) {
            return -1; // Geçersiz eleman indeksi
        }
        return itemIndex / itemsPerPage;
    }
}
