//6.输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中
//都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
// (重建二叉树)

//                                  1
//                                /   \
//                               2     3
//                              /     / \
//                             4     5   6
//                              \        /
//                              7        8
import java.util.Arrays;

public class Ex6 {
    static class TreeNode { // 静态内部类TreeNode
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) { // pre前序遍历，in中序遍历
        if (pre == null || in == null) {
            return null;
        }
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        if (pre.length != in.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == in[i]) {
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }

    public static void printTree(TreeNode node) { // 后序打印
        if (node != null) {
            printTree(node.left);
            printTree(node.right);
            System.out.print(node.val + " "); //决定打印顺序的就是print相对两个迭代的位置
        }
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(preOrder, inOrder);
        printTree(root);
    }
}
//Arrays.copyOfRange(T[ ] original,int from,int to)
//        将一个原始的数组original，从小标from开始复制，复制到小标to，生成一个新的数组。
//        注意这里包括下标from，不包括上标to。 [from, to)
//        这个方法在一些处理数组的编程题里很好用，效率和clone基本一致，都是native method，比利用循环复制数组效率要高得多。
