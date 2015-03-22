package ohtuesimerkki;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class StaticsticsTest {

	Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    @Before
    public void setUp() {
    	stats = new Statistics(readerStub);
    }
    
    @Test
    public void nullIfSearchDoesNotFoundPlayer() {
    	assertNull(stats.search("Rasinmäki"));
    }

    @Test
    public void searchWorks() {
    	assertEquals("Semenko", stats.search("Semen").getName());
    }
    
    @Test
    public void testTeam() {
    	List<Player> players = stats.team("EDM");
    	assertEquals(3, players.size());
    }
    
    @Test
    public void topScrorersReturnEmptyListIfHowManyLessThanZero() {
    	List<Player> players = stats.topScorers(-1);
    	assertNotNull(players);
    	assertEquals(0, players.size());
    }
    
    @Test
    public void topScrorersInCorrectOrder() {
    	List<Player> players = stats.topScorers(3);
    	assertEquals("Gretzky", players.get(0).getName());
    	assertEquals("Lemieux", players.get(1).getName());
    	assertEquals("Yzerman", players.get(2).getName());
    }
	
}
