package Member;

import java.util.List;
import java.util.Scanner;

import Book.Book;
import Menu.MainMenu;

public class Return implements MainMenu {

	private List<Book> getList;

	public Return(List<Book> getList) {

		this.getList = getList;
	}

	@Override
	public void menu(Scanner sc) {

		System.out.println("----返却----");

		if (getList.size() == 0) {
			System.out.println("あなたが借りている本は、ありません");
			return;
		}

		System.out.println("あなたが借りている本を返却しますか");
		System.out.println("番号を入力してください");

		for (Book book : getList) {
			System.out.println(book.getIndex() + "番号:" + book.getName());
		}

		while (true) {
			if (!sc.hasNextInt()) {
				System.out.println("数値を入力してください");
				sc.next();//すてる
				continue;
			}

			int index = sc.nextInt();

			Book returnBook = null;

			for (Book book : getList) {
				if (index == book.getIndex()) {
					returnBook = book;
					break;
				}
			}
			/*
			 * 	getList.remove(book);//返却は削除する
			ここで　removeするとずれる
			 */

			if (returnBook != null) {
				System.out.println("一致しました");

				returnBook.returnRental();
				getList.remove(returnBook);
				return;
			}
			System.out.println("一致しないので、やり直してください");

		}
	}

}
