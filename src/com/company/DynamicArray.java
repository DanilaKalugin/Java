package com.company;

import java.util.*;

public class DynamicArray<T> {

    private T[] array;

    public int Length;

    public DynamicArray() {array = (T[]) new Object[10];
        Length = 0;}

    public T GetItem(int index) {return array[index];}
    public void Add(T element) {
        if (Length == array.length)
        {
            array = Arrays.copyOf(array, array.length + 1);
        }
        array[Length] = element;
        Length++;
    }

    public void Clear() {array = null; Length = 0;};

    public void RemoveAt(int index) {
        for (int i = index; i < Length - 1; i++)
        {
            array[i] = array[i + 1];
        }
        Length--;
    }

    public T[] DifferentItems()
    {
        T[] arr = Arrays.copyOf(array, Length);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i].equals(arr[j]) || arr[i] == arr[j] || arr[i].toString().equals(arr[j].toString()))
                {
                    for (int k = j; k < arr.length - 1; k++)
                    {
                        arr[k] = arr[k + 1];
                    }
                    arr = Arrays.copyOf(arr, arr.length - 1);
                    j= i ;
                }
            }
        }

        return arr;
    }

    public String DifferentItemsWithCount()
    {
        String str = "";
        T[] mainArr = Arrays.copyOf(array, Length);
        T[] arr = DifferentItems();

        for (int i = 0; i < arr.length; i++)
        {
            int index = Arrays.asList(mainArr).indexOf(arr[i]);
            str += arr[i] + " - " +  ItemCount(mainArr[index]) + "\n";
        }
        return str;
    }

    public int ItemCount(T item)
    {
        int count = 0;
        for (int i=0; i<Length; i++)
        {
            if(array[i].equals(item))
                count++;
        }
        return count;
    }

}
