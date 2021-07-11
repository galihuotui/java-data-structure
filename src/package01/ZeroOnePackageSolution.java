package package01;

public class ZeroOnePackageSolution {

    //0-1背包问题
    public static void main (String[] args) throws java.lang.Exception
    {

        int weight[] = new int[] {2, 1, 3};
        int val[] = new int[] {4, 2, 3};
        int choice = 3;
        int space = 4;


        int [][] dp = new int[choice+1][space+1];

        for(int i = 1; i <= choice; i++) {
            for(int j = 1; j <= space; j++) {
                if(j-weight[i-1] < 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i-1][j],
                            dp[i-1][j-weight[i-1]] + val[i-1]
                    );
                }

            }
        }

        System.out.println(dp[choice][space] + "");
    }
}
