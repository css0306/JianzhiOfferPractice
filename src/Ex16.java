//16.输入一个链表，反转链表后，输出链表的所有元素。
//思路：定义两个指针，反向输出

public class Ex16 {
    public static ListNode ReverseList(ListNode head){
// 将当前节点cur的下一个节点 cur.getNext()缓存到temp后，然后更改当前节点指针指向上一结点pre。
// 也就是说在反转当前结点指针指向前，先把当前结点的指针域用tmp临时保存，以便下一次使用
        if(head == null){
            return null;
        }
        ListNode temp = null;
        while(head != null){
            ListNode p = head.next;
            head.next = temp;
            temp = head;
            head = p;
        }
        return temp;
    }
    public static void PrintNode(ListNode node){
        while (node != null){
            System.out.println(node.val);
            node = node.next;
//            PrintNode(node.next);
        }
    }
    public static void main(String[] args){
        ListNode node1= new ListNode(1);
        ListNode node2= new ListNode(2);
        ListNode node3= new ListNode(3);
        node1.next=node2; node2.next=node3;
        ReverseList(node1);
        PrintNode(node3);
    }
}
