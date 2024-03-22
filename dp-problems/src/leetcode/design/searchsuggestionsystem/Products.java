package leetcode.design.searchsuggestionsystem;

class Products {
    public TrieNode createProducts(final String[] products) {
        final TrieNode root = new TrieNode();

        for (String product : products) {
            TrieNode temp = root;

            for (char c : product.toCharArray()) {
                temp.getMap().putIfAbsent(c, new TrieNode());
                temp = temp.getMap().get(c);
            }

            temp.setWord(true);
            temp.setWord(product);
        }

        return root;
    }
}