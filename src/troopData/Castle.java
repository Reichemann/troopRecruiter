package troopData;

public class Castle implements Item {

    @Override
    public String classNameToString() {
        return "castles";
    }

    @Override
    public String IDToString() {
        return "castleID";
    }

    @Override
    public String nameToString() {
        return "castleName";
    }
}
