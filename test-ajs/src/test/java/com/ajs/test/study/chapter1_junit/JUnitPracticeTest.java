package com.ajs.test.study.chapter1_junit;

import org.junit.jupiter.api.*;

import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // @Test 메서드 이름에 언더바를 " "로 변경해서 display 해준다.
public class JUnitPracticeTest {

    @Test
    public void assert_equals_test() {
        String expect = "something";
        String actual = "something";

        Assertions.assertEquals(expect, actual);
    }

    @Test
    @DisplayName("Assert Not Equals Test 메소드 테스트")
    public void assertNotEqualsTest() {
        String expect = "something";
        String actual = "hello";

        Assertions.assertNotEquals(expect, actual);
    }

    @Test
    public void assetTrueTest(){
        int value1 = 1;
        int value2 = 2;
        Assertions.assertTrue(value1 < value2);
    }

    @Test
    public void assetFalseTest(){
        int value1 = 1;
        int value2 = 2;
        Assertions.assertFalse(value1 == value2);
    }

    @Test
    public void assertIterableEqualsTest(){
        List<Integer> list1 = List.of(1,2,3);
        List<Integer> list2 = List.of(1,2,3);

        Assertions.assertIterableEquals(list1, list2);

    }

    @Test
    public void assertAllTest(){
        String expect = "something";
        String actual = "something";
        List<Integer> list1 = List.of(1,2,3);
        List<Integer> list2 = List.of(1,2,3);


        Assertions.assertAll("Assert All",
                List.of(
                        () -> Assertions.assertEquals(expect, actual)
                        , () -> Assertions.assertIterableEquals(list1, list2)
                ));
    }
}
