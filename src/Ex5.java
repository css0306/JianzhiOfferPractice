// 5.输入一个链表，从尾到头打印链表每个节点的值。

// 思路：借助栈实现，或使用递归的方法。

import java.util.ArrayList;
import java.util.Stack;

public class Ex5 {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null)
            return list;
        Stack<ListNode> stack = new Stack<>();
        while(listNode != null){
            stack.push(listNode);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop().val);
        }
        return list;
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1); // 结点1，储存的元素值为1，下一跳为结点2
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(printListFromTailToHead(listNode1));
    }
}
