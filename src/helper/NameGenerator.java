package helper;

import GameObjects.PlayerName;

import java.util.ArrayList;
import java.util.List;

/**
 * NameGenerator is used for generating player names randomly (primarily for youth players who join the team)
 */
public class NameGenerator {
    private List<String> firstNames;
    private List<String> lastNames;

    public NameGenerator() {
        initFirstNames();
        initLastNames();
    }

    public PlayerName getRandomName() {
        //get random name from firstnames
        //get random name from lastnames
        //return as PlayerName instance
        return null;
    }

    private void initFirstNames() {
        firstNames = new ArrayList<>();

        // -----   A   -----
        firstNames.add("Ahmad");
        firstNames.add("Ahmed");
        firstNames.add("Albert");
        firstNames.add("Alejandro");
        firstNames.add("Aleksandar");
        firstNames.add("Alessandro");
        firstNames.add("Alex");
        firstNames.add("Alexander");
        firstNames.add("Alfons");
        firstNames.add("Alfred");
        firstNames.add("Amin");
        firstNames.add("Amir");
        firstNames.add("Andreas");
        firstNames.add("Andrew");
        firstNames.add("André");
        firstNames.add("Andriy");
        firstNames.add("Andy");
        firstNames.add("Anthony");
        firstNames.add("Antoine");
        firstNames.add("Anton");
        firstNames.add("Armin");
        firstNames.add("Arnold");
        firstNames.add("Ashley");
        firstNames.add("Atakan");
        firstNames.add("Axel");

        // -----   B   -----

        firstNames.add("Bastian");
        firstNames.add("Ben");
        firstNames.add("Benjamin");
        firstNames.add("Bernard");
        firstNames.add("Bernd");
        firstNames.add("Bernhard");
        firstNames.add("Bob");
        firstNames.add("Boban");
        firstNames.add("Bobby");
        firstNames.add("Bogdan");
        firstNames.add("Bojan");
        firstNames.add("Branislav");
        firstNames.add("Bruno");
        firstNames.add("Bülent");

        // -----   C   -----

        firstNames.add("Cameron");
        firstNames.add("Cem");
        firstNames.add("Charles");
        firstNames.add("Charlie");
        firstNames.add("Chris");
        firstNames.add("Christian");
        firstNames.add("Christoph");
        firstNames.add("Christopher");
        firstNames.add("Cican");
        firstNames.add("Cody");
        firstNames.add("Conrad");
        firstNames.add("Cory");

        // -----   D   -----

        firstNames.add("Damien");
        firstNames.add("Dan");
        firstNames.add("Daniel");
        firstNames.add("Danny");
        firstNames.add("David");
        firstNames.add("Dawid");
        firstNames.add("Dejan");
        firstNames.add("Dimitri");
        firstNames.add("Domenic");
        firstNames.add("Domenik");
        firstNames.add("Dominic");
        firstNames.add("Dominik");
        firstNames.add("Dusan");

        // -----   E   -----

        firstNames.add("Eirik");
        firstNames.add("Elias");
        firstNames.add("Emil");
        firstNames.add("Enrico");
        firstNames.add("Eric");
        firstNames.add("Erik");

        // -----   F   -----

        firstNames.add("Farid");
        firstNames.add("Ferhat");
        firstNames.add("Frantisek");
        firstNames.add("Franz");
        firstNames.add("Fred");
        firstNames.add("Freddy");
        firstNames.add("Frederick");
        firstNames.add("Frederik");
        firstNames.add("Fredrick");
        firstNames.add("Fredrik");
        firstNames.add("Friedrich");
        firstNames.add("Fritz");

        // -----   G   -----

        firstNames.add("Gabriel");
        firstNames.add("Georg");
        firstNames.add("George");
        firstNames.add("Gerald");
        firstNames.add("Gerhard");
        firstNames.add("Gianluigi");
        firstNames.add("Gianni");
        firstNames.add("Giorgio");
        firstNames.add("Giovanni");
        firstNames.add("Gisbert");
        firstNames.add("Giselbert");
        firstNames.add("Giuseppe");
        firstNames.add("Greg");
        firstNames.add("Gregor");
        firstNames.add("Gregory");
        firstNames.add("Gunnar");
        firstNames.add("Gunther");
        firstNames.add("Gus");
        firstNames.add("Gustaf");
        firstNames.add("Gustav");
        firstNames.add("Gustavo");
        firstNames.add("Günter");
        firstNames.add("Günther");
        firstNames.add("Gylfi");

        // -----   H   -----

        firstNames.add("Hannes");
        firstNames.add("Hans");
        firstNames.add("Harald");
        firstNames.add("Harry");
        firstNames.add("Hasan");
        firstNames.add("Heinrich");
        firstNames.add("Heinz");
        firstNames.add("Herbert");

        // -----   I   -----

        firstNames.add("Ibo");
        firstNames.add("Ibrahim");
        firstNames.add("Ignaz");
        firstNames.add("Igor");
        firstNames.add("Irving");
        firstNames.add("Isaac");
        firstNames.add("Isak");
        firstNames.add("Isidor");
        firstNames.add("Ivan");
        firstNames.add("Iwan");

        // -----   J   -----

        firstNames.add("James");
        firstNames.add("Jan");
        firstNames.add("Janek");
        firstNames.add("Janos");
        firstNames.add("Jerry");
        firstNames.add("Jim");
        firstNames.add("Jimmy");
        firstNames.add("Johann");
        firstNames.add("Johannes");
        firstNames.add("John");
        firstNames.add("Johnny");
        firstNames.add("Jon");
        firstNames.add("Jonas");
        firstNames.add("Jón");
        firstNames.add("Julian");

        // -----   K   -----

        firstNames.add("Karl");
        firstNames.add("Kevin");
        firstNames.add("Kim");
        firstNames.add("Klaus");
        firstNames.add("Konrad");
        firstNames.add("Kris");
        firstNames.add("Kristian");
        firstNames.add("Kristijan");
        firstNames.add("Kristof");
        firstNames.add("Kristoff");
        firstNames.add("Kristoffer");

        // -----   L   -----

        firstNames.add("Larry");
        firstNames.add("Lars");
        firstNames.add("Lasse");
        firstNames.add("Lothar");
        firstNames.add("Luca");
        firstNames.add("Lucas");
        firstNames.add("Lucky");
        firstNames.add("Ludger");
        firstNames.add("Ludvig");
        firstNames.add("Ludwig");
        firstNames.add("Luigi");
        firstNames.add("Luka");
        firstNames.add("Lukas");

        // -----   M   -----

        // -----   N   -----

        // -----   O   -----

        // -----   P   -----


        //only for test!!!
        System.out.println(firstNames.size() + " first names registered.");
    }

