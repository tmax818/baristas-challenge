package co.tylermaxwell;

import java.util.ArrayList;

public class Order {

    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order() {
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }

    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public String getStatusMessage(){
        if(this.ready){
            return "Your order is ready.";
        } else {
        return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public double getOrderTotal(){
        double total = 0;
        for(Item item: this.items){
            total += item.getPrice();
        }
        System.out.println(total);
        return total;
    }

    public String display() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Customer Name: %s\n", this.name));
        for(Item item: this.items){
            stringBuilder.append(String.format("""
                    %s - $%.2f
                    """, item.getName(), item.getPrice()));
        }
        stringBuilder.append(String.format("Total: $%.2f", this.getOrderTotal()));

        return stringBuilder.toString();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
