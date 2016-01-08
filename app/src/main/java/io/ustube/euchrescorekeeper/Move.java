package io.ustube.euchrescorekeeper;

public class Move {

    private int teamNum;
    private int amount;

    public Move(int teamNum, int amount) {
        this.teamNum = teamNum;
        this.amount = amount;
    }

    public int getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
