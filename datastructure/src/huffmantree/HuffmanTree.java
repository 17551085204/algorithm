/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/14
*/

package huffmantree;
//import java.util.Scanner;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {
    public static void main(String[] args) {
        int[]arr={13,7,8,3,29,6,1};
        Node root = createHunffmanTree(arr);
        preOrder(root);


    }

    // 前序遍历
    public  static  void preOrder(Node root){
        if(root!=null){
            root.preorder();
        }else{
            System.out.println("空树，无法遍历");
        }

    }


    //创建huffman树
    public static Node createHunffmanTree(int []arr){
        // 遍历arr
        // 将arr的每一个元素构成一个Node
        // 将Node放入List
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        // 循环处理
        while (nodes.size()>1) {
            // 从小到大排序
            Collections.sort(nodes);

            // 取出权值最小的2个节点
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            // 根据最小的2个节点，构建一棵新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            // 从list中删除掉处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 将parent节点加入List
            nodes.add(parent);

        }

        // 返回huffman树的root节点
        return nodes.get(0);


    }

}

//创建节点
// 为了让node支持排序
class Node implements Comparable<Node>{
    int value; // 节点取值
    Node left; // 左子节点
    Node right;// 右子节点

    // 前序遍历
    public void preorder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preorder();
        }
        if(this.right!=null){
            this.right.preorder();
        }

    }




    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;//从小到大进行排序
    }
}

