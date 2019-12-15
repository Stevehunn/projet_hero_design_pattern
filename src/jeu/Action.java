package jeu;

public class Action {
    protected int degatDefenceur;
    protected TypeAction typeAction;

    public Action(int degatDefenceur, TypeAction typeAction) {
        this.degatDefenceur = degatDefenceur;
        this.typeAction = typeAction;
    }

    int getDegatDefenceur() {
        return degatDefenceur;
    }

    void setTypeAction(TypeAction typeAction) {
        this.typeAction = typeAction;
    }

    TypeAction getTypeAction() {
        return typeAction;
    }
}
