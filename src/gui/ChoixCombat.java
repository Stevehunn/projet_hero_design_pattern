package gui;

import javax.swing.*;

public class ChoixCombat extends JDialog {
    private int typeAction;

    public ChoixCombat(LabyrintheGraphique labyrintheGraphique, ModalityType applicationModal) {
        super(labyrintheGraphique, applicationModal);
    }

    public int getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(int typeAction) {
        this.typeAction = typeAction;
    }
}

