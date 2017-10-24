import java.sql.*;
import java.util.Scanner;
//https://stackoverflow.com/questions/20150880/insert-a-hashmap-into-any-database-table
public class Tester 
{
	public static Scanner userInput = new Scanner(System.in);

	public static void createNewDatabase(String fileName) 
	{

		String url = "jdbc:sqlite:C:/sqlite/db/" + fileName;

		try(Connection conn = DriverManager.getConnection(url)) 
		{
			if(conn != null) 
			{
				String name = fileName.replace(".db", "");
				String capName = name.substring(0, 1).toUpperCase() + name.substring(1);
				DatabaseMetaData meta = conn.getMetaData();
				//System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database \"" + capName + "\" has been created.");
			}
			// Statement stm = conn.createStatement();
			//String items = //big mac etc

		} 
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());
		}
	}


	public static void createMenuTable()
	{
		// SQLite connection string
		String url = "jdbc:sqlite:C://sqlite/db/menu.db";

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
				+ "	id integer PRIMARY KEY,\n"
				+ "	name text NOT NULL,\n"
				+ "	capacity real\n"
				+ ");";

		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) 
		{
			// create a new table
			stmt.execute(sql);
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	/*
	 * @param args the command line arguments
	 */
	public static void main(String[] args) 
	{
		createNewDatabase("menu.db");
		createMenuTable();
	}
}