import java.sql.*;
 
public class Tester {
 
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
            Statement stm = conn.createStatement();
            //String items
 
        } 
        catch(SQLException e) 
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
    }
}