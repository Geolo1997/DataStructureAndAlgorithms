package pers.geolo.dp;

/**
 * 最长公共子序列问题(LCS)
 *
 * @author 桀骜(Geolo)
 * @date 2019-06-28
 */
public class LCSQuestion {

    public static void main(String[] args) {
        String a = "abcbdb";
        String b = "acbbabdbb";
        System.out.println(getLCS(a, b));
    }

    public static String getLCS(String a, String b) {
        // lcs[i][j]: a的前i个字符和b的前j个字符的最长公共子序列长度
        int[][] lcs = new int[a.length() + 1][b.length() + 1];

        // 初始化lcs[i][0]
        for (int i = 0; i <= a.length(); i++) {
            lcs[i][0] = 0;
        }
        // 初始化lcs[0][i]
        for (int i = 0; i <= b.length(); i++) {
            lcs[0][i] = 0;
        }

        // 计算最长公共子序列长度
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        // 倒序生成最长公共子序列
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = a.length(), j = b.length(); i > 0 && j > 0; ) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                stringBuilder.append(a.charAt(i - 1));
                i--;
                j--;
            } else {
                if (lcs[i - 1][j] == Math.max(lcs[i - 1][j], lcs[i][j - 1])) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        String lcsString = stringBuilder.reverse().toString();
        return lcsString;
    }
}
