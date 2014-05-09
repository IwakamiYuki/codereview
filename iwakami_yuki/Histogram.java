public class Histogram {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("グラフにプロットする値を引数に指定してください。");
			System.out.println("例）java Histogram 1 2 3 3 2 1");
			return;
		}
		int max = 0;	// 引数の最大値を格納する
		try {
			// 引数の最大値を求める
			for(int i = 0; i < args.length; i++) {
				int n = Integer.parseInt(args[i]);
				max = max < n ? n : max;
			}
			
			// ヒストグラムを出力
			for(int j = max; j > 0; j--) {
				for(int i = 0; i < args.length; i++) {
					if(Integer.parseInt(args[i]) < j)
						System.out.print(" ");
					else
						System.out.print("*");
				}
				System.out.println();
			}
		} catch (NumberFormatException e) {
			System.out.println("引数に指定できるのは数値のみです。");
		}
		
	}
}