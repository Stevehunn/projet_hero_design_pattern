package jeu;

public class Action {
    protected int regenLanceur;
    protected int degatDefenceur;
    protected TypeAction typeAction;

    public Action(int regenLanceur, int degatDefenceur, TypeAction typeAction) {
        this.regenLanceur = regenLanceur;
        this.degatDefenceur = degatDefenceur;
        this.typeAction = typeAction;
    }

    int getDegatDefenceur() {
        return degatDefenceur;
    }

    void setRegenLanceur(int regenLanceur) {
        this.regenLanceur = regenLanceur;
    }

    void setTypeAction(TypeAction typeAction) {
        this.typeAction = typeAction;
    }
}
