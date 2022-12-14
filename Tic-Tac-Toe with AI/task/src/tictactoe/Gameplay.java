package tictactoe;

public class Gameplay {

    private Grid grid;
    private char currentPlayer;

    public Gameplay() {
        this.grid = new Grid();
        this.currentPlayer = 'X';
    }

    public void startGame(Player playerX, Player playerO) {
        this.grid.printGrid();
        while (true) {
            makeMove(getCurrentPlayer() == 'X' ? playerX : playerO);
            this.grid.printGrid();
            if (isFinished()) {
                printGameState();
                reset();
                break;
            }
        }
    }

    private void reset() {
        this.grid = new Grid();
        this.currentPlayer = 'X';
    }

    private String getGameState() {
        if (checkIfWon('X')) {
            return "X wins";
        } else if (checkIfWon('O')) {
            return "O wins";
        } else if (allCellsOccupied()) {
            return "Draw";
        } else {
            return "Game not finished";
        }
    }

    private void printGameState() {
        System.out.println(getGameState());
    }

    private boolean isFinished() {
        return !getGameState().equals("Game not finished");
    }


    public char getCurrentPlayer() {
        return this.currentPlayer;
    }

    public char getOpponent() {
        return getCurrentPlayer() == 'X' ? 'O' : 'X';
    }


    public void placeCell(int x, int y) {
        this.placeCell(new int[]{x, y});
    }

    public void placeCell(int[] coordinates) {
        this.placeCell(coordinates, getCurrentPlayer());
    }

    public void placeCell(int[] coordinates, char player) {
        this.grid.setCell(coordinates[0], coordinates[1], player);
    }

    public boolean isCellOccupied(int x, int y) {
        return this.grid.getCell(x, y) != ' ';
    }

    private boolean allCellsOccupied() {
        for (int i = 0; i < this.grid.getSize(); i++) {
            for (int j = 0; j < this.grid.getSize(); j++) {
                if (this.grid.getCell(i, j) == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkIfWon(char player) {
        for (int i = 0; i < this.grid.getSize(); i++) {
            if (grid.getCell(i, 0) == player && grid.getCell(i, 1) == player && grid.getCell(i, 2) == player){
                return true;
            }
        }
        for (int i = 0; i < this.grid.getSize(); i++) {
            if (grid.getCell(0, i) == player && grid.getCell(1, i) == player && grid.getCell(2, i) == player){
                return true;
            }
        }
        return grid.getCell(0, 0) == player && grid.getCell(1, 1) == player && grid.getCell(2, 2) == player ||
                grid.getCell(0, 2) == player && grid.getCell(1, 1) == player && grid.getCell(2, 0) == player;
    }

    private void makeMove(Player player) {
        player.makeTurn();
        this.currentPlayer = (this.currentPlayer == 'X') ? 'O' : 'X';
    }
}
