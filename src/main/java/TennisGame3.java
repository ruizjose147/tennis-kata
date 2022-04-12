
public class TennisGame3 implements TennisGame {

    private int player2Score;
    private int player1Score;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (player1Score < 4 && player2Score < 4 && (player1Score + player2Score != 6)) {
            return getScoreCuandoSonMayoresOIgualesACuatro();
        }
        return getScoreCuandoSonMayoresATres();
    }

    private String getScoreCuandoSonMayoresATres() {
        if (player1Score == player2Score)
            return "Deuce";
        return getScoreCuandoSonMayoresATresYSonDiferentes();
    }

    private String getScoreCuandoSonMayoresATresYSonDiferentes() {
        String currentPlayer;
        currentPlayer = player1Score > player2Score ? player1Name : player2Name;
        currentPlayer = (Math.abs(player1Score - player2Score) == 1) ? "Advantage " + currentPlayer : "Win for " + currentPlayer;
        return currentPlayer;
    }

    private String getScoreCuandoSonMayoresOIgualesACuatro() {
        String s;
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        s = p[player1Score];
        return (player1Score == player2Score) ? s + "-All" : s + "-" + p[player2Score];
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            this.player1Score += 1;
        if (playerName.equals(player2Name))
            this.player2Score += 1;

    }

}