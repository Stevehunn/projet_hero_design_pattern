package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe qui affiche l'écran titre du jeu.
 */
public class Menu extends JFrame {

    private static final long serialVersionUID = 1L;
    //private static final String Menu = "ressources/Menu.jpg";
    ImageIcon background;
    JButton bouton;
    JButton bouton2;
    JButton bouton3;
    JPanel panel = new JPanel();

    public Menu() {
        super("Bienvenue Hero !");
        setLocation(50, 50);
        setSize(720, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(buildContentPane());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Menu();
    }

    private JPanel buildContentPane() {

        //JLabel background = new JLabel(new ImageIcon(Menu));
        //panel.add(background);
        Font font = new Font("Times new roman", Font.BOLD, 22);
        panel.setLayout(null);

        JLabel label = new JLabel("Bienvenue à toi jeune héro !");
        panel.add(label);
        label.setFont(font);
        label.setForeground(Color.red);
        label.setBounds(170, 90, 500, 100);

        Font font2 = new Font("Times new roman", Font.BOLD, 18);
        JLabel label2 = new JLabel("Veux tu commencer ton aventure ?");
        panel.add(label2);
        label2.setFont(font2);
        label2.setForeground(Color.red);
        label2.setBounds(190, 100, 1000, 150);


        Font font3 = new Font("Times new roman", Font.BOLD, 16);
        bouton = new JButton(new Launch("Jouer"));
        bouton.setFont(font3);
        bouton.setBounds(260, 250, 150, 45);
        bouton.setOpaque(false);
        panel.add(bouton);


        bouton2 = new JButton("Quitter le jeu");
        bouton2.setFont(font3);
        bouton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        bouton2.setBounds(500, 540, 150, 45);
        bouton2.setOpaque(false);
        panel.add(bouton2);

        bouton3 = new JButton("Crédit");
        bouton3.setFont(font3);
        bouton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDialog();
            }
        });
        bouton3.setBounds(34, 540, 120, 45);
        bouton3.setOpaque(false);
        panel.add(bouton3);


        background = new ImageIcon("ressources/Menu.jpg");
        JLabel bgLabel = new JLabel(background);
        bgLabel.setBounds(0, 0, 700, 600);
        panel.add(bgLabel);
        bgLabel.setOpaque(false);

        return panel;
    }

    private void showDialog() {
        JDialog dialog = new JDialog(this, Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setLayout(null);
        dialog.getContentPane().setBackground(Color.gray);

        Font font3 = new Font("Times new roman", Font.BOLD, 16);
        JLabel l = new JLabel("Ceci vous à étais créé par:");
        l.setBounds(20, 20, 200, 20);
        l.setFont(font3);
        l.setForeground(Color.red);
        JLabel a = new JLabel(" Mahtieu, Jonas, Elouan, Yucheng, Jieying, Wendy et Nicolas");
        a.setBounds(40, 40, 450, 40);
        a.setFont(font3);
        a.setForeground(Color.red);
        JLabel b = new JLabel("en espérant que cela vous plaira ! Bisous !");
        b.setBounds(50, 80, 400, 50);
        b.setFont(font3);
        b.setForeground(Color.red);
        dialog.setBounds(650, 450, 550, 300);

        dialog.add(l);
        dialog.add(a);
        dialog.add(b);

        dialog.setVisible(true);
    }
}

