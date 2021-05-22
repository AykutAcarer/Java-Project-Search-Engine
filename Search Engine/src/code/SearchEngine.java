package code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngine {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("Enter regex pattern:");

			Pattern patt = Pattern.compile(scan.nextLine());

			FileReader fr = new FileReader("C:\\Users\\CC-Student\\Desktop\\Beispiel_Datei\\metin.txt");
			BufferedReader br = new BufferedReader(fr);
			String zeile = "";
			String ergebnis = "";
			String ergebnis2 = "";
			int count = 0;
			int count2=0;
			while ((zeile = br.readLine()) != null) {

				Matcher matcher = patt.matcher(zeile);
				boolean found = false;
				count++;
				while (matcher.find()) {

					ergebnis = "I found the text  "+"'"+ matcher.group() +"'"+ " " + count + ". Zeile"
							+ "  starting at index  " + matcher.start() + "  and ending at index  " + matcher.end();
					System.out.println(ergebnis);
					count2++;
					found = true;
				}
				if (!found) {
					ergebnis2 = "No extra match found";

				}

			}
			System.out.println("Total matches "+count2);
			System.out.println(ergebnis2);
			br.close();
		}
	}

}
