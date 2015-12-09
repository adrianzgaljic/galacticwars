package demo;

import participants.WarParticipant;
import participants.empire.characters.DarthVader;
import participants.rebelalliance.LukeSkywalker;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by adrianzgaljic on 09/12/15.
 */
public class Demo {

    public static void main(String args[]){
        ArrayList<WarParticipant> empireParticipants = new ArrayList<>();
        ArrayList<WarParticipant> rebelParticipants = new ArrayList<>();

        DarthVader darthVader = DarthVader.getInstance();
        darthVader.setId(UUID.randomUUID().toString());
        empireParticipants.add(darthVader);

        LukeSkywalker lukeSkywalker = LukeSkywalker.getInstance();
        lukeSkywalker.setId(UUID.randomUUID().toString());
        rebelParticipants.add(lukeSkywalker);




    }

}
