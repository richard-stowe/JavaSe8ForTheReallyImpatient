package io.scrumbox.java8.chapter1;

import java.io.File;
import java.util.Arrays;

import static java.lang.Boolean.compare;

public class Chapter1Exercise04 {

    public void orderFiles(File[] files) {
        Arrays.sort(files, (f1, f2) -> {
            int typeComparison = compare(f1.isDirectory(), f2.isDirectory()) * -1;
            return typeComparison == 0 ? f1.getName().compareTo(f2.getName()) : typeComparison;
        });
    }

}
