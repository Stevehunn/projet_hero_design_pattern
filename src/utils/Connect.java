package utils;


import java.sql.*;


public class Connect {

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/g6?serverTimezone=UTC"; //partie connexion
            String user = "root";
            String passwd = "root";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");


            Statement state = (Statement) conn.createStatement();//création objet statement pour recupérer résultat
            ResultSet result = state.executeQuery("SELECT * FROM objets");//requete
            ResultSetMetaData resultMeta = (ResultSetMetaData) result.getMetaData();

            System.out.println("\n**************************************************************************************");

            for (int i = 1; i <= resultMeta.getColumnCount(); i++)// prends toutes les lignes set colonnes du tableau
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

            System.out.println("\n**************************************************************************************");

            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                    System.out.print("\t" + result.getObject(i).toString() + "\t |");

                System.out.println("\n------------------------------------------------------------------------------------");
            }
/*
   		   	}
   		 	while(result.next()){
   				   System.out.print("\t" + result.getInt("numHéro") + "\t |"); // affiche seulement numHéro et héro
   				   System.out.print("\t" + result.getString("héro") + "\t |");
   				   System.out.println("\n---------------------------------");
   				 }*/

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}


