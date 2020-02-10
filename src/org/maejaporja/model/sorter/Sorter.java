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
public interface Sorter<T> {
    abstract public T[] sort(Comparable<T>[] arr);
    abstract public boolean compareInOrder(Comparable<T> obja, T objb);
    abstract public boolean verifyOrder(String order) throws IllegalArgumentException;
    abstract public Comparable<T>[] newArrayFrom(Comparable<T>[] arr);
}
