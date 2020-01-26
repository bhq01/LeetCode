package com.company.algorithm;

/**
 * 堆排序实现从无序的数组中找到最大的10个数
 */
public class HeapSort {

    private Object[] obj;

    private int size = 0;

    public HeapSort() {
        obj = new Object[16];
    }

    public Object get(int i) {
        if (i < 0 || i > size) {
            throw new RuntimeException();
        }
        return obj[i];
    }

    public int getSize() {
        return this.size;
    }

    public void add(Object o) {
        if (size > obj.length) {
            resize();
        }
        obj[size++] = o;
    }

    private void resize() {
        Object[] newObj = new Object[size * 2];
        System.arraycopy(obj, 0, newObj, 0, obj.length);
        this.obj = newObj;
    }

}
