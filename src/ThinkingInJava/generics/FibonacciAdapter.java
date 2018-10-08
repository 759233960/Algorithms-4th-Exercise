package ThinkingInJava.generics;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public final class FibonacciAdapter implements Iterable<Integer> {

    private Fibonacci fibonacci;

    private int n;

    public FibonacciAdapter(Fibonacci fibonacci, int n) {
        this.fibonacci = fibonacci;
        this.n = n;
    }

    public static void main(String[] args) {
        for (int i : new FibonacciAdapter(new Fibonacci(), 18))
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
                return fibonacci.nextItem();
            }
        };
    }
}
