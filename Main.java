import java.io.*;
import java.sql.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException
	{
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		String name =sc.readLine();
		int age=Integer.parseInt(sc.readLine());
		String address=sc.readLine();
		Class.forName("com.mysql.jdbc.Driver");   //Register driver class
		Connection con=null;         //connection object initialized as null
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database_jdbc","root",""); //getting connection from database
		if(con!=null)
		{
			System.out.println("WELCOME");
		}
		Statement st=con.createStatement();
		String s= "INSERT INTO details VALUES('"+name+"','"+age+"','"+address+"')";
		st.execute(s);
	}
}
