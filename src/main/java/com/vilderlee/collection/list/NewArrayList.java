package com.vilderlee.collection.list;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/4/3      Create this file
 * </pre>
 */
public class NewArrayList<E> {

    private static final int DefaultSize = 10;
    private Object[] arrays;
    private int size = DefaultSize;

    public NewArrayList() {
        arrays = new Object[size];
    }

    public NewArrayList(int size) {
        this.size = size;
        arrays = new Object[this.size];
    }

    public int size() {
        return size;
    }

    public void add(E e) {
        arrays[size + 1] = e;
    }


    public E get(int index){
        return (E) arrays[index];
    }

}
