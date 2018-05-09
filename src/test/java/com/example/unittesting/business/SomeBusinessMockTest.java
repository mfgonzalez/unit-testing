package com.example.unittesting.business;

import com.example.unittesting.service.SomeDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImpl business = new SomeBusinessImpl();

    @Mock
    SomeDataService someDataServiceMock;

    @Test
    public void calculateSumUsingDataService_basic() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
        assertEquals(6, business.calculateSumUsingDataService());
    }
    @Test
    public void calculateSumUsingDataService_empty() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {1});
        assertEquals(1, business.calculateSumUsingDataService());
    }

}
