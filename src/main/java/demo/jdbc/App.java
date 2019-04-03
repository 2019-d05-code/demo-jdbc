package demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// DriverManager.registerDriver(new Driver());
		// Etape 1 - Chargement du pilote
		Class.forName("com.mysql.jdbc.Driver");
		
		// Etape 2 - Définition de la JDBC URL
		String jdbcUrl = "jdbc:mysql://localhost:3306/formation-jpa";
		
		// Etape 3 - Création de la connexion
		Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "root");
		
		Statement st = uneConnexion.createStatement();
		
		// Etape 4 - exécution  de la requête
		ResultSet rs = st.executeQuery("select * from LIVRE");
		
		// Etape 5 - exploitation des résultats
		while(rs.next()) {
			
			int id = rs.getInt("ID");
			String titre = rs.getString("TITRE");
			
			System.out.println("ID=" + id + " TITRE=" + titre);
		}

		// Etape 6 - Fermeture des ressources
		rs.close();
		
		st.close();
		
		uneConnexion.close();

	}

}
