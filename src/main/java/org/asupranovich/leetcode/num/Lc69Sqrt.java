package org.asupranovich.leetcode.num;

public class Lc69Sqrt {

    public static void main(String[] args) {
        final Lc69Sqrt solution = new Lc69Sqrt();
        System.out.println(solution.mySqrt(2147395500));
    }

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        if (x >= 2147395600) {
            return 46340;
        }

        int start = 1;
        int end = Math.min(x, 46340);

        while (start <= end) {
            int middle = start + (end - start) / 2;
            int square = middle * middle;
            if (square < x) {
                if ((middle + 1) * (middle + 1) > x) {
                    return middle;
                }
                start = middle;
            } else if (square > x) {
                if ((middle - 1) * (middle - 1) <= x) {
                    return middle - 1;
                }
                end = middle;
            } else {
                return middle;
            }
        }
        return x;
    }
}
