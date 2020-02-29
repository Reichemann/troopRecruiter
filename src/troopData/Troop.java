package troopData;

public class Troop extends Item {

    //private int troopID;
    //private String troopName;

    @Override
    public String classNameToString() {
        return "troops";
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
