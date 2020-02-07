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
public class SelectionSorter<T> implements Sorter<T> {
    
    private String order;
    
    public SelectionSorter(){
        this("ASC");
    }
    public SelectionSorter(String order){
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
        return this.selectionSort(copiedArr);
    }
    @Override
    public boolean compareInOrder(Comparable<T> obja, T objb) {
        return this.order.equals("ASC") ? obja.compareTo(objb) < 0 :
                obja.compareTo(objb) > 0;
    }
    @Override
    public Comparable<T>[] newArrayFrom(Comparable<T>[] arr){
        Comparable<T>[] newArr = arr.clone();
        System.arraycopy(arr, 0, newArr, 0, 0);
        return newArr;
    }
    
    private T[] selectionSort(Comparable<T>[] arr){
        for(int i=0; i<arr.length; i++){    
           int minIndex = i;
           T minElement = (T)arr[minIndex];
           
           for(int j=i+1; j<arr.length; j++){
               if(compareInOrder(arr[j],minElement)){
                   minIndex = j;
                   minElement = (T)arr[minIndex];
               }
           }
           
           if(minIndex!=i){
               swap(i, minIndex, arr);
           }
        }
        return (T[])arr;
    }
    
    private void swap(int indexA, int indexB, Comparable<T>[] arr){
        Comparable<T> temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
    
}
