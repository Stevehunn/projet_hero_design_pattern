package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LabyrintheGraphique extends JFrame implements KeyListener {

    private static final long serialVersionUID = 1L;

    private static final int TAILLE_CASE = 100;

    // On est obligé d'avoir un décalage sinon on ne voit pas le terrain

    private static final int DEC_HAUT = 35;

    private static final int DEC_GAUCHE = 20;

    // La taille d'un pion pour ne pas prendre toute la case

    private static final int TAILLE_PION = 90;

    private static final String mur = "ressources/mur.PNG";
    private static final String chemin = "ressources/chemin.jpg";
    private static final String porte = "ressources/porte.jpg";
    private static final String porteFin = "ressources/porteFin.png";
    private static final String personnageFace = "ressources/personnageFace.png";
    private static final String personnageDos = "ressources/personnageDos.png";
    private static final String personnageGauche = "ressources/personnageGauche.png";
    private static final String personnageDroite = "ressources/personnageDroite.png";
    private static final String portail = "ressources/portail.png";
    private static final String monstre = "ressources/monstre.png";
    private static final String octogone = "ressources/octogone.png";
    private static final String devogele = "ressources/devogele.png";
    private static final String labroche = "ressources/labroche.png";
    private static final String bisone = "ressources/bisone.png";
    private static final String manel = "ressources/manel.png";
    private static final String dab = "ressources/dab.png";

    private int x;
    private int y;
    private String[][] mapEnCours;
    private int numeroMap = 0;
    private String[][] map1 = { // 1.1

            {"X", "X", "X", "X", "X"},

            {"X", "_", "_", "_", "X"},

            {"X", "_", "_", "_", "A"},

            {"X", "_", "_", "_", "X"},

            {"X", "X", "X", "X", "X"}};
    private String[][] map2 = { // 1.2

            {"X", "X", "A", "X", "X"},

            {"X", "_", "_", "_", "X"},

            {"D", "_", "_", "M", "B"},

            {"X", "_", "_", "_", "X"},

            {"X", "X", "X", "X", "X"}};
    private String[][] map3 = { // 2.2

            {"X", "X", "X", "X", "X"},

            {"X", "_", "_", "_", "X"},

            {"A", "_", "_", "_", "X"},

            {"X", "_", "_", "_", "X"},

            {"X", "X", "D", "X", "X"}};
    private String[][] map4 = { // 1.3

            {"X", "X", "A", "X", "X"},

            {"X", "_", "_", "_", "X"},

            {"D", "_", "_", "_", "X"},

            {"X", "_", "_", "_", "X"},

            {"X", "X", "B", "X", "X"}};
    private String[][] map5 = { // 2.1

            {"X", "X", "X", "X", "X"},

            {"X", "_", "_", "_", "X"},

            {"X", "P", "_", "_", "D"},

            {"X", "_", "_", "_", "X"},

            {"X", "X", "X", "X", "X"}};
    private String[][] map6 = { // 2.3

            {"X", "X", "A", "X", "X"},

            {"X", "_", "_", "_", "X"},

            {"X", "_", "_", "_", "B"},

            {"X", "_", "_", "_", "X"},

            {"X", "X", "D", "X", "X"}};
    private String[][] map7 = { // 3.3

            {"X", "X", "B", "X", "X"},

            {"X", "_", "_", "_", "X"},

            {"A", "_", "_", "_", "X"},

            {"X", "_", "_", "_", "X"},

            {"X", "X", "D", "X", "X"}};
    private String[][] map8 = { // 3.2

            {"X", "X", "X", "X", "X"},

            {"X", "_", "_", "_", "X"},

            {"A", "_", "_", "_", "D"},

            {"X", "_", "_", "_", "X"},

            {"X", "X", "X", "X", "X"}};
    private String[][] map9 = { // 3.1

            {"X", "X", "F", "X", "X"},

            {"X", "_", "_", "_", "X"},

            {"X", "_", "_", "_", "D"},

            {"X", "_", "_", "_", "X"},

            {"X", "X", "X", "X", "X"}};
    private String[][] map10 = {

            {"X", "X", "X", "X", "X"},

            {"X", "_", "_", "_", "X"},

            {"D", "_", "O", "_", "X"},

            {"X", "_", "_", "_", "X"},

            {"X", "X", "X", "X", "X"}};
    private String[][] map11 = {

            {"X", "X", "X", "X", "X"},

            {"X", "N", "BF", "T", "X"},

            {"x", "_", "_", "_", "X"},

            {"X", "_", "_", "_", "X"},

            {"X", "X", "D", "X", "X"}};
    private String[][] map12 = {

            {"X", "X", "X", "X", "X"},

            {"X", "_", "_", "_", "X"},

            {"X", "P", "_", "_", "X"},

            {"X", "_", "DA", "_", "X"},

            {"X", "X", "X", "X", "X"}};
    private String[][] map13 = {

            {"X", "X", "D", "X", "X"},

            {"X", "_", "_", "_", "X"},

            {"X", "_", "_", "_", "X"},

            {"X", "_", "MA", "_", "X"},

            {"X", "X", "X", "X", "X"}};
    /**
     * La direction courante.
     */

    private Direction direction;

    public LabyrintheGraphique() {
        super("map");
        mapEnCours = map1;
        numeroMap = 1;
        this.x = 1;
        this.y = 1;
        this.direction = Direction.BAS;
        setLocation(50, 50);
        setSize(700, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);

    }

    public static void main(String[] args) {
        new LabyrintheGraphique();
    }

    public static BufferedImage scale(BufferedImage src, int w, int h) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        int ww = src.getWidth();
        int hh = src.getHeight();
        int[] ys = new int[h];
        for (int y = 0; y < h; y++)
            ys[y] = y * hh / h;
        for (int x = 0; x < w; x++) {
            int newX = x * ww / w;
            for (int y = 0; y < h; y++) {
                int col = src.getRGB(newX, ys[y]);
                img.setRGB(x, y, col);
            }
        }
        return img;
    }

    public void avancer(Direction direction) {
        if (this.x >= 0 && this.y >= 0 && this.x < this.mapEnCours[0].length && this.y < this.mapEnCours.length) {
            switch (direction) {
                case DROITE:
                    if (this.x + 1 < this.mapEnCours[0].length && !"X".equals(this.mapEnCours[this.y][this.x + 1])) {
                        this.x++;
                    }
                    this.direction = direction.DROITE;
                    break;
                case BAS:
                    if (this.y + 1 < this.mapEnCours.length && !"X".equals(this.mapEnCours[this.y + 1][this.x])) {
                        this.y++;
                    }
                    this.direction = direction.BAS;
                    break;
                case GAUCHE:
                    if (this.x - 1 >= 0 && !"X".equals(this.mapEnCours[this.y][this.x - 1])) {
                        this.x--;
                    }
                    this.direction = direction.GAUCHE;
                    break;
                case HAUT:
                    if (this.x - 1 >= 0 && !"X".equals(this.mapEnCours[this.y - 1][this.x])) {
                        this.y--;
                    }
                    this.direction = direction.HAUT;
                    break;
            }
        }
    }

    @Override

    public void paint(Graphics g) {
        for (int i = 0; i < mapEnCours.length; i++) {
            for (int j = 0; j < mapEnCours[0].length; j++) {
                switch (this.mapEnCours[i][j]) {
                    case "A":
                    case "D":
                    case "B":
                        // Ici on dessine une porte
                        dessiner(porte, Color.PINK, Color.LIGHT_GRAY, g, j, i);
                        break;
                    case "P":
                        dessiner(portail, Color.blue, Color.LIGHT_GRAY, g, j, i);
                        break;
                    case "F":
                        // Ici on dessine la porte de fin
                        dessiner(porteFin, Color.GREEN, Color.LIGHT_GRAY, g, j, i);
                        break;
                    case "_":
                        // Ici on dessine un chemin
                        dessiner(chemin, Color.WHITE, Color.LIGHT_GRAY, g, j, i);
                        break;
                    case "M":
                        // Ici on dessine un monstre TODO
                        dessiner(chemin, Color.WHITE, Color.LIGHT_GRAY, g, j, i);
                        dessinerMonstre(g, Color.black, Color.LIGHT_GRAY, j, i);
                        break;
                    case "O":
                        // Ici on dessine un octogone
                        dessiner(chemin, Color.WHITE, Color.LIGHT_GRAY, g, j, i);
                        dessiner(octogone, Color.red, Color.LIGHT_GRAY, g, j, i);
                        break;
                    case "N":
                        dessiner(chemin, Color.WHITE, Color.LIGHT_GRAY, g, j, i);
                        dessiner(labroche, Color.red, Color.LIGHT_GRAY, g, j, i);
                        break;
                    case "BF":
                        dessiner(chemin, Color.WHITE, Color.LIGHT_GRAY, g, j, i);
                        dessiner(bisone, Color.red, Color.LIGHT_GRAY, g, j, i);
                        break;
                    case "T":
                        dessiner(chemin, Color.WHITE, Color.LIGHT_GRAY, g, j, i);
                        dessiner(devogele, Color.red, Color.LIGHT_GRAY, g, j, i);
                        break;
                    case "MA":
                        dessiner(chemin, Color.WHITE, Color.LIGHT_GRAY, g, j, i);
                        dessiner(manel, Color.red, Color.LIGHT_GRAY, g, j, i);
                        break;
                    case "DA":
                        dessiner(chemin, Color.WHITE, Color.LIGHT_GRAY, g, j, i);
                        dessiner(dab, Color.red, Color.LIGHT_GRAY, g, j, i);
                        break;

                    default:
                        // Ici on dessine un mur

                        dessiner(mur, Color.BLUE, Color.LIGHT_GRAY, g, j, i);
                        break;
                }
            }
        }
        dessinerPersonnage(g);
        // A c'est quand on avance
        if ("A".equals(this.mapEnCours[this.y][this.x])) {
            if (numeroMap == 1) {
                mapEnCours = map2;
                numeroMap = 2;
                x = 1;
                y = 2;
            } else if (numeroMap == 2) {
                mapEnCours = map3;
                numeroMap = 3;
                x = 2;
                y = 3;
            } else if (numeroMap == 3) {
                mapEnCours = map5;
                numeroMap = 5;
                x = 3;
                y = 2;
            } else if (numeroMap == 4) {
                mapEnCours = map6;
                numeroMap = 6;
                x = 2;
                y = 3;
            } else if (numeroMap == 6) {
                mapEnCours = map7;
                numeroMap = 7;
                x = 2;
                y = 3;
            } else if (numeroMap == 7) {
                mapEnCours = map8;
                numeroMap = 8;
                x = 3;
                y = 2;
            } else if (numeroMap == 8) {
                mapEnCours = map9;
                numeroMap = 9;
                x = 3;
                y = 2;
            }
            this.repaint();
            // D c'est quand on revient en arrière
        } else if ("D".equals(this.mapEnCours[this.y][this.x])) {
            if (numeroMap == 2) {
                mapEnCours = map1;
                numeroMap = 1;
                x = 3;
                y = 2;
            } else if (mapEnCours == map3) {
                mapEnCours = map2;
                numeroMap = 2;
                x = 2;
                y = 1;
            } else if (mapEnCours == map4) {
                mapEnCours = map2;
                numeroMap = 2;
                x = 3;
                y = 2;
            } else if (mapEnCours == map5) {
                mapEnCours = map3;
                numeroMap = 3;
                x = 1;
                y = 2;
            } else if (mapEnCours == map6) {
                mapEnCours = map4;
                numeroMap = 4;
                x = 2;
                y = 1;
            } else if (mapEnCours == map7) {
                mapEnCours = map6;
                numeroMap = 6;
                x = 2;
                y = 1;
            } else if (mapEnCours == map8) {
                mapEnCours = map7;
                numeroMap = 7;
                x = 1;
                y = 2;
            } else if (mapEnCours == map9) {
                mapEnCours = map8;
                numeroMap = 8;
                x = 1;
                y = 2;
            } else if (mapEnCours == map10) {
                mapEnCours = map6;
                numeroMap = 6;
                x = 3;
                y = 2;
            } else if (mapEnCours == map11) {
                mapEnCours = map7;
                numeroMap = 7;
                x = 2;
                y = 1;
            } else if (numeroMap == 13) {
                mapEnCours = map4;
                numeroMap = 4;
                x = 2;
                y = 3;
            }

            this.repaint();

        } else if ("x".equals(this.mapEnCours[this.y][this.x])) {
            if (numeroMap == 11) {
                mapEnCours = map12;
                numeroMap = 12;
                x = 4;
                y = 2;
            }
        }
        // B c'est une autre porte
        else if ("B".equals(this.mapEnCours[this.y][this.x])) {
            if (numeroMap == 2) {
                mapEnCours = map4;
                numeroMap = 4;
                x = 1;
                y = 2;
            } else if (numeroMap == 6) {
                mapEnCours = map10;
                numeroMap = 10;
                x = 1;
                y = 2;
            } else if (numeroMap == 7) {
                mapEnCours = map11;
                numeroMap = 11;
                x = 2;
                y = 3;

            } else if (numeroMap == 4) {
                mapEnCours = map13;
                numeroMap = 13;
                x = 2;
                y = 1;
            }

            this.repaint();
        }
        // P est un portail qui tp au début du labyrinthe
        else if ("P".equals(this.mapEnCours[this.y][this.x])) {
            if (numeroMap == 5) {
                mapEnCours = map1;
                numeroMap = 1;
                x = 1;
                y = 2;
            } else if (numeroMap == 12) {
                mapEnCours = map1;
                numeroMap = 1;
                x = 1;
                y = 2;
            }

            this.repaint();
        } else if ("O".equals(this.mapEnCours[this.y][this.x])) {
            showDialogo();
        } else if ("N".equals(this.mapEnCours[this.y][this.x])) {
            showDialogn();
        }
        // F c'est la fin du jeu
        else if ("F".equals(this.mapEnCours[this.y][this.x])) {
            showDialog();
            new Menu();//  Repartir au menu
        } else if ("T".equals(this.mapEnCours[this.y][this.x])) {
            showDialogd();
        } else if ("BF".equals(this.mapEnCours[this.y][this.x])) {
            showDialogB();
        } else if ("MA".equals(this.mapEnCours[this.y][this.x])) {
            showDialogma();
        } else if ("DA".equals(this.mapEnCours[this.y][this.x])) {
            showDialogda();
        }
    }

    private void dessinerPersonnage(Graphics g) {
        try {
            switch (this.direction) {
                case HAUT:
                    g.drawImage(scale(ImageIO.read(new File(personnageDos)), TAILLE_PION, TAILLE_PION),
                            DEC_GAUCHE + 1 + this.x * TAILLE_CASE, DEC_HAUT + 1 + this.y * TAILLE_CASE, null);
                    break;
                case BAS:
                    g.drawImage(scale(ImageIO.read(new File(personnageFace)), TAILLE_PION, TAILLE_PION),
                            DEC_GAUCHE + 1 + this.x * TAILLE_CASE, DEC_HAUT + 1 + this.y * TAILLE_CASE, null);
                    break;
                case GAUCHE:
                    g.drawImage(scale(ImageIO.read(new File(personnageGauche)), TAILLE_PION, TAILLE_PION),
                            DEC_GAUCHE + 1 + this.x * TAILLE_CASE, DEC_HAUT + 1 + this.y * TAILLE_CASE, null);
                    break;
                case DROITE:
                    g.drawImage(scale(ImageIO.read(new File(personnageDroite)), TAILLE_PION, TAILLE_PION),
                            DEC_GAUCHE + 1 + this.x * TAILLE_CASE, DEC_HAUT + 1 + this.y * TAILLE_CASE, null);
                    break;
            }
        } catch (IOException e) {
            g.setColor(Color.RED);
            g.fillOval(DEC_GAUCHE + 1 + this.x * TAILLE_CASE, DEC_HAUT + 1 + this.y * TAILLE_CASE,
                    TAILLE_PION, TAILLE_PION);
        }
    }

    private void dessinerMonstre(Graphics g, Color couleurFond, Color couleurBord, int j, int i) {
        try {
            g.drawImage(scale(ImageIO.read(new File(monstre)), TAILLE_CASE, TAILLE_CASE), DEC_GAUCHE + j * TAILLE_CASE,
                    DEC_HAUT + i * TAILLE_CASE, null);
        } catch (IOException e) {
            // Dans le cas ou on n'arrive pas à charger l'image
            dessinerRectangleCouleurs(couleurFond, couleurBord, g, j, i);
        }
    }

    private void dessiner(String objet, Color couleurFond, Color couleurBord, Graphics g, int j, int i) {
        try {
            g.drawImage(scale(ImageIO.read(new File(objet)), TAILLE_CASE, TAILLE_CASE), DEC_GAUCHE + j * TAILLE_CASE,
                    DEC_HAUT + i * TAILLE_CASE, null);
        } catch (IOException e) {
            // Dans le cas ou on n'arrive pas à charger l'image
            dessinerRectangleCouleurs(couleurFond, couleurBord, g, j, i);
        }
    }

    private void dessinerRectangleCouleurs(Color couleurFond, Color couleurBord, Graphics g, int j, int i) {
        g.setColor(couleurFond);
        g.fillRect(DEC_GAUCHE + j * TAILLE_CASE, DEC_HAUT + i * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
        g.setColor(couleurBord);
        g.drawRect(DEC_GAUCHE + j * TAILLE_CASE, DEC_HAUT + i * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
    }

    public void keyBoardEvent(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            avancer(Direction.GAUCHE);

        }

        if (key == KeyEvent.VK_RIGHT) {

            avancer(Direction.DROITE);

        }

        if (key == KeyEvent.VK_UP) {

            avancer(Direction.HAUT);

        }

        if (key == KeyEvent.VK_DOWN) {

            avancer(Direction.BAS);

        }

        this.repaint();

    }

    public void keyPressed(KeyEvent arg0) {
        keyBoardEvent(arg0);
    }

    public void keyReleased(KeyEvent arg0) {
        // Rien à faire, sinon on va multiplier les déplacements
    }

    public void keyTyped(KeyEvent arg0) {
        // Rien à faire, sinon on va multiplier les déplacements
    }

    private void showDialog()

    {

        JDialog dialog = new JDialog(this, Dialog.ModalityType.APPLICATION_MODAL);

        JLabel l = new JLabel("Vous êtes enfin sorti !");

        dialog.setBounds(650, 650, 300, 300);

        dialog.add(l);

        dialog.setVisible(true);

    }

    private void showDialogo()

    {

        JDialog dialog = new JDialog(this, Dialog.ModalityType.APPLICATION_MODAL);

        JLabel l = new JLabel("1V1 Octogone, tes regles c'est mes regles");

        dialog.setBounds(650, 650, 300, 300);

        dialog.add(l);

        dialog.setVisible(true);

    }

    private void showDialogn()

    {

        JDialog dialog = new JDialog(this, Dialog.ModalityType.APPLICATION_MODAL);

        JLabel l = new JLabel("Mr Labroche : j'espere que vous nous avez fais un jeu de qualité ! ");

        dialog.setBounds(650, 450, 500, 300);

        dialog.add(l);

        dialog.setVisible(true);

    }

    private void showDialogd()

    {

        JDialog dialog = new JDialog(this, Dialog.ModalityType.APPLICATION_MODAL);

        JLabel l = new JLabel("Mr Devogele : Eh non ce n'est pas la sortie! ");

        dialog.setBounds(650, 450, 500, 300);

        dialog.add(l);

        dialog.setVisible(true);

    }

    private void showDialogma()

    {

        JDialog dialog = new JDialog(this, Dialog.ModalityType.APPLICATION_MODAL);

        JLabel l = new JLabel("Manel : Je suis complètement perdue...");

        dialog.setBounds(650, 350, 300, 300);

        dialog.add(l);

        dialog.setVisible(true);

    }

    private void showDialogB()

    {

        JDialog dialog = new JDialog(this, Dialog.ModalityType.APPLICATION_MODAL);

        JLabel l = new JLabel("Mr Bisone : Arrêtez de parler ! ");

        dialog.setBounds(650, 450, 500, 300);

        dialog.add(l);

        dialog.setVisible(true);

    }

    private void showDialogda()

    {

        JDialog dialog = new JDialog(this, Dialog.ModalityType.APPLICATION_MODAL);

        JLabel l = new JLabel("DabMan : la voie se situe à gauche après la masse verte, ne suivez surtout pas le sens de Manel !");

        dialog.setBounds(650, 350, 600, 300);

        dialog.add(l);

        dialog.setVisible(true);

    }


    private enum Direction {
        DROITE, BAS, GAUCHE, HAUT
    }

}





