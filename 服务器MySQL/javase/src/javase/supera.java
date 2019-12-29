package javase;

public class supera implements Runnable{
	static Thread thread=new Thread(new supera());
public static void main(String[] args)
{
	    thread.start();
}

int i=0;
@Override
public void run() {
	 while (i <= 3) {
       
         try {
             i++;
             thread.sleep(180);
System.out.println(""+i);
             if (i == 3) {
              System.out.println("结束");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
	
}
}





