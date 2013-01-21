
import java.util.Scanner;


public class Fonctions {
	public static void attente(){
		Scanner sc = new Scanner(System.in);
		System.out.println("=========Appuyer sur entrée pour continuer=========");
		String d = sc.nextLine();
		d.toLowerCase();
	}
}
