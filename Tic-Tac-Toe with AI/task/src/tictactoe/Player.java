package tictactoe;

import java.util.Random;

abstract class Player {
    Gameplay gameplay;

    public Player(Gameplay gameplay) {
        this.gameplay = gameplay;
    }

    abstract void makeTurn();

    public void placeRandom() {
        Random rnd = new Random();
        while (true) {
            int x = rnd.nextInt(3);
            int y = rnd.nextInt(3);
            if (!this.gameplay.isCellOccupied(x, y)) {
                this.gameplay.placeCell(x, y);
                break;
            }
        }
    }
}
