package mysqlce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class c {
public static void main(String[] args)
{

	 Connection conn = null;
	 Statement my;
	 ResultSet run;
	 PreparedStatement sql;
	 
	try{
   	 Class.forName("com.mysql.jdbc.Driver");
       //getConnection()方法，连接MySQL数据库！
  System.out.println("驱动加载成功");
    }
    catch(ClassNotFoundException e){
        //数据库驱动类异常处理
   System.out.println("数据库驱动加载失败！");


   
   }
}
}
