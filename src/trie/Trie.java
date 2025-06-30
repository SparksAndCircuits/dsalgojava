public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        System.out.println("The trie has been created.");
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }

            current = node;
        }
        current.endOfString = true;
        System.out.println("Value was successfully inserted: " + word + " in the trie.");
    }

    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = currentNode.children.get(ch);

            if (node == null) {
                System.out.println("Word: " + word + " does not exist in the trie.");
                return false;
            }

            currentNode = node;
        }

        if (currentNode.endOfString == true) {
            System.out.println("Word: " + word + " exists in trie");
            return true;
        } else {
            System.out.println("Word: " + word + "Does not exist in a trie. But it is a prefix of another string.");
        }

        return currentNode.endOfString;
    }

    private boolean delete(TrieNode parentNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canThisNodeBeDeleted = false;

        if(currentNode == null){
            return false;
        }

        if (currentNode.children.size() > 1) {
            delete(currentNode, word, index + 1);
            return false;
        }

        if (index == word.length() - 1) {
            if (currentNode.children.size() >= 1) {
                currentNode.endOfString = false;
                return false;
            }

            if (index == word.length() - 1) {
                if (currentNode.children.size() >= 1) {
                    currentNode.endOfString = false;
                    return false;
                } else {
                    parentNode.children.remove(ch);
                    return true;
                }
            }

            if (currentNode.endOfString == true) {
                delete(currentNode, word, index + 1);
                return false;
            }

            canThisNodeBeDeleted = delete(currentNode, word, index + 1);

            if (canThisNodeBeDeleted == true) {
                parentNode.children.remove(ch);
                return true;
            } else {
                return false;
            }
        }
        return canThisNodeBeDeleted;
    }

    public void delete(String word) {
        if (search(word) == true) {
            delete(root, word, 0);
        }
    }
}
