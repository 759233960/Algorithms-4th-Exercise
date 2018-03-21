package exercise.chapter1_3;

import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        Stack<Integer> stack;
        stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            stack.push(StdIn.readInt());
        }

        for (int i : stack) {
            System.out.println(i);
        }

        System.out.println();

        System.out.println(stack.size());

        System.out.println();

        while (!stack.empty())
            System.out.println(stack.pop());
    }
}
