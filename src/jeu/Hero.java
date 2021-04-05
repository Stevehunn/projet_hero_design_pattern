package jeu;

import utils.Inventaire;

/**
 * Spécialisation de la Classe Entite.
 * Permet à un joueur humain de jouer.
 *
 * @see Entite
 */

public class Hero extends Entite implements Attaquer {
    private int armure;
    private Inventaire inventaire;
    private int choix;
    private BoostStat equipement;

    public Hero(String nom, int vie, int force, int armure) {
        super(nom, vie, force);
        this.armure = armure;
        this.equipement = new BaseEquipement();
    }

    void ajouterEquipement(Equipement equipement) {
        equipement.placerBaseEquipement(this.equipement);
        this.equipement = equipement;
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
        this.vie -= Math.max((action.degatDefenceur - (armure + this.equipement.renforceDefence())), 0);
        return vie <= 0;
    }

    /**
     * Méthode permettant d'effectuer un choix et ainsi de définir l'Action a effectuer.
     */
    @Override
    public Action attaquer() {
        TypeAction typeAction = TypeAction.values()[choix];
        if (typeAction == TypeAction.Attaquer)
            return new Action(force + this.equipement.renforceAttaque(), typeAction);
        else if (typeAction == TypeAction.Objet) {
            return new Action(0, typeAction);    // TODO gestion inventaire
        } else if (typeAction == TypeAction.Fuite) {
            return new Action(0, typeAction);
        }
        return null;
    }
}
