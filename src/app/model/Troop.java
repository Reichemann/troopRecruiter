package app.model;

public class Troop implements Item {

    @Override
    public String toString() {
        return "troop";
    }

    @Override
    public String IdToString() {
        return "troopId";
    }

    @Override
    public String nameToString() {
        return "troopName";
    }
}