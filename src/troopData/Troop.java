package troopData;

public class Troop implements Item {

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
