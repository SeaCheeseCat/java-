package mysqlce;
import java.util.*;
public class bao {
public static void main(String[] args)
{
	System.out.println('数'+12);
	System.out.println("为哈"+12);
	System.out.println(12.2+1);
	//加减乘除的运算一律转换为int型
	
	long a=System.currentTimeMillis();
	double a1=3.14;
    double a2=3.1;
    double a3=a1*a2;
    System.out.println(a2);
System.out.println(a1);
System.out.println(a3);




double ab=3.0;
double ac=2.0;
System.out.println("相简结果"+(ab-ac));
double a12=3.0;
double a13=2.9;
System.out.println("想见结果是"+(a12-a13));

double a33=8.0;
double a44=6.9;
System.out.println("3.0-1.9的结果是"+(a33-a44));

float b1=3.144222222444444444f;//最多显示7位

float b2=3.1f;

//byte short int long  float double char

System.out.println("单浮点b1是"+b1);
System.out.println("双浮点b1是"+(double)b1);
System.out.println("单浮点b2是"+b2);

long aaa=12345L;


char z='\"';
char zz='\u4e2d';//16位的unicode表示是
char az=20013;
System.out.println(az);

System.out.println(z);
System.out.println(zz);


int lenght =10;
System.out.println("lenght是"+lenght);
//强转的溢出
long r1=1234121312312311221L;
int r2=(int)r1;
double par=80.0/100.0;
byte a23=5;
byte a11=6;
byte aaaa=(byte)(a23-a11);
System.out.println("我不知道"+aaaa);
System.out.println(a23);
System.out.println(par);
System.out.println(r2);

int a21=25;
long b=a21;
int g=(int)b;



long  a123=25;
double b123=25;
long g12=100000000000000L;
int g123=(int)g12;
float h=56.987f;
int i=(int )h;
System.out.print(i);

byte a7=5;
byte a8=6;
byte a4=(byte)(a7+a8);
System.out.println("性价"+a4);
System.out.println(2+2);
System.out.println('1'+'1');


double ea=1.25E2;
System.out.println("科学计数法"+ea);


short sh1=20;
short sh2=10;
short sh3=(short)(sh1+sh2);

double Double = 0;
System.out.println(Double);

float xm1=12f;
int xm2=26;


}



}
