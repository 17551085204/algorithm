/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/21
*/

package horse;
//import java.util.Scanner;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Horse {
    static int X; //棋盘的行数和列数
    static int Y;
    // 标记棋盘的各个位置是否被访问过
    private static boolean visited[];
    // 标记棋盘的所有位置都被访问过
    private static boolean finished;

    public static void main(String[] args) {
        X=8;Y=8;
        int row=2;int col=3;// 初始的行和列
        // 创建棋盘
        int[][] chessBoard=new int[X][Y];
        visited=new boolean[X*Y];
        // 开始算法
        horse(chessBoard,row-1,col-1,1);
        // 打印输出最后的棋盘，记录了走的步骤
        for (int[] ints : chessBoard) {
            System.out.println(Arrays.toString(ints));
        }




    }

    // 根据当前位置，计算马还可以走那些位置
    public static ArrayList<Point>next(Point curPoint){
       ArrayList<Point> ps = new ArrayList<>();
       // 创建一个point
       Point p1 = new Point();
       // 代表马可以走到 5 这个点
       if((p1.x=curPoint.x-2)>=0&&(p1.y=curPoint.y-1)>=0){
           ps.add(new Point(p1));
       }
        //判断马儿可以走6这个位置
        if((p1.x = curPoint.x - 1) >=0 && (p1.y=curPoint.y-2)>=0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走7这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走0这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走1这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走2这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走3这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走4这个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;


    }

    // 输入棋盘，目前所处的行和列，以及到了第几步
    public static void horse(int[][]chessBoard,int row,int col,int step){
        chessBoard[row][col]=step;
        visited[row*X+col]=true;// 标记该位置为已访问
        //获取下一个位置的集合
        ArrayList<Point> ps = next(new Point(col, row));
        //对ps进行排序,排序的规则就是对ps的所有的Point对象的下一步的位置的数目，进行非递减排序
        sort(ps);
        // 遍历ps
        while (!ps.isEmpty()){
           Point p = ps.remove(0);
           //取出一个位置，判断是否访问过
            if(!visited[p.y*X+p.x]){// 还没访问过
                horse(chessBoard,p.y,p.x,step+1);

            }

        }
        // 棋盘没走完，或者在回溯
        if(step<X*Y&&!finished){
            chessBoard[row][col]=0;
            visited[row*X+col]=false;
        }else{
            finished=true;
        }

    }

    public static void sort(ArrayList<Point>ps){
        // 比较器
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                // 获取到o1下一步的所有步数
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                if(count1<count2){
                    return -1;
                }else if(count1==count2){
                    return 0;
                }else{
                    return 1;
                }

            }
        });

    }



}
