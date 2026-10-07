package Library;

import java.util.ArrayList;
import java.util.List;

import Book.Book;
import Member.Member;

public class Library {

	Book[] book = {
			new Book("あ", 100), new Book("い", 101), new Book("う", 102),
			new Book("え", 103)
	};

	private List<Member> memList = new ArrayList<>();

	public List<Member> getMem() {
		return memList;
	}
	
	public Book[] getBook() {
		return book;
	}
}

//インタフェースでもない、おかしくなるっていうか　Book「」が生成されないは
//図書館が本を検索するというのは、おかしいので　interfaceにする
