import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class CaseStudy_1 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException
	{
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		Class.forName("com.mysql.jdbc.Driver");   //Register driver class
		Connection con=null;         //connection object initialized as null
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root",""); //getting connection from database
		Statement st=con.createStatement();
		String s2;
		do
		{
			System.out.println("MENU\n1.Registration\n2.Display\n3.Exit");
			System.out.println("Enter your choice");
			int c=Integer.parseInt(sc.readLine());
			switch(c)
			{
				case 1: System.out.println("enter name");
						String name=sc.readLine();
						System.out.println("enter address");
						String address=sc.readLine();
						System.out.println("enter contact number");
						String contactNumber=sc.readLine();
						System.out.println("enter email");
						String email=sc.readLine();
						System.out.println("enter prooftype");
						String prooftype=sc.readLine();
						System.out.println("enter proofid");
						String proofid=sc.readLine();
						String s= "INSERT INTO registration1 VALUES('"+name+"','"+address+"','"+contactNumber+"','"+email+"','"+prooftype+"','"+proofid+"')";
						st.execute(s);
						break;
				case 2: String s1="SELECT * FROM registration1";
						ResultSet rs=st.executeQuery(s1);
						System.out.println("NAME\t\tADDRESS\t\tCONTACT_NO\t\tEMAIL\t\tPROOFTYPE\tPROOF_ID\n");
						while(rs.next())
						{
							String Name=rs.getString("name");
							String Address=rs.getString("address");
							String contact_no=rs.getString("contact_no");
							String Email=rs.getString("email");
							String Prooftype=rs.getString("proof_type");
							String Proofid=rs.getString("proof_id");
							System.out.println( Name+"\t\t"+ Address+"\t\t\t"+contact_no+"\t\t"+Email+"\t\t"+Prooftype+"\t\t"+Proofid);
						}
						break;
				case 3: System.exit(0);
				default:System.out.println("invalid");
			}
			System.out.println("DO YOU WANT TO CONTINUE(y/n)");
			s2=sc.readLine();
		}while(s2.equals("y"));
	}
}
