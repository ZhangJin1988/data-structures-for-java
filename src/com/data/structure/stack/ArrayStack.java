package com.data.structure.stack;

import com.data.structure.array.Array;


/**
 * @author zhangjin
 * @date 2019-11-19 10:38
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 添加元素
     *
     * @param e 元素
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 推出元素
     *
     * @return 元素
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 获取最后一个元素
     *
     * @return E
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}

