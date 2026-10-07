package Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Book.Book;
import Menu.EndDay;

public class Member {

	private String name;

	private EndDay day = null;

	private boolean entai;
	private boolean rental = false;//レンタルしていない

	private Borrow borrow = null;
	private Return returnBook = null;
	/*
	 * memberがBorrowする Member has a Borrow の関係
	 */

	//boolean rentalだけだと、なんの本を借りているのかしか、分からないので
	//List<Book>にする　has-aの関係
	private List<Book> bookList = new ArrayList<>();

	public Member(String name) {

		this.name = name;
	}

	public void setRental() {
		rental = true;
	}

	public void setBorrow(Borrow borrow, Scanner sc) {
		if (borrow == null) {
			this.borrow = borrow;
		}
		borrow.menu(sc);//Memberがborrowする

		/*
		 * 借りられなかった場合、Borrow.menu() は途中で return するので、getBook が null のままになる可能性がある。
		 */
		if (borrow.getBook() != null) {
			bookList.add(borrow.getBook());
		}
	}

	public void setReturn(Return r, Scanner sc) {
		returnBook = r;
		r.menu(sc);//返却

	}

	public boolean getRental() {
		return rental;
	}

	public void setDay(EndDay day) {
		//一日が終了して初回では無ければ、endDayを持たせる　で進める
		if (this.day == null) {
			this.day = day;
			day.setDay();
			return;
		} else {
			//すでに入っているなら　++する
			this.day.setDay();
		}
	}
	
	public  List<Book> getList(){
		return  bookList;
	}

}
