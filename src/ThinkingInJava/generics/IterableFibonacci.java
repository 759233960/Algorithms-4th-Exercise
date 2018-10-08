package ThinkingInJava.generics;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public final class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;

    public IterableFibonacci(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18))
            System.out.print(i + " ");
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return nextItem();
            }
        };
    }
}
