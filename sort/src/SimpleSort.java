import java.util.Arrays;

/**
 * revise sort
 *
 * @author zmh email: zmhzhaomenghui@gmail.com
 * @createDate 2018/7/27
 * @see "https://www.jianshu.com/p/8c915179fd02"
 */
public class SimpleSort {
    static int[] arr = {2, 3, 1, 2, 5, 4, 9, 7, 6};

    public static void main(String[] args) {
        print();

//        bubble();
//        choice();
//        binary();
        qsort(arr, 0, arr.length-1);
//        shellSort();


        print();
    }

    public static void shellSort() {
        int j    = 0;
        int temp = 0;
        //每次将步长缩短为原来的一半
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < arr.length; i++) {
                temp = arr[i];
                for (j = i; j >= increment; j -= increment) {
                    if (temp < arr[j - increment])//如想从小到大排只需修改这里
                    {
                        arr[j] = arr[j - increment];
                    } else {
                        break;
                    }

                }
                arr[j] = temp;
            }

        }
    }

    //快排1
    private static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot - 1);                   //递归排序左子数组
            qsort(arr, pivot + 1, high);                  //递归排序右子数组
        }
    }

    //快排2
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];     //枢轴记录
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];             //交换比枢轴小的记录到左端
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }

    static void print() {
        System.out.println(Arrays.toString(arr));

    }

    private static void bubble() {
        print();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int m = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = m;
                }
            }
        }
        print();
    }

    private static void choice() {
        print();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int m = arr[i];
                    arr[i] = arr[j];
                    arr[j] = m;
                }
            }
        }
        print();
    }

    private static void binary() {
        print();
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int low  = 0, high = i - 1;
            int mid  = -1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (arr[mid] > temp) {
                    high = mid - 1;
                } else { // 元素相同时，也插入在后面的位置
                    low = mid + 1;
                }
            }
            if (i - low >= 0) System.arraycopy(arr, low, arr, low + 1, i - low);
            arr[low] = temp;
        }
        print();
    }
}
