// Phu Thanh Nguyen

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

class BinarySearchTree {

    Node root;

    /*
     recursive insert method
     */
    /*
     inserts a node into the tree
     */
    public void insert(int value) {
        //tree is empty
        if (root == null) {
            root = new Node(value);
            return;
        } else {
            Node current = root;
            Node parent = null;

            while (true) {
                parent = current;

                if (value < current.value) {
                    current = current.left;
                    if (current == null) {
                        parent.left = new Node(value);
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = new Node(value);
                        return;
                    }
                }

            }//closing while

        }//closing main if-else 
    }

    /**
     * Performs a pre-order traversal of the tree.
     * Visits current node, then left, then right.
     * 
     * @param root The current node
     */
    public void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    /**
     * Performs an in-order traversal of the tree.
     * Visits left subtree, node, then right.
     * 
     * @param root The current node
     */
    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.value + " ");
            inOrderTraversal(root.right);
        }
    }

    /**
     * Performs a post-order traversal of the tree.
     * Visits left, right, then node.
     * 
     * @param root The current node
     */
    public void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value + " ");
        }
    }

    /**
     * Searches for a key in the tree.
     * 
     * @param root The current node
     * @param key The value to find
     * @return true if found, false otherwise
     */
    public boolean find(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (key == root.value) {
            return true;
        } else if (key < root.value) {
            return find(root.left, key);
        } else {
            return find(root.right, key);
        }
    }

    /**
     * Finds the minimum value in the tree.
     * 
     * @param root The current node
     * @return The minimum value
     */
    public int getMin(Node root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.value;
    }

    /**
     * Finds the maximum value in the tree.
     * 
     * @param root The current node
     * @return The maximum value
     */
    public int getMax(Node root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.value;
    }

    /*
     this method will not compile until getMax is implemented
     */
    public Node delete(Node root, int key) {

        if (root == null) {
            return root;
        } else if (key < root.value) {
            root.left = delete(root.left, key);
        } else if (key > root.value) {
            root.right = delete(root.right, key);
        } else {
            //node has been found
            if (root.left == null && root.right == null) {
                //case #1: leaf node
                root = null;
            } else if (root.right == null) {
                //case #2 : only left child
                root = root.left;
            } else if (root.left == null) {
                //case #2 : only right child
                root = root.right;
            } else {
                //case #3 : 2 children
                root.value = getMax(root.left);
                root.left = delete(root.left, root.value);
            }
        }
        return root;
    }
}

public class TreeDemo {
    public static void main(String[] args) {
        BinarySearchTree t1 = new BinarySearchTree();
        t1.insert(24);
        t1.insert(80);
        t1.insert(18);
        t1.insert(9);
        t1.insert(90);
        t1.insert(22);

        System.out.print("in-order :   ");
        t1.inOrderTraversal(t1.root);
        System.out.println();
    }
}
