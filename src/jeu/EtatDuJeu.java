package jeu;

import java.util.HashSet;

/**
 * Classe pour vérifier l'état du jeu.
 */
public class EtatDuJeu {
    private Hero hero;
    private HashSet<Monstre> montres;

    public EtatDuJeu(Hero hero, HashSet<Monstre> monstres) {
        this.hero = hero;
        if (monstres != null) {
            this.montres = monstres;
        } else {
            this.montres = new HashSet<Monstre>();
        }
    }

    public void ajouterMonstre(Monstre monstre) {
        this.montres.add(monstre);
    }

    /**
     * Méthode pour vérifier si un monstre est viavnt.
     */
    public boolean estVivant(Monstre monstre) {
        if (this.montres.contains(monstre)) {
            for (Monstre elm : this.montres) {
                if (elm.equals(monstre)) {
                    return elm.getVie() > 0;
                }
            }
            System.out.println("DEBUG: Something wicked is coming.");
        }
        return true;
    }

    public Hero getHero() {
        return hero;
    }

    /**
     * Méthode pour récupérer un monstre sur le terrrain.
     */
    public Monstre recupererMonstre(Monstre monstre) {
        if (this.montres.contains(monstre)) {
            for (Monstre elm : this.montres) {
                if (elm.equals(monstre)) {
                    return elm;
                }
            }
            System.out.println("DEBUG: Something wicked is coming.");
        }
        return null;
    }

}
