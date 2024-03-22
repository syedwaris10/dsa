package leetcode.design.searchsuggestionsystem;

import java.util.List;

public class SearchSuggestion {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Products ps = new Products();
        TrieNode root = ps.createProducts(products);

        SuggestionEngine se = new SuggestionEngine();

        return se.suggestProducts(root, searchWord);
    }


    public static void main(String[] args) {
        SearchSuggestion searchSuggestion = new SearchSuggestion();
        List<List<String>> ans = searchSuggestion.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");

        System.out.println(ans);
    }
}
