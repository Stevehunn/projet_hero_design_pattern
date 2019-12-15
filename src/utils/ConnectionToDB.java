package utils;


import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ConnectionToDB {
    private int tableau[] = new int[11];

    public ConnectionToDB(String requete) {
        final String url = "jdbc:mysql://localhost:3306/g6"; //partie connexion
        final String user = "root";
        final String passwd = "root";
        try {
            Connection conn = DriverManager.getConnection(url, user, passwd);
            // System.out.println("Connexion effective !");

            Statement state = (Statement) conn.createStatement();//création objet statement pour recupérer résultat
            ResultSet result = state.executeQuery(requete);//requete
            ResultSetMetaData resultMeta = (ResultSetMetaData) result.getMetaData();

			   /*   for(int i = 1; i <= resultMeta.getColumnCount(); i++)// prends toutes les lignes set colonnes du tableau
			        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

			      */

            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    tableau[i] = Integer.parseInt(result.getObject(i).toString());
                    // System.out.println(tableau[i]);
                }
            }
            /*    while(result.next()){
			    	  System.out.print("\t" + result.getInt("numHéro") + "\t |"); // affiche seulement numHéro et héro
			    	  System.out.print("\t" + result.getString("héro") + "\t |");
			    	  System.out.println("\n---------------------------------");
			    	}*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[] getResult() {
        return tableau;
    }

}
