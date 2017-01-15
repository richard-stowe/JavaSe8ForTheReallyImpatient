package io.scrumbox.java8.chapter1;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Chapter1Exercise07 {

    @Getter
    private List<String> output = new ArrayList<>();

    public void action() {
        new Thread(andThen(
                () -> output.add("Runnable 1"),
                () -> output.add("Runnable 2"),
                () -> output.add("Runnable 3")
        )).run();
    }

    public static Runnable andThen(Runnable... runnables) {
        return () -> asList(runnables).forEach(Runnable::run);
    }

}
