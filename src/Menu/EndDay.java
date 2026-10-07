package Menu;

import java.util.List;
import java.util.Scanner;

import Member.Member;

public class EndDay implements MainMenu {

	private int day;
	private List<Member> memList;

	private EndDay end = null;//自分自身を入れる

	public EndDay(List<Member> list) {
		memList = list;
	}

	public void setEnd(EndDay end) {
		this.end = end;
		System.out.println("setEnd が呼ばれた");
	}
	

	public int getDay() {
		return day;
	}

	public void setDay() {
		day++;
	}

	@Override
	public void menu(Scanner sc) {

		System.out.println("一日が終了します");

		for (Member mem : memList) {

			//★★　条件式
			//ここで　商品をレンタルしてたら　カウントを進める
			//こうしたら、レンタル人だけをカウントできるはず
			
			//AもBも借りてる場合　→　mem.getREntal()がtrue→で同じ　endが入るってこと？
			//共有されてしまう
			/*if (mem.getRental()) {
				mem.setDay(end);
			}*/

			if (mem.getRental()) {
				mem.setDay(new EndDay(memList));
		}
			
	}

}
}
