import java.util.LinkedList;
import java.util.Queue;

/*
 * Version: 5.0
 * Use Case: Booking Request (First-Come-First-Served)
 * Demonstrates how a Queue preserves booking request order
 */

// Reservation class representing a booking request
class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayReservation() {
        System.out.println("Guest: " + guestName + " | Requested Room: " + roomType);
    }
}


// Booking Request Queue Manager
class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        requestQueue.add(reservation);
        System.out.println("Booking request added for " + reservation.getGuestName());
    }

    // Display all queued requests
    public void displayQueue() {

        if (requestQueue.isEmpty()) {
            System.out.println("No booking requests in queue.");
            return;
        }

        System.out.println("\nCurrent Booking Request Queue:");

        for (Reservation reservation : requestQueue) {
            reservation.displayReservation();
        }
    }

    // Peek next request without removing
    public void peekNextRequest() {
        Reservation next = requestQueue.peek();

        if (next != null) {
            System.out.println("\nNext request to process:");
            next.displayReservation();
        } else {
            System.out.println("Queue is empty.");
        }
    }
}


// Main Program
public class BookMyStayApp {

    public static void main(String[] args) {

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Guests submit booking requests
        Reservation r1 = new Reservation("Alice", "Single");
        Reservation r2 = new Reservation("Bob", "Double");
        Reservation r3 = new Reservation("Charlie", "Suite");

        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Display queue
        bookingQueue.displayQueue();

        // Show next request (FIFO)
        bookingQueue.peekNextRequest();
    }
}