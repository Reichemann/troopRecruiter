package troopData;

public class Castle extends Item {

    //private int castleID;
    //private String castleName;

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
