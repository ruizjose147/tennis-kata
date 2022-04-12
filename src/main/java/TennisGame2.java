
public class TennisGame2 implements TennisGame
{
    private int player1Score = 0;
    private int player2Score = 0;

    private String score1Name;
    private String score2Name;




    public TennisGame2(String score1Name, String score2Name) {
        this.score1Name = score1Name;
        this.score2Name = score2Name;
    }

    public String getScore(){
        String score = "";
        score = empate(score);
        score = ScoresMayorQueCero(score);
        score = PlayerOneScoreEsMayorAPlayertwoScore(score);
        score = PlayerTwoScoreEsMayorAPlayerOneScore(score);
        score = scoreMayorOIgualACuatro(score);
        return score;
    }

    private String scoreMayorOIgualACuatro(String score) {
        if(player1Score >=4 || player2Score >=4){
            score = getScoreCuandoEsMayorQueCuatroYDiferenciaMayorQueUno(score);
        }
        return score;
    }

    private String PlayerTwoScoreEsMayorAPlayerOneScore(String score) {
        if (player2Score > player1Score) {
            score = getScoreJugadorDosGana(score);
        }
        return score;
    }

    private String PlayerOneScoreEsMayorAPlayertwoScore(String score) {
        if(player1Score > player2Score){
            score = getScoreJugadorUnoGana(score);
        }
        return score;
    }

    private String ScoresMayorQueCero(String score) {
        if (player1Score > 0 || player2Score > 0){
            score = getScoreCuandoUnoEsIgualQueCero(score);
        }
        return score;
    }

    private String empate(String score) {
        if (player1Score == player2Score){
            score = getScoreCuandoSonIguales(score);
        }
        return score;
    }

    private String getScoreCuandoUnoEsIgualQueCero(String score) {
        if (player2Score ==0)
        {
            score = getScoreJugadorUnoGanaYJugadorDosQuedaEnCero();
        }
        if (player1Score ==0)
        {
            score = getScoreJugadorDosGanaYJugadorUnoQuedaEnCero();
        }
        return score;
    }

    private String getScoreCuandoEsMayorQueCuatroYDiferenciaMayorQueUno(String score) {
        if ( player1Score - player2Score >=2)
        {
            score = "Win for player1";
        }
        if (player2Score - player1Score >= 2)
        {
            score = "Win for player2";
        }
        return score;
    }

    private String getScoreJugadorDosGana(String score) {
        if (player2Score < 4) {
            getScoreJugadorDosGanaMenosDeCuatroDos();
            getScoreJugadorDosGanaMenosDeCuatro();
            score = String.format("%s-%s", score1Name, score2Name);
        }
        if (player1Score >= 3) {
            score = "Advantage player2";
        }
        return score;
    }

    private String getScoreJugadorUnoGana(String score) {
        if(player1Score < 4){
            getScoreJugadorUnoGanaMenosDeCuatro();
            getScoreJugadorUnoGanaMenosDeCuatroDos();
            score = String.format("%s-%s",score1Name, score2Name);
        }
        if(player2Score >= 3){
            score = "Advantage player1";
        }
        return score;
    }

    private String getScoreCuandoSonIguales(String score) {
        if(player1Score < 4){
            score = getScoreMenorOIgualATres();
        }
        if (player1Score >=3){
            score = "Deuce";
        }
        return score;
    }


    private void getScoreJugadorDosGanaMenosDeCuatro() {
        if (player1Score ==1)
            score1Name ="Fifteen";
        if (player1Score ==2)
            score1Name ="Thirty";
    }

    private void getScoreJugadorDosGanaMenosDeCuatroDos() {
        if (player2Score ==2)
            score2Name ="Thirty";
        if (player2Score ==3)
            score2Name ="Forty";
    }

    private void getScoreJugadorUnoGanaMenosDeCuatro() {
        switch(player1Score) {
            case 2:
                score1Name = "Thirty";
                break;
            case 3:
                score1Name = "Forty";
                break;
            default:
                break;
        }
    }

    private void getScoreJugadorUnoGanaMenosDeCuatroDos() {
        switch(player2Score) {
            case 1:
                score2Name = "Fifteen";
                break;
            case 2:
                score2Name = "Thirty";
                break;
            default:
                break;
        }
    }

    private String getScoreJugadorUnoGanaYJugadorDosQuedaEnCero() {
        score2Name = "Love";
        switch(player1Score){
            case 1:
                score1Name = "Fifteen";
                return score1Name + "-" + score2Name;
            case 2:
                score1Name = "Thirty";
                return score1Name + "-" + score2Name;
            default:
                score1Name = "Forty";
                return score1Name + "-" + score2Name;
        }
    }

    private String getScoreJugadorDosGanaYJugadorUnoQuedaEnCero() {
        score1Name = "Love";
        switch(player2Score){
            case 1:
                score2Name = "Fifteen";
                return score1Name + "-" + score2Name;
            case 2:
                score2Name = "Thirty";
                return score1Name + "-" + score2Name;
            default:
                score2Name = "Forty";
                return score1Name + "-" + score2Name;
        }
    }

    private String getScoreMenorOIgualATres() {
        switch (player1Score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            default:
                return "Thirty-All";
        }
    }


    public void POneScore(){
        player1Score++;
    }

    public void PTwoScore(){
        player2Score++;
    }

    public void wonPoint(String player) {
        if (player.equals(score1Name))
            POneScore();
        if(player.equals(score2Name))
            PTwoScore();
    }
}