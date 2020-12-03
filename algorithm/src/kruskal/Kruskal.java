/*
 * @Author hdk
 * @QQ:2890241339
 **/
package kruskal;

import java.util.Arrays;

public class Kruskal {
    private int edgeNum; // 记录边的个数
    private char[]vertexs; // 顶点数组
    private int[][]matrix;// 邻接矩阵
    // 表示2个顶点不可联通
    private static  final int INF=Integer.MAX_VALUE;


    public static void main(String[] args) {
        char[]vertexs={'A','B','C','D','E','F','G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
        /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
        /*A*/ {   0,  12, INF, INF, INF,  16,  14},
        /*B*/ {  12,   0,  10, INF, INF,   7, INF},
        /*C*/ { INF,  10,   0,   3,   5,   6, INF},
        /*D*/ { INF, INF,   3,   0,   4, INF, INF},
        /*E*/ { INF, INF,   5,   4,   0,   2,   8},
        /*F*/ {  16,   7,   6, INF,   2,   0,   9},
        /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        Kruskal kruskal = new Kruskal(vertexs,matrix);
//        kruskal.print();

        // 获得所有边并排序
        EData[] edges = kruskal.getEdges();
        kruskal.sortEdges(edges);
//        System.out.println(Arrays.toString(edges));


        kruskal.kruskal();

    }

    public Kruskal(char[]vertexs,int[][]matrix){
        // 初始化顶点数，边的个数
        int vlen=vertexs.length;
        // 初始化顶点
        this.vertexs=new char[vlen];
        for (int i = 0; i <vertexs.length ; i++) {
            this.vertexs[i]=vertexs[i];
        }
        // 初始化边
        this.matrix=new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j]=matrix[i][j];
            }
        }
        // 统计边的个数
        for (int i = 0; i < vlen; i++) {
            for (int j = i+1; j < vlen; j++) {
                if(this.matrix[i][j]!=INF){
                    edgeNum++;
                }
            }
        }

    }

    public void kruskal(){
        int index=0; // 表示最后结果数组的索引
        int []ends=new int[edgeNum]; // 保存已有最小生成树中的每个顶点在最小生成树中的终点
        // 创建结果数组，保存最后的最小生成树
        EData[]rets=new EData[edgeNum];
        //图中所有边的集合
        EData[]edges=getEdges();
        // 按照边的权值大小进行排序
        sortEdges(edges);
        //遍历edges[]
        // 将边加入最小生成树中，判断加入的边是否构成回路
        // 没有就加入
        for (int i = 0; i < edgeNum; i++) {
            // 获取第i条边的  顶点和 终点
            int p1=getPosition(edges[i].start);
            int p2=getPosition(edges[i].end);

            // p1,p2在已有最小生成树中的终点
            int m=getEnd(ends,p1);
            int n=getEnd(ends,p2);

            if(m!=n){// 不构成回路
                ends[m]=n;// 设置m在已有最小生成树的终点
                rets[index++]=edges[i];// 有一条边加入
                System.out.println(edges[i]);
            }

        }


    }

    public void print(){
        System.out.println("邻接矩阵");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }

    }

    // 对边进行排序
    public  void sortEdges(EData[] edges){
        for (int i = 0; i < edges.length-1; i++) {
            for (int j = 0; j < edges.length-1-i; j++) {
                if(edges[j].weight>edges[j+1].weight){
                    EData temp=edges[j];
                    edges[j]=edges[j+1];
                    edges[j+1]=temp;
                }
            }
        }
    }

    // 传入顶点值，返回对应的下标 'A'->0
    public int getPosition(char ch){
        for (int i = 0; i < vertexs.length; i++) {
            if(vertexs[i]==ch){
                return i;
            }
        }
        return -1; // 找不到
    }

    //获取图中的边，放到EData[]中，后面需要遍历该数组
    // 通过matrix获取  EData[]={['A','B',12],['B','F',7]}
    public EData[] getEdges(){
        int index=0;
        EData[] edges=new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if(matrix[i][j]!=INF){
                    edges[index++]=new EData(vertexs[i],vertexs[j],matrix[i][j]);

                }
            }
        }
        return edges;

    }

    // 获取下标为i的顶点的终点，用于后面判断
    // 2个顶点的终点是否相同
    public int getEnd(int[]ends,int i){
        // ends记录了各个顶点对应的终点是哪个
        // 在遍历过程中逐步形成的
        while (ends[i]!=0){
            i=ends[i];
        }
        return i;
    }


}

// EData类，表示一条边
class EData{
    char start; // 边的起点和终点
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }

}


