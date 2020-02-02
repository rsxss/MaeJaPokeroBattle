/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.model;

import java.util.Objects;

/**
 *
 * @author NATWORPONGLOYSWAI
 */
public class Match {
    
    public static long matchCount;
    private final long MATCH_ID;
    private String matchName;
    private boolean matchStatus;
    private Pokero[] versus;
    private Pokero winner;
    private Pokero loser;
    private Callback fight;
    private Callback<Boolean> condition;
    
    public Match(String matchName){
        this.MATCH_ID = matchCount++;
        this.matchName = matchName;
    }

    public static long getMatchCount() {
        return matchCount;
    }
    public long getMATCH_ID() {
        return this.MATCH_ID;
    }
    public String getMatchName() {
        return this.matchName;
    }
    public boolean getMatchStatus() {
        return this.matchStatus;
    }
    public Pokero[] getVersus() {
        return this.versus;
    }
    public Pokero getWinner() {
        return this.winner;
    }
    public Pokero getLoser() {
        return this.loser;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }
    public void setMatchStatus(boolean matchStatus) {
        this.matchStatus = matchStatus;
    }
    public void setVersus(Pokero[] versus) {
        this.versus = versus;
    }
    public void setFight(Callback fight){
        this.fight = fight;
    }
    public boolean setWinner(Pokero winner) {
        boolean result = false;
        if(!Objects.isNull(winner)){
            this.winner = winner;
            result = true;
        }       
        return result;
    }
    public boolean setLoser(Pokero loser) {
        boolean result = false;
        if(!Objects.isNull(loser)){
            this.loser = loser;
            result = true;
        }       
        return result;
    }
    public boolean setCondition(Callback callback){
        boolean result = false;
        if(!Objects.isNull(callback)){
            this.condition = callback;
            result = true;
        }       
        return result;
    }
    
    public void startMatch(){
        if (!matchAvailable()){
            throw new IllegalStateException(String.format(
                "Match %s is not available due to no challengers",this.matchName
            ));
        } else {
            declareMatchStart();
            declareFightStart();
            declareMatchResult();
            declareMatchComplete();
        }
        
    }
    
    private void declareFightStart(){
        fight.call(this);
    }
    private boolean declareMatchComplete(){
        if(condition.call()){
            this.matchStatus = true;
            return true;
        }
        return false;
    }
    private void declareMatchStart(){
        System.out.printf("%s: Battle between %s & %s start!%n",
                this.matchName,
                versus[0].getOwnBy().getTrainerName(),
                versus[1].getOwnBy().getTrainerName()
            );
        System.out.printf("%s sent out %s!%n"+"%s sent out %s!%n",
                versus[0].getOwnBy().getTrainerName(),
                versus[0].getPokeroName(),
                versus[1].getOwnBy().getTrainerName(),
                versus[1].getPokeroName()
            );
    }
    private void declareMatchResult(){
        System.out.printf("%s cp%d -- %s cp%d %s win!%n%n", 
                versus[0].getPokeroName(),
                versus[0].getCombatPower(),
                versus[1].getPokeroName(),
                versus[1].getCombatPower(),
                winner.getOwnBy().getTrainerName()
            );
    }
    
    public boolean matchAvailable(){
        return !Objects.isNull(versus);
    }
}

