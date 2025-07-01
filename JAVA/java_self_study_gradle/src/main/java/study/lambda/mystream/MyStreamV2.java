package study.lambda.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamV2 {
    private List<Integer> internalList;

    private MyStreamV2(List<Integer> internalList) {
        this.internalList = internalList;
    }

    public static MyStreamV2 of(List<Integer> internalList){
        return new MyStreamV2(internalList);
    }

    public MyStreamV2 filter(Predicate<Integer> predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer i : internalList) {
           if(predicate.test(i)){
               filtered.add(i);
           }
        }
        return new MyStreamV2(filtered);
    }
    public MyStreamV2 map(Function<Integer, Integer> function) {
        List<Integer> mapped = new ArrayList<>();
        for (Integer i : internalList) {
               mapped.add(function.apply(i));
        }
        return new MyStreamV2(mapped);
    }
    public List<Integer> toList(){
        return internalList;
    }

}
