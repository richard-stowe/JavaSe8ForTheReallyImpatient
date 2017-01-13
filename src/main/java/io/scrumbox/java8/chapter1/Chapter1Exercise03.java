package io.scrumbox.java8.chapter1;

import java.io.File;
import java.util.Collection;

import static java.util.Arrays.asList;

public class Chapter1Exercise03 {


    public Collection<File> getByExtenstion(File parent, String extension) {
        return asList(parent.listFiles((dir, name) -> name.endsWith(extension)));
    }


}
