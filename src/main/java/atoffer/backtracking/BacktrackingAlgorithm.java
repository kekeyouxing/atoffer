package atoffer.backtracking;

import java.util.List;

public class BacktrackingAlgorithm {
	
    /**
     * <p>
     * Given a 2D board and a word, find if the word exists in the grid.
     * The word can be constructed from letters of sequentially adjacent cell, 
     * where "adjacent" cells are those horizontally or vertically neighboring. 
     * The same letter cell may not be used more than once.
     * <p>
     * Example:
     * <blockquote>
     * <pre>
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     * 
     * Given word = "ABCCED", return true.
     * Given word = "SEE", return true.
     * Given word = "ABCB", return false.
     * </pre>
     * </blockquote>
     * @param board
     * @param word
     * @see <a href="https://leetcode.com/problems/word-search">word-search</a>
     */
    public boolean exist(char[][] board, String word) {
    	if(board == null || board.length == 0) {
    		return false;
    	}
    	int rows = board.length;
    	int cols = board[0].length;
        if(word.length() > rows*cols){
            return false;
        }
    	boolean[] visited = new boolean[rows*cols];
    	char[] words = word.toCharArray();
    	for(int i=0;i < rows; i++) {
    		for(int j=0; j < cols; j++) {
    			if(isExist(board, i, j, rows, cols, words, visited, 0)) {
    				return true;
    			}
    		}
    	}
		return false;
    }

	private boolean isExist(char[][] board, int i, int j, int rows, int cols, char[] words, boolean[] visited,int k) {
		
		int index = i*cols + j;
		if(i<0 || i>=rows || j<0 || j>=cols || board[i][j]!=words[k] || visited[index] == true) {
			return false;
		}
		if(k == words.length-1) {
			return true;
		}
		visited[index] = true;
		
		if( isExist(board, i-1, j, rows, cols, words, visited, k+1)||
			isExist(board, i+1, j, rows, cols, words, visited, k+1)||
			isExist(board, i, j-1, rows, cols, words, visited, k+1)||
			isExist(board, i, j+1, rows, cols, words, visited, k+1)) 
		{
			return  true;
		}
		
		visited[index] = false;
		return false;
		
	}
	
    /**
     * <p>
     * Given a 2D board and a list of words from the dictionary, find all words in the board.
     * Each word must be constructed from letters of sequentially adjacent cell, 
     * where "adjacent" cells are those horizontally or vertically neighboring. 
     * The same letter cell may not be used more than once in a word.
     * <p>
     * <blockquote>
     * <pre>
     * Input: 
     * board = [
     *   ['o','a','a','n'],
     *   ['e','t','a','e'],
     *   ['i','h','k','r'],
     *   ['i','f','l','v']
     * ]
     * words = ["oath","pea","eat","rain"]

     * Output: ["eat","oath"]
     * </pre>
     * </blockquote>
     * @param board
     * @param words
     * @see <a href="https://leetcode.com/problems/word-search-ii/">word-search-ii</a>
     */
    public List<String> findWords(char[][] board, String[] words) {
		return null;
        
    }
    
}
