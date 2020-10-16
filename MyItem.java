package cs3345_project2;

import java.util.List;

public class MyItem implements IDedObject {
    private int itemID;
    private int itemPrice;
    private List<Integer> itemDescription;
    
    public MyItem(int itemID, int itemPrice, List<Integer> name){
        this.itemID = itemID;
        this.itemPrice = itemPrice;
        itemDescription = name;
    }
    
    public int getID(){
        return itemID;
    }
    public String printID(){
        String itemInfo;
        itemInfo = getID() + " " + itemPrice + " " + itemDescription.toString();
        return itemInfo;
    }
    public String toString(MyItem x){
        return x.toString();
    }
}
