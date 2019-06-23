package pers.geolo.dp;

import java.util.Scanner;

/**
 * @author 桀骜(Geolo)
 * @date 2019-06-23
 */
public class Test {
    public static void main(String[] args) {
        int[][] array;
//        = {
//                {0, 1, 10, 10},
//                {1, 0, 1, 2},
//                {10, 1, 0, 10},
//                {10, 2, 10, 0}
//        };
        int[][] array2 = {
                {0, 3, 6, 7},
                {5, 0, 2, 3},
                {6, 4, 0, 2},
                {3, 7, 5, 0}
        };
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            array = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = scanner.nextInt();
                }
            }
            int res = TSPQuestion.getMinDistance(array);
            System.out.println(res);
        }
    }

}
