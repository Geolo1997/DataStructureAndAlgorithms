package pers.geolo.dp;

/**
 * @author 桀骜(Geolo)
 * @date 2019-06-23
 */
public class TSPQuestion {

    public static int getMinDistance(int[][] distance) {
        // 点的数量
        final int pointNum = distance.length;
        // 集合的数量(2的pointNum-1次方, 除去0点)
        final int setNum = 1 << (pointNum - 1);
        // minDistance[point][set]表示点point经过set集合一遍的最小路程
        int[][] minDistance = new int[pointNum][setNum];
        // path[point][set]表示point经set集合一遍最小路程的下一个点
        int[][] next = new int[pointNum][setNum];

        // 将point到空集的最小距离设为point到0点的距离
        for (int point = 1; point < pointNum; point++) {
            minDistance[point][0] = distance[point][0];
            next[point][0] = 0;
        }
        // 遍历所有的集合，set的二进制值表示点的选择状态，如set = 5 = 101(2)表示set集合中有点1和3
        for (int set = 1; set < setNum; set++) {
            // 遍历不在集合中的点
            for (int pointOutSet = 1; pointOutSet < pointNum; pointOutSet++) {
                // 如果点pointOutSet不在集合set中
                // 如pointOutSet = 2, 1 << (pointOutSet - 1) = 1左移1位 = 10(2), set = 5, 10(2) & 101(2) = 0, 所以点2不在集合5中
                if (!containPoint(set, pointOutSet)) {
                    int minDistanceInSet = Integer.MAX_VALUE;
                    int nextPoint = 0;
                    // 遍历在集合中的点
                    for (int pointInSet = 1; pointInSet < pointNum; pointInSet++) {
                        // 如果点pointInSet在集合set中
                        if (containPoint(set, pointInSet)) {
                            // setWithoutPoint:去掉点pointInSet后的集合
                            // 如set = 5 = 101(2), pointInSet = 1 = 1(2), setWithoutPoint = 101(2) - 1(2) = 100(2) = 4
                            // 因为减去正整数，所以可确定minDistance[*][setWithoutPoint]值一定被计算过
                            int setWithoutPoint = removePoint(set, pointInSet);
                            // minDistanceInSet更新为(pointOutSet到集合中任意点的距离+该点到剩余集合的最小值)的最小值
                            int minValue = Math.min(minDistanceInSet,
                                    distance[pointOutSet][pointInSet] + minDistance[pointInSet][setWithoutPoint]);
                            if (minValue < minDistanceInSet) {
                                nextPoint = pointInSet;
                                minDistanceInSet = minValue;
                            }
                        }
                    }
                    minDistance[pointOutSet][set] = minDistanceInSet;
                    next[pointOutSet][set] = nextPoint;
                }
            }
        }
        // 计算点0到集合的最小值
        int minTotalDistance = Integer.MAX_VALUE;
        for (int point = 1; point < pointNum; point++) {
            int setWithoutPoint = removePoint(setNum - 1, point);
            int minValue = Math.min(minTotalDistance, distance[0][point] + minDistance[point][setWithoutPoint]);
            if (minValue != minTotalDistance) {
                next[0][setNum - 1] = point;
                minTotalDistance = minValue;
            }
        }

//        for (int i = 0; i < minDistance.length; i++) {
//            for (int j = 0; j < minDistance[0].length; j++) {
//                System.out.print(minDistance[i][j] + " ");
//            }
//            System.out.println();
//        }

        int point = 0, set = setNum - 1;
        while (true) {
            System.out.print(point + "->");
            point = next[point][set];
            set = removePoint(set, point);
            if (point == 0) {
                System.out.println(0);
                break;
            }
        }

        return minTotalDistance;
    }

    /**
     * set是否包含点point
     *
     * @param set
     * @param point
     * @return
     */
    private static boolean containPoint(int set, int point) {
        return ((1 << (point - 1)) & set) != 0;
    }

    /**
     * 从set中移除点point
     *
     * @param set
     * @param point
     * @return
     */
    private static int removePoint(int set, int point) {
        return set - (1 << (point - 1));
    }
}
