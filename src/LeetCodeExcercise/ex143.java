package LeetCodeExcercise;

/**
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class ex143 {
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head, curr = head;
        ListNode reverse = null;
        //寻找中间结点slow
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //将后半部分链表翻转
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = reverse;
            reverse = slow;
            slow = temp;
        }
        //合并两个链表C-R-C-R-C-R···
        //末尾结点两种情况：
        //1.C和R为同一个，以R!=null为循环结束判断条件:···-C/R-null
        //2.R为最后一个，以R.next!=null为循环结束判断条件:···-C-R-null
        while (reverse != null && reverse.next != null) {
            ListNode temp = curr.next;
            ListNode tempR = reverse.next;
            curr.next = reverse;
            reverse.next = temp;
            curr = temp;
            reverse = tempR;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
