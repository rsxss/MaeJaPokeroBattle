/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.driver;

import java.util.Arrays;
import org.maejaporja.model.sorter.InsertionSorter;
import org.maejaporja.model.sorter.SelectionSorter;

/**
 *
 * @author NATWORPONGLOYSWAI
 */
public class SorterDriver {
    private static final Comparable<Integer>[] INT_ARRAY = getRandInt(5000);
    
    public static void main(String[] args){
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(INT_ARRAY));
        System.out.println("===========================");
        sort_by(INT_ARRAY, "insertion", "DESC");
        System.out.println("===========================");
        sort_by(INT_ARRAY, "selection", "ASC");
        System.out.println("===========================");
    }
    
    private static void sort_by(Object o, String algorithm, String order){
        double startTime = System.currentTimeMillis()/1000.0;
        switch(algorithm){
            case "insertion":
                System.out.println(Arrays.toString(
                        (new InsertionSorter(order)).sort((Comparable[]) o)
                )); break;
            case "selection":
                System.out.println(Arrays.toString(
                        (new SelectionSorter(order)).sort((Comparable[]) o)
                )); break;
            default:
                throw new IllegalArgumentException(
                        String.format("Algorithm %s not supported!", algorithm)
                );
        }
        double endTime = System.currentTimeMillis()/1000.0;
        double totalTime = endTime - startTime;
        System.out.println(
                String.format("Time used for %s sort: %.2f",
                            algorithm, totalTime
                        )
        );
    }
    
    private static Comparable<Integer>[] getRandInt(int size){
        Integer[] intArr = new Integer[size];
        for(int i=0; i<size; i++){
            intArr[i] = (int)(Math.random()*9)+1;
        } return (Comparable<Integer>[])intArr;
    }
    
}
