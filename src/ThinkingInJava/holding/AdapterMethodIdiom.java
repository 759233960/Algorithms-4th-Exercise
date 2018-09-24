package ThinkingInJava.holding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class AdapterMethodIdiom {
    public static void main(String[] args) {
        ReversibleArrayList<String> strings = new ReversibleArrayList<>(Arrays.asList(("to be " +
                "number one").split(" ")));
        for (String s : strings)
            System.out.print(s + " ");
        System.out.println("\n--------------------");
        for (String s : strings.reversed())
            System.out.print(s + " ");
    }
}

class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c) {
        super(c);
    }

    public Iterable<T> reversed() {
        return new Iterable<T>() {
            @NotNull
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;

                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }
                };
            }
        };
    }

}
