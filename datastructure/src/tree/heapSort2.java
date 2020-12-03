package tree;
// 来自csdn
public class heapSort2 {
    public static void heapSort(int[] arr){
        buildMaxHeap(arr);
        int heapSize = arr.length;
        //最大值的节点与最后一个节点交换位置
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //最后一个节点为最大值后，再对前边节点进行堆排序，每交换出一个最大值，最大堆的大小减1
            heapSize--;
            maxHeapify(arr, 0, heapSize);
        }
    }
    /**
     * 4 3 9 5 10 2 6
     * 0 1 2 3 4  5 6
     *
     *       4
     *   3       9
     * 5   10  2   6
     *
     * @param arr 待排序的数组
     * @param index 要进行调整的节点位置
     * @param heapSize 最大堆的大小
     */
    public static void maxHeapify(int[] arr, int index, int heapSize) {
        int leftIndex = 2 * index + 1;//左节点
        int rightIndex = 2 * index + 2;
        int largeIndex;//临时存储三个节点中最大的节点
        if (leftIndex < heapSize && arr[leftIndex] > arr[index]) {
            largeIndex = leftIndex;
        } else {
            largeIndex = index;
        }
        if (rightIndex < heapSize && arr[rightIndex] > arr[largeIndex]) {
            largeIndex = rightIndex;
        }
        if (largeIndex != index) {
            //与最大值的节点交换位置
            int temp = arr[largeIndex];
            arr[largeIndex] = arr[index];
            arr[index] = temp;
            //递归的方式对新的节点进行最大堆调整
            maxHeapify(arr, largeIndex, heapSize);
        }
    }
    //建立最大堆，遍历其中的非叶子节点，调整位置，达到最大堆的特点，即父节点的值大于子节点的值
    public static void buildMaxHeap(int[] arr) {
        int heapSize = arr.length;
        for (int i = (arr.length - 2) / 2; i > -1; i--) {
            maxHeapify(arr, i, heapSize);
        }
    }

    public static void main(String args[]){
        int[] test = {4,3,9,5,10,2,6};
        heapSort(test);
        for(int i=0; i<test.length; i++){
            System.out.print(test[i] + " ");
        }
    }


}