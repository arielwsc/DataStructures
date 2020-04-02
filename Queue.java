package arielcarvalhoassignment3;

public class Queue {
    private Contact[] data;
    private int size;
    private int front;
    private int rear;
    
    public Queue(){
        size = 50;
        front = 0;
        rear = 0;
        data = new Contact[size];
    }
    
    public Queue(int n){
        size = n;
        front = 0;
        rear = 0;
        data = new Contact[n];
    }
    
    public boolean enque(Contact newContact){
        if (rear == size)
            return false; //Overflow error
        
        else{
            data[rear] = newContact.deepCopy();
            rear++;  //Increment the rear value for the next node
            return true; //Push operation sucessfull
        }
    }
    
    public Contact deque(){
        int frontLocation;
        if (rear == 0) //Underflow error
            return null;
        
        else{
            frontLocation = front;
            front++;
            return data[frontLocation];
        }
    }
    
    public void output(){
        for(int i=front; i<=rear-1; i++)
            data[i].output();
    }
    
    public void empty(){
        for(int i=front; i<=rear-1; i++) 
            data[i] = null;
    }
    
    public boolean isEmpty(){
        if (data[front] == null)
            return true;
        else
            return false;
    }
    
    public Contact peek(){
        return data[front];
    }
    
    public int find(String contactName){
        for(int i=front; i<=rear-1; i++){
            if (data[i] == null)
               break;
            if (data[i].compare(contactName))
                return i+1;
           }
        return -1;
    }
}