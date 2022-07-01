class Solution {
    public void gameOfLife(int[][] board) {
        int ySize = board.length;
        int xSize = board[0].length;
        int[][] secondBoard = new int[ySize][xSize];

        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                int lives  = (i > 0 ? board[i-1][j] : 0);
                lives += (i < (ySize-1) ? board[i + 1][j] : 0);
                lives += (j > 0 ? board[i][j - 1] : 0);
                lives += (j < (xSize-1) ? board[i][j + 1] : 0);
                lives += (i > 0 && j > 0) ? board[i-1][j-1] : 0;
                lives += (i < (ySize-1) && j < (xSize-1)) ? board[i+1][j+1] : 0;
                lives += (i > 0 && j < (xSize - 1)) ? board[i-1][j+1] : 0;
                lives += (i < (ySize-1) && j > 0) ? board[i+1][j-1] : 0;

                if (board[i][j] == 1) {
                    if (lives < 2 || lives > 3) {
                        secondBoard[i][j] = 0;
                    } else {
                        secondBoard[i][j] = 1;
                    }
                } else {
                    if (lives == 3) {
                        secondBoard[i][j] = 1;
                    } else {
                        secondBoard[i][j] = 0;
                    }
                }
            }
        }
        
        // board = secondBoard.clone();
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                board[i][j] = secondBoard[i][j];
            }
        }
    }
}