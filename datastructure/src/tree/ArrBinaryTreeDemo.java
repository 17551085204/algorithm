/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/9
*/

package tree;
//import java.util.Scanner;
// 顺序存储二叉树


public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
//        arrBinaryTree.preOrder(0);
//        arrBinaryTree.infixOrder(0);
        arrBinaryTree.postOrder(0);


    }

}

// 写一个ArrBinaryTree，实现顺序存储二叉树遍历
class ArrBinaryTree{
    private int[]arr; // 存储数据

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    // 编写方法，完成顺序存储二叉树的前序遍历
    public void preOrder(int index){// index表示数组下标
        // 如果数组为空，或者arr.length=0
        if(arr==null ||arr.length==0){
            System.out.println("数组为空，无法遍历");
            return;
        }
        System.out.print(arr[index]+" ");// 输出当前数组元素
        // 向左递归遍历
        if(index*2+1<arr.length){
            preOrder(index*2+1);
        }
        // 向右递归遍历
        if(index*2+2<arr.length){
            preOrder(index*2+2);
        }


    }

    // 编写方法，完成顺序存储二叉树的中序遍历
    public void infixOrder(int index){// index表示数组下标
        // 如果数组为空，或者arr.length=0
        if(arr==null ||arr.length==0){
            System.out.println("数组为空，无法遍历");
            return;
        }

        // 向左递归遍历
        if(index*2+1<arr.length){
            infixOrder(index*2+1);
        }
        System.out.print(arr[index]+" ");// 输出当前数组元素
        // 向右递归遍历
        if(index*2+2<arr.length){
            infixOrder(index*2+2);
        }


    }

    // 编写方法，完成顺序存储二叉树的后序遍历
    public void postOrder(int index){// index表示数组下标
        // 如果数组为空，或者arr.length=0
        if(arr==null ||arr.length==0){
            System.out.println("数组为空，无法遍历");
            return;
        }

        // 向左递归遍历
        if(index*2+1<arr.length){
            postOrder(index*2+1);
        }

        // 向右递归遍历
        if(index*2+2<arr.length){
            postOrder(index*2+2);
        }
        System.out.print(arr[index]+" ");// 输出当前数组元素


    }


}
