/**
 * ユーザが指定した月のカレンダーを出力するプログラム
 * 
 * @author 岩上裕樹
 */

import java.io.*;
import java.util.*;

public class Calendar {
	/**
	 * ユーザからの入力をする
	 */
	public static int input () {
		try {
			// 入力
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = reader.readLine();
			return Integer.reader.readLine();
		} catch (IOException e) {
			System.out.println(e);
			return null;
		} catch (NumberFormatException e) {
			System.out.println("数値の形式が正しくありません。");
			return null;
		}
	}
	
	/**
	 * カレンダーを出力する
	 */
	public static void printCalendar () {
		
	}
	public static void main (String[] args) {
		// Calendarインスタンス
		java.util.Calendar call = java.util.Calendar.getInstance();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("カレンダーを出力します");
		
		// 変数を初期化しておくけど、ユーザに代入してもらう
		int year = 2014;
		int month = 4;
		
		// 年の入力
		System.out.println("年を入力してください（例：2014）");
		year = input();
		// 数値の形式が正しくない場合
		if (year == null) 
			return;
		// 値が小さい場合
		if(year <= 0) {
			System.out.println("年は1以上の自然数で入力してください。");
			return;
		}
		
		// 月の入力
		System.out.println("月を入力してください（例：4）");¥
		month = input();
		if(month == null)
			return;
		// 範囲外の場合
		if(month < 1 || month > 12){
			System.out.println("月は1〜12の間で入力してください。");
			return;
		
		// 最初の数行を出力
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
					if (i == call.get(java.util.Calendar.DAY_OF_WEEK) ) {
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
					if(month-1 != call.get(java.util.Calendar.MONTH)) {
						System.out.println();
						return;
					}
				}
			}
			System.out.println();
		}
	}
}