package app.model;

public class Troop implements Item {

    @Override
    public String toString() {
        return "troop";
    }

    @Override
    public String IDToString() {
        return "troopID";
    }

    @Override
    public String nameToString() {
        return "troopName";
    }
}