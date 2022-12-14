import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        int[][] array = new int[width][height];
        int greatest = Integer.MIN_VALUE;
        String output = "";

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();
                if (array[i][j] > greatest) {
                    greatest = array[i][j];
                    output = String.format("%d %d", i, j);
                }
            }
        }
        System.out.println(output);
    }
}