package LeetCodeExcercise;

/**
 * 707. 设计链表
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next
 * 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index
 * 大于链表长度，则不会插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * <p>
 * 示例：
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 * <p>
 * 提示：
 * <p>
 * 所有值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 */
public class ex707 {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
//        System.out.println("linkedList.addAtHead(1);");
//        linkedList.addAtHead(1);
//        System.out.println(linkedList);
//        System.out.println("linkedList.addAtTail(3);");
//        linkedList.addAtTail(3);
//        System.out.println(linkedList);
//        System.out.println("linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3");
//        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
//        System.out.println(linkedList);
//        System.out.println("linkedList.get(1);            //返回2");
//        System.out.println(linkedList.get(1));
//        System.out.println("linkedList.deleteAtIndex(1);  //现在链表是1-> 3");
//        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//        System.out.println(linkedList);
//        System.out.println("linkedList.get(1);            //返回3");
//        System.out.println(linkedList.get(1));

        //-----------------------------------------------------------------------------------
        //["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex",
        // "addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
        //[[],[7],[2],[1],[3,0],[2],
        // [6],[4],[4],[4],[5,0],[6]]
//        linkedList.addAtHead(7);
//        System.out.println(linkedList);
//        linkedList.addAtHead(2);
//        System.out.println(linkedList);
//        linkedList.addAtHead(1);
//        System.out.println(linkedList);
//        linkedList.addAtIndex(3, 0);
//        System.out.println(linkedList);
//        linkedList.deleteAtIndex(2);
//        System.out.println(linkedList);
//        linkedList.addAtHead(6);
//        System.out.println(linkedList);
//        linkedList.addAtTail(4);
//        System.out.println(linkedList);
//        System.out.println(linkedList.get(4));
//        linkedList.addAtHead(4);
//        System.out.println(linkedList);
//        linkedList.addAtIndex(5, 0);
//        System.out.println(linkedList);
//        linkedList.addAtHead(6);
//        System.out.println(linkedList);

        //-----------------------------------------------------------------------------------
        //["MyLinkedList","addAtHead","addAtHead","deleteAtIndex","addAtIndex","addAtTail",
        // "addAtIndex","addAtTail","addAtHead","addAtHead","addAtHead","addAtTail","addAtTail",
        // "addAtHead","addAtTail","addAtTail","addAtHead","addAtTail","deleteAtIndex",
        // "addAtTail","addAtTail","get","addAtIndex","addAtHead","get","get","addAtHead","get",
        // "addAtIndex","addAtTail","addAtIndex","addAtHead","addAtHead","addAtHead","get",
        // "addAtHead","addAtIndex","addAtTail","addAtHead","addAtIndex","get","addAtTail",
        // "addAtTail","addAtIndex","addAtIndex","addAtHead","addAtHead","get","addAtTail",
        // "addAtIndex","addAtIndex","addAtHead","deleteAtIndex","addAtIndex","addAtHead",
        // "deleteAtIndex","addAtTail","deleteAtIndex","addAtTail","addAtHead","addAtTail",
        // "addAtTail","addAtHead","addAtTail","addAtIndex","deleteAtIndex","addAtHead",
        // "addAtHead","addAtHead","addAtTail","get","addAtIndex","addAtTail","addAtTail",
        // "addAtTail","deleteAtIndex","get","addAtHead","get","get","addAtTail","deleteAtIndex",
        // "addAtTail","addAtIndex","addAtHead","addAtIndex","addAtTail","get","addAtIndex",
        // "addAtIndex","addAtHead","addAtHead","get","get","get","addAtIndex","addAtHead",
        // "addAtIndex","addAtHead","addAtTail","addAtIndex","get"]
        //[[],[38],[45],[2],[1,24],[36],[3,72],[76],[7],[36],[34],[91],[69],[37],[38],[4],[66],
        // [38],[14],[12],[32],[5],[7,5],[74],[7],[13],[11],[8],[10,9],[19],[3,76],[7],[37],[99],
        // [10],[12],[1,20],[29],[42],[21,52],[11],[44],[47],[6,27],[31,85],[59],[57],[4],[99],
        // [13,83],[10,34],[48],[9],[22,64],[69],[33],[5],[18],[87],[42],[1],[35],[31],[67],[36,
        // 46],[23],[64],[81],[29],[50],[23],[36,63],[8],[19],[98],[22],[28],[42],[24],[34],[32],
        // [25],[53],[55,76],[38],[23,98],[27],[18],[44,27],[16,8],[70],[15],[9],[27],[59],[40,
        // 50],[15],[11,57],[80],[50],[23,37],[12]]


        linkedList.addAtHead(38);
        System.out.println(linkedList);
        linkedList.addAtHead(45);
        System.out.println(linkedList);
        linkedList.deleteAtIndex(2);
        System.out.println(linkedList);
        linkedList.addAtIndex(1, 24);
        System.out.println(linkedList);
        linkedList.addAtTail(36);
        System.out.println(linkedList);

    }
}

class MyLinkedList {
    private Node first;
    private int N;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        first = null;
        N = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return
     * -1.
     */
    public int get(int index) {
        if (index >= N || index < 0) return -1;
        Node curr = first;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr == null ? -1 : curr.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the
     * insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node temp = first;
        first = new Node(val);
        first.next = temp;
        N++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (isEmpty()) {
            addAtHead(val);
            return;
        }
        Node temp = node(N);
        Node curr = new Node(val);
        curr.next = temp.next;
        temp.next = curr;
        N++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals
     * to the length of linked list, the node will be appended to the end of linked list. If
     * index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > N || index < 0) return;
        if (isEmpty()) {
            addAtHead(val);
            return;
        }
        if (index == N) {
            addAtTail(val);
            return;
        }
        Node curr = node(index);
        Node temp = curr;
        curr = new Node(val);
        curr.next = temp.next;
        temp.next = curr;
        N++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= N || index < 0) return;
        if (isEmpty()) return;
        Node curr = first;
        Node pre = null;
        for (int i = 0; i < index; i++) {
            pre = curr;
            curr = curr.next;
        }
        if (curr.next == null) {
            if (pre != null)
                pre.next = null;
            else first = null;
        } else {
            curr.val = curr.next.val;
            curr.next = curr.next.next;
        }
        N--;
    }

    private boolean isEmpty() {
        return N == 0;
    }

    private Node node(int index) {
        Node temp = this.first;
        for (int i = 0; i < index - 1; ++i) {
            temp = temp.next;
        }
        return temp;
    }


    private void deleteLast() {
        if (isEmpty()) return;
        Node temp = node(N - 1);
        temp.next = null;
        N--;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node curr = first;
        s.append("list[N=").append(N).append("]: ");
        while (curr != null) {
            s.append(curr.val);
            curr = curr.next;
            if (curr != null) s.append(" -> ");
        }
        return s.toString();
    }

    private class Node {
        Node next;
        int val;

        public Node(int x) {
            val = x;
            next = null;
        }
    }
}
