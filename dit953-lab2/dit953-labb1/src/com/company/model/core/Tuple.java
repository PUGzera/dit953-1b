package com.company.model.core;

public class Tuple<A,B> {
    public A fst;
    public B snd;

    public Tuple(A fst, B snd) {
        this.fst = fst;
        this.snd = snd;
    }
}
