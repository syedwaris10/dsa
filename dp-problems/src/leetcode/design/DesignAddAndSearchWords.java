package leetcode.design;


import java.util.*;

/**
 * <a href="https://leetcode.com/problems/design-add-and-search-words-data-structure/">...</a>
 */
public class DesignAddAndSearchWords {
    private Set<String> dict;

    public DesignAddAndSearchWords() {
        dict = new HashSet<>();
    }

    public void addWord(String word) {
        dict.add(word);
    }

    public boolean search(String word) {
        return find(0, word);
    }


    private boolean find(int index, String word) {
        if (index == word.length()) return true;

        for (int i = index; i <= word.length(); i++) {

            if (word.charAt(index) == '.') {
                for (char c = 'a'; c <= 'z'; c++) {
                    word = word.substring(0, i) + c + word.substring(i + 1);
                    if (dict.contains(word.substring(0, i)) && find(i, word)) {
                        return true;
                    }
                }
            }
            if (dict.contains(word.substring(0, i)) && find(i, word)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DesignAddAndSearchWords designAddAndSearchWords = new DesignAddAndSearchWords();
        designAddAndSearchWords.addWord("bad");
        designAddAndSearchWords.addWord("dad");
        designAddAndSearchWords.addWord("mad");
        System.out.println(designAddAndSearchWords.search("bad"));
        List<String> products = new ArrayList<>();
    }
}
