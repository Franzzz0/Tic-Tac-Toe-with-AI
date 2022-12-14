import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        double m = Double.parseDouble(scanner.next());

        while (true) {
            double[] numbers = new double[n];
            Random rnd = new Random(k);
            for (int i = 0; i < n; i++) {
                numbers[i] = rnd.nextGaussian();
            }
            if (!(Arrays.stream(numbers).max().getAsDouble() > m)) {
                System.out.println(k);
                break;
            }
            k++;
        }
    }
}