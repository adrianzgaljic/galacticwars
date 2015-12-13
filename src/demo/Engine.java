package demo;

import participants.WarParticipant;
import participants.empire.armies.B1BattleDroids;
import participants.empire.armies.ImperialRoyalGuard;
import participants.empire.armies.Siths;
import participants.empire.armies.StormTroopers;
import participants.empire.characters.DarthMaul;
import participants.empire.characters.DarthSidious;
import participants.empire.characters.DarthVader;
import participants.empire.vehicles.landvehicles.AtAt;
import participants.empire.vehicles.landvehicles.AtSt;
import participants.empire.vehicles.landvehicles.Z74SpeederBike;
import participants.empire.vehicles.spaceships.DeathStar;
import participants.empire.vehicles.spaceships.Executor;
import participants.empire.vehicles.spaceships.ImperialStarDestroyer;
import participants.rebelalliance.armies.Droideka;
import participants.rebelalliance.armies.Ewoks;
import participants.rebelalliance.armies.Jedis;
import participants.rebelalliance.armies.Wookiees;
import participants.rebelalliance.characters.LukeSkywalker;
import participants.rebelalliance.characters.ObiWanKenobi;
import participants.rebelalliance.characters.Yoda;
import participants.rebelalliance.vehicles.landvehicles.LAAT;
import participants.rebelalliance.vehicles.landvehicles.Podracer;
import participants.rebelalliance.vehicles.spaceships.Delta7BInterceptor;
import participants.rebelalliance.vehicles.spaceships.MillenniumFalcon;
import participants.rebelalliance.vehicles.spaceships.T47Airspeeder;
import participants.rebelalliance.vehicles.spaceships.T64XWing;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by adrianzgaljic on 11/12/15.
 * This is the implementation of game engine.
 * It asks for user input and then initializes armies of both sides and starts all war participants.
 *
 *
 */
public class Engine {

    private ArrayList<WarParticipant> empireCharacters = new ArrayList<>();
    private ArrayList<WarParticipant> rebelCharacters = new ArrayList<>();
    private ArrayList<WarParticipant> empireParticipants = new ArrayList<>();
    private ArrayList<WarParticipant> rebelParticipants = new ArrayList<>();
    Random random = new Random();
    int empireNo;
    int rebelNo;



