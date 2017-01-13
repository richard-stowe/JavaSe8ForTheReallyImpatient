package io.scrumbox.java8.chapter1;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Chapter1Exercise01 {

    @Getter
    private Collection<Long> threadIds = new HashSet<>();

    public void sort(String[] unsorted) {
        threadIds.add(Thread.currentThread().getId());

        Arrays.sort(unsorted, (o1, o2) -> {
            threadIds.add(Thread.currentThread().getId());
            return o1.compareTo(o2);
        });
    }

}
