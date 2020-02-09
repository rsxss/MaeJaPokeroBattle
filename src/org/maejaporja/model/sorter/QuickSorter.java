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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NATWORPONGLOYSWAI
 */
public class QuickSorter<T> implements Sorter<T>{
    private String order;
    private PivotEnum pivotPosition;
    
    public QuickSorter(){
        this("ASC");
    }
    public QuickSorter(String order){
        this(order, PivotEnum.MIDDLE);
    }
    public QuickSorter(String order, PivotEnum pivotPosition){
        if(verifyOrder(order)){
           this.order = order;
           this.pivotPosition = pivotPosition;
        }
    }
    
    @Override
    public T[] sort(Comparable<T>[] arr) {
       return null;
    }
    @Override
    public boolean compareInOrder(Comparable<T> obja, T objb) {
       return false;
    }
    @Override
    public boolean verifyOrder(String order) throws IllegalArgumentException {
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
    @Override
    public Comparable<T>[] newArrayFrom(Comparable<T>[] arr) {
        return arr.clone();
    }
    
    private Comparable<T>[] quickSort(Comparable<T>[] arr, int low, int high){
        return null;
    }
}
