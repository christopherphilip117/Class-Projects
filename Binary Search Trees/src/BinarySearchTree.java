/*  Student information for assignment:
 *
/*  Student information for assignment:
 * 
 * replace <NAME> with your name.
 *
 *  On my honor, <Christopher Philip>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Christopher Philip
 *  email address: christopher.philip117@gmail.com
 *  UTEID: cp26645
 *  Section 5 digit ID: 88620
 *  Grader name: Kris Vandercook
 *  Number of slip days used on this assignment: 2
 *  
 *   NOTE:
 *   
 *   I am so very sorry this is late, I beg for mercy in this assignment, I used slip days because my internet was not
 *   cooperating and I was having trouble and I simply could not turn it in on time, I have 3 slips
 *   days left if you could be so kind as to please forgive this 2 hour delay!!
 */

import java.util.ArrayList;
import java.util.List;
/**
 * Shell for a bianry search tree class.
 * @author scottm
 *
 */

public class BinarySearchTree<E extends Comparable<E>> {
	 
	    private int size;
	    private BSTNode<E> root;
	    
	    public BinarySearchTree(){
	    	size = 0;
	    	root = null;
	    }
    /**
     *  Add the specified item to this Binary Search Tree if it is not already present.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: Add value to this tree if not already present. Return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param value the value to add to the tree
     *  @return false if an item equivalent to value is already present
     *  in the tree, return true if value is added to the tree and size() = old size() + 1
     */
    public boolean add(E value) {
        int oldSize = size();
        root = addHelper(value, root);
        return oldSize != size();
    }
    
    private BSTNode<E> addHelper(E val, BSTNode<E> n){
    	if(n == null){
    		size++;
    		return new BSTNode<E>(val);
    	}
    	else{
    		int direction = val.compareTo(n.getData());
    		if(direction < 0)
    			n.setLeft(addHelper(val, n.getLeft()));
    		else if(direction > 0)
    			n.setRight(addHelper(val, n.getRight()));
    	}
    	return n;
    }

    /**
     *  Remove a specified item from this Binary Search Tree if it is present.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: Remove value from the tree if present, return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param value the value to remove from the tree if present
     *  @return false if value was not present
     *  returns true if value was present and size() = old size() - 1
     */
    public boolean remove(E value) {
        int oldSize = size();
        root = removeHelp(value, root);
        return oldSize != size();
    }
    
    private BSTNode<E> removeHelp(E val, BSTNode<E> n){
    	if(n != null){
    		int direction = val.compareTo(n.getData());
    		if(direction < 0)
    			n.setLeft(removeHelp(val, n.getLeft()));
    		else if (direction > 0)
    			n.setRight(removeHelp(val, n.getRight()));
    		else{
    			if(n.getLeft() == null && n.getRight() == null)
    				n = null;
    			else if(n.getRight() == null)
    				n = n.getLeft();
    			else if(n.getLeft() == null)
    				n = n.getRight();
    			else{
    				E minOfRight = getMin(n.getRight());
    				n.setData(minOfRight);
    				n.setRight(removeHelp(minOfRight, n.getRight()));
    				size++;
    			}
    			size--;
    		}
    	}
    	return n;
    }
    
    private E getMin(BSTNode<E> n){
    	while(n.getLeft() != null)
    		n = n.getLeft();
    	return n.getData();
    }


    /**
     *  Check to see if the specified element is in this Binary Search Tree.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: return true if value is present in tree, false otherwise
     *  @param value the value to look for in the tree
     *  @returns true if value is present in this tree, false otherwise
     */
    public boolean isPresent(E value) {
        return presentHelp(value, root);
    }

    private boolean presentHelp(E value, BSTNode<E> root){
    	boolean result = false;
    	
    	if(root == null)
    		return result;
    	
    	else{
    		int direction = value.compareTo(root.getData());
    		if(direction > 0)
    			result = presentHelp(value, root.getRight());
    		else if(direction < 0)
    			result = presentHelp(value, root.getLeft());
    		else if(direction == 0)
    			result = true;
    	}
    	return result;
    }

