package iterator_pattern.yc;

import java.sql.SQLOutput;

public class Main1 {
    public static void main(String[] args) {
        MyList list = new MyList(3);
        list.add("A");
        list.add("B");
        list.add("C");

        MyIterator iterator = list.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
