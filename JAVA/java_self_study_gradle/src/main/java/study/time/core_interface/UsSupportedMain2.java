package study.time.core_interface;

import javax.lang.model.SourceVersion;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class UsSupportedMain2 {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        boolean supported = now.isSupported(ChronoField.SECOND_OF_MINUTE);
        System.out.println("supported = " + supported);

        if(supported) {
            int minute = now.get(ChronoField.SECOND_OF_MINUTE);
            System.out.println("minute = " + minute);
        }

    }
}
