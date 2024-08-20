public abstract class AbstractPlayer implements Player {
    // field to store player's name
    private final String name;

    // constructor to ensure class is initialised with a name
    public AbstractPlayer(String name) {
        this.name = name;
    }

    // concrete method (all instances of Abstract player will have this method available)
    @Override
    public String returnName() {
        return name;
    }

}
