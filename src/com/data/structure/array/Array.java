package com.data.structure.array;

/**
 * @author zhangjin
 * @since 2019-11-18 11:29
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

    public void addFirst(int e) {
        add(0, e);
    }

    public void addLast(int e) {

        add(size, e);
    }


    public void add(int index, int e) {


        if (index > size || index < 0) {
            throw new IllegalArgumentException("数组越界 ");
        }

        //暂时不考虑扩容的问题
        if (index >= data.length) {
            throw new IllegalArgumentException("数组越界 ");

        }

        //遍历数据赋值
//        int[] tempData = new int[size + 1];
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;

    }


    // 获取index索引位置的元素
    public int get(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("数组越界 ");
        }

        return data[index];

    }

    // 修改index索引位置的元素为e
    public void set(int index, int e) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("数组越界 ");
        }

        data[index] = e;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(data[i]).append(",");
        }
        return sb.substring(0, sb.length() - 1);


    }


    // 查找数组中是否有元素e
    public boolean contains(int e) {

        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }

        return false;

    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(int e) {

        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }

        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public int remove(int index) {

        if (index > size || index < 0) {
            throw new IllegalArgumentException("数组越界 ");
        }

        //暂时不考虑扩容的问题
        if (index >= data.length) {
            throw new IllegalArgumentException("数组越界 ");

        }

        //遍历数据赋值
        int result = 0;
//        int[] tempData = new int[size + 1];
        for (int i = index; i + 1 < size; i++) {
            if (i == index) {
                result = data[i];
            }

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

    public static void main(String[] args) {


        Array arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }
}
