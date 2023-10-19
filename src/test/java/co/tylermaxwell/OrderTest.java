package co.tylermaxwell;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Order order;
    Item item;
    ArrayList<Item> items = new ArrayList<>();

    @BeforeEach
    void setUp() {
        order = new Order();
        items.addAll(Arrays.asList(
                new Item("mocha", 3.5),
                new Item("latte", 2.5),
                new Item("Cappuccino", 3.0)
                ));
        order.setItems(items);
    }

    @AfterEach
    void tearDown() {
        System.gc();
    }

    @Test
    void addItemTest() {
        order.addItem(items.get(0));
        assertEquals(order.getItems().get(0), items.get(0) );
    }

    @Test
    void addItemTestWithArrays() {
        assertEquals(order.getItems().get(2), items.get(2));
    }

    @Test
    void getStatusMessageTestTrue() {
        order.setReady(true);
        String trueMessage = "Your order is ready.";
        assertEquals(order.getStatusMessage(), trueMessage);
    }
    @Test
    void getStatusMessageTestFalse() {
        order.setReady(false);
        String trueMessage =  "Thank you for waiting. Your order will be ready soon.";
        assertEquals(order.getStatusMessage(), trueMessage);
    }

    @Test
    void getOrderTotal() {
        double total = order.getOrderTotal();
        assertEquals(total, 9.0);
    }

    @Test
    void display() {
        Order testOrder = new Order("Cindhuri");
        testOrder.addItem(new Item("drip coffee", 1.5));
        testOrder.addItem(new Item("cappuccino", 3.5));
        String testString = """
                Customer Name: Cindhuri
                drip coffee - $1.50
                cappuccino - $3.50
                Total: $5.00""";
        assertEquals(testOrder.display(), testString);
    }

}