// 3.在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完
// 成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

// 思路：从右上角或左下角开始找，逐行删除，或者用二分法查找

public class Ex3 {
    public static boolean find(int[][] array, int target) {
        if (array == null) {
//            System.out.println("null");
            return false;
        }
        int row = 0;
        int column = array[0].length - 1;

        while (row < array.length && column >= 0)
            if (array[row][column] == target) {
                System.out.println("true");
                return true;
            }
        if (array[row][column] > target) {
            column--;
        } else {
            row++;
        }
        System.out.println("false");
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2}, {4, 5}, {7, 8}, {9, 10}};
        find(array, 1);
    }
}

