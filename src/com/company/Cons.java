package com.company;


import java.util.ArrayList;
import java.util.List;

public class Cons<T>  {

    private T head;
    private List<T> tail;

    Cons(T head, List<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    public List<T>  cons() {
        List<T> list = new ArrayList<T>(this.tail);
        list.add(0, this.head);

        return  list;
    }
}