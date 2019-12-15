package utils;


import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class Connect {

    public static String[] Connect(String requete) {


        String url = "jdbc:mysql://localhost:3306/g6"; //partie connexion
        String user = "root";
        String passwd = "root";
        String tableau[] = new String[11];

        try {


            Connection conn = DriverManager.getConnection(url, user, passwd);
            // System.out.println("Connexion effective !");

            Statement state = (Statement) conn.createStatement();//création objet statement pour recupérer résultat
            ResultSet result = state.executeQuery(requete);//requete
            ResultSetMetaData resultMeta = (ResultSetMetaData) result.getMetaData();


            while (result.next()) {

                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {

                    tableau[i] = result.getObject(i).toString();

                }


            }

            return tableau;


        } catch (Exception e) {
            e.printStackTrace();

            return tableau;

        }


    }


}