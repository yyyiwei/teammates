import java.util.*;

class Notification {
	private String notificationId;
	private String title;
	private String message;
	
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
	
	@Override
	public String toString() {
		return "ID: " + notificationId + "  |  Title: " + title + "  |  Message: " + message;
	}
	
	public boolean containsKeyword(String keyword) {
		return title.contains(keyword) || message.contains(keyword);
	}

}

public class SearchNotification {
	private static Scanner input = new Scanner(System.in);
	private static List<Notification> notifs = new ArrayList<>();
	
	public static void main(String[] args) {
		notifs.add(new Notification("1", "Notification#1", "This is your message."));
		notifs.add(new Notification("2", "Notification#2", "This is your message."));
		notifs.add(new Notification("3", "Notification#3", "This is your message."));
		notifs.add(new Notification("4", "Notification#4", "This is your message."));
		notifs.add(new Notification("5", "Notification#5", "This is your message."));
	
		System.out.print("Enter keyword to search: ");
		String searchKeyword = input.nextLine();
		
		List<Notification> foundNotifications = searchNotificationsByKeyword(searchKeyword);
		
		if(!foundNotifications.isEmpty()) {
			System.out.print("\n");
			System.out.println("Notifications found:");
			for(int i = 0; i < foundNotifications.size(); i++) {
				Notification notification = foundNotifications.get(i);
				System.out.println(notification);
			}
		} else {
			System.out.println("No notifications found.");
		}
	}
	
	private static List<Notification> searchNotificationsByKeyword(String keyword) {
		List<Notification> foundNotifications = new ArrayList<>();
		for (int i = 0; i < notifs.size(); i++) {
			Notification notification = notifs.get(i);
			if (notification.containsKeyword(keyword)) {
				foundNotifications.add(notification);
			}
		}
		return foundNotifications;
	}
}
