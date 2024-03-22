package leetcode.design.searchsuggestionsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SuggestionEngine {
    private List<String> products;
    public List<List<String>> suggestProducts(TrieNode root, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String sub = searchWord.substring(0, i + 1);
            TrieNode node = prefix(root, sub);

            if (node != root) {
                products = new ArrayList<>();
                find(node);
                Collections.sort(products);

                List<String> ans = new ArrayList<>();

                if (products.size() <= 3) {
                    res.add(products);
                } else {
                    ans.add(products.get(0));
                    ans.add(products.get(1));
                    ans.add(products.get(2));

                    res.add(ans);
                }
            }
        }

        return res;
    }

    private TrieNode prefix(TrieNode root, String sub) {
        TrieNode temp = root;
        for (char c : sub.toCharArray()) {
            if (temp.getMap().get(c) == null) {
                return temp;
            }

            temp = temp.getMap().get(c);
        }

        return temp;
    }

    private void find(TrieNode root) {
        if (root.getMap() == null) return;

        if (root.isWord()) {
            products.add(root.getWord());
        }

        for (char key : root.getMap().keySet()) {
            find(root.getMap().get(key));
        }
        
    }
}