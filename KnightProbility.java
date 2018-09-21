public class KnightProbility {
    static int[][] direction = new int[][]{{2,1},{-2,1},{2,-1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};

    public static void main(String[] args) {
        int N = 8;
        int K = 1;
        int r = 0;
        int c = 0;
        KnightProbility sol = new KnightProbility();
        double res = sol.knightProbility(N,K,r,c);
        System.out.print(res);
    }

    public double knightProbility(int N, int K, int r, int c) {
        double[][] preWays = new double[N][N];
        // initiation
        preWays[r][c] = 1;
        double res = 0;

        for (int k = 0; k <= K; ++k) {
            double[][] ways = new double[N][N];
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    for (int[] dir : direction) {
                        int oldR = i - dir[0];
                        int oldC = j - dir[1];
                        if (isOnBoard(N, oldR, oldC)) {
                            ways[i][j] += (preWays[oldR][oldC] / 8.0);
                        }
                    }
                }
            }
            preWays = ways;
        }
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                res += preWays[i][j];
            }
        }
        return res;

    }

    private boolean isOnBoard(int N, int R, int C) {
        if (R >= 0 && R < N && C >= 0 && C < N) {
            return true;
        }
        return false;
    }
}
