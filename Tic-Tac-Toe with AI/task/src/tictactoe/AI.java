package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class AI extends Player{
    private final String difficultyLevel;

    public AI(Gameplay gameplay, String difficultyLevel) {
        super(gameplay);
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public void makeTurn() {
        System.out.printf("Making move level \"%s\"\n", difficultyLevel);
        switch (difficultyLevel) {
            case "easy" -> placeRandom();
            case "medium" -> medium();
            case "hard" -> hard();
        }
    }

    private void medium() {
        if (canWin(gameplay.getCurrentPlayer())) {
            gameplay.placeCell(getWinningCoordinates(gameplay.getCurrentPlayer()));
        } else if (canWin(gameplay.getOpponent())) {
            gameplay.placeCell(getWinningCoordinates(gameplay.getOpponent()));
        } else {
            placeRandom();
        }
    }

    private void hard() {
        gameplay.placeCell(getBestMove());
    }

    private int[] getBestMove() {
        int bestValue = -1000;
        int[] bestMove = new int[2];
        for (int[] move : getAvailableMoves()) {
            gameplay.placeCell(move, gameplay.getCurrentPlayer());
            int moveValue = minimax(gameplay, false);
            gameplay.placeCell(move, ' ');

            if (moveValue > bestValue) {
                bestValue = moveValue;
                bestMove = move;
            }
        }
        return bestMove;
    }

    private int minimax(Gameplay gameplay, boolean isMax) {
        if (gameplay.checkIfWon(gameplay.getCurrentPlayer())) {
            return 10;
        } else if (gameplay.checkIfWon(gameplay.getOpponent())) {
            return -10;
        } else if (getAvailableMoves().size() == 0) {
            return 0;
        }
        int best;
        if (isMax) {
            best = -1000;
            for (int[] move : getAvailableMoves()) {
                gameplay.placeCell(move, gameplay.getCurrentPlayer());
                best = Math.max(best, minimax(gameplay, false));
                gameplay.placeCell(move, ' ');
            }
        } else {
            best = 1000;
            for (int[] move : getAvailableMoves()) {
                gameplay.placeCell(move, gameplay.getOpponent());
                best = Math.min(best, minimax(gameplay, true));
                gameplay.placeCell(move, ' ');
            }
        }
        return best;
    }

    private List<int[]> getAvailableMoves() {
        List<int[]> moves = new ArrayList<>();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (gameplay.isCellOccupied(x, y)) {
                    continue;
                }
                moves.add(new int[]{x, y});
            }
        }
        return moves;
    }

    private boolean canWin(char player) {
        return getWinningCoordinates(player)[0] != -1;
    }

    private int[] getWinningCoordinates(char player) {
        for (int[] move : getAvailableMoves()) {
            this.gameplay.placeCell(move, player);
            if (gameplay.checkIfWon(player)) {
                this.gameplay.placeCell(move, ' ');
                return move;
            }
            this.gameplay.placeCell(move, ' ');
        }
        return new int[]{-1, -1};
    }
}
