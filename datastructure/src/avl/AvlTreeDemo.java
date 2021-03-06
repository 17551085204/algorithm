/*
 * @Author hdk
 * @QQ:2890241339
 **/
package avl;

public class AvlTreeDemo {
    public static void main(String[] args) {
//        int []arr={4,3,6,5,7,8}; // 需要左旋
//        int []arr={10,12,8,9,7,6};  // 需要右旋
        int []arr={2,1,6,5,7,3}; // 需要双重旋转
        AvlTree avlTree = new AvlTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        // 中序遍历
//        avlTree.infixOrder();

        // 树的高度
        System.out.println(avlTree.getRoot().height());
        // 左子树高度
        System.out.println(avlTree.getRoot().left.height());
        // 右子树高度
        System.out.println(avlTree.getRoot().right.height());





    }
}


class AvlTree{

    private Node root;

    public Node getRoot() {
        return root;
    }





    // 删除节点
    /*
    1,删除叶子节点
    找到要删除的节点targetNode以及父节点parent（不一定存在）
    targetNode是parent的左还是右子节点
    根据以上分析，对应删除
    例如 parent.left=null;

    2，删除只有一颗子树的节点
    找到要删除的节点targetNode以及父节点parent（不一定存在）
    确定targetNode的子节点是左还是右
    targetNode是parent的左还是右子节点，这里分为4种情况
    parent.left(right)=targetNode.left(right)

    3,删除具有2棵子树的节点
    找到要删除的节点targetNode以及父节点parent（不一定存在）
    从targetNode的右子树找到最小的节点
    用临时变量将最小的值保存remp
    删除该最小节点
    targetNode.value=temp

     */

    // 返回以node为根节点的二叉排序树的最小节点的值
    public int delRightTreeMin(Node node){
        Node target=node;
        // 循环查找左子节点，找到最小值
        while (target.left!=null){
            target=target.left;
        }
        // 这时，target指向最小的节点
        // 将其删除
        delNode(target.value);
        // 返回最小值
        return target.value;
    }

    // 返回以node为根节点的二叉排序树的最大节点的值
    public int delLeftTreeMax(Node node){
        Node target=node;
        // 循环查找右子节点，找到最大值
        while (target.right!=null){
            target=target.right;
        }
        // 这时，target指向最大的节点
        // 将其删除
        delNode(target.value);
        // 返回最大值
        return target.value;
    }


    // 删除节点
    public void delNode(int value){
        if (root==null){
            return;
        }else{
            Node targetNode=search(value);
            if(targetNode==null){
                System.out.println("没有这个节点");
                return;
            }
            // 如果二叉排序树只有一个节点
            if(root.left==null&&root.right==null){
                root=null;
                return;
            }
            //去查找targetNode的父节点
            Node parent=searchParent(value);
            //如果要删除的节点是叶子节点
            if(targetNode.left==null&&targetNode.right==null){
                // 判断targetNode是parent的左还是右子节点
                if(parent.left!=null&&parent.left.value==value){
                    parent.left=null;
                }else if(parent.right!=null&&parent.right.value==value){
                    parent.right=null;
                }
            }else if(targetNode.left!=null&&targetNode.right!=null){
                // 删除有左右2棵子树的节点
                // 第一种思路，删除右子树的最小节点
//                int minVal = delRightTreeMin(targetNode.right);
//                targetNode.value=minVal;

                // 第二种思路，删除左子树的最大节点
                int maxVal = delLeftTreeMax(targetNode.left);
                targetNode.value=maxVal;


            }else{// 删除只有一颗子树的节点
                if(targetNode.left!=null){
                    if(parent!=null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    }else{
                        root=targetNode.left;
                    }
                }else{
                    if(parent!=null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    }else{
                        root=targetNode.right;
                    }
                }

            }

        }

    }


    // 查找要删除的节点
    public  Node search(int value){
        if(root==null){
            return null;
        }else{
            return root.search(value);
        }
    }

