package LeetCodeExcercise;

import exercise.chapter1_3.Stack;

/**
 * 445. 两数相加 II
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶:
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
public class ex445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode p = l1, q = l2;
        while (p != null) {
            stack1.push(p.val);
            p = p.next;
        }
        while (q != null) {
            stack2.push(q.val);
            q = q.next;
        }
        int carry = 0;
        ListNode first = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = x + y + carry;
            carry = sum / 10;
            ListNode temp = first;
            first = new ListNode(sum % 10);
            first.next = temp;
        }
        if (carry > 0) {
            ListNode temp = first;
            first = new ListNode(carry);
            first.next = temp;
        }
        return first;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode rl1 = reverse(l1);
        ListNode rl2 = reverse(l2);

        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        ListNode p = rl1, q = rl2;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) curr.next = new ListNode(carry);
        return reverse(dummyHead.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

