package study.lambda.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamV1 {
    private List<Integer> internalList;

    public MyStreamV1(List<Integer> internalList) {
        this.internalList = internalList;
    }

    public MyStreamV1 filter(Predicate<Integer> predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer i : internalList) {
           if(predicate.test(i)){
               filtered.add(i);
           }
        }
        return new MyStreamV1(filtered);
    }
    public MyStreamV1 map(Function<Integer, Integer> function) {
        List<Integer> mapped = new ArrayList<>();
        for (Integer i : internalList) {
               mapped.add(function.apply(i));
        }
        return new MyStreamV1(mapped);
    }
    public List<Integer> toList(){
        return internalList;
    }

}
