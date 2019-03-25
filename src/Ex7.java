//7.用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
//        思路：一个栈压入元素，而另一个栈作为缓冲，将栈1的元素出栈后压入栈2中。也可以将栈1中的最后一个元
//        素直接出栈，而不用压入栈2中再出栈。
import java.util.Stack;

public class Ex7 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop() throws Exception{
        if (stack1.isEmpty() && stack2.isEmpty()){
            throw new Exception("stack is empty");
        }
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop()); // stack2接受stack1的出栈元素(把stack1中的元素都倒入stack2中)
            }
        }
        return stack2.pop(); //弹出stack2最上方元素
    }
}
