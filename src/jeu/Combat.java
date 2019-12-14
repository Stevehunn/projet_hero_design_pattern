package jeu;

public class Combat {
    private int numTours;
    private Entite hero;
    private Entite monstre;
    private boolean combatTermine;
    private Entite gagnant;

    public Combat(Hero hero, Monstre monstre) {
        this.hero = hero;
        this.monstre = monstre;
        numTours = 0;
        combatTermine = false;
        gagnant = null;
    }

    private void phaseJoueur() {
        if (hero.getVie() > 0) {
            if (monstre.subirAction(hero.infligerAction())) {
                combatTermine = true;
                gagnant = hero;
            }
        }
    }

    private void phaseMonstre() {
        if (monstre.getVie() > 0) {
            if (hero.subirAction(monstre.infligerAction())) {
                combatTermine = true;
                gagnant = monstre;
            }
        }
    }

    public Entite run() {
        while (!combatTermine) {
            phaseJoueur();
            phaseMonstre();
        }
        return gagnant;
    }

}