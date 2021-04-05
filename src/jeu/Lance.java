package jeu;

public class Lance extends Equipement {
    public Lance(BoostStat boost) {
        super(boost);
    }

    @Override
    public int renforceAttaque() {
        return super.renforceAttaque() + 50;
    }
}
