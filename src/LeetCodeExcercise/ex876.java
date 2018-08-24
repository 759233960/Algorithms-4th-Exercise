package LeetCodeExcercise;

/**
 * <Middle of the Linked List>\
 * 《链表的中间结点》
 * <p>
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 * <p>
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * <p>
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * <p>
 * Example 2:
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 * <p>
 * Note:
 * The number of nodes in the given list will be between 1 and 100.
 * <p>
 * 示例 2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * <p>
 * 解决方案
 * [方法一：输出到数组]
 * 思路和算法:按顺序将每个结点放入数组 A 中。然后中间结点就是 A[A.Length/2]，因为我们可以通过索引检索每个结点。
 * class Solution {
 * public ListNode middleNode(ListNode head) {
 * ListNode[] A = new ListNode[100];
 * int t = 0;
 * while (head.next != null) {
 * A[t++] = head;
 * head = head.next;
 * }
 * return A[t / 2];
 * }
 * }
 * 复杂度分析:
 * 时间复杂度：O(N)O(N)，其中 NN 是给定列表中的结点数目。
 * 空间复杂度：O(N)O(N)，A 用去的空间。
 * <p>
 * [方法二：快慢指针法]
 * 思路和算法:当用慢指针 slow 遍历列表时，让另一个指针 fast 的速度是它的两倍。当 fast 到达列表的末尾时，slow 必然位于中间。
 * class Solution {
 * public ListNode middleNode(ListNode head) {
 * ListNode slow = head, fast = head;
 * while (fast != null && fast.next != null) {
 * slow = slow.next;
 * fast = fast.next.next;
 * }
 * return slow;
 * }
 * }
 * 复杂度分析:
 * 时间复杂度：O(N)O(N)，其中 NN 是给定列表的结点数目
 * 空间复杂度：O(1)O(1)，slow 和 fast 用去的空间。
 */
public class ex876 {
    public ListNode middleNode(ListNode head) {
        int total = 0;
        ListNode curr = head;
        while (curr != null) {
            total++;
            curr = curr.next;
        }
        curr = head;
        for (int i = 0; i < total / 2; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public ListNode middleNode2(ListNode head) {
        ListNode curr = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            curr = curr.next;
        }
        return curr;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
