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
		String jdbcUrl = "jdbc:mysql://localhost:3306/bdd_mysql";
		
		// Etape 3 - Création de la connexion
		Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root","");
		
		Statement st = uneConnexion.createStatement();
		
		// Etape 4 - exécution  de la requête
		ResultSet rs = st.executeQuery("select * from clients");
		
		// Etape 5 - exploitation des résultats
		while(rs.next()) {
			
			String code = rs.getString("CODE_POSTAL");
			String ville = rs.getString("VILLE");
			String societe=rs.getString("SOCIETE");
		
			
			System.out.println("CODE_POSTAL->" + code +"|"+ " SOCIETE = " + societe +"|"+ "   " + " VILLE = "+ ville );
		}

		// Etape 6 - Fermeture des ressources
		rs.close();
		
		st.close();
		
		uneConnexion.close();

	}

}
