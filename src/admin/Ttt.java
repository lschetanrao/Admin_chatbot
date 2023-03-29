package admin;
import java.sql.*;

public class Ttt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String que="a,b,c,d,fg";
String ans="sssssssssssfdfdssss";
		 try
		 {
			 String url="jdbc:mysql://localhost:3306/Chatbot";
			 String uname="root";
			 String password="root";
			/* String query1="INSERT INTO questions(keywords) " +
	                   "VALUES ('"+ que + "') ";
			 String query2="INSERT INTO answers(answer) " +
	                   "VALUES ('" + ans + "') ";
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection conn=DriverManager.getConnection(url,uname,password);
			 Statement stmt=conn.createStatement();
			 int i=stmt.executeUpdate(query1);
			 int j=stmt.executeUpdate(query2);
			 System.out.println(i+"rows affected");
			 */
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection conn=DriverManager.getConnection(url,uname,password);
			 String query_answer = "select answer from answers where id= 17";
			 Statement stmt=conn.createStatement();
			 ResultSet rs = stmt.executeQuery(query_answer);
			 while(rs.next())
				 System.out.println(rs.getString("answer"));
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
	      

	}

}
