import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
public class CollectionUtils {
    // Метод, который принимает список значений типа T и функцию, применяемую к каждому элементу
    public static <T, P> List<P> map(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }
}
