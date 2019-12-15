package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe permettant de sélectionner une action parmis les trois proposées
 */

public class ChoixCombat extends JDialog {
    private int typeAction;

    public ChoixCombat(LabyrintheGraphique labyrintheGraphique, ModalityType applicationModal, Font font3, int vie, int monstreVie) {
        super(labyrintheGraphique, applicationModal);
        setLayout(null);
        JLabel labelStatHero = new JLabel("Vie du héros: " + vie);
        labelStatHero.setBounds(20, 5, 500, 20);
        add(labelStatHero);
        JLabel labelStatMonstre = new JLabel("Vie du monstre: " + monstreVie);
        labelStatMonstre.setBounds(20, 25, 500, 20);
        add(labelStatMonstre);

        JLabel l = new JLabel("Choisissez une action :");
        l.setBounds(20, 45, 500, 20);
        add(l);
        setBounds(650, 350, 360, 170);

        JButton boutonAttaquer = new JButton("Attaquer");
        boutonAttaquer.setFont(font3);
        boutonAttaquer.setBounds(20, 70, 100, 45);
        boutonAttaquer.setOpaque(false);
        boutonAttaquer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setTypeAction(0);
                dispose();
            }
        });
        add(boutonAttaquer);
        JButton boutonObjet = new JButton("Objet");
        boutonObjet.setFont(font3);
        boutonObjet.setBounds(125, 70, 100, 45);
        boutonObjet.setOpaque(false);
        boutonObjet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setTypeAction(1);
                dispose();
            }
        });
        add(boutonObjet);
        JButton boutonFuite = new JButton("Fuite");
        boutonFuite.setFont(font3);
        boutonFuite.setBounds(230, 70, 100, 45);
        boutonFuite.setOpaque(false);
        boutonFuite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setTypeAction(2);
                dispose();
            }
        });

        add(boutonFuite);
    }

    public int getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(int typeAction) {
        this.typeAction = typeAction;
    }
}

