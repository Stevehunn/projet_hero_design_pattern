package jeu;

import utils.Inventaire;

/**
 * Spécialisation de la Classe Entite.
 * Permet à un joueur humain de jouer.
 *
 * @see Entite
 */

public class Hero extends Entite {
    private int armure;
    private Inventaire inventaire;
    private int choix;

    public Hero(String nom, int vie, int force, int armure) {
        super(nom, vie, force);
        this.armure = armure;
    }

    void setChoix(int choix) {
        this.choix = choix;
    }

    /**
     * Méthode pour réduire la vie de l'entite qui a subit une attaque.
     *
     * @param action valeur des dégats a infliger .
     * @return retourne la vie de l'entite qui a subit l'action.
     */
    @Override
    public boolean subirAction(Action action) {
        this.vie -= Math.max((action.degatDefenceur - armure), 0);
        return vie <= 0;
    }

    /**
     * Méthode permettant d'effectuer un choix et ainsi de définir l'Action a effectuer.
     */
    @Override
    public Action infligerAction() {
        TypeAction typeAction = TypeAction.values()[choix];
        if (typeAction == TypeAction.Attaquer)
            return new Action(force, typeAction);
        else if (typeAction == TypeAction.Objet) {
            return new Action(0, typeAction);    // TODO gestion inventaire
        } else if (typeAction == TypeAction.Fuite) {
            return new Action(0, typeAction);
        }
        return null;
    }
}
