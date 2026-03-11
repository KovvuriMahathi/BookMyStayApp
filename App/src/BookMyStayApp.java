import java.util.HashMap;
import java.util.Map;

/*
 * Version: 4.0
 * Use Case: Room Search & Availability Check
 * Demonstrates read-only access to room inventory
 */

// Room Domain Model
class Room {

    private String type;
    private double price;
    private String amenities;

    public Room(String type, double price, String amenities) {
        this.type = type;
        this.price = price;
        this.amenities = amenities;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getAmenities() {
        return amenities;
    }

    public void displayDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Price: $" + price + " per night");
        System.out.println("Amenities: " + amenities);
    }
}


// Centralized Inventory Management
class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {

        inventory = new HashMap<>();

        // Initialize room availability
        inventory.put("Single", 10);
        inventory.put("Double", 5);
        inventory.put("Suite", 2);
    }

    // Read-only availability check
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public Map<String, Integer> getAllInventory() {
        return inventory;
    }
}


// Search Service (Read-only access)
class SearchService {

    private RoomInventory inventory;
    private HashMap<String, Room> roomCatalog;

    public SearchService(RoomInventory inventory) {

        this.inventory = inventory;
        roomCatalog = new HashMap<>();

        // Room details
        roomCatalog.put("Single", new Room("Single", 100, "WiFi, TV, Single Bed"));
        roomCatalog.put("Double", new Room("Double", 180, "WiFi, TV, Double Bed"));
        roomCatalog.put("Suite", new Room("Suite", 300, "WiFi, TV, King Bed, Living Area"));
    }

    public void searchAvailableRooms() {

        System.out.println("Available Rooms:\n");

        for (String roomType : roomCatalog.keySet()) {

            int available = inventory.getAvailability(roomType);

            // Defensive validation
            if (available > 0) {

                Room room = roomCatalog.get(roomType);

                room.displayDetails();
                System.out.println("Rooms Available: " + available);
                System.out.println("------------------------");
            }
        }
    }
}


// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        // Initialize Inventory
        RoomInventory inventory = new RoomInventory();

        // Initialize Search Service
        SearchService searchService = new SearchService(inventory);

        // Guest searches available rooms
        System.out.println("Guest searching for available rooms...\n");

        searchService.searchAvailableRooms();
    }
}