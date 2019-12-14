package utils;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Inventaire extends Connect {
    public int id;

    public Inventaire(int id) {
        this.id = id;
        recupererInventaire(recupererIntInventaire(id));


    }

    public static int[] recupererIntInventaire(int iDperso) {
        String a = "Select * from inventaire where id_personnage=";
        a = a + Integer.toString(iDperso);
        int[] tab = Connect(a);

        return tab;
    }

    public static String[][] recupererInventaire(int[] tableau) {
        String inventaire[][] = new String[3][5];
        String inventaire1[] = new String[5];
        String inventaire2[] = new String[5];
        String inventaire3[] = new String[5];
        int objet1 = tableau[2];
        int objet2 = tableau[3];
        int objet3 = tableau[4];

        String url = "jdbc:mysql://localhost:3306/g6"; // partie connexion
        String user = "root";
        String passwd = "root";

        try {

            String requete1 = "Select * from objets where id_objet=" + objet1;

            Connection conn = DriverManager.getConnection(url, user, passwd);

            Statement state = (Statement) conn.createStatement();// création objet statement pour recupérer résultat
            ResultSet result = state.executeQuery(requete1);
            ResultSetMetaData resultMeta = (ResultSetMetaData) result.getMetaData();

            while (result.next()) {

                for (int i = 1; i <= 4; i++) {
                    inventaire1[i] = result.getObject(i).toString();

                }

            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        try {

            String requete2 = "Select * from objets where id_objet=" + objet2;
            Connection conn = DriverManager.getConnection(url, user, passwd);

            Statement state1 = (Statement) conn.createStatement();// création objet statement pour recupérer résultat
            ResultSet result1 = state1.executeQuery(requete2);
            ResultSetMetaData resultMeta = (ResultSetMetaData) result1.getMetaData();

            while (result1.next()) {

                for (int i = 1; i <= 4; i++) {
                    inventaire2[i] = result1.getObject(i).toString();

                }

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        try {

            String requete3 = "Select * from objets where id_objet=" + objet3;

            Connection conn = DriverManager.getConnection(url, user, passwd);
            // System.out.println("Connexion effective !");

            Statement state2 = (Statement) conn.createStatement();// création objet statement pour recupérer résultat
            ResultSet result2 = state2.executeQuery(requete3);
            ResultSetMetaData resultMeta = (ResultSetMetaData) result2.getMetaData();

            while (result2.next()) {

                for (int i = 1; i <= 4; i++) {
                    inventaire3[i] = result2.getObject(i).toString();

                }

            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        for (int j = 1; j < inventaire1.length; j++) {

            inventaire[0][j] = inventaire1[j];

        }
        for (int j = 1; j < inventaire2.length; j++) {

            inventaire[1][j] = inventaire2[j];

        }
        for (int j = 1; j < inventaire3.length; j++) {

            inventaire[2][j] = inventaire3[j];

        }

        return inventaire;

    }

}

