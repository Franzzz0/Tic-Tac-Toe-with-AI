package tictactoe;

import java.util.Scanner;

public class User extends Player{
    private final Scanner scanner;

    public User(Gameplay gameplay, Scanner scanner) {
        super(gameplay);
        this.scanner = scanner;
    }

    @Override
    public void makeTurn() {
        while (true) {
            System.out.print("Enter the coordinates: > ");
            int x;
            int y;
            try {
                String[] parts = scanner.nextLine().split(" ");
                x = Integer.parseInt(parts[0]) - 1;
                y = Integer.parseInt(parts[1]) - 1;
            } catch (Exception exception) {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (x < 0 || x > 2 || y < 0 || y > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (this.gameplay.isCellOccupied(x, y)) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            this.gameplay.placeCell(x, y);
            break;
        }
    }
}