    // 查找父节点
    public  Node searchParent(int value){
        if(root==null){
            return null;
        }else{
            return root.searchParent(value);
        }
    }




    // 添加节点
    public void add(Node node){
        if(this.root==null){// 代表空树
            this.root=node;
        }else{
            this.root.add(node);
        }
    }

    // 中序遍历
    public void infixOrder(){
        if(this.root==null){
            System.out.println("空树");
        }else{
            this.root.infixOrder();
        }
    }

}


// 创建node节点
class Node{
    int value;
    Node left;
    Node right;

    //返回左子树高度
    public int leftHeight(){
       if(left==null){
           return 0;
       }
       return left.height();
    }
    //返回右子树高度
    public int rightHeight(){
        if(right==null){
            return 0;
        }
        return right.height();
    }

    // 返回当前节点高度，以该节点为根节点的树的高度
    public int height(){
        return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;
    }

    // 左旋转
    public void rightRotate(){
        // 创建新节点
        Node newNode = new Node(value);
        newNode.right=right;
        newNode.left=left.right;
        value=left.value;
        left=left.left;
        right=newNode;

    }


    // 左旋转
    public void leftRotate(){
        // 创建新节点
        Node newNode = new Node(value);
        // 新节点的左子树设置为当前节点的左子树
        newNode.left=left;
        // 新节点的右子树设置为当前节点的右子树的左子树
        newNode.right=right.left;
        //当前节点的值换为右子节点的值
        value=right.value;
        //当前节点的右子树设置为当前节点的右子树的右子树
        right=right.right;
        // 当前节点的左子节点设置为新的节点
        left=newNode;



    }




    // 查找要删除的节点的父节点
    public Node searchParent(int value){
        if((this.left!=null && this.left.value==value)||
                (this.right!=null && this.right.value==value)){
            return this;

        }else{
            if(value<this.value&&this.left!=null){
                return  this.left.searchParent(value);
            }else if(value>this.value&&this.right!=null){
                return  this.right.searchParent(value);
            }else{
                return null;
            }

        }

    }



    // 查找要删除的节点
    // value是节点的value
    public Node search(int value){
        if(value==this.value){
            return this;
        }else if(value<this.value){
            // 需要向左子树递归查找
            if(this.left==null){
                return null;
            }
            return this.left.search(value);
        }else{
            // 需要向右子树递归查找
            if(this.right==null){
                return null;
            }
            return this.right.search(value);

        }


    }



    // 中序遍历
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }

    }


    // 递归形式 添加节点，满足二叉排序树的规则
    public void add(Node node){
        if(node==null){
            return;
        }
        // 加入的节点与当前子树的根节点之间的关系
        if(node.value<this.value){
            if(this.left==null){// 当前节点的左子节点为空
                this.left=node;
            }else{
                this.left.add(node); // 递归向左子树添加
            }
        }else{//添加节点的值大于当前节点的值
            if(this.right==null){// 当前节点的右子节点为空
                this.right=node;
            }else{
                this.right.add(node); // 递归向右子树添加
            }
        }

        // 添加完一个节点后，如果右子树高度-左子树高度>1,要左旋转
        // 如果左子树高度-右子树高度>1,要右旋转
        if(rightHeight()-leftHeight()>1){

            // 如果右子树的左子树的高度大于他的右子树的高度
            if(right!=null&&right.left.height()>right.right.height()){
                // 先对当前节点的右子树进行右旋转
                right.rightRotate();
                // 在对当前节点左旋转
                leftRotate();
            }else{
                // 直接对当前节点左旋转
                leftRotate();
            }
            return;

        }else if(leftHeight()-rightHeight()>1){
            // 如果左子树的右子树的高度大于他的左子树的高度
            if(left!=null&&left.right.height()>left.left.height()){
                // 先对当前节点的左子树进行左旋转
                left.leftRotate();
                // 在对当前节点右旋转
                rightRotate();
            }else{
                // 直接对当前节点右旋转
                rightRotate();
            }



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
}
