package participants.rebelalliance;

import participants.WarParticipant;

/**
 * Created by adrianzgaljic on 09/12/15.
 * LukeSkywalker is singleton class which represents Jedi Luke Skywalker
 */
public class LukeSkywalker implements WarParticipant {

    /**
     * randomly generated unique identification number
     * id is generated outside this class
     */
    private String id;


    /**
     * name of character
     */
    private final String name = "Luke Skywalker";

    /**
     * only instance of LukeSkywalker  class
     */
    private static  LukeSkywalker lukeSkywalker  = new LukeSkywalker();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private LukeSkywalker(){}

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
     * getter for only instance of LukeSkywalker  class
     * @return LukeSkywalker instance
     */
    public static LukeSkywalker getInstance(){
        return lukeSkywalker;
    }


    @Override
    public void attack() {

    }

    @Override
    public void defend() {

    }
}
