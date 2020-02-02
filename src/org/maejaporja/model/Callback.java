/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.model;

/**
 *
 * @author NATWORPONGLOYSWAI
 * @param <T>
 */
@FunctionalInterface
public interface Callback<T> {
    abstract public T call(Object... params);
}
