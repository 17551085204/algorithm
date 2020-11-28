/*
 * @Author hdk
 * @QQ:2890241339
 **/
/*
最长公共序列数
     给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。
     例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是
     最长公共子序列。
给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。
保证两串长度均小于等于300。
测试样例：
"1A2C3D4B56",10,"B1D23CA45B6A",12
返回：6

解析：设dp[n][m] ，为A的前n个字符与B的前m个字符的公共序列长度，
则当A[n]==B[m]的时候，dp[i][j] = max(dp[i-1][j-1]+1,dp[i-1][j],dp[i][j-1])，
否则，dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);

 */


public class LCS {
    public static void main(String[] args) {
        String A="1A2C3D4B56";
        String B="B1D23CA45B6A";
        System.out.println(findLCS(A,A.length(),B,B.length()));

    }

    public static int findLCS(String A, int n, String B, int m) {
        // write code here
        int[][] dp = new int[n][m];
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for(int i=0;i<n;i++){
            if(a[i]==b[0]){
                dp[i][0] = 1;
                for(int j=i+1;j<n;j++){
                    dp[j][0] = 1;
                }
                break;
            }
        }
        for(int i=0;i<m;i++){
            if(a[0]==b[i]){
                dp[0][i] = 1;
                for(int j=i+1;j<m;j++){
                    dp[0][j] = 1;
                }
                break;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(a[i]==b[j]){
                    dp[i][j] = max(dp[i-1][j-1]+1,dp[i-1][j],dp[i][j-1]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n-1][m-1];
    }
    public static  int max(int a,int b,int c){
        int max = a;
        if(b>max)
            max=b;
        if(c>max)
            max = c;
        return max;
    }

}
