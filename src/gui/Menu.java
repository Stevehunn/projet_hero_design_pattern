package gui;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    private static final long serialVersionUID = 1L;

    public Menu() {
        super("Bienvenue Hero !");
        setLocation(50, 50);
        setSize(700, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(buildContentPane());


    }

    public static void main(String[] args) {
        new Menu();
    }

    private JPanel buildContentPane() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Bienvenue à toi jeune héro !");

        JLabel label2 = new JLabel("Veux tu commencer ton aventure ?");
        JButton bouton = new JButton(new Launch("Start"));
        panel.add(label);
        panel.add(label2);
        panel.add(bouton);
        return panel;
    }
}
