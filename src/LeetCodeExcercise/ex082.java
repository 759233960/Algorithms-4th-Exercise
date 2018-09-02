package LeetCodeExcercise;


/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class ex082 {
    //递归实现
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val) {
            //如果当前结点是重复结点，则找到第一个与当前结点不同的开始递归。
            ListNode node = head.next;
            while (node != null && node.val == head.val) {
                node = node.next;
            }
            return deleteDuplicates(node);
        } else {
            //如果当前结点不是重复结点，保留当前结点，从下个结点开始递归。
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    //迭代实现
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                //出现重复
                while (curr.next != null && curr.val == curr.next.val)
                    curr = curr.next;
                pre.next = curr.next;
                curr.next = null;
                curr = pre.next;
                continue;
            }
            curr = curr.next;
            pre = pre.next;
        }
        return dummyHead.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
