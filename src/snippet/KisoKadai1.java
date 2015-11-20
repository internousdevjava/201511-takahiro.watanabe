/**
 *
 */
package snippet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author internous
 *
 */
public class KisoKadai1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	String x =null;
	String y =null;
	int a=0;
	int b=0;
	int c=0;

	do{
      try{
    	  BufferedReader  br=
    			  new BufferedReader(new InputStreamReader(System.in));
     //ループしたら画面出力させる
    	  if(c==0){
          c++;
         }else{
    	  System.out.println("もう一度入力してください");
         }
    	  System.out.println("１～１００まで入力してください");
          //x軸の入力待ち
    	  x = br.readLine();
    	//x軸が数値に直せるか
    	  //直せなかったらもう一度
    	  try{
    		 Integer.parseInt(x);
    	  }catch(NumberFormatException nfex){
    		  continue;
    	  }
    	  if(Integer.parseInt(x)>100||Integer.parseInt(x)<1){
    		  continue;
    	  }
    	  System.out.println("１～１００まで入力してください");
         //y軸の入力待ち
          y=br.readLine();

          //y軸が数値に直せるか
          //直せなかったらもう一度入力させる。
          try{
        	  Integer.parseInt(y);
          } catch (NumberFormatException nfex){
        	  continue;
          }

          if(Integer.parseInt(y)>100|Integer.parseInt(y)<1){
        	  continue;
        	  }
          }catch(Exception e){
        	   e.printStackTrace();
          }
          //a,bにx,yを代入
          a=Integer.parseInt(x);
          b=Integer.parseInt(y);

      }while (a>100 || a<=0 || b> 100||b<=0);
      //y軸の繰り返し
      for(int i=1;i<=b; i++){
    	//x軸の繰り返し
    	  for(int j=1; j<=a; j++){
    		  int kotae =i*j;
    		  System.out.print(String.format("%1$5d", kotae));
    	  }
    	  //x軸が全部表示せれたら改行
    	  System.out.println("");
      }
	}
	}
