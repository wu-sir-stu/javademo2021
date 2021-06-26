package top.wusir.sort;

/**
 * @title: InsertSort
 * @Author wusir
 * @Date: 2021/6/9 21:01
 * @Version 1.0
 */
public class InsertSort {
    public static void main(String[] args) {

        int[] x={4,3,5,2,5,1,6};
        //sort(x);
        //shellSort(x);
        //bubbleSort(x);
        //quickSort(x,0,x.length-1);
        selectSort(x);
        for (int i:x) {
            System.out.println(i);
        }
    }

    /**
     * 插入排序将无序区数据插入到有序区合适的位置
     * @param x
     * @return
     */
    public static int[] sort(int[] x){
        int flag;
        for (int i=0;i<x.length;i++){
            flag=x[i];
            int j;
            for (j=i-1;j>=0&&x[j]>flag;j--){
                //有序区数据比待排序区数据大，一次往后移动
                x[j+1]=x[j];
            }
            x[j+1]=flag;

        }

        return x;
    }

    /**
     * 希尔排序 将数据按组划分进行组内排序
     * @param x
     * @return
     */
    public static int[] shellSort(int[] x){
        for (int d=x.length/2; d >= 1; d=d/2) {//将数组依次划分成大小为d的数组
            for (int i = d; i <x.length ; i++) {//依次从划分的第一个数组获取第二个数据开始，和之前的数据进行比较，每次往后都将该组中坐标i+1之前的数据全部排序
                int flag=x[i];
                int j;
                for (j=i-d;j>=0&&flag<x[j];j=j-d){//j定位该数组中需要将数据插入的地方
                    x[j+d]=x[j];

                }
                x[j+d]=flag;
            }
        }
        return x;
    }


    /**
     * 冒泡排序 最大值一起交换放到最后面
     * @param x
     * @return
     */
    public static int[] bubbleSort(int[] x){

        //确定上一次交换的最后的位置，初始化为数组最后以为
        int exchange=x.length-1;
        while (exchange!=0){
            int bound=exchange;
            exchange=0;
            for (int i = 0; i < bound; i++) {
                if (x[i]>x[i+1]){
                    //交换
                    int r=x[i];
                    x[i]=x[i+1];
                    x[i+1]=r;
                    exchange=i;
                }
            }
        }

        return x;
    }

    /**
     * 快速排序 将数据划分成两段 一次交换排序，左侧的值比中间的值小，右侧的值比中间大，递归进行
     * @param x
     * @param first
     * @param end
     */
    public static  void quickSort(int[] x,int first,int end){

       if(first<end){
           //第一遍快排
           int r=Partition(x,first,end);
           //递归
           quickSort(x,first,r-1);
           quickSort(x,r+1,end);
       }

    }

    public static int Partition(int[] x,int first,int end){
        int i=first,j=end;
        while (i<j){
            while(i<j&&x[i]<=x[j]){
                j--;
            }
            //跳出循环则是x[i]>x[j]或者i>=j
            if(i<j){
                //交换
                int r=x[i];
                x[i]=x[j];
                x[j]=r;
                i++;//左侧开始遍历
            }
            while (i<j&&x[i]<=x[j]){
                i++;//右侧遍历
            }
            //跳出循环则是x[i]>x[j]或者i>=j
            if(i<j){
                //交换
                int r=x[i];
                x[i]=x[j];
                x[j]=r;
                j--;//右侧开始遍历
            }

        }

        return i;//最终i=j跳出循环
    }

    /**
     * 选择排序，选出最小值，一次放到数组前部
     * @param x
     * @return
     */
    public static int[] selectSort(int[] x){
        for (int i=0;i<x.length;i++){
            int min=i;
            for (int j=i+1;j<x.length;j++){
                if(x[j]<x[min]){//找出最小值位置
                    min=j;
                }
            }
            //交换
            int r=x[i];
            x[i]=x[min];
            x[min]=r;
        }
        return x;
    }
}
