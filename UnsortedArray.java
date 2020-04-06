
package arielcarvalhoassignment2;

/**
 *
 * @author ariel
 */
public class UnsortedArray {
    private Contact[] data;
    private int size;
    private int next;
    
    public UnsortedArray(int size, int next){
        this.data = new Contact[size];
        this.size = size;
        this.next = next;
    }
    
    public boolean insert(Contact newContact){
        if(next >= size)
            return false;
        
        data[next] = newContact.deepCopy();
        
        if(data[next] == null)
            return false;
        
        next++;
        return true;
    }
    
    public void delete(String contactName){
        int i = 0;
        
        while(!data[i].compare(contactName)){
            i++;
        }
        
        for(int j=i; j <= size-1; j++){
            //data[j] = data[j + 1];
        //}
        next = size - 1;
        data[next] = null;
        }
    }
    
    public Contact fetch(String contactName){
        int i = 0;
        
        while(!data[i].compare(contactName)){
            i++;
        }
        
        return data[i].deepCopy();
    }
   
    public void update(String contactName, String newName, String newAddress,
    int newPhone, String newEmail){
        int i = 0;
        
        while(!data[i].compare(contactName)){
            i++;
        }
        
        data[i].update(newName, newAddress, newPhone, newEmail);
    }
    
    public void output(){
        for (int i=0; i<=size-1; i++)
            data[i].output();
    }
}
