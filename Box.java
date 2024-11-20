public class Box<T> {
    private T item;

    public void put(T item) {
        if (this.item != null) {
            throw new IllegalStateException("Коробка уже заполнена. Сначала заберите объект.");
        }
        this.item = item;
    }

    public T get() {
        T temp = item;
        item = null;
        return temp;
    }

    public boolean isEmpty() {
        return item == null;
    }
}
