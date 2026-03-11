abstract class Room {

    // Encapsulated attributes
    private int beds;
    private int size;
    private double price;

    // Constructor
    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    // Getter methods
    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    // Abstract method
    public abstract String getRoomType();

    // Common method to display room details
    public void displayRoomDetails() {
        System.out.println("Room Type : " + getRoomType());
        System.out.println("Beds      : " + beds);
        System.out.println("Size (sqft): " + size);
        System.out.println("Price     : ₹" + price);
    }
}

// Single Room Class
class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 200, 3000);
    }

    @Override
    public String getRoomType() {
        return "Single Room";
    }
}

// Double Room Class
class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 350, 5000);
    }

    @Override
    public String getRoomType() {
        return "Double Room";
    }
}

// Suite Room Class
class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 600, 9000);
    }

    @Override
    public String getRoomType() {
        return "Suite Room";
    }
}

// Main Application Class
public class BookMyStayApp {

    public static void main(String[] args) {

        // Static availability variables
        int singleRoomAvailability = 10;
        int doubleRoomAvailability = 7;
        int suiteRoomAvailability = 3;

        // Room object creation (Polymorphism)
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        System.out.println("===== Welcome to Book My Stay =====\n");

        // Display Single Room
        singleRoom.displayRoomDetails();
        System.out.println("Available Rooms : " + singleRoomAvailability);
        System.out.println("----------------------------------");

        // Display Double Room
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms : " + doubleRoomAvailability);
        System.out.println("----------------------------------");

        // Display Suite Room
        suiteRoom.displayRoomDetails();
        System.out.println("Available Rooms : " + suiteRoomAvailability);
        System.out.println("----------------------------------");

        System.out.println("\nApplication Terminated.");
    }
}
