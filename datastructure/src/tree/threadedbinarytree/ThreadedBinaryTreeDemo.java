/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/12
*/

package tree.threadedbinarytree;
//import java.util.Scanner;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        // 创建节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(3, "吴用");
        HeroNode node3 = new HeroNode(6, "卢俊义");
        HeroNode node4 = new HeroNode(8, "林冲");
        HeroNode node5 = new HeroNode(10, "关胜");
        HeroNode node6 = new HeroNode(14, "jack");

        // 创建二叉树
        root.setLeft(node2);root.setRight(node3);
        node2.setLeft(node4);node2.setRight(node5);
        node3.setLeft(node6);

        // 测试线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        // 完成线索化
        threadedBinaryTree.threadedNodes(root);
//        System.out.println(node5.getLeft());
//        System.out.println(node5.getRight());

        // 遍历线索化二叉树
        threadedBinaryTree.threadedList();


    }



}




//  线索化二叉树
class ThreadedBinaryTree{
    private HeroNode root;
    // 为了实现线索化，需要一个指向当前节点的前驱节点的指针
    private  HeroNode pre=null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }


    //遍历线索化二叉树的方法
    public void threadedList() {
        //定义一个变量，存储当前遍历的结点，从root开始
        HeroNode node = root;
        while(node != null) {
            //循环的找到leftType == 1的结点，第一个找到就是8结点
            //后面随着遍历而变化,因为当leftType==1时，说明该结点是按照线索化
            //处理后的有效结点
            while(node.getLeftType() == 0) {
                node = node.getLeft();
            }

            //打印当前这个结点
            System.out.println(node);
            //如果当前结点的右指针指向的是后继结点,就一直输出
            while(node.getRightType() == 1) {
                //获取到当前结点的后继结点
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的结点
            node = node.getRight();

        }
    }

    // 对当前节点进行线索化,  中序线索化
    public void threadedNodes(HeroNode node){
        if(node==null){
            return;
        }
        // 线索化左子树
        threadedNodes(node.getLeft());

        // 线索化当前节点
        // 处理当前节点的前驱节点
        if(node.getLeft()==null){
            // 让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            // 修改当前节点左指针的类型
            node.setLeftType(1);

        }
        // 处理后继节点
        if(pre!=null && pre.getRight()==null){
            // 前驱节点的右指针指向当前节点
            pre.setRight(node);
            pre.setRightType(1);// 修改类型

        }
        // 每处理衣蛾节点后，让当前节点成为下一个节点的前驱节点
        pre=node;


        // 线索化右子树
        threadedNodes(node.getRight());

    }




    // 删除节点
    public void delete(int no){
        if(root!=null){
            // 如果只有一个root
            if(root.getNo()==no){
                root=null;
            }else{
                // 递归删除
                root.delete(no);

            }

        }else{
            System.out.println("空，无法删除");
        }

    }



    // 前序查找
    public HeroNode preSearch(int no){
        if(root!=null){
            return root.preSearch(no);
        }else{
            return null;
        }
    }

    // 中序查找
    public HeroNode infixSearch(int no){
        if(root!=null){
            return root.infixSearch(no);
        }else{
            return null;
        }
    }

    // 后序查找
    public HeroNode postSearch(int no){
        if(root!=null){
            return root.postSearch(no);
        }else{
            return null;
        }
    }


    // 前序遍历
    public  void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else{
            System.out.println("空，无法遍历");
        }
    }
    // 中序遍历
    public  void infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else{
            System.out.println("空，无法遍历");
        }
    }
    // 后序遍历
    public  void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else{
            System.out.println("空，无法遍历");
        }
    }

}




// HeroNode
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    private  int leftType; // 0表示指向左子树，1表示指向前驱节点
    private  int rightType;// 0表示指向右子树，1表示指向后继节点

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }


    // 节点的删除
    // 如果删除子节点，直接删除，如果是父节点，删除这个子树
    // 1,由于是单向二叉树，所以删除时，要判断当前节点的子节点是否需要删除
    // 不能去判断当前这个节点是不是需要删除节点
    // 2,如果当前节点的左子节点不为空，并且左子节点就是要删除的节点
    // this.left=null，返回，结束删除任务
    //3,如果当前节点的右子节点不为空，并且右子节点就是要删除的节点
    // this.right=null,返回，结束删除任务
    // 4,如果2,3都没有删除节点，那么需要向左子树递归删除
    // 5,如果4没有删除节点，那么需要向右子树递归删除
    // 6，如果只有一个root节点，root=null,这种情况首先考虑
    public void delete(int no){
        if(this.left!=null && this.left.no==no){
            this.left=null;
            return;
        }
        if(this.right!=null && this.right.no==no){
            this.right=null;
            return;
        }
        //向左子树递归删除
        if(this.left!=null){
            this.left.delete(no);
        }
        //向右子树递归删除
        if(this.right!=null){
            this.right.delete(no);
        }



    }







    //前序遍历查找
    public   HeroNode preSearch(int no){
        // 比较当前节点是不是
        System.out.println("前序遍历");
        if(this.no==no){
            return this;
        }
        // 向左遍历查找
        HeroNode resNode=null;
        if(this.left!=null){
            resNode=this.left.preSearch(no);
        }

        // 如果左查找找到，就返回
        if(resNode!=null){
            return resNode;
        }

        // 向右遍历查找
        if(this.right!=null){
            resNode=this.right.preSearch(no);
        }
        return resNode;

    }

    //中序遍历查找
    public HeroNode infixSearch(int no){
        HeroNode resNode=null;
        // 向左遍历查找
        if(this.left!=null){
            resNode=this.left.infixSearch(no);
        }
        // 如果左查找找到，就返回
        if(resNode!=null){
            return resNode;
        }

        // 比较当前节点是不是
        System.out.println("中序遍历");
        if(this.no==no){
            return this;
        }

        // 向右遍历查找
        if(this.right!=null){
            resNode=this.right.infixSearch(no);
        }
        return resNode;

    }

    //后序遍历查找
    public HeroNode postSearch(int no){
        HeroNode resNode=null;
        // 向左遍历查找
        if(this.left!=null){
            resNode=this.left.postSearch(no);
        }
        // 如果左查找找到，就返回
        if(resNode!=null){
            return resNode;
        }

        // 向右遍历查找
        if(this.right!=null){
            resNode=this.right.postSearch(no);
        }

        // 如果右查找找到，就返回
        if(resNode!=null){
            return resNode;
        }

        // 比较当前节点是不是
        System.out.println("后序遍历");
        if(this.no==no){
            return this;
        }

        return  resNode;

    }



    // 前序遍历
    public  void preOrder(){

        System.out.println(this);// 先输出父节点
        // 向左子树递归
        if(this.left!=null){
            this.left.preOrder();
        }
        // 向右子树递归
        if(this.right!=null){
            this.right.preOrder();
        }
    }

    // 中序遍历
    public  void infixOrder(){
        // 向左子树递归
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);// 中间输出父节点
        // 向右子树递归
        if(this.right!=null){
            this.right.infixOrder();
        }

    }

    // 后序遍历
    public  void postOrder(){
        // 向左子树递归
        if(this.left!=null){
            this.left.postOrder();
        }

        // 向右子树递归
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);// 最后输出父节点

    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }
}