    private void initLastNames() {
        lastNames = new ArrayList<>();

        // -----   A   -----

        lastNames.add("Anzengruber");
        lastNames.add("Arnold");
        lastNames.add("Ash");
        lastNames.add("Ashton");
        lastNames.add("Asimov");
        lastNames.add("Auer");
        lastNames.add("Auhofer");
        lastNames.add("Aumaier");
        lastNames.add("Aursnes");

        // -----   F   -----

        lastNames.add("Frank");

        // -----   S   -----

        lastNames.add("Sahle");
        lastNames.add("Sahler");
        lastNames.add("Salah");
        lastNames.add("Sané");
        lastNames.add("Schindlegger");
        lastNames.add("Schlecht");
        lastNames.add("Schleich");
        lastNames.add("Schmid");
        lastNames.add("Schmidbauer");
        lastNames.add("Schmidt");
        lastNames.add("Schmitt");
        lastNames.add("Schmitz");
        lastNames.add("Schwarz");
        lastNames.add("Schwarzbauer");
        lastNames.add("Smith");


        //only for test!!!
        System.out.println(lastNames.size() + " last names registered.");
        System.out.println(firstNames.size() + " x " + lastNames.size() + " = " + (firstNames.size() * lastNames.size()) + " possible different names!");
    }
}
