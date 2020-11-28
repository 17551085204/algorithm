/*
 * @Author hdk
 * @QQ:2890241339
 **/
/*
走台阶问题
    有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，
    请将结果Mod 1000000007
给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
测试样例：
1
返回：1

解析：这是一个非常经典的为题，设f(n)为上n级台阶的方法，要上到n级台阶的最后
一步有两种方式：从n-1级台阶走一步；从n-1级台阶走两步，于是就有了这个公式
f(n) = f(n-1)+f(n-2);

 */


public class GoUpstairs {
    public static void main(String[] args) {
        System.out.println(countWays(20));
    }
    public static int countWays(int n) {
        // write code here
        if(n<=2)
            return n;
        int f = 1%1000000007;
        int s = 2%1000000007;
        int t = 0;
        for(int i=3;i<=n;i++){
            t = (f+s)%1000000007;
            f = s;
            s = t;
        }
        return t;
    }


}
