import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxSumArray {

    public static int maxSum(List<Integer>num, int n, int k) {
        if(n < k) {
            return -1;
        }
        int maxSum = num.stream().limit(k).mapToInt(Integer::intValue).sum();
        int windowSum = maxSum;
        for(int i = k; i < n; i++) {
            windowSum += num.get(i).intValue() - num.get(i - k).intValue();
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String args[]) {
        int n, k;
        List<Integer> num = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        for(int i=0; i<n; i++) {
            num.add(in.nextInt());
        }
        System.out.println(maxSum(num, n, k));
    }
}