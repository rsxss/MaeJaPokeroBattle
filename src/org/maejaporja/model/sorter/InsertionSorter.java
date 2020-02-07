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
public class InsertionSorter<T> implements Sorter<T>{
    
    private String order;
    
    public InsertionSorter(){
        this("ASC");
    }
    public InsertionSorter(String order){
        switch(order){
            case "ASC": break;
            case "DESC": break;
            default:
                throw new IllegalArgumentException(
                        String.format(
                                "Must be ordered by ASC or DESC. got %s", order
                        )
                );
        }
        this.order = order;
    }
    
    @Override
    public T[] sort(Comparable<T>[] arr) {
        Comparable<T>[] copiedArr = newArrayFrom(arr);
        return this.insertionSort(copiedArr);
    }

    private T[] insertionSort(Comparable<T>[] arr){
        for(int i=1; i<arr.length; i++){
            T key = (T)arr[i];
            int j = i-1;
            
            while(j>=0 && compareInOrder(arr[j],key)){
                arr[j+1] = arr[j];
                j--;
            }
            
            arr[j+1] = (Comparable<T>)key;
        }
        return (T[])arr;
    }
    @Override
    public boolean compareInOrder(Comparable<T> obja, T objb){
        return this.order.equals("ASC") ? obja.compareTo(objb) > 0 :
                obja.compareTo(objb) < 0;
    }
    @Override
    public Comparable<T>[] newArrayFrom(Comparable<T>[] arr){
        Comparable<T>[] newArr = arr.clone();
        System.arraycopy(arr, 0, newArr, 0, 0);
        return newArr;
    }
    
}
