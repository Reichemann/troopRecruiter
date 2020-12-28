package app.model;

public class Castle implements Item {

    @Override
    public String toString() {
        return "castle";
    }

    @Override
    public String IdToString() {
        return "castleId";
    }

    @Override
    public String nameToString() {
        return "castleName";
    }
}