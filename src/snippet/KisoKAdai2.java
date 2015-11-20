/**
 *
 */
package snippet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @author internous
 *
 */
public class KisoKAdai2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Random rnd = new Random();//Randomクラスのインスタンス化

	        int end = 0;
	        int ran = rnd.nextInt() % 101;//乱数作成
	        if(ran<0){//もし乱数がマイナスだったら-1をかけてプラスに
	            ran*= -1;
	        }
	        System.out.println("ＣＰＵが１～１００の数字をランダムで作成しますそれを当ててください");

	        while(end==0){
	            try{
	                System.out.println("１～１００の数字を入力してください、終了するときは1000を入力してください");
	                String str = br.readLine();
	                int nu= Integer.parseInt(str);
	                if(nu==1000){
	                    break;
	                }
	                if(nu==ran){
	                    System.out.println("正解です！");
	                    end = 1;
	                }else{
	                    if(nu>ran){
	                        System.out.println("CPUが作成した数字はもっと小さいです");
	                    }else{
	                        System.out.println("CPUが作成した数字はもっと大きいです");
	                    }
	                }
	             }catch(Exception e){
	                 System.out.println("入力エラーです");
	             }
	        }
	         System.out.println("終了しました");
	    }
	}