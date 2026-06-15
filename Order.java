package bst_lab;

public class Order{

    int orderNum;
    String itemName;
    int quantity;
    double price;

    public Order(int orderNum,String itemName,int quantity,double price){

        this.orderNum=orderNum;
        this.itemName=itemName;
        this.quantity=quantity;
        this.price=price;
    }

    public int getOrderNum(){ return orderNum; }

    public void setOrderNum(int orderNum){ this.orderNum=orderNum; }

    public String getItemName(){ return itemName; }

    public void setItemName(String itemName){ this.itemName=itemName; }

    public int getQuantity(){ return quantity; }

    public void setQuantity(int quantity){ this.quantity=quantity; }

    public double getPrice(){ return price; }

    public void setPrice(double price){ this.price=price; }

    public String toString(){
        return "Order Number: "+orderNum+
        ", Item Name: "+itemName+
        ", Quantity: "+quantity+
        ", Price: "+price;
    }
}
