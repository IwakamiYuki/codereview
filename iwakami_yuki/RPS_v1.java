import java.io.*;
import java.util.Random;
public class RPS_v1 {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("じゃんけんをしましょう！");
		System.out.println("1: グー、2: チョキ、3: パー");
		System.out.println("じゃーんけーん・・");
		System.out.print("出す手を入力 => ");
		
		try {
			// 入力 
			String line = reader.readLine();
			
			// 数値に変換
			int myHand = Integer.parseInt(line);
			// 1〜3ではない場合は警告！
			if(myHand<1 || myHand>3) {
				System.out.println("1〜3で入力してください！");
				return;	// 処理を終了する
			}
			
			// 自分の手の出力
			System.out.print("あなた : ");
			switch(myHand){
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
			
			// ここからコンピュータの手を決める処理
			System.out.print("、コンピュータ : ");
			// コンピュータの手をランダムに決める
			Random rnd = new Random();
			int cpHand = rnd.nextInt(3) + 1;
			switch(cpHand){
				case 1:
					System.out.println("グー");
					break;
				case 2:
					System.out.println("チョキ");
					break;
				case 3:
					System.out.println("パー");
					break;
			}
			
			// 勝負の結果を出力する
			switch( (myHand - cpHand +3) % 3 )
			{
				case 0:
					System.out.println("あいこでした！");
					break;
				case 1:
					System.out.println("あなたの負けです！");
					break;
				case 2:
					System.out.println("あなたの勝ちです！");
					break;
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("1〜3で入力してください！");
		}
	}
}