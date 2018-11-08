import java.util.*;

class Email implements Comparable<Email> {
	public String s;
	Email(String s) {
		this.s = s;
	}
	// define compareTO function to compare the provider part.
	public int compareTo(Email e) {
		// use .split to split the email address to get the provider part.
		// split by "a", the [0] part is name, the [1] part is provider.
		return s.split("@")[1].compareTo(e.s.split("@")[1]);
	}
}

public class SortEmails
{
	public static void main(String[] args)
	{
		System.out.println("Problem 1: Sort the email address by name in reverse order.");
		// Problem 1: sort reversely
		String[] emails = {"Fred@cmu.edu","Bob@yahoo.com",
                "Tom@gmail.com","Mark@ucla.edu","John@usc.edu","Steve@microsoft.com"};
		// use collections.reverseordr to sort in reverse order
		Arrays.sort(emails, Collections.reverseOrder());
		// foreach loop to print all the elements
		for(String s:emails) {
			System.out.println(s);
		}
		System.out.println();
		
		System.out.println("Problem 2: Sort the email address by provider.");
		// Problem 2: sort by provider
		Email[] emails2 = new Email[emails.length];
		// use for loop to change the virable type
		for(int i = 0; i < emails.length; i++) {
			emails2[i] = new Email(emails[i]);
		}
		Arrays.sort(emails2);
		for(Email s:emails2) {
			System.out.println(s.s);
		}
	}
}