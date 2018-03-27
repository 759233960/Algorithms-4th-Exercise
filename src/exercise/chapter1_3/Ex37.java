package exercise.chapter1_3;

import edu.princeton.cs.algs4.StdIn;

/**
 * Josephus problem!
 * w(n,k) = ( w(n-1,k) + k ) % n
 * T = O(n)
 */
public class Ex37 {
    public static void main(String[] args) {
        System.out.println("Please input amount: ");
        int N = StdIn.readInt();
        System.out.println("Please input interval: ");
        int M = StdIn.readInt();
        killed(N, M);
    }

    private static void killed(int N, int M) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }
        System.out.println("All people is " + N + " ; interval is " + M);
        System.out.print("Killed : ");
        while (queue.size() > 1) {
            for (int i = 0; i < M - 1; i++) {
                int temp = queue.dequeue();
                queue.enqueue(temp);
            }
            int kill = queue.dequeue();
            System.out.print(" [" + kill + "] ");
        }
        System.out.println();
        System.out.println("Safe people is : " + queue.dequeue());

    }
}
