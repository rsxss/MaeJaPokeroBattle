/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.model.sorter;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
 * @param <T>
 */
public class QuickSorter<T> implements Sorter<T>{
    private String order;
    private PivotEnum pivotPosition;
    private boolean startLeft;
    private boolean startRight;
    
    public enum PivotEnum {
        BEGIN {
            @Override
            <T> int partition(Comparable<T>[] arr, int low, int high, QuickSorter qs){
                return 0;
            }
        }, MIDDLE {
            @Override
            <T> int partition(Comparable<T>[] arr, int low, int high, QuickSorter qs) {
               return 0;
            }
        }, END {
            @Override
            <T> int partition(Comparable<T>[] arr, int low, int high, QuickSorter qs) {
                Comparable<T> pivot = arr[high];
                
                for(int i=low; i<high; i++){
                    if(qs.compareInOrder(arr[i], pivot)){
                        Comparable<T> temp = arr[low];
                        arr[low] = arr[i];
                        arr[i] = temp;
                        low++;
                    }
                }
                
                Comparable<T> temp = arr[low];
                arr[low] = pivot;
                arr[high] = temp;
                
                return low;
            }

        };

        abstract <T> int partition(Comparable<T>[] arr, int low, int high, QuickSorter qs);
        
    }
    
    public QuickSorter(){
        this("ASC");
    }
    public QuickSorter(String order){
        this(order, PivotEnum.MIDDLE);
    }
    public QuickSorter(PivotEnum pivotPosition){
        this("ASC", pivotPosition);
    }
    public QuickSorter(String order, PivotEnum pivotPosition){
        if(verifyOrder(order)){
           this.order = order;
           this.pivotPosition = pivotPosition;
        }
    }
    
    @Override
    public T[] sort(Comparable<T>[] arr) {
       Comparable<T>[] copiedArr = newArrayFrom(arr);
       return this.quickSort(copiedArr, 0, copiedArr.length-1);
    }
    @Override
    public boolean compareInOrder(Comparable<T> obja, T objb) {
       return this.order.equals("ASC") ? obja.compareTo(objb) < 0 : 
               obja.compareTo(objb) > 0;
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
    
    private T[] quickSort(Comparable<T>[] arr, int low, int high){
        int partition = pivotPosition.partition(arr, low, high, this);
        
        if(partition-1 > low){
            quickSort(arr, 0, partition-1);
        }
        if(partition+1 < high){
            quickSort(arr, partition+1, high);
        }
        
// StackOverFlow will be occured on big number of input (Trying to figure out what is happening under the hood)
//        if(partition-1 > low){
//            if(!startLeft){
//                try {
//                    this.startLeft = true;
//                    System.out.println("LEFT "+Thread.currentThread().getName());
//                    CompletableFuture.runAsync(() -> quickSort(arr, 0, partition-1)).get();
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(QuickSorter.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ExecutionException ex) {
//                    Logger.getLogger(QuickSorter.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } else
//                quickSort(arr, 0, partition-1);
//        }
//        if(partition+1 < high){
//            if(!startRight){
//                try {
//                    this.startRight = true;
//                    System.out.println("RIGHT "+Thread.currentThread().getName());
//                    CompletableFuture.runAsync(() -> quickSort(arr, partition+1, high)).get();
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(QuickSorter.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ExecutionException ex) {
//                    Logger.getLogger(QuickSorter.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } else 
//                quickSort(arr, partition+1, high);
//        }
        
        return (T[])arr;
    }

}
    