import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int seed = a;
        int maximum = k;
        for (int i = a; i <= b; i++) {
            Random generator = new Random(i);
            int[] numbers = new int[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = generator.nextInt(k);
            }
            int seedMax = Arrays.stream(numbers).max().getAsInt();
            if (seedMax < maximum) {
                maximum = seedMax;
                seed = i;
            }
        }
        System.out.println(seed);
        System.out.println(maximum);
        // write your code here
    }
}