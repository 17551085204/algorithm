/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/20
*/

package dijkstra;
//import java.util.Scanner;


import java.util.Arrays;

public class Dijkstra {

    public static void main(String[] args) {
        char[]vertex={'A','B','C','D','E','F','G'};
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;// 表示不可以连接
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        Graph graph = new Graph(vertex, matrix);
//        graph.showGraph();
        graph.dsj(6);
        graph.show();



    }






}


class VisitedVertex{
    int[]already_arr;// 记录每个顶点是否被访问过，1代表访问过
    int[]pre_visited;// 每个下标对应的值为前一个顶点下标，会动态更新
    int[]dis;// 记录出发顶点到其他所有顶点的距离

    // length=顶点个数   index=出发顶点的下标
    public VisitedVertex(int length,int index) {
        this.already_arr=new int[length];
        this.pre_visited=new int[length];
        this.dis=new int[length];
        // 初始化dis数组
        Arrays.fill(dis,65535);
        this.already_arr[index]=1;// 设置出发顶点被访问
        this.dis[index]=0;

    }

    // 判断index顶点是否被访问过
    public boolean in(int index){
        return already_arr[index]==1;
    }

    // 更新出发顶点到index顶点的距离
    public void updateDis(int index,int len){
        dis[index]=len;

    }

    // 更新顶点的前驱为index的节点
    public void updatePre(int pre,int index){
        pre_visited[pre]=index;

    }

    // 继续选择并返回新的访问顶点
    public int updateArr(){
        int min=65535;int index=0;
        for (int i = 0; i < already_arr.length; i++) {
            if(already_arr[i]==0&&dis[i]<min){
                min=dis[i];
                index=i;
            }
        }
        already_arr[index]=1;
        return index;

    }

    //显示最后结果
    public void show(){
        System.out.println("=====================");
        System.out.println(Arrays.toString(already_arr));
        System.out.println(Arrays.toString(pre_visited));
        System.out.println(Arrays.toString(dis));

        //
        char[]vertex={'A','B','C','D','E','F','G'};
        int count=0;
        for (int di : dis) {
            if(di!=65535){
                System.out.print(vertex[count]+"("+di+")  ");
            }else{
                System.out.print("N");
            }
            count++;
        }
        System.out.println();

    }


    // 返回出发顶点到index顶点的距离
    public int getDis(int index){
        return dis[index];

    }


}


// 定义图
class Graph{
    char[]vertex; // 顶点数组
    int[][]matrix; // 邻接矩阵
    VisitedVertex vv;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void show(){
        vv.show();
    }


    // 算法实现
    // 输入 出发顶点对应的下标
    public void dsj(int index){
        vv = new VisitedVertex(vertex.length, index);
        update(index);// 更新index顶点到周围顶点的距离和前驱节点
        for (int j = 1; j < vertex.length; j++) {
            index=vv.updateArr(); // 选择并返回新的访问节点
            update(index);// 更新index顶点到周围顶点的距离和前驱节点
        }
    }



    // 更新index下标顶点到周围顶点的距离和周围节点的前驱顶点
    public void update(int index){
        int len=0;
        // 根据遍历邻接矩阵的index行
        for (int j = 0; j < matrix[index].length; j++) {
            // 出发顶点到index顶点的距离+从index顶点到j顶点的距离
            len=vv.getDis(index)+matrix[index][j];
            // 如果j这个顶点没有被访问过，且len小于出发顶点到j顶点的距离
            // 这时需要更新
            if(!vv.in(j)&&len<vv.getDis(j)){
                vv.updatePre(j,index);// 更新j顶点前驱为index节点
                vv.updateDis(j,len);// 更新出发顶点到j顶点的距离
            }

        }

    }




    public void showGraph(){
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }

    }

}

