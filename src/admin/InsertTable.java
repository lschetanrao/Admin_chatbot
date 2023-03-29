package admin;
import java.sql.*;
import java.util.ArrayList;

public class InsertTable {

	public  void insert_qa(String question,String answer){
		// TODO Auto-generated method stub
		
		String que=question;
		String ans=answer;
		String [] ques_split=KeyWordsFind.removeWords(que);
		 Stemmer s = new Stemmer(); 
		 ArrayList<String> list = new ArrayList<String>();
		 
		 for (String str : ques_split){
			 str=s.Stem(str);
		     if (str != null && str.length() > 0)
		         list.add(str);
		 }
ques_split=list.toArray(new String[list.size()]);
		
		 s.Unload();
		 que=String.join(",",ques_split);
		System.out.println(que);
		 
		 try
		 {
			 String url="jdbc:mysql://localhost:3306/Chatbot";
			 String uname="root";
			 String password="root";
			 String query1="INSERT INTO questions(keywords) " +
	                   "VALUES ('"+ que + "') ";
			 String query2="INSERT INTO answers(answer) " +
	                   "VALUES ('" + ans + "') ";
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection conn=DriverManager.getConnection(url,uname,password);
			 Statement stmt=conn.createStatement();
			 int i=stmt.executeUpdate(query1);
			 stmt.executeUpdate(query2);
			 System.out.println(i+"row affected");
			
			 
			 
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
	      

	}
	public static void main(String args[]){

	new InsertTable().insert_qa("hey asking iii lorem", " gggggggg");
		
	}

}
