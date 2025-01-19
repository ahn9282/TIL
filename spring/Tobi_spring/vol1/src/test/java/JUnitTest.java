import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class JUnitTest {
    static JUnitTest testObject;
    static Set<JUnitTest> testObjects = new HashSet<>();

    @Test
    public void test1(){
        assertThat(this).isNotEqualTo(testObject);
        testObject = this;

    }
    @Test
    public void test2(){
        assertThat(this).isNotEqualTo(testObject);
        testObject = this;

    }
    @Test
    public void test3(){
        assertThat(this).isNotEqualTo(testObject);
        testObject = this;

    }
}
