package leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    TrieNode root;
    List<String> ans;
    public List<String> findWords(char[][] board, String[] words) {
        this.root = new TrieNode();
        ans = new ArrayList<>();
        insert(words);
        TrieNode temp = root;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (temp.map.get(board[i][j]) != null) {
                    search(root, board, i, j);
                }
            }
        }
        System.out.println(ans);
        return ans;

    }
    
    private void search(TrieNode temp, char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] == '#' || temp.map.get(board[row][col]) == null) {
            return;
        }


        char c = board[row][col];
        temp = temp.map.get(c);

        if (temp.isWord) {
            ans.add(temp.word);
            temp.isWord = false;
        }

        board[row][col] = '#';

        search(temp, board, row, col - 1);
        search(temp, board, row, col + 1);
        search(temp, board, row - 1, col);
        search(temp, board, row + 1, col);

        board[row][col] = c;
    }
    private void search1(TrieNode node, char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] == '#' || node.map.get(board[row][col]) == null) {
            return;
        }

        char c = board[row][col];
        node = node.map.get(c);

        if (node.isWord) {
            ans.add(node.word);
            node.isWord = false; // Remove the word from the Trie to avoid duplicates
        }

        board[row][col] = '#'; // Mark the cell as visited

        search(node, board, row, col - 1);
        search(node, board, row, col + 1);
        search(node, board, row - 1, col);
        search(node, board, row + 1, col);

        board[row][col] = c; // Reset the cell value after exploration
    }

    private void insert(String[] words) {
        for (String word: words) {
            TrieNode temp = root;
            for (char c: word.toCharArray()) {
            if (temp.map.get(c) == null) {
                temp.map.put(c, new TrieNode());
            }
            
            temp = temp.map.get(c);
          }
        
            temp.isWord = true;
            temp.word = word;
        }
        
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        solution.findWords(board, words);
    }
    
}

class TrieNode {
    Map<Character, TrieNode> map;
    boolean isWord;
    String word;
    public TrieNode() {
        map = new HashMap<>();
    }
}