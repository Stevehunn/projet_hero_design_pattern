package jeu;

public class Equipement implements BoostStat {
    private BoostStat boost;

    public Equipement(BoostStat boost) {
        this.boost = boost;
    }

    @Override
    public int renforceDefence() {
        return this.boost.renforceDefence();
    }

    @Override
    public int renforceAttaque() {
        return this.boost.renforceAttaque();
    }

    @Override
    public void placerBaseEquipement(BoostStat be) {
        boost = be;
    }
}
