package com.lwy.sort;

import java.util.Arrays;

public class Heapsort {
    public static void main(String[] args) {
        Heapsort heapsort = new Heapsort();
        int[] arr =new int[]{9,8,2,3,6,5,1,8,9,0};
        heapsort.heapSort(arr);
        for (int i:arr){
            System.out.print(i);
        }
    }
    public static void heapSort(int arr[]){
        for(int i = arr.length/2 -1; i>= 0;i--){              //构建堆
            arrHeap(arr,i,arr.length);
        }
        for (int i = arr.length-1; i >0 ; i--) {          //排序
            swap(arr,i,0);
            arrHeap(arr,0,i);
        }
    }/**
     * 调整大顶堆
     * @param arr
     * @param i 当前节点
     * @param length 长度
     */
    public static void arrHeap(int arr[],int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置

    }
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class Heapsort2{
    /**
     * 堆排序
     */

        //创建大顶堆
        public static void maximumHeap(int k, int[] arr,int m) {
            int i, j, temp;
            boolean finished;
            i = k;
            j = 2*i+1;
            temp = arr[k];
            finished = false;
            while((j <= m) && !finished){
                //孩子结点位置小于数组长度 且 右孩子大于左孩子
                if ((j < m) && (arr[j+1] > arr[j])){
                    j++;    //把右孩子结点当作最大孩子结点
                }
                //如果最大的孩子结点小于其根节点
                if (temp >= arr[j]){
                    finished = true;    //结束循环
                }else{
                    //把最大子节点赋给根结点
                    arr[i] = arr[j];
                    i = j;
                    //循环下一个根结点
                    j = 2*j+1;
                }
            }
            arr[i] = temp;
        }

        //交换
        public static void heapsort(int[] arrays) {
            int i;
            //从最后一个非叶节点开始构建大顶堆
            for (i = arrays.length / 2 - 1; i >= 0; i--) {
                maximumHeap(i, arrays, arrays.length);
            }
            System.out.println("建堆后：" + Arrays.toString(arrays));
            //从最小的叶子节点开始与根节点进行交换并重新构建大顶堆
            for (i = arrays.length - 1; i >= 1; i--) {
                int temp = arrays[i];
                arrays[i] = arrays[0];
                arrays[0] = temp;
                maximumHeap(0, arrays,i-1);
            }
            System.out.println(Arrays.toString(arrays));
        }

        public static void main(String[] args) {
            int[] arrays = {49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1};
            heapsort(arrays);
        }

}

class HeapSort3{
    static int len ;
    public static void main(String[] args) {
        int[] arr = {3,5,7,9,1,2,6,4,8};
        len = arr.length;
        HeapSort(arr);
        for (int i:arr){
            System.out.println(i);
        }

    }
    public static void HeapSort(int[] arr){
        if(len<1){
            return;
        }
        //构建大顶堆
        build(arr);
        //排序
        while (len >0){
            swap(arr,0,len-1);       //现在顶上的数字是最大的 交换到最后一位上
            len--;
            cheap(arr,0);        //再次重构 让顶上的数字再最大
        }
    }
    public static void build(int[] arr){
        for (int i=(len /2) -1;i>=0;i--){
            cheap(arr,i);
        }
    }
    public static void cheap(int[] arr,int index){         //重构 保证顶上是最大的数字
        int max = index;
        if(index * 2 < len && arr[index * 2] > arr[max]){
            max = index * 2;
        }

        if(index * 2 +1< len && arr[index * 2 +1] > arr[max]){
            max = index * 2 +1;
        }
        if(max != index){
            swap(arr,index,max);
            cheap(arr,max);
        }
    }
    public static void swap(int[] arr,int x,int y){
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }



}