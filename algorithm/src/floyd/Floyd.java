/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/21
*/

package floyd;
//import java.util.Scanner;
// 弗洛伊德算法，计算最短路径

import java.util.Arrays;

public class Floyd {
    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //创建邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
        matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
        matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
        matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
        matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
        matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
        matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };
        Graph graph = new Graph(vertex.length, matrix, vertex);
        graph.floyd();
        graph.show();


    }


}


class Graph{
    char[]vertex;// 存放顶点
    int[][]dis;//  保存从各个顶点出发，到其他节点的距离，也就是保留最后结果
    int[][]pre;// 记录到达目标顶点的前驱顶点

    public Graph(int length,int[][]matrix,char[]vertex) {
        this.vertex=vertex;
        this.dis=matrix;
        this.pre=new int[length][length];
        // 对pre初始化
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < pre.length; j++) {
                pre[i][j]=i;
            }
        }


    }

    // 显示方法pre 和dis
    public void show(){
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        System.out.println("dis数组");
        for (int i = 0; i <dis.length ; i++) {
            for (int j = 0; j < dis[0].length; j++) {
                System.out.print("<"+vertex[i]+"到"+vertex[j]+"="+dis[i][j]+">   ");
            }
            System.out.println();
        }

        System.out.println("pre数组");
        for (int i = 0; i <pre.length ; i++) {
            for (int j = 0; j < pre[0].length; j++) {
                System.out.print(vertex[pre[i][j]]+"  ");
            }
            System.out.println();
        }
        System.out.println();

    }

    // floyd算法
    public void floyd(){
        int len=0; // 保存距离
        // 代表中间顶点的遍历 'A', 'B', 'C', 'D', 'E', 'F', 'G'
        for (int k = 0; k < dis.length; k++) {
            // 出发顶点遍历 'A', 'B', 'C', 'D', 'E', 'F', 'G'
            for (int i = 0; i < dis.length; i++) {
                // 终点遍历 'A', 'B', 'C', 'D', 'E', 'F', 'G'
                for (int j = 0; j < dis.length; j++) {
                    len=dis[i][k]+dis[k][j];
                    if(len<dis[i][j]){
                        dis[i][j]=len; // 更新距离
                        pre[i][j]=pre[k][j];// 更新前驱顶点
                    }


                }
            }
        }


    }




}

