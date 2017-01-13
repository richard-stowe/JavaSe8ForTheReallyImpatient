package io.scrumbox.java8.chapter1;

import java.io.File;
import java.util.Collection;

import static java.util.Arrays.asList;

public class Chapter1Exercise02 {


    public Collection<File> getSubdirectories(File parent) {
        return asList(parent.listFiles(File::isDirectory));
    }

}
