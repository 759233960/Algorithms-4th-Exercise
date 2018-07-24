package exercise.chapter3_5;

import com.sun.istack.internal.NotNull;
import edu.princeton.cs.algs4.StdOut;
import exercise.chapter3_3.RedBlackBST;

import java.util.Iterator;

public class MultiSET<Key extends Comparable<Key>> implements Iterable<Key> {

    private static final Object ELEMENT = new Object();
    private RedBlackBST<Key, Integer> set;

    public MultiSET() {
        set = new RedBlackBST<>();
    }

    public MultiSET(MultiSET<Key> x) {
        this.set = x.set;
    }

    /**
     * Unit tests the {@code SET} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        MultiSET<String> set = new MultiSET<String>();
        StdOut.println("set = " + set);

        // insert some keys
        set.add("www.cs.princeton.edu");
        set.add("www.cs.princeton.edu");    // overwrite old value
        set.add("www.princeton.edu");
        set.add("www.math.princeton.edu");
        set.add("www.yale.edu");
        set.add("www.amazon.com");
        set.add("www.simpsons.com");
        set.add("www.stanford.edu");
        set.add("www.google.com");
        set.add("www.ibm.com");
        set.add("www.apple.com");
        set.add("www.slashdot.com");
        set.add("www.whitehouse.gov");
        set.add("www.espn.com");
        set.add("www.snopes.com");
        set.add("www.movies.com");
        set.add("www.cnn.com");
        set.add("www.iitb.ac.in");


        StdOut.println(set.contains("www.cs.princeton.edu"));
        StdOut.println(!set.contains("www.harvardsucks.com"));
        StdOut.println(set.contains("www.simpsons.com"));
        StdOut.println();

        StdOut.println("ceiling(www.simpsonr.com) = " + set.ceiling("www.simpsonr.com"));
        StdOut.println("ceiling(www.simpsons.com) = " + set.ceiling("www.simpsons.com"));
        StdOut.println("ceiling(www.simpsont.com) = " + set.ceiling("www.simpsont.com"));
        StdOut.println("floor(www.simpsonr.com)   = " + set.floor("www.simpsonr.com"));
        StdOut.println("floor(www.simpsons.com)   = " + set.floor("www.simpsons.com"));
        StdOut.println("floor(www.simpsont.com)   = " + set.floor("www.simpsont.com"));
        StdOut.println();

        StdOut.println("set = " + set);
        StdOut.println();

        // print out all keys in this set in lexicographic order
        for (String s : set) {
            StdOut.println(s);
        }

        StdOut.println();
        MultiSET<String> set2 = new MultiSET<String>(set);
        StdOut.println(set.equals(set2));
    }

    public int size() {
        return set.size();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public boolean contains(@NotNull Key key) {
        return set.contains(key);
    }

    public boolean add(@NotNull Key key) {
        if (key == null) throw new IllegalArgumentException();
        if (set.contains(key)) {
            set.put(key, count(key) + 1);
            return false;
        }
        set.put(key, 1);
        return true;
    }

    public int count(Key key) {
        if (key == null) throw new IllegalArgumentException();
        return set.get(key);
    }

    public boolean remove(@NotNull Key key) {
        if (set.contains(key)) {
            set.delete(key);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = set.toString();
        return "{" + s.substring(1, s.length() - 1) + "}";
    }

    @Override
    public Iterator<Key> iterator() {
        return set.iterator();
    }

    public Key ceiling(Key key) {
        return set.ceiling(key);
    }

    public Key floor(Key key) {
        return set.floor(key);
    }
}
