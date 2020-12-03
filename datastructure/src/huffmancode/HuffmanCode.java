/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/14
*/

package huffmancode;
//import java.util.Scanner;

//import jnr.ffi.annotations.In;
//import org.python.antlr.ast.Str;

import java.io.*;
import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) throws IOException {
        // huffman压缩解码字符串
//        String str="i like like like java do you like a java";
//        // 获取原字符串对应的字节数组
//        byte[] bytes = str.getBytes();
//        // 经过huffman压缩后的新的字节数组
//        byte[] huffmanCodeBytes = huffmanZip(bytes);
//        // 传入huffman编码表以及 经过huffman压缩后的新的字节数组
//        // 解码出 原字符串对应的字节数组
//        byte[] decode = decode(huffmanCodes, huffmanCodeBytes);
//        // 还原为原字符串
//        String str2=new String(decode);
//        System.out.println(str2);



        // 利用huffman压缩文件
//        String srcFile="E:\\重要文件\\w3cschool菜鸟教程.CHM";
//        String dstFile="E:\\重要文件\\zip.zip";
//        zipFile(srcFile,dstFile);

        // 解压缩文件
        String zipFile="E:\\重要文件\\zip.zip";
        String dstFile="E:\\w3cschool菜鸟教程.CHM";
        unzipFile(zipFile,dstFile);



    }

    // 对huffman压缩文件的解压
    public static void unzipFile(String zipFile,String dstFile) throws IOException {

        InputStream inputStream = null;
        ObjectInputStream objectInputStream =null;
        FileOutputStream fileOutputStream=null;
        try {
            inputStream = new FileInputStream(zipFile);
            objectInputStream = new ObjectInputStream(inputStream);
            fileOutputStream = new FileOutputStream(dstFile);
            // 读取byte数组
           byte[] huffmanBytes = (byte[])objectInputStream.readObject();
            // 读取huffman编码表
            Map<Byte,String>huffmanCodes = (Map<Byte,String>)objectInputStream.readObject();
            // 解码
           byte[] decode = decode(huffmanCodes, huffmanBytes);
           fileOutputStream.write(decode);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            fileOutputStream.close();
            inputStream.close();
            objectInputStream.close();

        }


    }



    // 传入压缩文件的路径，返回压缩文件
    public static void zipFile(String srcFile,String dstFile)  {
        FileInputStream fileInputStream=null;
        OutputStream outputStream=null;
        ObjectOutputStream objectOutputStream=null;
       try {
           fileInputStream = new FileInputStream(srcFile);
           byte[]b=new byte[fileInputStream.available()];
           fileInputStream.read(b);// 将文件读取到字节数组
           // 使用huffman编码
           byte[] huffmanBytes = huffmanZip(b);// 源文件压缩，得到压缩后的字节数组
           // 创建输出流
           outputStream = new FileOutputStream(dstFile);
           objectOutputStream = new ObjectOutputStream(outputStream);
           // 对象流的方式写入huffman编码，方便后续
           objectOutputStream.writeObject(huffmanBytes);
           // 需要将huffman编码表写入压缩文件
           objectOutputStream.writeObject(huffmanCodes);



       }catch (Exception e){
           System.out.println(e.getMessage());
       }finally {
           try {
               fileInputStream.close();
               outputStream.close();
               objectOutputStream.close();

           } catch (IOException e) {
               e.printStackTrace();
           }
       }


    }



    // 编写方法，完成对压缩数据的解码
    public static byte[] decode(Map<Byte, String> huffmanCodes,byte[]huffmanBytes){
        // 得到huffmanBytes对应的二进制字符串
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转为二进制字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            boolean flag=(i==huffmanBytes.length-1);
            stringBuilder.append(byte2BitString(!flag,huffmanBytes[i]));
        }
