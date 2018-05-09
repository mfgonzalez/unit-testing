package com.example.unittesting.business;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SomeBusinessTest {

    @Test
    public void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {1,2,3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {1});
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }

}
