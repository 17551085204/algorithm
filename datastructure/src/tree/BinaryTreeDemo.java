/*
 * @Author hdk
 * @QQ:2890241339
 **/
package tree;

// 二叉树的前中后序遍历


public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        // 设置二叉树的root节点
        binaryTree.setRoot(root);

        // 调用binaryTree的方法进行遍历
        // 前序遍历
//        binaryTree.preOrder();
        // 中序遍历
//        binaryTree.infixOrder();
        // 后序遍历
//        binaryTree.postOrder();


        // 调用binaryTree的方法进行查找
//        System.out.println(binaryTree.preSearch(4));
//        System.out.println(binaryTree.infixSearch(4));
//        System.out.println(binaryTree.postSearch(4));


        // 测试二叉树删除节点
        System.out.println("删除前");
        binaryTree.preOrder();
        binaryTree.delete(5);
        System.out.println("删除后");
        binaryTree.preOrder();





    }
}

// 定义一个BinaryTree
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
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


