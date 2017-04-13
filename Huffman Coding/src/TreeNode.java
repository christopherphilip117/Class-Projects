

/**
 * Utility binary-tree (Huffman tree) node for Huffman coding.
 * This is a simple, standard binary-tree node implementing
 * the comparable interface based on frequency.
 * 
 * @author Owen Astrachan, minor changes Mike Scott, version 3.0
 * @version 1.0 July 2000
 * @version 2.0 Jan 2006
 * @version 3.0 Nov 2011
 *
 */
public class TreeNode implements Comparable<TreeNode> {


    /*
     * The value stored in this node. A number read from a file. 
     * No matter the file type we read in bits and treat the data as an int.
     */
    private int value;

    /*
     * The frequency of the value for leaf nodes or the sum of the 
     * frequency of the children for internal nodes.
     */
    private int frequency;

    // The left child of this node. Equals null if no left child.
    private TreeNode left;


    // The right child of this node. Equals null if no left child.
    private TreeNode right;

    /**
     * construct leaf node (null children)
     * 
     * @param value is the value stored in the node (e.g., dat from original file)
     * @param freq is number of times value occurred (e.g., count of # occurrences)
     */
    public TreeNode(int value, int freq) {
        this.value = value;
        frequency = freq;
    }

    /**
     * construct internal node (with children).<br>
     * pre: ltree != null, rtree != null
     * The new node's frequency is the sume of the frequencies of ltree and rtree.
     * 
     * @param value the stored as value of node
     * @param ltree is left subtree
     * @param rtree is right subtree
     */

    public TreeNode(int value, TreeNode ltree, TreeNode rtree) {
        if(ltree == null || rtree == null)
            throw new IllegalArgumentException("child node references cannot be null");
        this.value = value;
        left = ltree;
        right = rtree;
        frequency = left.frequency + right.frequency;
    }

    /**
     * Return value  based on comparing this TreeNode to another.
     * @return -1 if this < rhs, +1 if this > rhs, and 0 if this == rhs
     */

    public int compareTo(TreeNode rhs) {

        return frequency - rhs.frequency;
    }

    /**
     * Return a String version of this node.
     * @return A String version of this node including the frequency (weight) and value.
     */
    public String toString() {
        // consider values as characters for readability
        return "(" + frequency + ", " + (char) value + "as char, " + value + " value as int)";
    }

    /**
     * Get the value stored in this node.
     * @return the value stored in this node
     */
    public int getValue() {
        return value;
    }

    /**
     * Get the frequency of this node.
     * @return the frequency of this node. For internal nods the value should be the sum of the child nodes
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Get the left child of this node.
     * @return The left child of this node. If no left child, returns null.
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * Get the right child of this node.
     * @return The right child of this node. If no right child, returns null.
     */
    public TreeNode getRight() {
        return right;
    }


    /**
     * Is this node a leaf or not.
     * @return true if this node is a leaf, false if it is an internal node
     */
    public boolean isLeaf() {
        return left == null && right == null;
    }

}
