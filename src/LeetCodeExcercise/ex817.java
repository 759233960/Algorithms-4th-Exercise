package LeetCodeExcercise;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. Linked List Components
 * We are given head, the head node of a linked list containing unique integer values.
 * <p>
 * We are also given the list G, a subset of the values in the linked list.
 * <p>
 * Return the number of connected components in G, where two values are connected if they appear
 * consecutively in the linked list.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 * Example 2:
 * <p>
 * Input:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected
 * components.
 * Note:
 * <p>
 * If N is the length of the linked list given by head, 1 <= N <= 10000.
 * The value of each node in the linked list will be in the range [0, N - 1].
 * 1 <= G.length <= 10000.
 * G is a subset of all values in the linked list.
 * <p>
 * 简而言之：
 * 输入一个链表，以及一个set，set中元素为链表的子结点。
 * 问：set中的元素组成链表几个连续的部分？
 */
public class ex817 {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> g = new HashSet<>();
        int num = 0;
        for (int i : G)
            g.add(i);
        while (head != null) {
            if (g.contains(head.val)) {
                if (head.next == null || !g.contains(head.next.val))
                    num++;
            }
            head = head.next;
        }
        return num;
    }

    public int numComponents2(ListNode head, int[] G) {
        Set<Integer> g = new HashSet<>();
        for (int i : G) g.add(i);
        int nums = 0;
        while (head != null) {
            if (g.contains(head.val)) {
                ++nums;
                ListNode next = head.next;
                while (next != null && g.contains(next.val)) {
                    next = next.next;
                }
                head = next;
                continue;
            }
            head = head.next;
        }
        return nums;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
