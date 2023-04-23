package com.nchng1.ds.chap01;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<E> {
    // 真正存储数据的底层数组
    private E[] data;
    // 记录当前元素个数
    private int size;
    // 默认初始容量
    private static final int INIT_CAP = 1;

    public MyArrayList() {
        this(INIT_CAP);
    }

    public MyArrayList(int initCapacity) {
        this.data = (E[]) new Object[initCapacity];
    }

    // 增
    public void addLast(E e) {
        if (data.length == size) {
            this.resize(size + size / 2);
        }
        data[size] = e;
        size++;
    }

    public void add(int index, E e) {
        checkPositionIndex(index);
        if (data.length == size) {
            this.resize(size + size / 2);
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        this.add(0, e);
    }

    // 删
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size < data.length / 4) {
            resize(data.length / 2);
        }
        E res = data[size - 1];
        data[size - 1] = null;
        size--;
        return res;
    }

    public E remove(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        checkElementIndex(index);
        if (size < data.length / 4) {
            resize(data.length / 2);
        }
        E res = data[index];
        System.arraycopy(data, index + 1, data, index, size - (index + 1));
        data[size - 1] = null;
        size--;
        return res;
    }

    public E removeFirst() {
        return this.remove(0);
    }

    // 查
    public E get(int index) {
        checkElementIndex(index);
        return data[index];
    }

    // 改
    public E set(int index, E element) {
        checkElementIndex(index);
        E res = data[index];
        data[index] = element;
        return res;
    }

    // 工具方法
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // 将 data 的容量改为 newCap
    private void resize(int newCap) {
        E[] newArr = (E[]) new Object[newCap];
        System.arraycopy(data, 0, newArr, 0, size);
        data = newArr;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * 检查 index 索引位置是否可以存在元素
     */
    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * 检查 index 索引位置是否可以添加元素
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }



    private void display() {
        System.out.println("size = " + size + " cap = " + data.length);
        System.out.println(Arrays.toString(data));
    }


    public static void main(String[] args) {
        // 初始容量设置为 3
        MyArrayList<Integer> arr = new MyArrayList<>(3);

        // 添加 5 个元素
        for (int i = 1; i <= 5; i++) {
            arr.addLast(i);
        }

        arr.remove(3);
        arr.add(1, 9);
        arr.addFirst(100);
        int val = arr.removeLast();

        System.out.println("last val:" + val);

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

}