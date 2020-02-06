/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.model.sorter;

/**
 *
 * @author NATWORPONGLOYSWAI
 * @param <T>
 */
public class InsertionSort<T> implements Sorter<T> {

    @Override
    public T[] sort(Comparable<T>[] arr) {
        Comparable<T>[] newArr = arr;
        return this.insertionSort(newArr);
    }

    private T[] insertionSort(Comparable<T>[] arr){
        for(int i=1; i<arr.length; i++){
            T key = (T)arr[i];
            int j = i-1;
            
            while(j>=0 && arr[j].compareTo(key) > 0){
                arr[j+1] = arr[j];
                j--;
            }
            
            arr[j+1] = (Comparable<T>)key;
        }
        return (T[])arr;
    }
}
