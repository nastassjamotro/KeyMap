import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class KeyMap {
	public static String mappings[][] = {
		{"0"}, {"1"}, {"A", "B", "C"}, {"D", "E", "F"}, 
		{"G", "H", "I"}, {"J", "K", "L"}, {"M", "N", "O"}, 
		{"P", "Q", "R", "S"}, {"T", "U", "V"}, {"W", "X", "Y", "Z"}
	};

	public static void generateHelper(List<String> combos, String prefix, String remaining) {
		// what digit I'm working with
		int digit = Integer.parseInt(remaining.substring(0, 1));

		if (remaining.length() == 1) {
			for (int i = 0; i < mappings[digit].length; i++) {
				combos.add(prefix + mappings[digit][i]);
			}
		} else {
			for (int i = 0; i < mappings[digit].length; i++) {
				generateHelper(combos, prefix + mappings[digit][i], remaining.substring(1));
			}
		}
	}

	public static List<String> generateCombos (String number) {
		List<String> combos = new LinkedList<String>();
		generateHelper(combos, "", number);
		return combos;
	}

	public static void main(String[] args) {
		boolean cont = true;
		System.out.println("Welcome to this key mapping, combo making from numbers application!");
		System.out.println("This program is supposed to take in a 5 digit number and then give you words back based on the corresponding or aligning letters");
		while (cont = true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter in five digits: ");
			String phone = scan.nextLine();
			if (phone.length() != 5) {
				System.out.println("The number given is not 5 digits long.");
				System.out.println("Try again? Y/N");
				String reply1 = scan.next();
				if (reply1.charAt(0) == 'Y' || reply1.charAt(0) == 'y') {
					cont = true;
				} else {
					System.exit(0);
				}
			} else {
				List<String> combos = generateCombos(phone);
				System.out.println("Here are your combos: ");
				for (String s: combos) {
					System.out.println(s);
				}
				System.out.println("Would you like to try another? Y/N");
				String reply2 = scan.next();
				if (reply2.charAt(0) == 'Y' || reply2.charAt(0) == 'y') {
					cont = true;
				} else {
					System.exit(0);
				}
			}
		}
	}
}