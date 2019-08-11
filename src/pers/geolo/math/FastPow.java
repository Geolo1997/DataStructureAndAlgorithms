package pers.geolo.math;

/**
 * 快速幂
 *
 * @author 桀骜(Geolo)
 * @date 2019/8/11
 */
public class FastPow {

    /**
     * 快速幂
     *
     * @param base 底数
     * @param exp  指数
     * @return 底数的指数次方
     * TODO 未考虑溢出
     */
    public static int pow(int base, int exp) {
        // 0^n = 0, 1^n = 1
        if (base <= 1) {
            return base;
        }
        int res = 1;
        while (exp != 0) {
            if ((exp & 1) != 0) { // 是奇数
                res *= base;
            }
            base = base * base;
            exp /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int base = (int) (Math.random() * 100);
            int exp = (int) (Math.random() * 10);
            int systemResult = (int) Math.pow(base, exp);
            int myResult = pow(base, exp);
//            if (systemResult != myResult) {
            System.err.println("FAILURE: systemResult = " + systemResult + ", myResult = " + myResult);
//                break;
//            }
        }
    }
}
