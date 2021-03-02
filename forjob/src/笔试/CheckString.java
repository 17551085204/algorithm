/*
 * @Author hdk
 * @QQ:2890241339
 * @Date 2021/3/2 0002
 **/
package 笔试;

public class CheckString {
    public static void main(String[] args) {

        checkString("helllo");

    }

    // 编写一个字符串校验函数
    /**
     * helllo-->hello
     *
     * woooook->wook
     */
     public  static  String checkString(String inputStr){
         char[] chars = inputStr.toCharArray();
         StringBuilder stringBuilder = new StringBuilder();
         for (int i = 0; i < chars.length-1;) {
             stringBuilder.append(chars[i]);
             if(chars[i]!=chars[i+1]){
                 stringBuilder.append(chars[i+1]);
             }




         }



         return "";
     }


}
