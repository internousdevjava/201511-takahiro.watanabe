/**
 *
 */
package snippet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author internous
 *
 */
public class KisoKadai3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("--フォルダー及びファイルの作成場所を入力してください--");


		String x=reader.readLine();//String str(文字列)を一行読み込む。x入力はファイル居場所を示すために使う

       File file = new File(x);//argsをxに変えないとファイルは作れない。

		// ディレクトリパスを取得する
       File dir=new File(file.getParent());
		 //getParentはそのオブジェクトが示すファイルが格納されているディレクトリー（dirフォルダー）のこと

		if(!dir.exists()){//exists(メソッド)フォルダーやあるかどうか探る
			System.out.println("フォルダがありません。:"+file.getAbsolutePath());//.getAbsolutePath()いらない
			dir.mkdirs();//mkdirs(メソッド)フォルダーを作る
			System.out.println("作成成功");
		} else {//そうでなかった場合
			System.out.println("フォルダは既に存在します。");
			dir.list();{System.out.println("フォルダリスト一覧");//フォルダが存在するときにファイル一覧表示する。
		}

		if(file.exists()){//exists(メソッド)ファイルがあるかどうか探る
			System.out.println("ファイルは既に存在します。\n" + file.getAbsolutePath());
			file.list();{System.out.println("ファイルリスト一覧");//ファイルが存在するときにファイル一覧表示する。
			}
		}else{
			System.out.println("ファイルは存在しません。\n"+file.getAbsolutePath());
			try{//
				if (file.createNewFile()){
					//Fileオブジェクトが参照するファイルを、ファイルが存在しない時だけ作成します。
					System.out.println("作成成功");
				}else{//それ以外
					System.out.println("作成失敗");
				}
			}catch(IOException e){//エラー
				System.out.println(e);
			}
		}
		}



		int end = 0;;//整数
		while(end==0){//endが0と等しい場合

			System.out.println("\n\n--メニュー--\n\n 1:読み込み\n 2:書き込み\n99:終了\nを入力してください");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();//String str(文字列)を一行読み込む

			int nu=0;//整数

			if(str.matches("^[0-9]+$")){//部分的に一致している
				nu=Integer.parseInt(str);//Integer戻値型,文字列(str)を整数に変換します。
			}else{
				System.out.println("\n----------\n半角数値でメニューを選択してください。\n----------\n");
			}

			if(nu==99){
				System.out.println("終了");
				break;
			}
			if(nu==1){
				System.out.println("ファイルを読む");
				try{
					FileReader filereader = new FileReader(file.getAbsolutePath());

					int ch;
					while((ch = filereader.read()) != -1){
						System.out.print((char)ch);
					}

					filereader.close();
				}catch(FileNotFoundException e){
					System.out.println(e);
				}catch(IOException e){
					System.out.println(e);
				}
			}
			if(nu==2){
				System.out.println("ファイルを書く");
				try {
					boolean mode = false;
					System.out.println("モードの設定。1:追記、2:上書き");
					BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
					String str2 = br2.readLine();
					// モードを決める
					switch (str2) {
					case "1":
						mode = true;
						break;
					case "2":
						mode = false;
					default:
						break;
					}
					//出力先を作成する
					FileWriter fw = new FileWriter(file.getAbsolutePath(), mode);
					PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

					//内容を指定する
					BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
					String str3 = br3.readLine();
					pw.println(str3);

					//ファイルに書き出す
					pw.close();

					//終了メッセージを画面に出力する
					System.out.println("出力が完了しました。");

				} catch (IOException ex) {
					//例外時処理
					ex.printStackTrace();
				}

			}
		}
		System.out.println("--処理終了--");
	}
}






		/*// print "ファイル名を入力:"
        System.out.print("ファイル名を入力:");
        // filename = コンソール入力 (String)
        String filename = reader.readLine();
        // writer = filename のファイルを書き込み用に開く
        // # BufferedWriter を使う
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        // # ファイルを開いたので、try-finally で閉じる
        try {
            // print "内容を入力 (ドットのみの行で終了):", 改行
            System.out.println("内容を入力 (ドットのみの行で終了):");
            // 以下を繰り返し
            while (true) {
                // line = コンソールから一行入力
                String line = reader.readLine();
                // if line の内容が "." のみ
                if (line.equals(".")) {
                    // ループを終了
                    break;
                }
                // writerにprint line, 改行
                writer.write(line);
                writer.newLine();
            }
            // print filename + "に書き出しました", 改行
            System.out.println(filename + "に書き出しました。");
        }
        finally {
            writer.close();
        }
    }
}*/