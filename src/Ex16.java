//16.输入一个链表，反转链表后，输出链表的所有元素。
//思路：定义两个指针，反向输出

public class Ex16 {
    public static ListNode ReverseList(ListNode head) {
// 将当前节点head的下一个节点head.next缓存到temp后，然后更改当前节点指针指向上一结点。
// 也就是说在反转当前结点指针指向前，先把当前结点的指针域用temp临时保存，以便下一次使用
        if (head == null) { //当前结点为null说明位于尾结点
            return null;
        }
        ListNode temp = null;
        ListNode p;
        while (head != null) {
            p = head.next; // 值,地址，next指针域全部都会复制
            head.next = temp;
            temp = head;
            head = p;
        }
        return temp;
    }

    public static void PrintNode(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        System.out.print("node1:"+node1 +" "+ "node2:"+node2+ " "+ "node3:"+node3+"\n");
        ReverseList(node1);
        PrintNode(node4);
    }
}
