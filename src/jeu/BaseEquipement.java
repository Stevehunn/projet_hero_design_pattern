package jeu;

public class BaseEquipement implements BoostStat {

    @Override
    public int renforceDefence() {
        return 0;
    }

    @Override
    public int renforceAttaque() {
        return 0;
    }

    @Override
    public void placerBaseEquipement(BoostStat be) {
    }
}
