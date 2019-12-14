package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Launch extends AbstractAction {
    public Launch(String texte) {
        super(texte);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        new LabyrintheGraphique();
    }

}
