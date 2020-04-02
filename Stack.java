package arielcarvalhoassignment3;

public class Stack {
    private Contact[] data;
    private int top;
    private int size;
    
    public Stack(){
        top = -1;
        size = 50;
        data = new Contact[size];
    }
    
    public Stack(int n){
        top = -1;
        size = n;
        data = new Contact[n];
    }
    
    public boolean push(Contact newContact){
        if (top == size - 1)
            return false; //Overflow error
        else{
            top++;
            data[top] = newContact.deepCopy();
            return true; //Push operation successful
        }
    }
    
    public Contact pop(){
        int topLocation;
        if (top == -1)
            return null; //Underflow error
        else{
            topLocation = top;
            top--;
            return data[topLocation];
        }
    }
    
    public void output(){
        for(int i=0; i<= top; i++)
            data[i].output();
    }
    
    public void empty(){
        for(int i=0; i<=top; i++) 
            data[i] = null;
    }
    
    public boolean isEmpty(){
        if (data[0] == null)
            return true;
        else
            return false;
    }
    
    public Contact peek(){
        return data[top];
    }
    
    public int find(String contactName){
        for(int i=0; i<=top; i++){
            if (data[i] == null)
               break;
            if (data[i].compare(contactName))
                return i+1;
        }
        return -1;
    }
}