package com.ajs.test.study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LombokTestDataTest {

    @Test
    public void testDataTest(){
        TestData testData =new TestData();
        testData.setName("ajs");

        assertThat("ajs").isEqualTo(testData.getName());
    }
}
