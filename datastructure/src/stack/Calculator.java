/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/5
*/

package stack;
//import java.util.Scanner;

// 使用栈来计算表达式

/*
1,通过Index来遍历表达式
2，如果是数字，就入数栈
3，如果是符号
3.1 如果符号栈为空，直接入栈
3.2 如果符号栈有操作符，就要比较
如果当前操作符的优先级小于或者等于栈中的操作符，就需要从数栈中pop出
2个数，然后从符号栈中pop出一个符号，进行运算，将运算结果在入数栈
然后当前操作符入符号栈

如果当前操作符的优先级大于栈中的操作符直接入符号栈
4，扫描完毕后，就顺序的从数栈和符号栈中pop出相应的数和符号，并运算
5，最后数栈只有一个数字，就是表达式的结果

 */

public class Calculator {
    public static void main(String[] args) {
        // w完成表达式的计算
        String expr="311+2*6-11";
        // 创建数栈和符号栈
        ArrayStack2 numStack = new ArrayStack2(20);
        ArrayStack2 opeStack = new ArrayStack2(20);
        // 需要的相关变量
        int index=0;
        int num1=0;int num2=0;
        int ope=0;int res=0;
        char ch=' '; // 每次扫描得到的char
        String keppNum=""; // 用于拼接字符串，得到多位数
        // 扫描expr
        while (true){
//            ch=expr.substring(index,index+1).charAt(0);
            ch=expr.charAt(index);
            if(opeStack.isOper(ch)){// 如果是符号
                // 判断符号栈是否为空
                if(!opeStack.isEmpty()){
                    // 处理
                    /*
                    如果当前操作符的优先级小于或者等于栈中的操作符，就需要从数栈中pop出
                     2个数，然后从符号栈中pop出一个符号，进行运算，将运算结果在入数栈
                     然后当前操作符入符号栈

                    如果当前操作符的优先级大于栈中的操作符直接入符号栈

                     */
                    if(opeStack.priority(ch)<=opeStack.priority(opeStack.peek())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        ope=opeStack.pop();
                        res=numStack.cal(num1,num2,ope);

                        // 结果入数栈
                        numStack.push(res);
                        // 当前符号入符号栈
                        opeStack.push(ch);
                    }else{
                        // 当前符号入符号栈
                        opeStack.push(ch);
                    }

                }else{
                    // 如果符号栈为空
                    // 当前符号入符号栈
                    opeStack.push(ch);

                }

            }else{// 如果是数，则直接入数栈
                /*
                这里只能处理个位数的运算，需要修改
                 */
                // ch是字符，查阅ascii码表，'0'->48
//                numStack.push(ch-48);

                // 修改为多位数的运算
                /*
                不能发现一个数就立即入栈，可能是多位数，
                需要向下一位继续判断是不是数
                 */
                keppNum+=ch;

                if(index==expr.length()-1){
                    numStack.push(Integer.parseInt(keppNum));
                } else {
                    // 判断下一位是不是数字，如果是，继续扫描，如果四
                    // 运算符，就结束
                    if (opeStack.isOper(expr.charAt(index + 1))) {
                        numStack.push(Integer.parseInt(keppNum));
                        // 每次都需要清空
                        keppNum = "";
                    }


                }


            }
            index++;
            // 判断是否扫描到最后
            if(index>=expr.length()){
                break;
            }

        }
        // 退出循环后，扫描结束
        while (true){
            // 如果符号栈为空，数栈中只有一个数，就是结果
            if(opeStack.isEmpty()){
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            ope=opeStack.pop();
            res=numStack.cal(num1,num2,ope);

            // 结果入数栈
            numStack.push(res);

        }

        System.out.println("表达式:"+expr+"="+numStack.pop());




    }

}

// 使用数组模拟栈
class ArrayStack2{
    private  int maxSize; // 栈的大小
    private  int [] stack;
    private  int top=-1; // 指向栈顶

    public ArrayStack2(int maxSize){
        this.maxSize=maxSize;
        stack=new int[maxSize];
    }

    // 返回当前栈顶的值，但不是pop
    public int peek(){
        return  stack[top];
    }


    // 返回运算符的优先级,数字大，代表优先级高
    // 假定只有+，-，*，/ 4种
    public int priority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }
        return -1;
    }
    // 是不是一个操作符
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }

    // 计算方法
    public int cal(int num1,int num2,int oper){
        int res=0;
        switch (oper){
            case '+':
                res=num2+num1;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num2*num1;
                break;
            case '/':
                res=num2/num1;
                break;
        }
        return res;

    }



    // 栈满
    public boolean isFull(){
        return top==maxSize-1;
    }
    // 栈空
    public boolean isEmpty(){
        return top==-1;
    }
    // 入栈
    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;

    }
    // 出栈
    public int pop(){
        if(isEmpty()){
            System.out.println("栈为空");
            throw new RuntimeException("栈为空");
        }
        int value=stack[top];
        top--;
        return value;

    }
    // 遍历栈,要从栈顶开始显示数据
    public  void list(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.println(stack[i]);
        }
    }





}



