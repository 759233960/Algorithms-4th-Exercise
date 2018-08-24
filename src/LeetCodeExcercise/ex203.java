package LeetCodeExcercise;

/**
 * 203. 删除链表中的节点
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class ex203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        if (curr.val == val) {
            curr = curr.next;
        }
        ListNode temp = head;
        while (curr != null) {
            if (curr.val == val) {
            } else {
                temp.next = curr;
            }
            curr = curr.next;
        }
        return temp;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
