/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/1
*/

package sparsearray;
//import java.util.Scanner;

import java.io.*;
import java.util.Arrays;
/*
要求：
1)	在前面的基础上，将稀疏数组保存到磁盘上，比如 map.data
2)	恢复原来的数组时，读取 map.data 进行恢复
 */
// 实现二维数组转稀疏数组以及稀疏数组转二维数组
public class SparseArray2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        arr2sparse();
        sparse2arr();
    }

    // 读取map.dat文件，得到稀疏数组，将其转为原始数组
    public static void  sparse2arr() throws IOException, ClassNotFoundException {
        String savepath="E:\\Java_IntelliJ_IDEA_WorkSpace\\MyProjects\\project00\\src\\javaStudy\\java数据结构和算法\\尚硅谷_韩顺平\\代码\\my\\dataStructure\\sparsearray\\map.dat";
        FileInputStream fileInputStream = new FileInputStream(savepath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        int[][]sparseArr = (int[][])objectInputStream.readObject(); // 读取稀疏数组
        int[][]chessArr2=new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }

        // 输出  恢复后的数组
        System.out.println("恢复后的数组");
        for(int[]temp:chessArr2){
            System.out.println(Arrays.toString(temp));
        }


    }

    public static void  arr2sparse() throws IOException {
        // 创建一个原始的二维数组 11*11
        // 0表示无淇，1表示黑子，2表示蓝子
        int[][]chessArr1=new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        chessArr1[4][7]=2;
        // 调用重载函数，将二维数组转为稀疏数组，并保存为文件
        arr2sparse(chessArr1);

    }


    // 将数组转为稀疏数组，并保存为map.dat文件
    public static  void arr2sparse(int[][]chessArr1) throws IOException {
        // 将二维数组转为稀疏数组
        // 1,先得到有效数据，非0
        int sum=0;
        for (int i = 0; i <chessArr1.length ; i++) {
            for (int j = 0; j <chessArr1[0].length ; j++) {
                if(chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        // 2，创建稀疏数组
        int[][]sparseArr=new int[sum+1][3];
        // 给稀疏数组赋值
        sparseArr[0][0]=chessArr1.length;
        sparseArr[0][1]=chessArr1[0].length;
        sparseArr[0][2]=sum;

        int count=0; // 记录是第几个非0数据
        for (int i = 0; i <chessArr1.length ; i++) {
            for (int j = chessArr1[0].length - 1; j >= 0; j--)
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];

                }
        }
        // 将sparseArr写入文件中
        String savepath="E:\\Java_IntelliJ_IDEA_WorkSpace\\MyProjects\\project00\\src\\javaStudy\\java数据结构和算法\\尚硅谷_韩顺平\\代码\\my\\dataStructure\\sparsearray\\map.dat";
        FileOutputStream fileOutputStream = new FileOutputStream(savepath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(sparseArr);

    }

}
