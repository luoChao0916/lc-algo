package com.zkwq.array;

/**
 * @author luoChao
 * @create_date 2020-04-07 20:45
 * 数组的插入、删除、按照下标随机访问操作 动态数组
 * 内存连续，类型相同
 */
public class LcArrayList {

    // 保存数据
    private int[] elements;

    // 数组中的元素个数
    private int size;


    public LcArrayList(int capacity) {
        this.elements = new int[capacity];
        this.size = 0;
    }

    /**
     * 根据下标随机访问
     * @param index 索引
     * @return index索引处的元素
     */
    public int find(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * @param index 要插入元素的索引
     * @param element 要插入的元素
     */
    public void add(int index, int element) {
        rangeCheckForAdd(index);
        // 元素个数等于数组容量，扩容为原来的两倍
        if (size == elements.length) {
            resize(2 * size);
        }
        for (int i = size;i > index;i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 数组扩容
     * @param capacity 扩容后的大小
     */
    private void resize(int capacity) {
        int [] newElements = new int[capacity];
        for (int i = 0; i< size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }


    /**
     * @param index 索引
     * @return 被移除的元素
     */
    public int remove(int index) throws Exception{
        rangeCheck(index);
        int deleteElement = elements[index];
        // 将index后的元素向前移动一位
        for (int i = index; i < size-1;i++) {
            elements[i] = elements[i+1];
        }
        size--;
        return deleteElement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Array size =" + size + " capacity = " +elements.length);
        sb.append(" [");
        for (int i = 0;i < size;i++) {
            sb.append(elements[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >=size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
    }

    /**
     * 判断数组中是否包含元素
     * @param element 是否包含的元素
     * @return 是否包含
     */
    public boolean contains(int element) {
        for (int i = 0;i < size;i++) {
            if (element == elements[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 向数组尾部添加元素
     * @param element 要添加的元素
     */
    public void add(int element) {
        add(size, element);
    }

    /**
     * @return 数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
