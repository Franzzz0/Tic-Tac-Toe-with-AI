import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] rotatedArray = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedArray[j][rotatedArray[j].length - 1 - i] = scanner.nextInt();
            }
        }
        for (int[] i : rotatedArray) {
            System.out.println();
            for (int j : i) {
                System.out.print(j + " ");
            }
        }
    }
}