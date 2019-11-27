import java.util.Arrays;

public class Email {

	public static boolean verify_email_address(String email) {
		String arr[] = email.split("@");
		String domain[] = {"hotmail.com", "gmail.com", "live.com", "yahoo.com"};
		if (arr.length == 2) {
			if (arr[0].matches("^[a-zA-Z0-9.-]*$")) {
				if (Arrays.asList(domain).contains(arr[1])) {
					System.out.println("Correct!");
					return true;
				}
			}
		}
		System.out.println("Invalid");
		return false;
	}
	
	public static void main(String args[]) {
		String email = "hey.-8@@hotmail.com";
		verify_email_address(email);
	}
	
}
