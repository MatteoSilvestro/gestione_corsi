package Back;

import java.util.Random;
import java.util.Arrays;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


// Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/database_silvestro?user=root&password=cocito2022");
// Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/database_silvestro?user=root&password=matteo05");
// maria db path : C:\MariaDB

public class GestioneDB {

	public static void InsertClasse(String desc, int capacità) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/database_silvestro?user=root&password=cocito2022");
			System.out.println("connessione aperta");
			Statement stmt = connection.createStatement();
			Random rand = new Random();	
		    int intID = rand.nextInt(10000); 
		    String randomID = Integer.toString(intID);
		    while(isAulaIDRepeated(randomID)) {
		    	randomID = Integer.toString(intID);
		    }
			String script="INSERT INTO aule(ID,capacità,descrizione) VALUES ('"+randomID+"','"+capacità+"','"+desc+"'"+")";
			ResultSet item=stmt.executeQuery(script);
			stmt.close();
			connection.close();
			}

			catch(SQLException ex) {
			ex.printStackTrace();
			}
	}
	public static void Insert_Insegnanti(String nome,String cognome,String email,int nOre,String materia) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/database_silvestro?user=root&password=cocito2022");
			System.out.println("connessione aperta");
			Statement stmt = connection.createStatement();
			Random rand = new Random();
		    int intID = rand.nextInt(10000); 
		    String randomID = Integer.toString(intID);
		    while(isInsegnantiIDRepeated(randomID)) {
		    	randomID = Integer.toString(intID);
		    }
			String script="INSERT INTO insegnanti(ID,Nome,Cognome,Email,Materia,Ore) VALUES ('"+randomID+"','"+nome+"','"+cognome+"','"+email+"','"+materia+"','"+nOre+"')";
			System.out.println(script);
			ResultSet item=stmt.executeQuery(script);
			stmt.close();
			connection.close();
			}

			catch(SQLException ex) {

			ex.printStackTrace();

			}
		

}
	public static void InsertCorsi(String Titolo,int capienza,String desc,int blocco_orario,String destinatari,int IDInsegnante,int IDAula) {
		try {
			Random rand = new Random();
		    int intID = rand.nextInt(10000); 
		    String randomID = Integer.toString(intID);
		    while(isCorsiIDRepeated(randomID)) {
		    	randomID = Integer.toString(intID);
		    }
			Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/database_silvestro?user=root&password=cocito2022");
			System.out.println("connessione aperta");
			Statement stmt = connection.createStatement();
			String script="INSERT INTO corsi (ID,Titolo,Capienza,Descrizione,Blocco_orario,Destinatari,IDProfessore,IDAula) VALUES ('"+randomID+"','"+Titolo+"','"+capienza+"','"+desc+"','"+blocco_orario+"','"+destinatari+"','"+IDInsegnante+"','"+IDAula+"')" ;
			stmt.executeUpdate(script);
			stmt.close();
			connection.close();
			}

			catch(SQLException ex) {
			ex.printStackTrace();
			}
	}
	
	public static ResultSet GetInsegnanti() {
			ResultSet item=null;
			try {
				Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/database_silvestro?user=root&password=cocito2022");
				System.out.println("connessione aperta");
				Statement stmt = connection.createStatement();
				String script="Select * from insegnanti";
				System.out.println(script);
				item=stmt.executeQuery(script);			
				stmt.close();
				connection.close();
				}
				catch(SQLException ex) {
				ex.printStackTrace();
				}
			return item;
		}
	
	public static ResultSet GetAula() {
		ResultSet item=null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/database_silvestro?user=root&password=cocito2022");
			System.out.println("connessione aperta");
			Statement stmt = connection.createStatement();
			String script="Select * from aule";
			System.out.println(script);
			item=stmt.executeQuery(script);
			stmt.close();
			connection.close();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return item;
	}
	
	public static ResultSet GetBlocco() {
		ResultSet item=null;
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/database_silvestro?user=root&password=cocito2022");
			System.out.println("connessione aperta");
			Statement stmt = connection.createStatement();
			String script="Select * from corsi GROUP BY Blocco_orario";
			System.out.println(script);
			item=stmt.executeQuery(script);
			stmt.close();
			connection.close();
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return item;
	}
	
	public static ResultSet GetRicerca(int nBlocco,int IDProfessore,int IDClasse) {
		ResultSet item=null;
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/database_silvestro?user=root&password=cocito2022");
			System.out.println("connessione aperta");
			Statement stmt = connection.createStatement();
			if (nBlocco) 
			String script="SELECT * FROM corsi WHERE ";
			System.out.println(script);
			item=stmt.executeQuery(script);
			stmt.close();
			connection.close();
			
		}catch (SQLException ex) {
	        ex.printStackTrace();
	    }
		
		return item;
	}
	
	public static boolean isAulaIDRepeated(String id) {
	    boolean isRepeated = false;
	    try {
	        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/database_silvestro?user=root&password=cocito2022");
	        Statement stmt = connection.createStatement();
	        String script = "SELECT * FROM aule WHERE ID = '" + id + "'";
	        ResultSet rs = stmt.executeQuery(script);
	        isRepeated = rs.next();
	        rs.close();
	        stmt.close();
	        connection.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return isRepeated;
	}
	
	public static boolean isInsegnantiIDRepeated(String id) {
	    boolean isRepeated = false;
	    try {
	        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/database_silvestro?user=root&password=cocito2022");
	        Statement stmt = connection.createStatement();
	        String script = "SELECT * FROM insegnanti WHERE ID = '" + id + "'";
	        ResultSet rs = stmt.executeQuery(script);
	        isRepeated = rs.next();
	        rs.close();
	        stmt.close();
	        connection.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return isRepeated;
	}
	
	public static boolean isCorsiIDRepeated(String id) {
	    boolean isRepeated = false;
	    try {
	        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/database_silvestro?user=root&password=cocito2022");
	        Statement stmt = connection.createStatement();
	        String script = "SELECT * FROM corsi WHERE ID = '" + id + "'";
	        ResultSet rs = stmt.executeQuery(script);
	        isRepeated = rs.next();
	        rs.close();
	        stmt.close();
	        connection.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return isRepeated;
	}
	
	
		
}
	

	

