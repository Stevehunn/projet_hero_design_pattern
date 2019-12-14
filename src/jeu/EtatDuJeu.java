package jeu;

import java.util.HashSet;

public class EtatDuJeu {
    private Hero hero;
    private HashSet<Monstre> montres;

    public EtatDuJeu(Hero hero, HashSet<Monstre> monstres) {
        this.hero = hero;
        if (monstres != null && !monstres.isEmpty()) {
            this.montres = monstres;
        } else {
            this.montres = new HashSet<Monstre>();
        }
    }

    public void ajouterMonstre(Monstre monstre) {
        this.montres.add(monstre);
    }
}
