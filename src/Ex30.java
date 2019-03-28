//30.输入n个整数，找出其中最小的K个数。
//   思路：先排个序

import java.util.ArrayList;

public class Ex30 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        quicksort(input, 0, input.length-1);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<k; i++){
            list.add(input[i]);
        }
        return list;
    }

    public static void quicksort(int array[], int low, int high){
        int i,j;
        int pivot;
        if(low>=high)
            return;
        i = low;
        j = high;
        pivot = array[i];
        while(i<j){
            while(i<j && array[j] > pivot)
                j--;
            if(i<j)
                array[i++] = array[j];
            while(i<j && array[i] < pivot)
                i++;
            if(i<j)
                array[j--] = array[i];
        }
        array[i] = pivot;
        quicksort(array, low, i-1);
        quicksort(array, i+1, high);
    }
}