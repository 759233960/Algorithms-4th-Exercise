package exercise.chapter1_3;

import edu.princeton.cs.algs4.StdIn;

public class Ex04 {
    public static void main(String[] args) {
        boolean answer = false;
        Stack<Character> s = new Stack<>();
        while (!StdIn.isEmpty()) {
            char c = StdIn.readChar();
            if (c == ')') {
                try {
                    if (s.pop() == '(') {
                        answer = true;
                    } else {
                        answer = false;
                        break;
                    }
                } catch (NullPointerException e) {
                    System.out.println(e);
                }

            } else {
                s.push(c);
            }
        }
        System.out.println(answer);
    }
}
