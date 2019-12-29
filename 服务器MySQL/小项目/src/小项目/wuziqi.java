package 小项目;

import java.util.Scanner;

public class wuziqi {
	public static void main(String[] args)
	{
		System.out.println("       棋盘来了");
		new qipan().qipans();

	}
}

class qipan{
	int post[]= {0,0};
	String x[][]=new String[200][200];
	int qizi[][]= new int[15][15];
	boolean color=false;
int num=0;
	
	
	void qipans()
	{
		System.out.println(post[0]);
		System.out.println(post[1]);
		for(int i=0;i<15;i++)
		{
	    for(int a=0;a<15;a++)
	    {
	    	if(a%2==0)
	    	{
	    	x[i][a]="——";
	    	}
	    	
	    
	   
	    		else
	    		{
	    			x[i][a]="|";
	    		}
	    	
	    
	    	
	    }
	    
		}
		updata();
	}
	
	void qizi()
	{
		if (num==1)
			System.out.println("有人胜利了");
		String st[]=new String[2];
		System.out.println("请输入你棋子的位置");
		Scanner qizi=new Scanner(System.in);
		String postion =qizi.next();
		st=postion.split(",");
		post[0]=Integer.valueOf(st[0]);
		post[1]=Integer.valueOf(st[1]);
		
		System.out.println(post[0]);
		if(color) {
		color=false;
		if(post[1]%2==0)
		{
			post[1]++;
		}
		if(post[0]%2==0)
		{
			post[0]++;
		}
		
		x[post[0]][post[1]]="o";
		updata();
		}
		else
		{
			color=true;
			if(post[1]%2==0)
			{
				post[1]++;
			}
			if(post[0]%2==0)
			{
				post[0]++;
			}
			
			x[post[0]][post[1]]="●";
			updata();
		}
		
	}
	
	
	void updata()
	{
		
		
		for(int i=0;i<15;i++)
		{
			for(int a=0;a<15;a++)
			{
				System.out.print(x[i][a]);
				for(int x1=0;x1<5;x1++)
				{
					if(x[i][a+x1]==x[i][a+x1+1])
					{
						num++;
					}
				}
				
				
			}
			System.out.println("");
		}
		qizi();
	}
	
	
	
	
}


