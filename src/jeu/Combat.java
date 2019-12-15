package jeu;

import gui.LabyrintheGraphique;

/**
 * Méthode pour séquencer les combats.
 */
public class Combat {
    private Hero hero;
    private Monstre monstre;
    private boolean combatTermine;
    private Entite gagnant;

    /**
     * Méthode pour initialiser le combat entre le héros et le monstre.
     */
    public Combat(Hero hero, Monstre monstre) {
        this.hero = hero;
        this.monstre = monstre;
        combatTermine = false;
        gagnant = null;
    }

    /**
     * Méthode pour séquencer le tour du joueur.
     */
    private void phaseJoueur(LabyrintheGraphique labyrintheGraphique) {
        if (hero.getVie() > 0 && !combatTermine) {
            hero.setChoix(labyrintheGraphique.showDialogChoixCombat(hero.getVie(), monstre.getVie()));
            Action action = hero.infligerAction();
            if (action.getTypeAction() == TypeAction.Fuite) {
                combatTermine = true;
            }
            if (monstre.subirAction(action)) {
                combatTermine = true;
                gagnant = hero;
            }
        }
    }

    /**
     * Méthode pour séquencer le tour du monstre.
     */
    private void phaseMonstre() {
        if (monstre.getVie() > 0 && !combatTermine) {
            if (hero.subirAction(monstre.infligerAction())) {
                combatTermine = true;
                gagnant = monstre;
            }
        }
    }

    /**
     * Méthode pour terminer le combat et retourner le gagnant.
     */
    public Entite run(LabyrintheGraphique labyrintheGraphique) {
        while (!combatTermine) {
            phaseJoueur(labyrintheGraphique);
            phaseMonstre();
        }
        return gagnant;
    }

}