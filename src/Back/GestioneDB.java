package Back;

import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestioneDB {

	public static void InsertClasse(String desc, int capacit�) {
		try {

			Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/database_silvestro?user=root&password=cocito2022");

			System.out.println("connessione aperta");

			Statement stmt = connection.createStatement();
			
			Random rand = new Random();
			
		    int intID = rand.nextInt(1000); 
		    
		    String randomID = Integer.toString(intID);

			String script="INSERT INTO aule(ID,capacit�,descrizione) VALUES ('"+randomID+"','"+capacit�+"','"+desc+"'"+")";

			ResultSet item=stmt.executeQuery(script);

			stmt.close();

			connection.close();

			}

			catch(SQLException ex) {

			ex.printStackTrace();

			}
	}
	
	
	

}
