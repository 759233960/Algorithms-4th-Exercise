package exercise.chapter1_3;

public class Ex19_20<Item> {
    private Node first;

    /**
     * 删除任意链表尾节点
     *
     * @param N 链表删除位置
     */
    private void deleteLink(int N) {
        Node lastBefore = first;
        if (N == 1) {
            first = null;
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            lastBefore = lastBefore.next;
        }
        lastBefore.next = null;
    }

    private class Node {
        Node next;
        Item item;
    }
}
