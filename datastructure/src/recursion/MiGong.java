/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/6
*/

package recursion;
//import java.util.Scanner;

import java.util.Arrays;

public class MiGong {
    public static void main(String[] args) {
        // 用数组模拟迷宫
        // 地图
        int [][]map=new int[8][7];
        // 使用1表示墙
        // 上下全为1
        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        // 左右为1
        for(int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        // 设置单独的2个墙
        map[3][1]=1;map[3][2]=1;

        // 调用方法，迷宫找路
        setWay(map,1,1);
        // 查看map，距可以得到路线
        for(int i=0;i<8;i++){
            System.out.println(Arrays.toString(map[i]));
        }



    }

    // 使用递归回溯，解决迷宫问题
    // i，j表示从哪个位置开始找，找到通路就返回true
    // 说明: map表示地图，i,j表示从地图的那个位置开始出发
    // 如果小球可以到map[6][5],说明通路找到
    // 当map[i][j]=0,代表该点没有走过，map[i][j]=1表示墙
    // map[i][j]=2 代表是一个通路，map[i][j]=3，代表该位置已经走过，但是走不通
    //在走迷宫时，需要确定一个策略， 下-右-上-左，弱该点走不通，就回溯
    public  static boolean setWay(int[][]map,int i,int j){
        if(map[6][5]==2){
            // 通路找到
            return true;
        }else{
            if(map[i][j]==0){// 当前点还没走过
                // 按照策略走 下-右-上-左
                map[i][j]=2;// 假定该点可以走通
                if(setWay(map,i+1,j)){// 向下走
                    return true;
                }else if(setWay(map,i,j+1)){// 向右走
                    return true;
                }else if(setWay(map,i-1,j)){// 向上走
                    return true;
                }else if(setWay(map,i,j-1)){// 向左走
                    return true;
                }else{
                    map[i][j]=3;// 到这里说明该点走不通
                    return false;
                }

            }else{// map[i][j]!=0,可能是1,2,3
                return  false;

            }

        }


      }


}



