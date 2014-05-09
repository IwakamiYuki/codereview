import java.io.*;
import java.util.ArrayList;

public class Eratosthenes {
	public static void main (String[] args) {
		System.out.println("素数リストを出力するプゴグラムです。");
		System.out.println("リストの最大値を整数で入力してください。");
		
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		int k=2;
		try {
			// ユーザの入力
			String line = reader.readLine();
			k = Integer.parseInt(line);
		} catch (IOException e) {
			System.out.println(e);
			return;
		} catch (NumberFormatException e) {
			System.out.println("不正な値が入力されました。");
			return;
		}
		
		// 素数候補を昇順に入れておくArrayListの作成
		ArrayList<Integer> era = new ArrayList<Integer>();
		for(int i = 2; i <= k; i++) {
			era.add(i);
		}
		// 素数候補がある場合、繰り返す
		while(era.size() > 0) {
			// 先頭を読む
			int n = era.get(0);
			
			// 先頭を出力
			System.out.print(n + " ");
			
			// 素数の倍数は素数じゃない！
			for(int i = n; i * n <= k; i++) {
				// 素数の倍数を検索
				int index = era.indexOf(i * n);
				// 倍数は削除！
				if(index > 0)
					era.remove(index);
			}
			// 先頭は削除！
			era.remove(0);
		}
	}
}