package com.mcutil;

public class Information<T> {

    private T val;

    public Information(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }
}
