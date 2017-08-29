package followUpInCodeInterview;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given two integer arrays sorted in ascending order and an integer k.
 * Define sum = a + b,
 * where a is an element from the first array and b is an element from the second one.
 * Find the kth smallest sum out of all possible sums.
 * 
 * Example
 * Given [1, 7, 11] and [2, 4, 6].
 * For k = 3, return 7.
 * For k = 4, return 9.
 * For k = 8, return 15.
 */

class ArrayPair {
    public int x, y, sum;
    public ArrayPair(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.sum = val;
    }
}

class ArrayPairComparator implements Comparator<ArrayPair> {
    public int compare(ArrayPair a, ArrayPair b) {
        return a.sum - b.sum;
    }
}

public class KthSmallestSumInTwoSortedArrays {
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        boolean[][] hash = new boolean[A.length][B.length];
        PriorityQueue<ArrayPair> minHeap = new PriorityQueue<ArrayPair>(k, new ArrayPairComparator());
        minHeap.add(new ArrayPair(0, 0, A[0] + B[0]));

        for (int i = 0; i < k - 1; i++) {
            ArrayPair cur = minHeap.poll();
            for (int j = 0; j < 2; j++) {
                int next_x = cur.x + dx[j];
                int next_y = cur.y + dy[j];
                ArrayPair next_Pair = new ArrayPair(next_x, next_y, 0);
                if (next_x < A.length && next_y < B.length && !hash[next_x][next_y]) {
                    hash[next_x][next_y] = true;
                    next_Pair.sum = A[next_x] + B[next_y];
                    minHeap.add(next_Pair);
                }
            }
        }
        return minHeap.peek().sum;
    }
}
