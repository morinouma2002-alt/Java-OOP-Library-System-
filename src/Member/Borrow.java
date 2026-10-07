package Member;

import java.util.Scanner;

import Book.Book;
import Library.Library;
import Menu.MainMenu;

public class Borrow implements MainMenu {

	private Library lib;
	private Member mem;
	
	private Book getBook;

	public Borrow(Library lib,Member mem) {
		this.lib = lib;
		this.mem=mem;
	}
	
	public Book getBook() {
		return getBook;
	}
	
	public void setGetBook(Book b) {
		getBook=b;
	}

	@Override
	public void menu(Scanner sc) {
		System.out.println("数値で何をレンタルしますか?");

		Book[] book = lib.getBook();
		for (Book b : book) {
			if (b.getRental()) {
				System.out.println("借りられている");
			} else {
				System.out.println(b.getIndex() + "番号:" + b.getName());
			}

		}

		int n = sc.nextInt();

		Book b = null;
		for (Book b1 : book) {
			if (n == b1.getIndex()) {
				System.out.println("レンタルしました");
				b = b1;
				break;
			} 
		}
		
		//見つからない場合は、ループを全部回してからにする
		if(b==null || b.getRental()) {
			System.out.println("レンタルできない");
			return;
		}
		setGetBook(b);
		b.setRental();
		
		//レンタルした瞬間に日数を進める
		System.out.println("３日以内に返却しなえれば、延滞料金が発生します");
		mem.setRental();

	}
}
