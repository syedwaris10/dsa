package leetcode.design.searchsuggestionsystem;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    private Map<Character, TrieNode> map;
    private boolean isWord;
    private String word;

    public TrieNode() {
        map = new HashMap<>();
    }

    public Map<Character, TrieNode> getMap() {
        return map;
    }

    public void setMap(Map<Character, TrieNode> map) {
        this.map = map;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}