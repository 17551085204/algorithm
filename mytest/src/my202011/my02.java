/*
 * @Author hdk
 * @QQ:2890241339
 **/
package my202011;
import org.junit.Test;

/**
 * 单元测试
 */
public class my02 {

    @Test
    public  void add(){
        System.out.println("hello");
        int a=1;
        int b=2;
        System.out.println(a+b);

    }

    @Test
    public void my02(){
        // 将string转为整数
        String str="12663";
        char[] chars = str.toCharArray();
        int res=0;
        for (int i = 0; i < chars.length; i++) {
            res=res*10+chars[i]-48;
        }
        System.out.println(res);

    }





}
