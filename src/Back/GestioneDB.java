package Back;

import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestioneDB {

	public static void InsertClasse(String desc, int capacità) {
		try {

			Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/database_silvestro?user=root&password=cocito2022");

			System.out.println("connessione aperta");

			Statement stmt = connection.createStatement();
			
			Random rand = new Random();
			
		    int intID = rand.nextInt(1000); 
		    
		    String randomID = Integer.toString(intID);

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
			
		    int intID = rand.nextInt(1000); 
		    
		    String randomID = Integer.toString(intID);

			String script="INSERT INTO insegnanti(ID,Nome,Cognome,Email,Materia,Ore) VALUES ('"+randomID+"','"+nome+"','"+cognome+",'"+email+"','"+materia+"','"+nOre+"'),";
			System.out.println(script);
			ResultSet item=stmt.executeQuery(script);

			stmt.close();

			connection.close();

			}

			catch(SQLException ex) {

			ex.printStackTrace();

			}
		

}}
