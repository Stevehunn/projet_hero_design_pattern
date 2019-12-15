package utils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Table extends JFrame {
    public Object[][] tab;

    public Table(Object[][] tab) {
        super();
        setAlwaysOnTop(true);
        this.tab = tab;

        setTitle("Inventaire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object[][] donnees = tab;
        String[] entetes = {"objet", "    ", "pv/pm  ", " "};
        Modele table = new Modele(tab, entetes);
        JTable tableau = new JTable(table);

        getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(tableau, BorderLayout.CENTER);
        tableau.setRowHeight(80);
        tableau.setGridColor(Color.GRAY);
        tableau.setBackground(Color.black);
        JTableHeader Header = tableau.getTableHeader();
        Header.setVisible(false);
        setMinimumSize(new Dimension(400, 300));
        tableau.setFont(new Font("Tahome", Font.ROMAN_BASELINE, 14));
        TableColumn col = tableau.getColumnModel().getColumn(0);

        pack();

        tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        String imgUrl = "C:\\Users\\roidot\\Pictures\\"; // � changer quand reunion
        String lien1 = (String) tab[0][1];
        String lien2 = (String) tab[1][1];
        String lien3 = (String) tab[2][1];
        tab[0][1] = new ImageIcon(
                new ImageIcon(imgUrl + lien1).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        tab[1][1] = new ImageIcon(
                new ImageIcon(imgUrl + lien2).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        tab[2][1] = new ImageIcon(
                new ImageIcon(imgUrl + lien3).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        col.setPreferredWidth(100);
        JLabel label = new JLabel("Cliquer pour plus d'informations");
        tableau.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int row = tableau.rowAtPoint(e.getPoint());
                int column = tableau.columnAtPoint(e.getPoint());
                if (column == 0) {

                    label.setText("pv: " + donnees[row][column + 2] + "   pm: " + donnees[row][column + 3]);

                }
                if (column == 1) {
                    int pv = 0;
                    int pm = 0;

                    pv = (int) donnees[row][column + 1];
                    pm = (int) donnees[row][column + 2];

                }

            }
        });

        JPanel p = new JPanel();
        p.add(label);
        p.setBackground(Color.gray);
        p.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        getContentPane().add(p, BorderLayout.SOUTH);

    }
}
