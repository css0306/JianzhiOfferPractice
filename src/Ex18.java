//1.在静态方法中可以直接调用所在类的其他静态方法，却不可以直接调用非静态方法，而必须通过实例化之后调用非静态方法；
//2.与此相对的，在非静态方法中却可以直接调用所在类的所有静态方法和非静态方法。
// 体现在HasSubtree()和doesTree1HaveTree2()方法，虽然不是静态的，但都处于同一类中，可直接调用。

public class Ex18 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = doesTree1HaveTree2(root1, root2);
            }
            if (!result) {
                return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2){ //此方法基于根结点相同的情况，继续比较左右子结点是否都相同
        if(node2 == null){
            return true; // 注意这里返回的是true，因为该方法已经基于上一结点相同了，说明Tree2并不是空树，而此时Tree2已无下一个结点。
        }                // 实际上都是false的话哪里还能返回true啊，输入什么都是false，太蠢了
        if(node1 == null){
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }
}