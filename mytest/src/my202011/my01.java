/*
 * @Author hdk
 * @QQ:2890241339
 **/
package my202011;

import java.text.SimpleDateFormat;
import java.util.Date;

public class my01 {
    public static void main(String[] args) {
        printTime();

    }

    /**
     * java打印时间
     */
    public static  void printTime(){
        System.out.println(System.currentTimeMillis());// 当前的毫秒数
        // 格式化当前时间输出
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);


    }

}
