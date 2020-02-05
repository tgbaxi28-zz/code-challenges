/**
 * Print the nodes in a binary tree level-wise. For example,
 * 10
 * / \
 * 8 2
 * / \ /
 * 3 5 2
 *
 * <p>Output for this would be: 10 -> 8 -> 3, 10 -> 8 -> 5, 10 -> 2 -> 2
 */

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinaryTreeTraverse {
  public static void main(String[] args) {
    findPaths(buildBinaryTree());
  }

  private static void findPaths(BinaryTree binaryTree) {
    Node rootNode = binaryTree.getRoot();
    int[] paths = new int[1000];
    nodeTraverse(rootNode, paths, 0);
  }

  private static void nodeTraverse(Node node, int[] paths, int pathLength) {
    // if node is null then return as is.
    if (node == null) {
      return;
    }

    // we are making an array of paths
    paths[pathLength] = node.getValue();
    // this is required as we are adding values to array at specific index.
    pathLength++;

    // the leaf node is found now. so just print the path
    if (node.getLeft() == null && node.getRight() == null) {
      System.out.println(
          IntStream.of(paths)
              .limit(pathLength)
              .mapToObj(Integer::toString)
              .collect(Collectors.joining(" -> ")));
    } else {
      nodeTraverse(node.getLeft(), paths, pathLength);
      nodeTraverse(node.getRight(), paths, pathLength);
    }
  }

  private static BinaryTree buildBinaryTree() {
    BinaryTree binaryTree = new BinaryTree();
    binaryTree.setRoot(new Node(10));
    binaryTree.getRoot().setLeft(new Node(8));
    binaryTree.getRoot().setRight(new Node(2));
    binaryTree.getRoot().getLeft().setLeft(new Node(3));
    binaryTree.getRoot().getLeft().setRight(new Node(5));
    binaryTree.getRoot().getRight().setLeft(new Node(2));
    return binaryTree;
  }
}

class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class BinaryTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
