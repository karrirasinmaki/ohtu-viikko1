package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    
    private String[] POINTS_DISPLAY_NAMES = { "Love", "Fifteen", "Thirty", "Forty" };
    private String ALL = "All";
    private String DEUCE = "Deuce";
    private String ADVANTAGE_S = "Advantage %s";
    private String WIN_FOR_S = "Win for %s";
    
    private int TARGET_POINTS = 4;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1Score += 1;
        else
            player2Score += 1;
    }
    
    private String getPointDisplayName(int score) {
    	if (POINTS_DISPLAY_NAMES.length <= score) {
    		return POINTS_DISPLAY_NAMES[score];
    	}
    	return DEUCE;
    }

    public String getScore() {
        if (player1Score>=TARGET_POINTS || player2Score>=TARGET_POINTS)
        {
        	int seperationRaw = player1Score - player2Score;
            int seperation = Math.abs(seperationRaw);
            String playerName = seperationRaw > 0 ? player1Name : player2Name;
            if (seperation==1) return String.format(ADVANTAGE_S, playerName);
            return String.format(WIN_FOR_S, playerName);
        }
        return getPointDisplayName(player1Score) + "-" + 
        		(player1Score == player2Score ? ALL : getPointDisplayName(player2Score));
    }
}