    /**
     *  Return how many elements are in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the number of items in this tree
     *  @returns the number of items in this Binary Search Tree
     */
    public int size() {
        return size;
    }

    /**
     *  return the height of this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the height of this tree.
     *  If the tree is empty return -1, otherwise return the
     *  height of the tree
     *  @returns the height of this tree or -1 if the tree is empty
     */
    public int height() {
        return heightHelp(root);
    }
    
    private int heightHelp(BSTNode<E> root){
    	if(root == null)
    		return -1;
    	
    		int htLeft = heightHelp(root.getLeft());
    		int htRight = heightHelp(root.getRight());
    		
    		return 1 + Math.max(htLeft, htRight);
    	}
    

    /**
     *  Return a list of all the elements in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return a List object with all data from the tree in ascending order. 
     *  If the tree is empty return an empty List
     *  @returns a List object with all data from the tree in sorted order
     *  if the tree is empty return an empty List
     */
    public List<E> getAll() {
        List<E> result = new ArrayList<E>();
        getAllHelp(root, result);
        return result;
    }
    
    private List<E> getAllHelp(BSTNode<E> root, List<E> result){
    	if(root != null){
    		getAllHelp(root.getLeft(), result);
        	
        	result.add(root.getData());
        	
        	getAllHelp(root.getRight(), result);
    	}
    	return result;
    }



    /**
     * return the maximum value in this binary search tree.
     * <br>
     * pre: <tt>size()</tt> > 0<br>
     * post: return the largest value in this Binary Search Tree
     * @return the maximum value in this tree
     */
    public E max() {
        while(root.getRight() != null)
        	root = root.getRight();
        
        return root.getData();
    }

    /**
     * return the minimum value in this binary search tree.
     * <br>
     * pre: <tt>size()</tt> > 0<br>
     * post: return the smallest value in this Binary Search Tree
     * @return the minimum value in this tree
     */
    public E min() {
        while(root.getLeft() != null)
        	root = root.getLeft();
        
        return root.getData();
    }

    /**
     * An add method that implements the add algorithm iteratively instead of recursively.
     * <br>pre: data != null
     * <br>post: if data is not present add it to the tree, otherwise do nothing.
     * @param data the item to be added to this tree
     * @return true if data was not present before this call to add, false otherwise.
     */
    public boolean iterativeAdd(E data) {
        BSTNode<E> node = root;
        while(node != null){
        	if(node.getData().compareTo(data) > 0){
        		if(node.getLeft() == null){
        			node.setLeft(new BSTNode<E>(data));
        			size++;
        			return true;
        		}
        		else
            		node = node.getLeft();
        	}
        	else if(node.getData().compareTo(data) < 0){
        		if(node.getRight() == null){
        			node.setRight(new BSTNode<E>(data));
        			size++;
        			return true;
        		}
        		else
        			node = node.getRight();
        	}
        	else
        		return false;
        	
        }
        //if this reaches here, tree was empty from the start
        root = new BSTNode<E>(data);
        size++;
        return true;
    }


    /**
     * Return the "kth" element in this Binary Search Tree. If kth = 0 the 
     * smalles value (minimum) is returned. If kth = 1 the second smallest value is
     * returned, and so forth.
     * <br>pre: 0 <= kth < size()
     * @param kth indicates the rank of the element to get
     * @return the kth value in this Bianry Search Tree
     */
    public E get(int kth) {
        if(!(0 <= kth || kth < size()))
        	throw new IllegalArgumentException("kth is an invalid int");
        
        int[] count = {0};
        return getHelp(root, count, kth);
        
    }
    
    private E getHelp(BSTNode<E> root, int[] count, int kth){
    	E val = null;
    	if(root != null){
    		val = getHelp(root.getLeft(), count, kth);
    		if(val == null){
    			if(count[0] == kth)
    				return root.getData();
    			else{
    				count[0]++;
    				val = getHelp(root.getRight(), count, kth);
    			}
    		}
    	}
    	return val;
    }


