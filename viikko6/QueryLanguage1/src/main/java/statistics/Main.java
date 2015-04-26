package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        Matcher m = new MatcherBuilder()
        	.hasAtLeast(10, "goals")
        	.hasAtLeast(10, "assists")
        	.playsIn("PHI")
        	.build();
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}


/*
Matcher m = new And( new HasAtLeast(10, "goals"),
new HasAtLeast(10, "assists"),
new PlaysIn("PHI")
);
*/