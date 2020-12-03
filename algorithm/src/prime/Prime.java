/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/19
*/

package prime;
//import java.util.Scanner;

import java.util.Arrays;

public class Prime {
    public static void main(String[] args) {
        char[]data={'A','B','C','D','E','F','G'};
        int verxs=data.length;
        // 邻接矩阵的关系用二维数组表示
        // 10000代表没有直接连接
        int[][]weight={{10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};


        MGraph mGraph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph,verxs,data,weight);
        //输出
//        minTree.showGraph(mGraph);

        minTree.prim(mGraph,0);



    }

}

// 创建最小生成树
class MinTree{
    // 创建图的邻接矩阵
    public void createGraph(MGraph graph,int verxs,char[]data,int[][]weight){
        for(int i=0;i<verxs;i++){// 顶点
            graph.data[i]=data[i];
            for (int j = 0; j < verxs; j++) {
                graph.weight[i][j]=weight[i][j];
            }
        }
        
    }

    // 显示图
    public void showGraph(MGraph graph){
        for (int link []: graph.weight) {
            System.out.println(Arrays.toString(link));
        }

    }

    // 编写prime 算法，得到最小生成树
    // 输入图，v表示从图的第几个顶点开始生成
    public void prim(MGraph graph,int v){
        // 标记节点是否被访问过，0代表没有访问过
        int[] visited = new int[graph.verxs];
        // 当前节点标记为已访问
        visited[v]=1;
        //记录2个顶点的下标
        int h1=-1;
        int h2=-1;
        int minWeight=10000;// 初始化为较大数，后面会被替换
        // 有graph.verxs-1条边
        for (int k = 1; k <graph.verxs ; k++) {

            // 确定每一次生成的子图，哪一个节点和这次遍历的节点的距离最近
            for (int i = 0; i < graph.verxs; i++) {// i节点，表示被访问过的节点
                for (int j = 0; j < graph.verxs; j++) {// j节点，表示还没被访问过的节点
                    if(visited[i]==1&&visited[j]==0&&graph.weight[i][j]<minWeight){
                        // 寻找已经访问过的节点和未访问过的节点间的权值最小的边
                        minWeight=graph.weight[i][j];
                        h1=i;
                        h2=j;
                    }
                }
            }
            // 退出for循环时，找到了一条最小边
            System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+"> 权值:"+minWeight);
            // 将找到的节点标记为已经访问
            visited[h2]=1;
            //重新设置minWeight
            minWeight=10000;

        }



    }

    
    
}




class MGraph{
    int verxs;// 图的节点的个数
    char[]data;// 保存节点的数据
    int[][]weight; // 存放边，邻接矩阵
    public MGraph(int verxs){
        this.verxs=verxs;
        data=new char[verxs];
        weight=new int[verxs][verxs];

    }

}