    /**
     * Return a List with all values in this Binary Search Tree that are less than
     * the parameter <tt>value</tt>.
     * <tt>value</tt> != null<br>
     * @param value the cutoff value
     * @return a List with all values in this tree that are less than the parameter value. If there are
     * no values in this tree less than value return an empty list. The elements of the list are in ascending order.
     */
    public List<E> getAllLessThan(E value) {
    	List<E> result = new ArrayList<E> ();
    	return lessThanHelp(value, result, root);
    }
    
    private List<E> lessThanHelp(E value, List<E> result, BSTNode<E> root){
    	if(root != null){
    		
    		lessThanHelp(value, result, root.getLeft());
    		
    		if (root.getData().compareTo(value) < 0)
        		result.add(root.getData());
    		
    		lessThanHelp(value, result, root.getRight());
       
    	}
    	return result;
    }


    /**
     * Return a List with all values in this Binary Search Tree that are greater than
     * the parameter <tt>value</tt>.
     * <tt>value</tt> != null<br>
     * @param value the cutoff value
     * @return a List with all values in this tree that are greater than the parameter value. If there are
     * no values in this tree greater than value return an empty list. The elements of the list are in ascending order.
     */
    public List<E> getAllGreaterThan(E value) {
    	List<E> result = new ArrayList<E> ();
    	return greaterThanHelp(value, result, root);
    }
    
    private List<E> greaterThanHelp(E value, List<E> result, BSTNode<E> root){
    	if(root != null){
    		
    		if(root.getData().compareTo(value) > 0){
    			
    			greaterThanHelp(value, result, root.getLeft());
    			result.add(root.getData());
    		}
    		greaterThanHelp(value, result, root.getRight());
    		
    	}
    	
    	return result;
    }



    /**
     * Find the number of nodes in this tree at the specified depth.
     * <br>pre: none
     * @param d The target depth.
     * @return The number of nodes in this tree at a depth equal to
     * the parameter d.
     */
    public int numNodesAtDepth(int d) {
    	int count = 0;
        return depthHelp(d, count, root);
    }
    
    private int depthHelp(int d, int count, BSTNode<E> root){
    	if(root != null){
    		if(d == 0) 
    			count++;
    		else{
    			count += depthHelp(d--, count, root.getLeft());
    			count += depthHelp(d--, count, root.getRight());
    		}
    			
    	}
    	return count;
    }

    /**
     * Prints a vertical representation of this tree.
     * The tree has been rotated counter clockwise 90
     * degrees. The root is on the left. Each node is printed
     * out on its own row. A node's children wil not necessarily
     * be at the rows directly above and below a row. They will
     * be indented three spaces from the parent. Nodes indented the
     * same amount are at the same depth.
     * pre: none
     */
    public void printTree() {
        printTree(root, "");
    }

    private void printTree(BSTNode<E> n, String spaces) {
        if(n != null){
            printTree(n.getRight(), spaces + "  ");
            System.out.println(spaces + n.getData());
            printTree(n.getLeft(), spaces + "  ");
        }
    }

    private static class BSTNode<E extends Comparable<E>> {
        private E data;
        private BSTNode<E> left;
        private BSTNode<E> right;

        public BSTNode() {
            this(null);
        }

        public BSTNode(E initValue) {
            this(null, initValue, null); 
        }

        public BSTNode(BSTNode<E> initLeft,
                E initValue,        
                BSTNode<E> initRight) {
            data = initValue; 
            left = initLeft; 
            right = initRight; 
        }

        public E getData() { 
            return data; 
        }

        public BSTNode<E> getLeft() { 
            return left;
        }

        public BSTNode<E> getRight() { 
            return right; 
        }

        public void setData(E theNewValue) { 
            data = theNewValue; 
        }

        public void setLeft(BSTNode<E> theNewLeft) { 
            left = theNewLeft; 
        }

        public void setRight(BSTNode<E> theNewRight) { 
            right = theNewRight; 
        }    
    }
}
