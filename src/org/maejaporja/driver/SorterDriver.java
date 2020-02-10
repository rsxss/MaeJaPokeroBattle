/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.driver;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.maejaporja.model.sorter.BubbleSorter;
import org.maejaporja.model.sorter.InsertionSorter;
import org.maejaporja.model.sorter.QuickSorter;
import org.maejaporja.model.sorter.SelectionSorter;

/**
 *
 * @author NATWORPONGLOYSWAI
 */
public class SorterDriver {
    private static final Comparable<Integer>[] INT_ARRAY = getRandInt(5_000_000, 9000);
    
    public static void main(String[] args){
        System.out.printf("Unsorted array of length %d members%n", INT_ARRAY.length);
        System.out.println(Arrays.toString(INT_ARRAY));
        System.out.println("===========================");
        
        runAsyncSorter();
       
    }
    
    private static void sortBy(Comparable[] arr, String algorithm, String order){
        double startTime = System.currentTimeMillis()/1000.0;
        switch(algorithm){
            case "insertion":
                System.out.println(Arrays.toString(
                        (new InsertionSorter(order)).sort(arr)
                )); break;
            case "selection":
                System.out.println(Arrays.toString(
                        (new SelectionSorter(order)).sort(arr)
                )); break;
            case "bubble":
                System.out.println(Arrays.toString(
                        (new BubbleSorter(order)).sort(arr)
                )); break;
            case "quick":
                System.out.println(Arrays.toString(
                        (new QuickSorter(order)).sort(arr)
                )); break;
            default:
                throw new IllegalArgumentException(
                        String.format("Algorithm %s not supported!", algorithm)
                );
        }
        double endTime = System.currentTimeMillis()/1000.0;
        double totalTime = endTime - startTime;
        System.out.println(
                String.format("Time used for %s sort: %.2f seconds%n===========================",
                            algorithm, totalTime
                        )
        );
    }
    
    private static void runAsyncSorter(){
        CompletableFuture<Void> quickSortFuture = CompletableFuture.runAsync(() -> {
            sortBy(INT_ARRAY, "quick", "ASC");
        });
        CompletableFuture<Void> insertionSortFuture = CompletableFuture.runAsync(() -> {
            sortBy(INT_ARRAY, "insertion", "ASC");
        });
        CompletableFuture<Void> selectionSortFuture = CompletableFuture.runAsync(() -> {
            sortBy(INT_ARRAY, "selection", "ASC");
        });
        CompletableFuture<Void> bubbleSortFuture = CompletableFuture.runAsync(() -> {
            sortBy(INT_ARRAY, "bubble", "ASC");
        });

        
        try{
            CompletableFuture.allOf(
                    quickSortFuture,
                    insertionSortFuture,
                    selectionSortFuture,
                    bubbleSortFuture
            ).get();
        } catch(ExecutionException | InterruptedException err){
            for(StackTraceElement ste: err.getStackTrace()){
                System.out.println(ste);
            }
        }
    }
    
    private static Comparable<Integer>[] getRandInt(int size, int max){
        Comparable<Integer>[] intArr = new Integer[size];
        for(int i=0; i<size; i++){
            intArr[i] = (int)(Math.random()*max)+1;
        } return intArr;
    }
    
}
