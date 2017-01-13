package com.example;

import java.util.ArrayList;
import java.util.Random;

import sun.rmi.runtime.Log;

public class MyJokeClass {

    ArrayList<String> jokeList;
    Random randomGenerator = new Random();

    public MyJokeClass(){

        jokeList = new ArrayList<>();

        jokeList.add("JOKE NO ONE");
        jokeList.add("JOKE NO TWO");
        jokeList.add("JOKE NO THREE");
        jokeList.add("JOKE NO FOUR");
        jokeList.add("JOKE NO FIVE");
        jokeList.add("JOKE NO SIX");
        jokeList.add("JOKE NO SEVEN");
    }

    public String pullJoke(){

        int i = randomGenerator.nextInt(jokeList.size());
        return jokeList.get(i);
    }
}
