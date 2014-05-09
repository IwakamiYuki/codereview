/**
 * 現在の月のカレンダーを出力するプログラム
 * 
 * @author 岩上裕樹
 */

import java.util.*;

public class Calendar_v1 {
	public static void main (String[] args) {
		// Calendarインスタンス
		Calendar call = Calendar.getInstance();
		
		// 現在の年と月を取得
		int year = call.get(Calendar.YEAR);
		int month = call.get(Calendar.MONTH) + 1;
		
		// 最初の数行を出力
		System.out.println(year + "年" + month + "月のカレンダーを出力します");
		System.out.println(year + "年 " + month + "月");
		System.out.println("日 月 火 水 木 金 土");
		
		// その月の1日の曜日取得用にセットしておく（例えば、4月だったら4月1日の曜日を取得する）
		call.set(year, month - 1, 1);
		
		int i = 0;
		int date = 1;
		boolean flag = false;	// 日にちを出力するかどうかのフラグ
		while (true) {
			for (i = 1; i <= 7; i++) {
				// まだ日にちの出力を始めていない場合は
				if (!flag) {
					// 1日の曜日だったらそこからスタート！
					if (i == call.get(Calendar.DAY_OF_WEEK) ) {
						flag = true;
					}
				}
				
				// まだ日にちの出力を始めていない場合は：空白
				if(!flag){
					// まだ表示は始まらない
					System.out.print("   ");
					
				// 日にちの出力が始まっている場合は：日にちを出力
				} else {
					// 日を出力
					System.out.print(String.format("%1$2d",date)+" ");
					date++;
				
					// 今の月を取得してみる
					call.set(year, month - 1, date);
					// 違う月になったら終わり
					if(month-1 != call.get(Calendar.MONTH)) {
						System.out.println();
						return;
					}
				}
			}
			System.out.println();
		}
	}
}