package helper;

import GameObjects.PlayerName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        Random rand = new Random(System.nanoTime());
        String first = firstNames.get(rand.nextInt(firstNames.size()));
        String last = lastNames.get(rand.nextInt(lastNames.size()));
        return new PlayerName(first, last);
    }

    private void initFirstNames() {
        firstNames = new ArrayList<>();

        // -----   A   -----

        firstNames.add("Adam");
        firstNames.add("Ahmad");
        firstNames.add("Ahmed");
        firstNames.add("Albert");
        firstNames.add("Albin");
        firstNames.add("Alvin");
        firstNames.add("Alwin");
        firstNames.add("Alejandro");
        firstNames.add("Aleksandar");
        firstNames.add("Alessandro");
        firstNames.add("Alex");
        firstNames.add("Alexander");
        firstNames.add("Alfons");
        firstNames.add("Alfred");
        firstNames.add("Alois");
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
        firstNames.add("Benedict");
        firstNames.add("Benedikt");
        firstNames.add("Benjamin");
        firstNames.add("Bernard");
        firstNames.add("Bernd");
        firstNames.add("Bernhard");
        firstNames.add("Bert");
        firstNames.add("Birger");
        firstNames.add("Bob");
        firstNames.add("Boban");
        firstNames.add("Bobby");
        firstNames.add("Bogdan");
        firstNames.add("Bojan");
        firstNames.add("Boris");
        firstNames.add("Borislav");
        firstNames.add("Brandon");
        firstNames.add("Branislav");
        firstNames.add("Bruno");
        firstNames.add("Bülent");

        // -----   C   -----

        firstNames.add("Cameron");
        firstNames.add("Carl");
        firstNames.add("Carlos");
        firstNames.add("Cem");
        firstNames.add("Charles");
        firstNames.add("Charlie");
        firstNames.add("Chris");
        firstNames.add("Christian");
        firstNames.add("Christoph");
        firstNames.add("Christopher");
        firstNames.add("Cican");
        firstNames.add("Claude");
        firstNames.add("Cody");
        firstNames.add("Conrad");
        firstNames.add("Cory");

        // -----   D   -----

        firstNames.add("Damien");
        firstNames.add("Dan");
        firstNames.add("Daniel");
        firstNames.add("Danny");
        firstNames.add("Dario");
        firstNames.add("Darius");
        firstNames.add("David");
        firstNames.add("Dawid");
        firstNames.add("Dejan");
        firstNames.add("Didi");
        firstNames.add("Dieter");
        firstNames.add("Dietrich");
        firstNames.add("Dimitri");
        firstNames.add("Domenic");
        firstNames.add("Domenik");
        firstNames.add("Dominic");
        firstNames.add("Dominik");
        firstNames.add("Don");
        firstNames.add("Donald");
        firstNames.add("Donny");
        firstNames.add("Dusan");

        // -----   E   -----

        firstNames.add("Ed");
        firstNames.add("Eddie");
        firstNames.add("Eddy");
        firstNames.add("Edi");
        firstNames.add("Eduard");
        firstNames.add("Egon");
        firstNames.add("Eirik");
        firstNames.add("Elias");
        firstNames.add("Emil");
        firstNames.add("Emilio");
        firstNames.add("Enrico");
        firstNames.add("Eric");
        firstNames.add("Erik");
        firstNames.add("Ervin");
        firstNames.add("Erwin");
        firstNames.add("Eugene");
        firstNames.add("Ewald");

        // -----   F   -----

        firstNames.add("Fabian");
        firstNames.add("Farid");
        firstNames.add("Felix");
        firstNames.add("Ferdinand");
        firstNames.add("Ferhat");
        firstNames.add("Fernando");
        firstNames.add("Florian");
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
        firstNames.add("Gene");
        firstNames.add("Gianluigi");
        firstNames.add("Gianni");
        firstNames.add("Gilbert");
        firstNames.add("Giorgio");
        firstNames.add("Giovanni");
        firstNames.add("Gisbert");
        firstNames.add("Giselbert");
        firstNames.add("Giuseppe");
        firstNames.add("Greg");
        firstNames.add("Gregor");
        firstNames.add("Gregory");
        firstNames.add("Grzegorz");
        firstNames.add("Guido");
        firstNames.add("Gunnar");
        firstNames.add("Gunther");
        firstNames.add("Gus");
        firstNames.add("Gustaf");
        firstNames.add("Gustav");
        firstNames.add("Gustavo");
        firstNames.add("Günter");
        firstNames.add("Günther");
        firstNames.add("Gylfi");
        firstNames.add("György");

        // -----   H   -----

        firstNames.add("Hannes");
        firstNames.add("Hans");
        firstNames.add("Harald");
        firstNames.add("Harry");
        firstNames.add("Hasan");
        firstNames.add("Heinrich");
        firstNames.add("Heinz");
        firstNames.add("Herbert");
        firstNames.add("Heribert");
        firstNames.add("Herman");
        firstNames.add("Hermann");
        firstNames.add("Herrmann");
        firstNames.add("Hugo");

        // -----   I   -----

        firstNames.add("Ibo");
        firstNames.add("Ibrahim");
        firstNames.add("Ignaz");
        firstNames.add("Igor");
        firstNames.add("Ion");
        firstNames.add("Irving");
        firstNames.add("Isaac");
        firstNames.add("Isak");
        firstNames.add("Isidor");
        firstNames.add("Islam");
        firstNames.add("Ivan");
        firstNames.add("Iwan");

        // -----   J   -----

        firstNames.add("Jack");
        firstNames.add("James");
        firstNames.add("Jan");
        firstNames.add("Janek");
        firstNames.add("Janos");
        firstNames.add("Jerry");
        firstNames.add("Jim");
        firstNames.add("Jimmy");
        firstNames.add("Joe");
        firstNames.add("Joey");
        firstNames.add("Johann");
        firstNames.add("Johannes");
        firstNames.add("John");
        firstNames.add("Johnny");
        firstNames.add("Jon");
        firstNames.add("Jonas");
        firstNames.add("Jón");
        firstNames.add("Jörg");
        firstNames.add("Julian");
        firstNames.add("Jürgen");

        // -----   K   -----

        firstNames.add("Karl");
        firstNames.add("Kevin");
        firstNames.add("Kilian");
        firstNames.add("Killian");
        firstNames.add("Kim");
        firstNames.add("Klaus");
        firstNames.add("Konrad");
        firstNames.add("Kris");
        firstNames.add("Kristian");
        firstNames.add("Kristijan");
        firstNames.add("Kristof");
        firstNames.add("Kristoff");
        firstNames.add("Kristoffer");
        firstNames.add("Kylian");

        // -----   L   -----

        firstNames.add("Ladislav");
        firstNames.add("Ladislaw");
        firstNames.add("Larry");
        firstNames.add("Lars");
        firstNames.add("Lasse");
        firstNames.add("Leeroy");
        firstNames.add("Leif");
        firstNames.add("Leifur");
        firstNames.add("Leo");
        firstNames.add("Leon");
        firstNames.add("Leopold");
        firstNames.add("Leroy");
        firstNames.add("Lewis");
        firstNames.add("Lion");
        firstNames.add("Logan");
        firstNames.add("Lothar");
        firstNames.add("Luca");
        firstNames.add("Lucas");
        firstNames.add("Lucky");
        firstNames.add("Ludger");
        firstNames.add("Ludvig");
        firstNames.add("Ludwig");
        firstNames.add("Luigi");
        firstNames.add("Luis");
        firstNames.add("Luka");
        firstNames.add("Lukas");
        firstNames.add("Lutz");

        // -----   M   -----

        firstNames.add("Mahmoud");
        firstNames.add("Mahmut");
        firstNames.add("Maks");
        firstNames.add("Maksimilian");
        firstNames.add("Manfred");
        firstNames.add("Manuel");
        firstNames.add("Marc");
        firstNames.add("Marcel");
        firstNames.add("Marco");
        firstNames.add("Marcus");
        firstNames.add("Mario");
        firstNames.add("Marius");
        firstNames.add("Mark");
        firstNames.add("Marko");
        firstNames.add("Markus");
        firstNames.add("Masahiro");
        firstNames.add("Matias");
        firstNames.add("Mats");
        firstNames.add("Matt");
        firstNames.add("Matthew");
        firstNames.add("Matthias");
        firstNames.add("Matthijs");
        firstNames.add("Mattias");
        firstNames.add("Max");
        firstNames.add("Maxi");
        firstNames.add("Maximilian");
        firstNames.add("Maxwell");
        firstNames.add("Merlin");
        firstNames.add("Mert");
        firstNames.add("Mesut");
        firstNames.add("Michael");
        firstNames.add("Miikka");
        firstNames.add("Mika");
        firstNames.add("Mike");
        firstNames.add("Mohamed");
        firstNames.add("Mohammed");
        firstNames.add("Moritz");
        firstNames.add("Muhamed");
        firstNames.add("Muhammad");
        firstNames.add("Muhammed");
        firstNames.add("Muhamet");
        firstNames.add("Muhammet");
        firstNames.add("Murat");

        // -----   N   -----

        firstNames.add("Niclas");
        firstNames.add("Nick");
        firstNames.add("Nico");
        firstNames.add("Niklas");
        firstNames.add("Nino");
        firstNames.add("Norbert");
        firstNames.add("Nusret");

        // -----   O   -----

        firstNames.add("Olaf");
        firstNames.add("Ólafur");
        firstNames.add("Onur");
        firstNames.add("Oscar");
        firstNames.add("Oskar");
        firstNames.add("Oskari");

        // -----   P   -----

        firstNames.add("Pablo");
        firstNames.add("Paolo");
        firstNames.add("Patric");
        firstNames.add("Patrick");
        firstNames.add("Patrik");
        firstNames.add("Paul");
        firstNames.add("Paulo");
        firstNames.add("Pavel");
        firstNames.add("Pawel");
        firstNames.add("Pál");
        firstNames.add("Pekka");
        firstNames.add("Pete");
        firstNames.add("Peter");
        firstNames.add("Petteri");
        firstNames.add("Piet");
        firstNames.add("Przemyslaw");

        // -----   Q   -----

        // -----   R   -----

        firstNames.add("Ralf");
        firstNames.add("Ralph");
        firstNames.add("Randolph");
        firstNames.add("René");
        firstNames.add("Richard");
        firstNames.add("Rob");
        firstNames.add("Robbie");
        firstNames.add("Robert");
        firstNames.add("Roberto");
        firstNames.add("Robin");
        firstNames.add("Rolf");
        firstNames.add("Rolph");
        firstNames.add("Ron");
        firstNames.add("Ronald");
        firstNames.add("Rowan");
        firstNames.add("Ruben");
        firstNames.add("Rubens");
        firstNames.add("Rudolf");
        firstNames.add("Rudolph");

        // -----   S   -----

        firstNames.add("Sam");
        firstNames.add("Samir");
        firstNames.add("Sandro");
        firstNames.add("Sean");
        firstNames.add("Sebastian");
        firstNames.add("Semir");
        firstNames.add("Seyid");
        firstNames.add("Siegbert");
        firstNames.add("Siegfried");
        firstNames.add("Sigbert");
        firstNames.add("Sigismund");
        firstNames.add("Stefan");
        firstNames.add("Steffen");
        firstNames.add("Stephen");
        firstNames.add("Steve");
        firstNames.add("Steven");
        firstNames.add("Sunny");
        firstNames.add("Sveinn");
        firstNames.add("Sven");

        // -----   T   -----

        firstNames.add("Tarek");
        firstNames.add("Thaddäus");
        firstNames.add("Theo");
        firstNames.add("Theodor");
        firstNames.add("Thomas");
        firstNames.add("Thor");
        firstNames.add("Thordal");
        firstNames.add("Thorvald");
        firstNames.add("Tobias");
        firstNames.add("Toby");
        firstNames.add("Tomas");
        firstNames.add("Tomaso");
        firstNames.add("Tomasz");
        firstNames.add("Travis");
        firstNames.add("Trevor");

        // -----   U   -----

        firstNames.add("Ulrich");
        firstNames.add("Umberto");
        firstNames.add("Urs");
        firstNames.add("Uwe");

        // -----   V   -----

        firstNames.add("Valtteri");
        firstNames.add("Victor");
        firstNames.add("Viktor");
        firstNames.add("Vladimir");
        firstNames.add("Volkan");
        firstNames.add("Volker");

        // -----   W   -----

        firstNames.add("Walt");
        firstNames.add("Walter");
        firstNames.add("Werner");
        firstNames.add("Wigald");
        firstNames.add("Wilhelm");
        firstNames.add("Willi");
        firstNames.add("Willy");
        firstNames.add("Wolfgang");
        firstNames.add("Wladimir");

        // -----   X   -----

        firstNames.add("Xaver");

        // -----   Y   -----

        firstNames.add("Yann");
        firstNames.add("Yannick");
        firstNames.add("Yannik");

        // -----   Z   -----

        firstNames.add("Zvezdan");
        firstNames.add("Zoran");

        // -----   Ö   -----

        firstNames.add("Ömer");


        //only for test!!!
        System.out.println(firstNames.size() + " first names registered.");
    }

    private void initLastNames() {
        lastNames = new ArrayList<>();

        // -----   A   -----

        lastNames.add("Adams");
        lastNames.add("Aigner");
        lastNames.add("Allister");
        lastNames.add("Anzengruber");
        lastNames.add("Arnold");
        lastNames.add("Ash");
        lastNames.add("Ashton");
        lastNames.add("Asimov");
        lastNames.add("Auer");
        lastNames.add("Auhofer");
        lastNames.add("Aumaier");
        lastNames.add("Aursnes");

        // -----   B   -----

        lastNames.add("Barnes");
        lastNames.add("Barth");
        lastNames.add("Bauer");
        lastNames.add("Bauernfeind");
        lastNames.add("Becker");
        lastNames.add("Beckham");
        lastNames.add("Berner");
        lastNames.add("Bichinger");
        lastNames.add("Bichler");
        lastNames.add("Binder");
        lastNames.add("Bindlehner");
        lastNames.add("Bohr");
        lastNames.add("Borg");
        lastNames.add("Borger");
        lastNames.add("Bottas");
        lastNames.add("Brahm");
        lastNames.add("Brahms");
        lastNames.add("Brook");
        lastNames.add("Brooks");
        lastNames.add("Buch");
        lastNames.add("Buchberger");
        lastNames.add("Buchbinder");
        lastNames.add("Bucher");
        lastNames.add("Buchinger");
        lastNames.add("Buchl");
        lastNames.add("Burger");
        lastNames.add("Burn");
        lastNames.add("Burne");
        lastNames.add("Burner");
        lastNames.add("Burns");
        lastNames.add("Büchel");
        lastNames.add("Bücher");

        // -----   C   -----

        lastNames.add("Cerny");
        lastNames.add("Chamberlain");
        lastNames.add("Cvetkovic");
        lastNames.add("Czerny");

        // -----   D   -----

        lastNames.add("Deut");
        lastNames.add("Deuter");
        lastNames.add("Deutz");
        lastNames.add("Dundee");

        // -----   E   -----

        lastNames.add("Eigner");

        // -----   F   -----

        lastNames.add("Farnbrook");
        lastNames.add("Frank");

        // -----   G   -----

        lastNames.add("Gärtner");
        lastNames.add("Geiger");
        lastNames.add("Geigenbauer");
        lastNames.add("Gräber");
        lastNames.add("Gruber");

        // -----   H   -----

        lastNames.add("Harrison");
        lastNames.add("Himmer");
        lastNames.add("Hoffman");
        lastNames.add("Hoffmann");
        lastNames.add("Hofman");
        lastNames.add("Hofmann");
        lastNames.add("Holzapfel");
        lastNames.add("Horvat");
        lastNames.add("Horvath");
        lastNames.add("Horwath");
        lastNames.add("Huber");
        lastNames.add("Hubmaier");
        lastNames.add("Hubmayer");
        lastNames.add("Humer");
        lastNames.add("Hummer");
        lastNames.add("Hyde");

        // -----   I   -----

        lastNames.add("Inn");
        lastNames.add("Innbauer");
        lastNames.add("Innmayer");
        lastNames.add("Irvin");

        // -----   J   -----

        lastNames.add("Jackie");
        lastNames.add("Jackson");
        lastNames.add("Jung");
        lastNames.add("Junge");
        lastNames.add("Junger");

        // -----   K   -----

        lastNames.add("Kaminski");
        lastNames.add("Kastenbauer");
        lastNames.add("Kastenhofer");
        lastNames.add("Kastner");
        lastNames.add("Konrad");
        lastNames.add("Kowalski");

        // -----   L   -----

        lastNames.add("Lang");
        lastNames.add("Langer");
        lastNames.add("Leitgeb");
        lastNames.add("Leitgeber");
        lastNames.add("Leutgeb");
        lastNames.add("Lenin");
        lastNames.add("Ludolf");

        // -----   M   -----

        lastNames.add("Manner");
        lastNames.add("Manzinger");
        lastNames.add("Marsh");
        lastNames.add("Matzinger");
        lastNames.add("Maurer");
        lastNames.add("McAllister");
        lastNames.add("McDonald");
        lastNames.add("McFarlane");
        lastNames.add("Miyamoto");
        lastNames.add("Musil");

        // -----   N   -----

        lastNames.add("Neubauer");
        lastNames.add("Neuer");
        lastNames.add("Neugebauer");
        lastNames.add("Newman");

        // -----   O   -----

        lastNames.add("Ober");

        // -----   P   -----

        lastNames.add("Perth");
        lastNames.add("Podolski");
        lastNames.add("Porsche");
        lastNames.add("Putin");

        // -----   Q   -----

        // -----   R   -----

        lastNames.add("Ratte");
        lastNames.add("Rattenbauer");

        // -----   S   -----

        lastNames.add("Sahle");
        lastNames.add("Sahler");
        lastNames.add("Sakurai");
        lastNames.add("Salah");
        lastNames.add("Sané");
        lastNames.add("Schiele");
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

        // -----   T   -----

        lastNames.add("Tabakovic");
        lastNames.add("Takeshi");
        lastNames.add("Thorbauer");
        lastNames.add("Thorsson");
        lastNames.add("Toriyama");
        lastNames.add("Toyota");
        lastNames.add("Trent");
        lastNames.add("Truman");
        lastNames.add("Türker");

        // -----   U   -----

        lastNames.add("Umweger");
        lastNames.add("Untermaier");
        lastNames.add("Unterweger");

        // -----   V   -----

        lastNames.add("Valhalla");
        lastNames.add("Vauxhall");

        // -----   W   -----

        lastNames.add("Walter");
        lastNames.add("Weiher");
        lastNames.add("Wimmer");
        lastNames.add("Wunderbaldinger");
        lastNames.add("Wurm");
        lastNames.add("Wurmbrand");
        lastNames.add("Wurmer");

        // -----   X   -----

        // -----   Y   -----

        lastNames.add("Yildirim");
        lastNames.add("Younes");
        lastNames.add("Young");
        lastNames.add("Youngman");
        lastNames.add("Yunus");

        // -----   Z   -----

        lastNames.add("Zander");
        lastNames.add("Zauner");
        lastNames.add("Zuber");

        // -----   Ä   -----

        lastNames.add("Äbichler");
        lastNames.add("Äkinen");

        // -----   Ö   -----

        lastNames.add("Österreicher");
        lastNames.add("Östreicher");
        lastNames.add("Özmen");
        lastNames.add("Öztürk");

        // -----   Ü   -----

        lastNames.add("Ümüt");

        // -----   Þ   -----

        lastNames.add("Þórarinsson");
        lastNames.add("Þórdalsson");
        lastNames.add("Þórkelsson");
        lastNames.add("Þórsson");

        // -----   Á   -----

        lastNames.add("Ákason");

        // -----   Ó   -----

        lastNames.add("Ódinsson");
        lastNames.add("Ólafsson");

        // -----   Ú   -----
        // -----   Í   -----
        // -----   Ý   -----


        //only for test!!!
        System.out.println(lastNames.size() + " last names registered.");
        System.out.println(firstNames.size() + " x " + lastNames.size() + " = " + (firstNames.size() * lastNames.size()) + " possible different names!");
    }
}