//        System.out.println(stringBuilder);
        // 将字符串按照指定的huffman编码进行解码
        // 将huffman编码表进行调换
        Map<String,Byte>map=new HashMap<>();
        for(Map.Entry<Byte,String>entry:huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }

        // 创建集合，存放byte
        List<Byte>list=new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count=1;boolean flag=true;Byte b=null;
            while (flag){
                // 取出一个'1'或'0'
                // i不动，count移动，直到匹配到
                String key=stringBuilder.substring(i,i+count);
                b=map.get(key);
                if(b==null){// 没有匹配到
                    count++;
                }else{
                    flag=false;
                }

            }
            list.add(b);
            i+=count;

        }

        byte[]result=new byte[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=list.get(i);
        }
        return result;

    }

    // 将一个byte转为一个二进制的字符串
    // flag标记是否需要补高位
    public static  String byte2BitString(boolean flag,byte b){
        int temp=b;
        // b如果是正数，需要补高位
        if(flag){
            temp |= 256; // 按位与
        }
        String str=  Integer.toBinaryString(temp);

        if(flag) {
            return str.substring(str.length() - 8);
        }else{
            return str;
        }
    }


    // 封装一个函数，便于调用
    // 输入原始的字符串对应的字节数组
    // 返回经过huffman处理后的字节数组
    public static byte[]huffmanZip(byte[]bytes){
        List<Node> nodes = getNodes(bytes);
        Node root = createHunffmanTree(nodes);
        // 生成huffman编码
        Map<Byte, String> huffmanCodes = getCodes(root);
        // 经过huffman编码处理后的字节数组
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;

    }




    // 将一个字符串对应的byte数组，通过生成的huffman编码表，返回huffman编码压缩后的byte[]
    public static byte[] zip(byte[]bytes,Map<Byte, String> huffmanCodes){
        //利用huffmanCodes将bytes转为huffman编码对应的字符串
       StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            stringBuilder.append(huffmanCodes.get(aByte));
        }

        int len;
        //统计返回byte[]huffmanCodeBytes 长度
        if(stringBuilder.length()%8==0){
            len=stringBuilder.length()/8;
        }else{
            len=stringBuilder.length()/8+1;
        }
        //创建一个存储压缩后的byte[]
        byte[]huffmanCodeBytes=new byte[len];
        int index=0;
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            String str;
            if(i+8>stringBuilder.length()){
                str=stringBuilder.substring(i);
            }else{
                str=stringBuilder.substring(i,i+8);
            }
            // 将str转为byte
            huffmanCodeBytes[index]=(byte)(Integer.parseInt(str,2));
            index++;
        }

        return  huffmanCodeBytes;

    }


    // huffman树对应的huffman编码表 map<Byte,String>
    // 需要拼接路径，定义StringBuilder存储某个叶子节点的路径
    static  StringBuilder sb=new StringBuilder();
    static Map<Byte,String>huffmanCodes=new HashMap<>();
    // 将传入的node节点的所有叶子节点的huffman编码得到，放入到huffmanCodes中
    // code 路径:左子节点0，右1，sb用于拼接路径
    public static Map<Byte,String> getCodes(Node root){
        if(root==null){
            return null;
        }
        getCodes(root.left,"0",sb);
        getCodes(root.right,"1",sb);
        return huffmanCodes;
    }

    public static void getCodes(Node node,String code,StringBuilder sb){
        StringBuilder stringBuilder = new StringBuilder(sb);
        stringBuilder.append(code);
        if(node!=null){
            // 判断当前是不是叶子节点
            if(node.data==null){// 非叶子节点
                // 递归处理
                getCodes(node.left,"0",stringBuilder);
                getCodes(node.right,"1",stringBuilder);
            }else{// 叶子节点
                // 找到了某个叶子节点的最后
                huffmanCodes.put(node.data,stringBuilder.toString());
            }

        }


    }





    // 创建huffman树
    public static Node createHunffmanTree(List<Node>nodes){
       while (nodes.size()>1){
           Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            // 创建新的二叉树
           Node parent =new Node(null,leftNode.weight+rightNode.weight);
           parent.left=leftNode;parent.right=rightNode;
           // 从list中删除掉处理过的二叉树
           nodes.remove(leftNode);
           nodes.remove(rightNode);
           // 将parent节点加入List
           nodes.add(parent);

       }
       return  nodes.get(0);


    }

    // 前序遍历
    public  static  void preOrder(Node root){
        if(root!=null){
            root.preorder();
        }else{
            System.out.println("空树，无法遍历");
        }

    }

    // 字节数组转为List,保存字符以及出现的次数
    public static List<Node> getNodes(byte[]bytes){
       ArrayList<Node> nodes = new ArrayList<>();
       // 存储每个byte出现的次数，map[key,value]
       HashMap<Byte, Integer> byteIntegerHashMap = new HashMap<>();
        for (byte aByte : bytes) {
            Integer count=byteIntegerHashMap.get(aByte);
            if(count==null){// map中还没有这个数据
                byteIntegerHashMap.put(aByte,1);
            }else{
                byteIntegerHashMap.put(aByte,count+1);
            }

        }
        // 把每一个键值对，转为Node对象
        for(Map.Entry<Byte,Integer>entry:byteIntegerHashMap.entrySet()){
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
       return  nodes;

    }




}


//创建节点
// 让node支持排序
class Node implements Comparable<Node>{
    Byte data;// 存放数据 'a'->97
    int weight;// 权值
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

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}



