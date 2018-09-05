package LeetCodeExcercise;

/**
 * 138. 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深度拷贝。
 */
public class ex138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode node = new RandomListNode(-1);
        node.next = head;
        RandomListNode curr = node;
        while (head != null) {
            curr.next = new RandomListNode(head.label);
            curr.next.random = head.random == null ? null : new RandomListNode(head.random.label);
            curr = curr.next;
            head = head.next;
        }
        return node.next;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
