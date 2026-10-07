package Menu;

import java.util.List;
import java.util.Scanner;

import Library.Library;
import Member.Borrow;
import Member.Member;
import Member.Return;

public class Menu implements MainMenu {

	Library lib;

	public Menu(Library lib) {
		this.lib = lib;
	}

	@Override
	public void menu(Scanner sc) {

		List<Member> memList = lib.getMem();

		System.out.println("いらっしゃいませ");
		String s = sc.next();
		Member men = new Member(s);
		memList.add(men);

		while (true) {

			String textBlock = """
					入力してください
					1,借りる
					2,返却
					3,検索
					4,退館(次の客を生成)
					5,一日が終了する
					6,システムを終了
					""";
			System.out.println(textBlock);

			int n = sc.nextInt();

			switch (n) {

			case 1 -> {
				Borrow b = new Borrow(lib, men);
				men.setBorrow(b,sc);
			//	b.menu(sc);
			}
			
			case 2 -> {
				Return r =new Return(men.getList());
				men.setReturn(r,sc);
			}

			case 4 -> {
				System.out.println("ありがとうございました"
						+ "次のお客様の名前を入力してください");
				men = new Member(sc.next());
				memList.add(men);
			}

			case 5 -> {

				EndDay m = new EndDay(memList);
				m.setEnd(m);

				m.menu(sc);
			}

			}
		}
	}

}
