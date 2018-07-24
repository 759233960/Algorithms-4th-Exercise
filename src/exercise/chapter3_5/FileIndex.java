package exercise.chapter3_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.io.File;

public class FileIndex {
    public static void main(String[] args) {
        ST<String, SET<File>> st = new ST<>();
        for (String fileName : args) {
            File file = new File(fileName);
            In in = new In(file);
            while (!in.isEmpty()) {
                String word = in.readString();
                if (!st.contains(word)) st.put(word, new SET<>());
                SET<File> set = st.get(word);
                set.add(file);
            }
        }

        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.contains(query))
                for (File file : st.get(query))
                    System.out.println(" " + file.getName());
            else System.out.println("Not found");
        }
    }
}
