/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/16
*/

package graph;
//import java.util.Scanner;

// 临接矩阵表示图


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String>vertexList;// 存储顶点
    private int[][]edges;// 存储邻接矩阵
    private int numOfEdges;// 边的数目
    boolean[]isVisited; //记录牧歌顶点是否被访问过


    public static void main(String[] args) {
        int n=8;// 节点的数目
//        String[] labels={"A","B","C","D","E"};
        String labels[] = {"1", "2", "3", "4", "5", "6", "7", "8"};

        // 创建图
        Graph graph = new Graph(8);
        // 添加顶点
        for (String label : labels) {
            graph.insertVertex(label);
        }
        // 添加边
//        graph.insertEdge(0,1,1);
//        graph.insertEdge(0,2,1);
//        graph.insertEdge(1,2,1);
//        graph.insertEdge(1,3,1);
//        graph.insertEdge(1,4,1);

        //更新边的关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        // 深度优先遍历
        System.out.println("深度优先");
        graph.dfs();
        System.out.println();
        // 广度优先搜索
        System.out.println("广度优先");
        graph.bfs();


    }

    // 广度优先遍历
    public void bfs(boolean[]isVisited,int i){
        int u; // 代表队列的头结点
        int w;// 邻接节点的下标
        // 队列，节点访问的顺序
        LinkedList queue = new LinkedList<>();
        // 访问节点
        System.out.print(getValByIndex(i)+"->");
        isVisited[i]=true; // 标记为已访问
        // 将节点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()){
            // 取出队列头节点下标
            u = (Integer) queue.removeFirst();
            // 得到第一个邻接节点的下标
            w=getFirstNeighbor(u);
            while (w!=-1){// 找到
                if(!isVisited[w]){
                    System.out.print(getValByIndex(w)+"->");
                    //标记已经访问
                    isVisited[w]=true;
                    // 加入队列
                    queue.addLast(w);

                }
                // 如果已经访问过
                // 以u为前驱点，找w后面的下一个邻接节点
                w=getNextNeighbor(u,w);// 体现出广度优先

            }

        }

    }
    // 对bfs进行重载，遍历所有节点,都进行广度优先搜索
    public  void bfs(){
        isVisited=new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }




    // 深度优先遍历
    // i第一次为0
    public  void dfs(boolean[]isVisited,int i){
        // 首先访问该节点
        System.out.print(getValByIndex(i)+"->");
        // 将该节点标记为已经访问
        isVisited[i]=true;
        // 查找节点的第一个邻接节点w
        int w=getFirstNeighbor(i);
        while (w!=-1){// 有邻接节点w
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            // 如果w已经被访问
            w=getNextNeighbor(i,w);
        }


    }

    // 对dfs进行重载，遍历所有节点
    public  void dfs(){
        isVisited=new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
           if(!isVisited[i]){
               dfs(isVisited,i);
           }
        }
    }



    // 得到第一个邻接节点的下标w
    public int getFirstNeighbor(int index){
        for (int j=0;j<vertexList.size();j++) {
            if(edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }
    // 根据前一个邻接节点的下标，获取下一个邻接节点
    public int getNextNeighbor(int v1,int v2){
        for(int j=v2+1;j<vertexList.size();j++){
            if(edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }



    public Graph(int n) {
        edges=new int[n][n];
        vertexList=new ArrayList<>();
        numOfEdges=0;
        isVisited=new boolean[n];
    }

    // 插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    // 添加边
    // v1和v2代表点的下标，weigth代表2个顶点之间的权值，1代表连接，0代表不连接
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }

    // 返回节点下标对应的数据
    public String getValByIndex(int i){
        return vertexList.get(i);
    }
    // 返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    // 显示图对应的矩阵
    public void show(){
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    // 获取边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }

    // 获取节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }



}
