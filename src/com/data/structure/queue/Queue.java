package com.data.structure.queue;

/**
 * @author zhangjin
 * @date 2019-11-20 10:50
 */

public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
