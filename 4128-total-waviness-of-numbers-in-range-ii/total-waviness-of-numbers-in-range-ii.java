class Solution {

    static class Node {
        long count;
        long sum;

        Node(long count, long sum) {
            this.count = count;
            this.sum = sum;
        }
    }

    private String num;
    private Node[][][][] memo;
    private boolean[][][][] visited;

    private Node dfs(int pos, int last1, int last2, int tight) {

        if (pos == num.length()) {
            return new Node(1, 0);
        }

        if (tight == 0 && visited[pos][last1][last2][0]) {
            return memo[pos][last1][last2][0];
        }

        int limit = (tight == 1) ? num.charAt(pos) - '0' : 9;

        long totalCount = 0;
        long totalSum = 0;

        for (int d = 0; d <= limit; d++) {

            int newTight = (tight == 1 && d == limit) ? 1 : 0;

            if (last1 == 10) {

                // No digit chosen yet
                if (d == 0) {
                    Node next = dfs(pos + 1, 10, 10, newTight);

                    totalCount += next.count;
                    totalSum += next.sum;
                } else {
                    Node next = dfs(pos + 1, d, 10, newTight);

                    totalCount += next.count;
                    totalSum += next.sum;
                }

            } else if (last2 == 10) {

                // Exactly one digit chosen
                Node next = dfs(pos + 1, d, last1, newTight);

                totalCount += next.count;
                totalSum += next.sum;

            } else {

                int add = 0;

                if ((last1 > last2 && last1 > d) ||
                    (last1 < last2 && last1 < d)) {
                    add = 1;
                }

                Node next = dfs(pos + 1, d, last1, newTight);

                totalCount += next.count;
                totalSum += next.sum + (long) add * next.count;
            }
        }

        Node result = new Node(totalCount, totalSum);

        if (tight == 0) {
            visited[pos][last1][last2][0] = true;
            memo[pos][last1][last2][0] = result;
        }

        return result;
    }

    private long solve(long x) {

        if (x <= 0) {
            return 0;
        }

        num = String.valueOf(x);

        int n = num.length();

        memo = new Node[n + 1][11][11][2];
        visited = new boolean[n + 1][11][11][2];

        return dfs(0, 10, 10, 1).sum;
    }

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }
}