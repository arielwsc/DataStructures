package cs3345_project2;

public class IDedLinkedList <AnyType extends IDedObject> {
    
    private Node<AnyType> head, prev = null;
    private int size;
    
    public IDedLinkedList(){
        
        makeEmpty();
    }
    void makeEmpty(){
        
        head = new Node<>(null, null);
        size = 0;
    }
    
    AnyType findID(int ID){
        
        if (size == 0 || getNode(ID) == null)
            return null;
        else
            return getNode(ID).getDataType();
            
    }
    
    private Node<AnyType> getNode(int ID){
        
        Node<AnyType> node = head;
        
        while (node != null){
                if (node.getDataType().getID() == ID)
                    return node;
                prev = node;
                node = node.next;
        }
        return null;
    }
    
    private Node<AnyType> getNode(AnyType x){
        
        Node<AnyType> node = head;
        
        while (node != null){
            if (node.getDataType() == x)
                return node;
            prev = node;
            node = node.next;
        }
        return null;
    }
    
    boolean insertAtFront(AnyType x){
        if (getNode(x) == null){
            Node<AnyType> newNode = new Node<>(x, head);
            head = newNode;
            size += 1;
            return true;
        }
        else
            return false;
    }
    
    AnyType deleteFromFront(){
        
        if (size == 0)
            return null;
        else{
            Node<AnyType> temp = head;
            head = head.next;
            size -= 1;
            return temp.data;
        }
    }
    
    AnyType delete(int ID){
        Node<AnyType> temp = getNode(ID);
        if (temp != null){
            prev.next = temp.next;
            size -= 1;
            return head.data;
        }
        else
            return null;
    }
    
    int printTotal(){
        if (size == 0) return -1;
        else{
            Node<AnyType> temp = head;
            int sum = 0;
            while (temp != null){
                sum += temp.getDataType().getID();
                temp = temp.next;
            }
            return sum;
        }
    }
    
    private static class Node<AnyType>{
        
        public AnyType data;
        public Node<AnyType> next;
        
        public Node(AnyType d, Node<AnyType> n){
            
               data = d; next = n;
        }
        
        public AnyType getDataType(){
            return data;
        }
    }
    
}