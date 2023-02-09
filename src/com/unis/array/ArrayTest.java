package com.unis.array;

/**
 * @author luoChao
 * @create_date 2020-04-07 23:24
 */
public class ArrayTest {
    public static void main(String[] args) throws Exception{
        LcArrayList lcArrayList = new LcArrayList(5);
        System.out.println(lcArrayList.isEmpty());
        lcArrayList.add(1);
        lcArrayList.add(3);
        lcArrayList.add(5);
        System.out.println(lcArrayList);
        System.out.println(3);
        System.out.println(lcArrayList.contains(6));
        System.out.println(lcArrayList.remove(1));
        System.out.println(lcArrayList);
        lcArrayList.add(1,2);
        System.out.println(lcArrayList);
        lcArrayList.add(0,0);
        System.out.println(lcArrayList);
        lcArrayList.add(3,3);
        System.out.println(lcArrayList);
        lcArrayList.add(4,4);
        System.out.println(lcArrayList);
        System.out.println(lcArrayList.isEmpty());
    }
}
