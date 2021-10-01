/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.model.sorter;

/**
 *
 * @author NATWORPONGLOYSWAI
 */
public class BubbleSorter<T> implements Sorter<T> {
    
    private String order;
    
    public BubbleSorter(){
        this("ASC");
    }
    public BubbleSorter(String order){
        if(verifyOrder(order))
            this.order = order;
    }
    
    @Override
    public T[] sort(Comparable<T>[] arr) {
        Comparable<T>[] copiedArr = newArrayFrom(arr);
        return this.bubbleSort(copiedArr);
    }
    @Override
    public boolean compareInOrder(Comparable<T> obja, T objb) {
        return this.order.equals("ASC") ? obja.compareTo(objb) < 0 :
                obja.compareTo(objb) > 0;
    }
    @Override
    public Comparable<T>[] newArrayFrom(Comparable<T>[] arr) {
        return arr.clone();
    }
    
    private T[] bubbleSort(Comparable<T>[] arr){
        for(int i=0; i<arr.length; i++){
            boolean swapped = false;
            for(int j=0; j<arr.length-i-1; j++){
                T key = (T) arr[j];
                
                if(compareInOrder(arr[j+1], key)){
                    swap(j, j+1, arr);
                    swapped = true;
                }                
            }
            if(!swapped) break;
        }
        return (T[])arr;
    }
    
    private void swap(int indexA, int indexB, Comparable<T>[] arr){
        Comparable<T> temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    @Override
    public boolean verifyOrder(String order) throws IllegalArgumentException{
        switch(order){
            case "ASC": break;
            case "DESC": break;
            default:
                throw new IllegalArgumentException(
                        String.format(
                                "Must be ordered by ASC or DESC. got %s", order
                        )
                );
        } return true;
    }
}
