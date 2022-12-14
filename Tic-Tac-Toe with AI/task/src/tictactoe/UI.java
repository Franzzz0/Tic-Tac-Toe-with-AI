package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class UI {
    private final Scanner scanner;
    private final String[] validPlayer;
    private final Gameplay game;

    public UI() {
        this.scanner = new Scanner(System.in);
        this.game = new Gameplay();
        this.validPlayer = new String[]{"user", "easy", "medium", "hard"};
    }

    public void start() {
        while (true) {
            System.out.print("Input command: > ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("Bad parameters!");
                continue;
            }

            if (parts[0].equals("start") && Arrays.asList(validPlayer).contains(parts[1])
                    && Arrays.asList(validPlayer).contains(parts[2]))
            {
                Player playerX = getPlayer(parts[1]);
                Player playerO = getPlayer(parts[2]);
                this.game.startGame(playerX, playerO);
            } else {
                System.out.println("Bad parameters!");
            }
        }

    }

    private Player getPlayer(String input) {
        Player player;
        if (input.equals("user")) {
            player = new User(this.game, this.scanner);
        } else {
            player = new AI(this.game, input);
        }
        return player;
    }
}
