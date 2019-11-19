package com.data.structure.stack;

/**
 * @author zhangjin
 * @date 2019-11-19 10:39
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
