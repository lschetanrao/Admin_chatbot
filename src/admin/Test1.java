package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try
		 {
			 String url="jdbc:mysql://localhost:3306/Chatbot";
			 String uname="root";
			 String password="root";
		
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection conn=DriverManager.getConnection(url,uname,password);
			 int key=17;
			 String query_answer = "select answer from answers where id='"+ key +"'";
			 PreparedStatement stmt = conn.prepareStatement(query_answer);
			 ResultSet rs = stmt.executeQuery(query_answer);
			 
			 while(rs.next())
				 System.out.println(rs.getString("answer"));
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
	}

}
