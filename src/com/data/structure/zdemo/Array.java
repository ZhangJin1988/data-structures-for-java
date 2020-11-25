package com.data.structure.zdemo;

/**
 * @author zhangjin
 * @date 2020-11-16 11:09
 */
public class Array {


    private int[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;

    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }

    // 获取数组的容量
    public int getCapacity() {

        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize() {

        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty() {

        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(int e) {

        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(int e) {

        add(0, e);
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, int e) {

        //判断是否能够添加
        if (size == data.length) {
            throw new IllegalArgumentException("数组已经满了");
        }

        //判断添加的索引是否合法
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("参数不合法");
        }

        for (int i = data.length - 1; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;

    }

    // 获取index索引位置的元素
    public int get(int index) {

        if (index > data.length - 1 || index < 0) {
            throw new IllegalArgumentException("参数不合法");
        }

        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, int e) {
        if (index > data.length - 1 || index < 0) {
            throw new IllegalArgumentException("参数不合法");
        }
        data[index] = e;

    }

    // 查找数组中是否有元素e
    public boolean contains(int e) {

        for (int i = 0; i < data.length; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(int e) {


        for (int i = 0; i < data.length; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;

    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public int remove(int index) {

//        //判断是否能够添加
//        if (size == data.length) {
//            throw new IllegalArgumentException("数组已经满了");
//        }


        int result = -1;
        //判断移除的索引是否合法
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("参数不合法");
        }
        result = data[index];

        for (int i = index; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return result;


    }

    // 从数组中删除第一个元素, 返回删除的元素
    public int removeFirst() {

        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public int removeLast() {

        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(int e) {

        int i = find(e);
        if (i != -1) {
            remove(i);
        }

    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) {

        Array array = new Array(10);
        array.addFirst(1);
        array.addFirst(2);
        array.addFirst(3);
        array.addFirst(4);
        array.addFirst(5);
        array.addLast(15);

        System.out.println(array);


    }
}
