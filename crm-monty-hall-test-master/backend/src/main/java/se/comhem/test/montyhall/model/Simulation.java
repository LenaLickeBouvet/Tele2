package se.comhem.test.montyhall.model;

public class Simulation {
    private final int noSimulations;
    private final int sumWins;
    private final boolean switchDoorStrategy;

    public Simulation(int sumWins, int noSimulations, boolean switchDoorStrategy) {
        this.noSimulations = noSimulations;
        this.sumWins = sumWins;
        this.switchDoorStrategy = switchDoorStrategy;
    }

    @SuppressWarnings("unused")
    public int getNoSimulations() {
        return noSimulations;
    }

    @SuppressWarnings("unused")
    public int getSumWins() {
        return sumWins;
    }

    @SuppressWarnings("unused")
    public boolean isSwitchDoorStrategy() {
        return switchDoorStrategy;
    }

}
