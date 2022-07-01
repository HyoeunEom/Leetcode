class Solution {
    public void gameOfLife(int[][] board) {
        int ySize = board.length;
        int xSize = board[0].length;
        // int[][] secondBoard = new int[ySize][xSize];
        int[][] changes = new int[ySize * xSize][3];
        int changeIndex = 0;

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
                        changes[changeIndex] = new int[]{i, j, 0};
                    } else {
                        changes[changeIndex] = new int[]{i, j, 1};
                    }
                } else {
                    if (lives == 3) {
                        changes[changeIndex] = new int[]{i, j, 1};
                    } else {
                        changes[changeIndex] = new int[]{i, j, 0};
                    }
                }
                changeIndex += 1;
            }
        }

        for (int[] change : changes) {
            board[change[0]][change[1]] = change[2];
        }
    }
}