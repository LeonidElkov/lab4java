import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CollectionUtils2 {

    // Метод, который принимает список значений типа T и предикат для фильтрации
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
