/**
 * じゃんけんをする
 * @author Iwakami Yuki
 */
import java.io.*;
import java.util.Random;
public class RPS_v1 {
	/**
	 * 入力をする
	 * @return 入力した番号を返す
	 */
	public static int input () {
		System.out.print("出す手を入力 => ");
		try {
			// 入力
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = reader.readLine();
			// 入力した手の番号をint型で返す
			return Integer.parseInt(line);
		} catch (IOException e) {
			// 例外が発生したら-1を返す
			System.out.println(e);
			return -1;
		} catch (NumberFormatException e) {
			// 入力エラーが発生したら-1を返す
			return -1;
		}
	}
	
	/**
	 * 手の番号から手を出力する
	 * @param hand 手の番号
	 */
	public static void printHand(int hand) {
		switch(hand){
			case 1:
				System.out.print("グー");
				break;
			case 2:
				System.out.print("チョキ");
				break;
			case 3:
				System.out.print("パー");
				break;
			}
	}
	
	/**
	 * 結果を出力する
	 * @param myHand あなたの手
	 * @param cpHand 相手の手
	 */
	public static void result(int myHand, int cpHand) {
		switch( (myHand - cpHand +3) % 3 )
		{
			case 0:
				// あいこ
				System.out.println("あいこでした！");
				break;
			case 1:
				// 負け
				System.out.println("あなたの負けです！");
				break;
			default:
				// 勝ち
				System.out.println("あなたの勝ちです！");
				break;
		}
	}
	
	/**
	 * お互いの手と結果を出力
	 * @param myHand あなたの手
	 * @param cpHand 相手の手
	 */
	public static void printResult(int myHand, int cpHand) {
		System.out.println("ぽん！");
		System.out.print("あなた : ");
		printHand(myHand);	// あなたの手を出力
		System.out.print("、コンピュータ : ");
		printHand(cpHand);	// 相手の手を出力
		System.out.println();
		// 結果を出力してゲームを終了させるかどうかを返す
		result(myHand, cpHand);
	}
	
	/**
	 * じゃんけんのメインの処理部分
	 */
	public static void game() {
		// 相手の手を決める処理
		Random rnd = new Random();
		int cpHand = rnd.nextInt(3) + 1;
		
		// あなたの手を決める処理
		// 入力
		int myHand = input();
		// 入力エラーの確認
		if(myHand < 1 || myHand > 3) {
			System.out.println("1〜3で入力してください！");
			return;
		}
		
		// 結果を出力する
		printResult(myHand, cpHand);
	}
	
	/**
	 * 最初に表示するメッセージ
	 */
	public static void firstMessage() {
		System.out.println("じゃんけんをしましょう！");
		System.out.println("1: グー、2: チョキ、3: パー");
		System.out.println("じゃーんけーん・・");
	}
	
	/**
	 * メインメソッド
	 */
	public static void main(String[] args) {
		firstMessage();
		game();
	}
}