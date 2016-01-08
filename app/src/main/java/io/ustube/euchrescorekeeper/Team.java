package io.ustube.euchrescorekeeper;

import android.util.Log;

import java.io.Serializable;

public class Team implements Serializable {

    private static final String TAG = "Team";

    private String player1, player2;
    private int wins, num, score;
    private int pointsToWin;

    private int gameOnes, gameTwos, gameFours;
    private int matchOnes, matchTwos, matchFours;

    public Team(String player1, String player2, int num, int pointsToWin) {
        this.player1 = player1;
        this.player2 = player2;
        this.num = num;
        this.pointsToWin = pointsToWin;
        wins = 0;
        gameOnes = 0;
        gameTwos = 0;
        gameFours = 0;
        matchOnes = 0;
        matchTwos = 0;
        matchFours = 0;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getGameOnes() {
        return gameOnes;
    }

    public void setGameOnes(int gameOnes) {
        this.gameOnes = gameOnes;
    }

    public int getGameTwos() {
        return gameTwos;
    }

    public void setGameTwos(int gameTwos) {
        this.gameTwos = gameTwos;
    }

    public int getGameFours() {
        return gameFours;
    }

    public void setGameFours(int gameFours) {
        this.gameFours = gameFours;
    }

    public int getMatchOnes() {
        return matchOnes;
    }

    public void setMatchOnes(int matchOnes) {
        this.matchOnes = matchOnes;
    }

    public int getMatchTwos() {
        return matchTwos;
    }

    public void setMatchTwos(int matchTwos) {
        this.matchTwos = matchTwos;
    }

    public int getMatchFours() {
        return matchFours;
    }

    public void setMatchFours(int matchFours) {
        this.matchFours = matchFours;
    }

    public int add(int amount) {
        switch (amount) {
            case 1:
                score += 1;
                gameOnes++;
                matchOnes++;
                break;
            case 2:
                score += 2;
                gameTwos++;
                matchTwos++;
                break;
            case 4:
                score += 4;
                gameFours++;
                matchFours++;
                break;
        }
        Log.d(TAG, "Team " + num + " score: " + score + ", points to win: " + pointsToWin);
        return (score >= pointsToWin) ? num : 0;
    }

    public void resetMatchToo() {
        matchOnes -= gameOnes;
        matchTwos -= gameTwos;
        matchFours -= gameFours;
    }

    public void subtract(int amount) {
        switch (amount) {
            case 1:
                score -= 1;
                gameOnes--;
                matchOnes--;
                break;
            case 2:
                score -= 2;
                gameTwos--;
                matchTwos--;
                break;
            case 4:
                score -= 4;
                gameFours--;
                matchFours--;
                break;
        }
        Log.d(TAG, "Team " + num + " score: " + score + ", points to win: " + pointsToWin);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addWin() {
        wins++;
    }

    public void reset() {
        gameOnes = 0;
        gameTwos = 0;
        gameFours = 0;
        score = 0;
    }
}
