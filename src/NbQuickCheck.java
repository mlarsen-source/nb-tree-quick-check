import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NbQuickCheck {

  /**
   * Performs a pre-order traversal of the tree, printing each node on a separate line.
   * Does nothing if the root is not present in the tree.
   *
   * @param tree the tree represented as a map of parent nodes to child lists
   * @param root the root node to start traversal from
   */
  public static void preOrder(Map<Integer, List<Integer>> tree, int root) {
    if(!tree.containsKey(root)) {
      return;
    }
    System.out.println(root);
    List<Integer> children = tree.get(root);
    if(children != null) {
      for(Integer child: children) {
        preOrder(tree, child);
      }
    }
  }

  /**
   * Returns the minimum value in the tree.
   * Returns Integer.MAX_VALUE if the root is null.
   *
   * @param root the root node of the tree
   * @return the minimum value in the tree or Integer.MAX_VALUE if root is null
   */
  public static int minVal(Node<Integer> root) {
    if (root == null) return Integer.MAX_VALUE;
    int min = root.value;
    if (root.children != null) {
      for (Node<Integer> child : root.children) {
        min = Math.min(min, minVal(child));
      }
    }
    return min;
  }
}
