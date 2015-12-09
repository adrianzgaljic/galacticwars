package participants.empire.characters;

import participants.WarParticipant;

/**
 * Created by adrianzgaljic on 09/12/15.
 * DarthVader is singleton class which represents despicable Sith Darth Vader
 */
public class DarthVader implements WarParticipant{

    /**
     * randomly generated unique identification number
     * id is generated outside this class
     */
    private String id;


    /**
     * name of character
     */
    private final String name = "Darth Vader";

    /**
     * only instance of DarthVader class
     */
    private static DarthVader darthVader = new DarthVader();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private DarthVader(){}

    /**
     * getter for id
     * @return id
     */
    public String getId() {
        return id;
    }


    /**
     * setter for id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getter for name
     * @return character name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for only instance of DartVader class
     * @return DarthVader instance
     */
    public static DarthVader getInstance(){
        return darthVader;
    }


    @Override
    public void attack() {

    }

    @Override
    public void defend() {

    }
}
