package demo;

import participants.WarParticipant;
import participants.empire.armies.StormTroopers;
import participants.empire.characters.DarthSidious;
import participants.empire.vehicles.spaceships.DeathStar;
import participants.rebelalliance.characters.LukeSkywalker;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by adrianzgaljic on 09/12/15.
 */
public class Demo {

    public static void main(String args[]){
     /*   ArrayList<WarParticipant> empireParticipants = new ArrayList<>();
        ArrayList<WarParticipant> rebelParticipants = new ArrayList<>();


        DarthSidious darthVader = DarthSidious.getInstance();
        darthVader.setId(UUID.randomUUID().toString());
        darthVader.setEnemyParticipants(rebelParticipants);
        empireParticipants.add(darthVader);


        LukeSkywalker lukeSkywalker = LukeSkywalker.getInstance();
        lukeSkywalker.setId(UUID.randomUUID().toString());
        lukeSkywalker.setEnemyParticipants(empireParticipants);
        rebelParticipants.add(lukeSkywalker);

        StormTroopers stormTroopers = StormTroopers.getInstance();
        stormTroopers.setId(UUID.randomUUID().toString());
        stormTroopers.setEnemyParticipants(rebelParticipants);
        empireParticipants.add(stormTroopers);
        DeathStar deathStar = DeathStar.getInstance();
        deathStar.setId(UUID.randomUUID().toString());
        deathStar.setEnemyParticipants(rebelParticipants);
        empireParticipants.add(deathStar);

        darthVader.setHealth(1000);
        lukeSkywalker.setHealth(10000);
        stormTroopers.setHealth(50*10);
        deathStar.setHealth(5000);
        new Thread(lukeSkywalker).start();
        new Thread(darthVader).start();
        new Thread(stormTroopers).start();
        new Thread(deathStar).start();
*/
        Engine engine = new Engine();
        engine.startWar();






    }

}