    public void startWar(){

        Health.isOver = false;
        empireNo = getNumber("Imperija");
        rebelNo = getNumber("Pobunjeničkog otpora");


        if (empireNo==0 && rebelNo==0){
            System.out.println("Rat je započeo, ali nitko se nije pojavio.\nNema pobjednika!");
        } else

        if (rebelNo==0 && empireNo>0){
            initializeEmpireCharacters(empireNo);
            System.out.println("Rat je započeo.\nNa bojište su došli: ");
            for (WarParticipant empirePart:empireParticipants){
                System.out.println(empirePart.getName());
            }
            System.out.println("Ali nisu zatekli nikoga od protivničke vojske.");
            WarParticipant randomCharacter = empireCharacters.get(random.nextInt(empireCharacters.size()));
            System.out.println(randomCharacter.getName()+" je uzviknuo Huraaa pobijedili smo.");

        } else

        if (empireNo==0 && rebelNo>0){
            initializeRebelCharacters(rebelNo);
            System.out.println("Rat je započeo.\nNa bojište su došli: ");
            for (WarParticipant rebelPart:rebelParticipants){
                System.out.println(rebelPart.getName());
            }
            System.out.println("Ali nisu zatekli nikoga od protivničke vojske.");
            WarParticipant randomCharacter = rebelCharacters.get(random.nextInt(rebelCharacters.size()));
            System.out.println(randomCharacter.getName() + " je uzviknuo Huraaa pobijedili smo.");

        } else {
            initializeRebelCharacters(rebelNo);
            initializeEmpireCharacters(empireNo);
            arrangeEmpireSoldiers(empireNo - empireParticipants.size());
            arrangeRebelSoldiers(rebelNo - rebelParticipants.size());
            sendToWar(rebelParticipants);
            sendToWar(empireParticipants);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (empireParticipants.isEmpty()){
                        System.out.println("----------------------------------");
                        System.out.println("Rebel pobjedili");
                        System.out.println("pobjednička vojska:");
                        for (WarParticipant w:rebelParticipants){
                            System.out.println(w.getName()+" health: "+w.getHealth());
                        }
                        break;
                    } else if (rebelParticipants.isEmpty()){
                        System.out.println("----------------------------------");
                        System.out.println("Empire pobjeđuje");
                        System.out.println("pobjednička vojska:");
                        for (WarParticipant w:empireParticipants){
                            System.out.println(w.getName()+" health: "+w.getHealth());
                        }
                        break;
                    }
                }

            }
        }).start();


    }

    private void arrangeEmpireSoldiers(int noOfSoldiers){
        int noOfStromTroopers = (int) (noOfSoldiers*0.45);
        int noOfSiths = (int) (noOfSoldiers*0.1);
        int noOfRoyalGuards = (int) (noOfSiths*0.05);
        int noOfBattleDroids = noOfSoldiers-noOfSiths-noOfRoyalGuards-noOfStromTroopers;
        int stormTrInfantry = (int) (noOfStromTroopers*0.5);
        int stormTrCrew = noOfStromTroopers-stormTrInfantry;

        if (stormTrCrew>=20){
            System.out.println("20 Stormtroopera ulazi u Death Star");
            stormTrCrew = stormTrCrew-20;
            DeathStar deathStar = DeathStar.getInstance();
            deathStar.setHealth(10000);
            deathStar.setCrew(20);
            addEmpireParticipant(deathStar);

        }
        if (stormTrCrew>=5){
            System.out.println("5 Stormtroopera ulazi u Imperial Star Destroyer");
            stormTrCrew = stormTrCrew-5;
            ImperialStarDestroyer imperialSD = ImperialStarDestroyer.getInstance();
            imperialSD.setHealth(5000);
            imperialSD.setCrew(5);
            addEmpireParticipant(imperialSD);
        }

        int executorCrew = (int) (stormTrCrew*0.3);
        int atAtCrew = (int) (stormTrCrew*0.35);
        int atStCrew = (int) (stormTrCrew*0.25);
        int speederCrew = stormTrCrew-executorCrew-atAtCrew-atStCrew;

        if (executorCrew>0){
            System.out.println(executorCrew+" Stormtroopera pripremaju "+executorCrew+" Executor letjelica");
            Executor executorAirCrafts = Executor.getInstance();
            executorAirCrafts.setHealth(executorCrew*Health.STORM_TR);
            addEmpireParticipant(executorAirCrafts);
        }
        if (atAtCrew>0){
            //each AT-AT can take 1 or 2 Stromtroopers
            System.out.println(atAtCrew + " Stormtroopera ulaze u " + (int)Math.ceil(atAtCrew/(float)2) + " AT-AT hodaća");
            AtAt atAt = new AtAt();
            atAt.setHealth(atAtCrew*Health.STORM_TR);
            atAt.setCrew(atAtCrew);
            addEmpireParticipant(atAt);
        }
        if (atStCrew>0){
            //each AT-AT can take 1 or 2 Stromtroopers
            System.out.println(atStCrew + " Stormtroopera ulaze u " + (int)Math.ceil(atStCrew/(float)2) + " AT-ST hodaća");
            AtSt atSt = new AtSt();
            atSt.setHealth(atStCrew*Health.STORM_TR);
            atSt.setCrew(atStCrew);
            addEmpireParticipant(atSt);
        }
        if (speederCrew>0){
            System.out.println(speederCrew+" Stormtroopera sjedaju na " + speederCrew + " 74-Z Spederbikeova");
            Z74SpeederBike speederBikes = new Z74SpeederBike();
            speederBikes.setHealth(speederCrew*Health.STORM_TR);
            addEmpireParticipant(speederBikes);

        }

        if (stormTrInfantry>0){
            StormTroopers stormTroopers = StormTroopers.getInstance();
            stormTroopers.setHealth(stormTrInfantry*Health.STORM_TR);
            addEmpireParticipant(stormTroopers);
            System.out.println("Podignuta vojska od "+stormTrInfantry+" Stormtroopera");
        }

        if (noOfSiths>0){
            Siths siths = Siths.getInstance();
            siths.setHealth(noOfSiths*Health.SITHS);
            addEmpireParticipant(siths);
            System.out.println("Vojska "+noOfSiths+" zla Sitha je spremna na rat");
        }

        if (noOfBattleDroids>0){
            B1BattleDroids battleDroids = B1BattleDroids.getInstance();
            battleDroids.setHealth(noOfBattleDroids*Health.B1_BATTLE_DROID);
            addEmpireParticipant(battleDroids);
            System.out.println("Vojska "+noOfBattleDroids+" B1 battle droida spremna je na rat");
        }

        if (noOfRoyalGuards>0){
            ImperialRoyalGuard royalGuard = ImperialRoyalGuard.getInstance();
            royalGuard.setHealth(noOfRoyalGuards*Health.IMPERIAL_GUARD);
            addEmpireParticipant(royalGuard);
            System.out.println(noOfRoyalGuards+ " člana royalne garde spremno je braniti Imperij");
        }



    }

    private void arrangeRebelSoldiers(int noOfSoldiers){
        int noOfWookiees = (int) (noOfSoldiers*0.3);
        int noOfEwoks = (int) (noOfSoldiers*0.3);
        int noOfJedis = (int) (noOfSoldiers*0.10);
        int noOFDroideka = noOfSoldiers-noOfEwoks-noOfJedis;
        int wookieeCrew = (int) (noOfWookiees*0.4);
        int wookieeInfantry = noOfWookiees-wookieeCrew;

        if (wookieeCrew>=15){
            System.out.println("20 Wookieea ulazi u Millennium Falcon");
            wookieeCrew = wookieeCrew-15;
            MillenniumFalcon millenniumFalcon = MillenniumFalcon.getInstance();
            millenniumFalcon.setHealth(5000);
            millenniumFalcon.setCrew(15);
            addRebelParticipant(millenniumFalcon);
        }

        for (int i=1; i<4; i++){
            if (wookieeCrew<3){
                break;
            }
            System.out.println("3 Wookieea ulazi u T-65X Wing "+i);
            wookieeCrew = wookieeCrew-3;
            T64XWing t64XWing = new T64XWing("T-65X Wing "+i);
            t64XWing.setHealth(500);
            t64XWing.setCrew(3);
            addRebelParticipant(t64XWing);

        }
        int deltaCrew = (int) (wookieeCrew*0.3);
        int t47Crew = (int) (wookieeCrew * 0.35);
        int laatCrew = (int) (wookieeCrew * 0.25);
        int podracerCrew= wookieeCrew-deltaCrew-t47Crew-laatCrew;

        if (deltaCrew>0){
            Delta7BInterceptor delta7BInterceptor = new Delta7BInterceptor();
            delta7BInterceptor.setHealth(deltaCrew*Health.WOOKIEES);
            delta7BInterceptor.setCrew(deltaCrew);
            addRebelParticipant(delta7BInterceptor);
            System.out.println(deltaCrew+" Delta 7B Interceptora spremno");
        }

        if (t47Crew>0){
            T47Airspeeder t47Airspeeder = new T47Airspeeder();
            t47Airspeeder.setHealth(t47Crew*Health.WOOKIEES);
            t47Airspeeder.setCrew(t47Crew);
            addRebelParticipant(t47Airspeeder);
            System.out.println(t47Crew+" T-47 Airspeedera spremno");
        }

        if (laatCrew>0){
            LAAT laat = new LAAT();
            laat.setHealth(laatCrew * Health.WOOKIEES);
            laat.setCrew(laatCrew);
            addRebelParticipant(laat);
            System.out.println(laatCrew+ "Wookiee ulazi u LAAT/i transportera");
        }

        if (podracerCrew>0){
            Podracer podracer = new Podracer();
            podracer.setHealth(podracerCrew*Health.WOOKIEES);
            podracer.setCrew(podracerCrew);
            addRebelParticipant(podracer);
            System.out.println(podracerCrew+" Wookiee ulazi u Podracere");
        }

        if (wookieeInfantry>0){
            Wookiees wookiees = Wookiees.getInstance();
            wookiees.setHealth(wookieeInfantry*Health.WOOKIEES);
            addRebelParticipant(wookiees);
            System.out.println("Podignuta vojska od " + wookieeInfantry + " Wookiee");
        }

        if (noOfJedis>0){
            Jedis jedis = Jedis.getInstance();
            jedis.setHealth(noOfJedis*Health.JEDIS);
            addRebelParticipant(jedis);
            System.out.println("U rat krenulo "+noOfJedis+" Jedija");
        }

        if (noOfEwoks>0){
            Ewoks ewoks = Ewoks.getInstance();
            ewoks.setHealth(noOfEwoks*Health.EWOKS);
            addRebelParticipant(ewoks);
            System.out.println(noOfEwoks+" Ewoka spremo na borbu");
        }

        if(noOFDroideka>0){
            Droideka droideka = Droideka.getInstance();
            droideka.setHealth(noOFDroideka*Health.DROIDEKA);
            addRebelParticipant(droideka);
            System.out.println(noOFDroideka+" Droideka spremno");

        }





    }


    /**
     * Method which asks for user input until positive number is given.
     * @param army name of army
     * @return number of soldiers
     */
    private int getNumber(String army){
        int n=-1;
        Scanner scan;
        while(n<0){
            System.out.println("Unesi broj vojnika "+army);
            try{
                scan = new Scanner(System.in);
                n=scan.nextInt();
            }catch(Exception e){
                System.err.println(e + " while user input");
            }
            if (n<0){
                System.out.println("Unesi pozitivan broj");
            }
        }
        return n;

    }

    private void initializeEmpireCharacters(int n){

        if (n>0){
            DarthVader darthVader = DarthVader.getInstance();
            darthVader.setHealth(Health.DARTH_VADER);
            addEmpireCharacter(darthVader);
        }
        if (n>1){
            DarthSidious darthSidious = DarthSidious.getInstance();
            darthSidious.setHealth(Health.DARTH_SIDIOUS);
            addEmpireCharacter(darthSidious);
        }
        if (n>2){
            DarthMaul darthMaul = DarthMaul.getInstance();
            darthMaul.setHealth(Health.DARTH_MAUL);
            addEmpireCharacter(darthMaul);
        }

    }

    private void initializeRebelCharacters(int n){

        if (n>0){
            LukeSkywalker lukeSkywalker = LukeSkywalker.getInstance();
            lukeSkywalker.setHealth(Health.LUKE);
            addRebelCharacter(lukeSkywalker);
        }
        if (n>1){
            Yoda yoda = Yoda.getInstance();
            yoda.setHealth(Health.YODA);
            addRebelCharacter(yoda);

        }
        if (n>2){
            ObiWanKenobi obiWanKenobi = ObiWanKenobi.getInstance();
            obiWanKenobi.setHealth(Health.OBI_WAN);
            addRebelCharacter(obiWanKenobi);
        }

    }



    private  void addEmpireCharacter(WarParticipant character){
        character.setEnemyParticipants(rebelParticipants);
        empireCharacters.add(character);
        empireParticipants.add(character);
    }

    private void addRebelCharacter(WarParticipant character){
        character.setEnemyParticipants(empireParticipants);
        rebelCharacters.add(character);
        rebelParticipants.add(character);
    }

    private void addEmpireParticipant(WarParticipant participant){
        participant.setEnemyParticipants(rebelParticipants);
        empireParticipants.add(participant);
    }

    private void addRebelParticipant(WarParticipant participant){
        participant.setEnemyParticipants(empireParticipants);
        rebelParticipants.add(participant);
    }

    private void sendToWar(ArrayList<WarParticipant> warParticipants) {
        for (WarParticipant participant:warParticipants){
            new Thread(participant).start();
        }
    }





}
