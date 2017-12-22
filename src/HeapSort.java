import java.util.Arrays;

public class HeapSort {

    //进行Heap排序
    public static void ToSort(int[] data){
        int Length = data.length;
        //循环建堆，输出最后一个节点，达到排序的目的
        for (int i = 0; i < Length - 1; i++) {
            //按条件调整堆：
            HeadAdjust(data, Length - i - 1);
            System.out.println("第"+(i+1)+"次调整："+Arrays.toString(data));
            //交换根节点和最后一个节点
            Swap(data, 0, Length - i - 1);
            //输出最后一个节点
            System.out.println("第"+(i+1)+"次排序："+Arrays.toString(data));
        }
    }

    //调整堆：按照具体排序要求调整为 小顶堆 或 大顶堆,以下调整以大顶堆为例
    private static void HeadAdjust(int[] data,int lastIndex)  {
        //由于向下取整的特性，lastIndex - 1 后可以优化一些情况下的循环次数；
        //从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex-1) / 2; i >= 0; i--) {

           int k = i ; //记录当前比对的位置

            while (k * 2 + 1 <= lastIndex) {//判断是否存在孩子，由于是完全二叉树，不存在左孩子为空，右孩子存在的情况；

                int biggerForChilden = 2 * k + 1;//暂时存放存在的左孩子

                //判断右孩子存不存在；
                if (biggerForChilden + 1 <= lastIndex) {
                    //比较两个孩子那个比较大
                    if (data[biggerForChilden] < data[biggerForChilden + 1]) {

                        //取两者的最大值
                        biggerForChilden += 1;
                    }
                }

                //孩子中最大者 与父亲比较，
                if (data[k] < data[biggerForChilden]) {

                    //比父亲大则交换
                    Swap(data, k, biggerForChilden);

                    //把交换后的下标赋值给K，进行下一次循环，保证该节点下的子树满足条件
                    k = biggerForChilden;
                }else
                    break;
            }
        }
    }

    //交换方法
    private static void Swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
