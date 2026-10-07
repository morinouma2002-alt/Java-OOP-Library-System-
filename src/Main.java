import java.util.Scanner;

import Library.Library;
import Menu.Menu;
public class Main {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		Library lib =new Library();
		
		new Menu(lib).menu(sc);

	}

}
