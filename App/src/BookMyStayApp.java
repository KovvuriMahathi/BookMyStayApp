import java.util.HashMap;
import java.util.Map;
class RoomInventory {

    // Centralized inventory structure
    private HashMap<String, Integer> inventory;

    // Constructor - initializes room availability
    public RoomInventory() {
        inventory = new HashMap<>();

        // Register room types with initial availability
        inventory.put("Single", 10);
        inventory.put("Double", 5);
        inventory.put("Suite", 2);
    }

    // Retrieve availability for a specific room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability in a controlled way
    public void updateAvailability(String roomType, int newCount) {
        if (inventory.containsKey(roomType)) {
            inventory.put(roomType, newCount);
        } else {
            System.out.println("Room type not found: " + roomType);
        }
    }

    // Display current inventory state
    public void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " Rooms Available: " + entry.getValue());
        }
    }
}
/*
 * Version: 3.1
 * Use Case: Centralized Room Inventory Management
 * Demonstrates how HashMap maintains room availability
 */

public class BookMyStayApp {

    public static void main(String[] args) {

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        System.out.println("Initial Inventory:");
        inventory.displayInventory();

        // Retrieve availability
        System.out.println("\nChecking availability for Double room:");
        System.out.println("Double Rooms Available: " + inventory.getAvailability("Double"));

        // Update inventory
        System.out.println("\nUpdating availability after booking...");
        inventory.updateAvailability("Double", 4);

        // Display updated inventory
        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();
    }
}