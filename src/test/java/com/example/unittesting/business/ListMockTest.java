package com.example.unittesting.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> listMock = mock(List.class);

    @Test
    public void size_basic() {
        when(listMock.size()).thenReturn(5);
        assertEquals(5, listMock.size());
    }

    @Test
    public void size_different_values() {
        when(listMock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, listMock.size());
        assertEquals(10, listMock.size());
    }

    @Test
    public void return_with_parameter() {
        when(listMock.get(0)).thenReturn("test");
        assertEquals("test", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    public void return_with_generic_parameter() {
        when(listMock.get(anyInt())).thenReturn("test");
        assertEquals("test", listMock.get(0));
        assertEquals("test", listMock.get(1));
    }

    @Test
    public void verification_basics() {
        String value1 = listMock.get(0);
        String value2 = listMock.get(1);
        verify(listMock).get(0);
        verify(listMock).get(1);
        verify(listMock, times(2)).get(anyInt());
        verify(listMock, atLeast(1)).get(1);
        verify(listMock, atLeastOnce()).get(1);
        verify(listMock, atMost(2)).get(anyInt());
        verify(listMock, never()).get(2);
    }

    @Test
    public void ArgumentCapturing() {
        listMock.add("SomeString");
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(listMock).add(argumentCaptor.capture());
        assertEquals("SomeString", argumentCaptor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        listMock.add("SomeString1");
        listMock.add("SomeString2");
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(listMock, times(2)).add(argumentCaptor.capture());
        List<String> allValues = argumentCaptor.getAllValues();
        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    @Test
    public void Mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); // null
        System.out.println(arrayListMock.size()); // 0
        arrayListMock.add("Test");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size()); // 0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); // 5
    }

    @Test
    public void Spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0)); // null
        System.out.println(arrayListSpy.size()); // 0
        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size()); // 0
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); // 5
    }

}
