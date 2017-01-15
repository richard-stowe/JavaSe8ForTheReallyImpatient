package io.scrumbox.java8.chapter1;

import io.scrumbox.java8.exception.MyCheckedException;

public class Chapter1Exercise06 {

    public void action() {
        new Thread(uncheck(() -> {
            throw new MyCheckedException();
        })).run();
    }

    private static Runnable uncheck(RunnableEx runnableEx) {
        return () -> {
            try {
                runnableEx.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    @FunctionalInterface
    private interface RunnableEx {
        void run() throws Exception;
    }

}
