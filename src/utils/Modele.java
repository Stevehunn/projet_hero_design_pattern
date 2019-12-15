package utils;


import javax.swing.table.AbstractTableModel;

public class Modele extends AbstractTableModel {
    Object donnees[][];
    String titres[];


    public Modele(Object donnees[][], String titres[]) {
        this.donnees = donnees;
        this.titres = titres;


    }

    public int getColumnCount() {
        return 2;
    }

    public Object getValueAt(int i, int j) {


        return donnees[i][j];
    }

    public int getRowCount() {
        return donnees.length;
    }

    public String getColumnName(int col) {
        return titres[col];
    }

    public Class getColumnClass(int colonne) {

        return getValueAt(0, colonne).getClass();
    }


}
