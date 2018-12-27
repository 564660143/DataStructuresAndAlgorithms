package num1_100;

/**
 * 79. 单词搜索
 */
class Solution79 {
    private int[][] move = {{0, 1}, {1,0}, {0, -1}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (find(board, i, j, words, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    // 从board[row][col]开始寻找word的[index...word.length]部分
    private boolean find(char[][] board, int row, int col, char[] word, int index){
        if (index == word.length) {
            return true;
        }

        if (row >= board.length || col >= board[0].length || row < 0 || col < 0 || board[row][col] != word[index]) {
            return false;
        }

        char temp = board[row][col];
        // 将当前元素置为0, 表示当前元素已被使用过
        board[row][col] = '0';
        boolean exist = find(board, row + move[0][0], col + move[0][1], word, index + 1)
                || find(board, row + move[1][0], col + move[1][1], word, index + 1)
                || find(board, row + move[2][0], col + move[2][1], word, index + 1)
                || find(board, row + move[3][0], col + move[3][1], word, index + 1);
        // 回溯
        board[row][col] = temp;
        return exist;
    }

}