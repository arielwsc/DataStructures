package cs3345_project3;

public class LazyBinarySearchTree {
    
    private int size = 0;
    private TreeNode root;
    
    /**
     * 
     * @param key
     * @return boolean
     * @throws IllegalArgumentException 
     * 
     * Insert a new node into the tree and return true: node was inserted
     * successfuly or false: node failed to be inserted
     * 
     */
    
        public boolean insert(int key) throws IllegalArgumentException {
        if (key < 1 || key > 99){
            throw new IllegalArgumentException("Number has to be in the range"
                    + "[1, 99]");
        }
        
        if (!contains(key)){
            if (root == null){
                root = new TreeNode(key, null, null);
                size++;
                return true;
            }
            
            else{
                TreeNode node = root;
                TreeNode tempNode = null;
                
                while (node != null){
                    tempNode = node;
                    if (key < node.key)
                        node = node.leftChild;
                    else
                        node = node.rightChild;
                }
                
                if (key < tempNode.key){
                    tempNode.leftChild = new TreeNode(key, null, null);
                    size++;
                    return true;
                }
                else{
                    tempNode.rightChild = new TreeNode(key, null, null);
                    size++;
                    return true;
                }
            }
        }
        else
            return false;
    }
        
        /**
         * 
         * @param node
         * @param key
         * @return TreeNode
         * 
         * Return node when root node and key are passed as arguments
         */
    
    public TreeNode getNode(TreeNode node, int key){
        if (size == 0 || node == null)
            return null;
        
        else if (node.key == key)
            return node;
        
        else if (node.key > key)
            return getNode(node.leftChild, key);
        
        else
            return getNode(node.rightChild, key);
    }
    
    /**
     * Delete a node from the tree and return true if node was deleted or
     * false if node was not deleted
     * @param key
     * @return boolean
     * @throws IllegalArgumentException 
     */
    
    public boolean delete(int key) throws IllegalArgumentException{
        
        if (key < 1 || key > 99){
            throw new IllegalArgumentException("Number has to be in the range"
                    + "[1, 99]");
        }
        
        if (contains(key)){
            getNode(root, key).deleted = true;
            size--;
            return true;
        }
        
        else{
            return false;
        }
    }
    
    /**
     * Return -1 if min value was not found or return the min key
     * @return int
     */
    
    public int findMin(){
        
        TreeNode node = root;
        int minValue = node.key;
        
        if (size == 0)
            return -1;
        
        while(node != null){
            if (!node.deleted)
                minValue = node.key;
            node = node.leftChild;
        }
        
        return minValue;    
    }
    
    /**
     * Return -1 if max value was not found or return the max key
     * @return int
     */
    
    public int findMax(){
        
        TreeNode node = root;      
        int maxValue = node.key;
        
        if (size == 0)
            return -1;
        
        while(node != null){
            if (!node.deleted)
                maxValue = node.key;
            node = node.rightChild;
        }
        
        return maxValue;    
    }
    
    /**
     * Return the height of the tree
     * @return int
     */
    
    public int height(){
        
        int lHeight = 0, rHeight = 0;
        TreeNode node = root;
        
        if (size == 0)
            return 0;
        
        while (node != null){
            node = node.leftChild;
            lHeight++;
        }
        node = root;
        while (node != null){
            node = node.rightChild;
            rHeight++;
        }
        
        if (lHeight <= rHeight)
            return rHeight;
        else
            return lHeight;
    }
    
    /**
     * Search for key passed as argument and return true if node is found
     * in the tree or false if node was not found
     * @param key
     * @return boolean
     * @throws IllegalArgumentException 
     */
    
    public boolean contains(int key) throws IllegalArgumentException{
        
        if (key < 1 || key > 99){
            throw new IllegalArgumentException("Number has to be in the range"
                    + "[1, 99]");
        }
        
        if (getNode(root, key) != null)
            return true;
        else
            return false;
        
    }
    
    /**
     * Return size of the tree
     * @return int
     */
    
    public int size(){
        return size;
    }
    
    /**
     * Return toString of the nodes in the tree including deleted ones
     * @return String
     */
    
    public String toString(){
        String tree = "";
        TreeNode node = root;
        
        while (node != null){
            if (node.deleted)
                tree += "*" + node.key + " ";
            else
                tree += node.key + " ";
            node = node.leftChild;
        }
        
        node = root.rightChild;
        
        while (node != null){
            if (node.deleted)
                tree += "*" + node.key + " ";
            else
                tree += node.key + " ";
            node = node.rightChild;
        }
        
        return tree;   
    }
    
    /**
     * Class TreeNode to hold node and its attributes
     */
    
    private static class TreeNode{
        int key;
        TreeNode leftChild;
        TreeNode rightChild;
        //TreeNode parent;
        boolean deleted;
        
        public TreeNode(int key, TreeNode lChild, TreeNode rChild){
            this.key = key;
            leftChild = lChild;
            rightChild = rChild;
            deleted = false;
            
        }
        
    }
}
