package jeu;

public class Armure extends Equipement {
    Armure(BoostStat boost) {
        super(boost);
    }

    @Override
    public int renforceDefence() {
        return super.renforceDefence() + 50;
    }
}
