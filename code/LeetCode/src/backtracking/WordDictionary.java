package backtracking;

// https://leetcode.com/problems/add-and-search-word-data-structure-design/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
public class WordDictionary {

  private class TrieNode {
    private boolean isWord;
    private Map<Character, TrieNode> childMap;

    public TrieNode() {
      isWord = false;
      childMap = new HashMap<Character, TrieNode>();
    }

  }

  private TrieNode root;

  /** Initialize your data structure here. */
  public WordDictionary() {
    root = new TrieNode();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    TrieNode curr = root;
    for (char c: word.toCharArray()) {
      if (!curr.childMap.containsKey(c)) {
        curr.childMap.put(c, new TrieNode());
      }
      curr = curr.childMap.get(c);
    }

    curr.isWord = true;
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  public boolean search(String word) {
    return dfs(word,0, root);
  }

  public boolean dfs(String word, int pos, TrieNode node) {
    // if the word has all been scanned, return
    if (pos == word.length()) {
      return node.isWord;
    }
    // reach the leaf before finishing scanning the word
    if (node.childMap.size() == 0) {
      return false;
    }

    Character c = word.charAt(pos);
    // if the character at current position is '.',
    // recursive check whether the remaining word is in the trie
    if (c == '.') {
      for (char item: node.childMap.keySet()) {
        if (dfs(word, pos + 1, node.childMap.get(item))) {
          return true;
        }
      }
    }

    // if character at position 'pos' is neither equal to the node nor '.', return false
    if (!node.childMap.containsKey(c)) {
      return false;
    }

    // if character at current position matches the node,
    // recursively search the remaining word
    return dfs(word, pos + 1, node.childMap.get(c));
  }

  public static void main(String[] args) {
    WordDictionary obj = new WordDictionary();
    obj.addWord("bad");
    obj.addWord("dad");
    obj.addWord("mad");
    obj.addWord("a");
    System.out.println(obj.search("pad"));
    System.out.println(obj.search("bad"));
    System.out.println(obj.search(".ad"));
    System.out.println(obj.search("b.."));
    //obj.search("pad") -> false
    //obj.search("bad") -> true
    //obj.search(".ad") -> true
    //obj.search("b..") -> true
  }
}
