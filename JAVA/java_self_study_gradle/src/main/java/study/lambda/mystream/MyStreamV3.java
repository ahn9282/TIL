package study.lambda.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamV3<T> {
    private List<T> internalList;

    private MyStreamV3(List<T> internalList) {
        this.internalList = internalList;
    }

    public static <T> MyStreamV3<T> of(List<T> internalList){
        return new MyStreamV3<T>(internalList);
    }

    public MyStreamV3<T> filter(Predicate<T> predicate) {
        List<T> filtered = new ArrayList<>();
        for (T i : internalList) {
           if(predicate.test(i)){
               filtered.add(i);
           }
        }
        return new MyStreamV3<T>(filtered);
    }
    public <R> MyStreamV3<R> map(Function<T, R> function) {
        List<R> mapped = new ArrayList<>();
        for (T i : internalList) {
               mapped.add(function.apply(i));
        }
        return MyStreamV3.of(mapped);
    }
    public void forEach(Consumer<T> consumer){
        for (T t : internalList) {
            consumer.accept(t);
        }
    }
    public List<T> toList(){
        return internalList;
    }

}
