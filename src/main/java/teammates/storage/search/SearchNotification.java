import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Notification {
	private String notificationId;
	private String title;
	private String message;
	
	// Constructors, getters, and setters
	public Notification(String notificationId, String title, String message) {
		this.notificationId = notificationId;
		this.title = title;
		this.message = message;
	}
	
	public String getNotificationId() {
		return notificationId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getMessage() {
		return message;
	}
	
	public boolean containsKeyword(String keyword) {
		return title.contains(keyword) || message.contains(keyword);
	}

	@Override
	public String toString() {
		return "Notification{" +
				"title='" + title + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}

public class SearchNotification {
	private static List<Notification> notifs = new ArrayList<>();
	
	static {
		// Populate the list with sample notifications
		notifs.add(new Notification("1", "Notification#1", "This is your message."));
		notifs.add(new Notification("2", "Notification#2", "This is your message."));
		notifs.add(new Notification("3", "Notification#3", "This is your message."));
		notifs.add(new Notification("4", "Notification#4", "This is your message."));
		notifs.add(new Notification("5", "Notification#5", "This is your message."));
	}
	
	public static void main(String[] args) {
		// Create a Scanner for user input
		Scanner input = new Scanner(System.in);
		
		// Prompt the user for a keyword to search
		System.out.print("Enter keyword to search: ");
		String searchKeyword = input.nextLine();
		
		// Search for the notification by keyword
		List<Notification> foundNotifications = searchNotificationsByKeyword(searchKeyword);
		
		// Display the search results
		if(!foundNotifications.isEmpty()) {
			System.out.print("\n");
			System.out.println("Notifications found:");
			for (Notification notification : foundNotifications) {
				System.out.println(notification);
			}
		} else {
			System.out.println("No notifications found.");
		}
	}
	
	// Search for a notification by keyword in the list
	private static List<Notification> searchNotificationsByKeyword(String keyword) {
		List<Notification> foundNotifications = new ArrayList<>();
		for (Notification notification : notifs) {
			if (notification.containsKeyword(keyword)) {
				foundNotifications.add(notification);
			}
		}
		return foundNotifications;
	}
}
