package com.lwy.sort;

public class Quicksort {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,5,4,6,7,9,8};
        int[] ints1 = quickSort(ints);
        for (int i:ints1){
            System.out.print(i);
        }
    }
    public static int[] quickSort(int[] array) {
        int len;
        if(array == null || (len = array.length) == 0 || len == 1)
            return array;

        testsort01(array, 0, len - 1);
        return array;
    }

    /**
     * 快排核心算法，递归实现
     * @param array
     * @param left
     * @param right
     */
    public static void sort(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while(i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while(array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }


    public static void testsort01(int[] array,int left,int right){

        if(left > right){
            return;
        }
        //标志位 左右指针
        int x = left;
        int y = right;
        int flag = array[left];

        while (x!= y){
            while (array[y] >flag && y>x){
                y--;
            }

            while (array[x] < flag && y>x){
                x++;
            }

            if(x<y){
                int t = array[x];
                array[x] = array[y];
                array[y] = t;
            }
        }

        int t = array[x];
        array[left] = t;
        array[x] = flag;
        sort(array,left,x-1);
        sort(array,x+1,right);




    }
}
