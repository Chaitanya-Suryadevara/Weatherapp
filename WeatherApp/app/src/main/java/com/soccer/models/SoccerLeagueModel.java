package com.soccer.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SoccerLeagueModel {
    @SerializedName("GameId")
    @Expose
    private String gameId;
    @SerializedName("AwayTeamId")
    @Expose
    private String awayTeamId;
    @SerializedName("AwayTeamName")
    @Expose
    private String awayTeamName;
    @SerializedName("HomeTeamId")
    @Expose
    private String homeTeamId;
    @SerializedName("HomeTeamName")
    @Expose
    private String homeTeamName;
    @SerializedName("AwayScore")
    @Expose
    private int awayScore;
    @SerializedName("HomeScore")
    @Expose
    private int homeScore;

    private int win;
    private  int loss;
    private  int draw;
    private  String winper;
    private String winingTeam;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public String getWiningTeam() {
        return winingTeam;
    }

    public void setWiningTeam(String winingTeam) {
        this.winingTeam = winingTeam;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public String getWinper() {
        return winper;
    }

    public void setWinper(String winper) {
        this.winper = winper;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(String awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public String getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(String homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }
}
