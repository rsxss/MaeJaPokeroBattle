/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.controller;

import java.util.Objects;
import java.util.Scanner;
import org.maejaporja.model.Match;
import org.maejaporja.model.Pokero;
import org.maejaporja.model.PokeroPowerBooster;
import org.maejaporja.model.PokeroTrainer;

/**
 *
 * @author NATWORPONGLOYSWAI
 */
public class MatchExecutor {
    public static long matchExecutorCount;
    private final long MATCH_EXEUCUTOR_ID;
    private final Scanner sc = new Scanner(System.in);
    private int matchHead;
    private int powerBoosterHead;
    private Match[] matches;
    private PokeroPowerBooster[] powerBoosterUsed;
    
    public MatchExecutor(){
        this.MATCH_EXEUCUTOR_ID = MatchExecutor.matchExecutorCount++;
        this.matches = new Match[50];
        this.powerBoosterUsed = new PokeroPowerBooster[50];
    }
    public MatchExecutor(Match[] matches){
        this.MATCH_EXEUCUTOR_ID = MatchExecutor.matchExecutorCount++;
        this.matches = matches;
        this.matchHead = newMatchHeadFromMatches(matches);
        this.powerBoosterUsed = new PokeroPowerBooster[matches.length];
    }  
    
    public void execute(){
        if(!executeable()){
            throw new IllegalStateException(String.format(
                    "MatchExeucutor-%d is not executeable because no matches available",
                    this.MATCH_EXEUCUTOR_ID
                    ));
        } 
        for(int i=0; i<this.matchHead; i++){
            System.out.printf("Round %d ", i+1);
            Match match = this.matches[i];
            if(!match.matchAvailable()){
                try {
                throw new IllegalStateException(String.format(
                    "Match %s is not available due to no challengers",
                        match.getMatchName()
                ));
                } catch(IllegalStateException ise){
                    System.out.printf(
                            "will be skipped!%nReason: %s%n"
                            ,ise.getMessage()
                    ); continue;
                }
            }
            class OneOffPokeroPowerBooster {
                private final Pokero[] pokeros = new Pokero[]{
                    match.getVersus()[0],
                    match.getVersus()[1]
                };
                private final PokeroTrainer[] pokeroTrainers = new PokeroTrainer[]{
                    match.getVersus()[0].getOwnBy(), 
                    match.getVersus()[1].getOwnBy()
                };
                public void boost(){
                    for(int i=0; i<this.pokeroTrainers.length; i++){
                        if(this.pokeroTrainers[i].getIsPlayer() && 
                            isAbleToBoostPower(this.pokeroTrainers[i])){
                            int enchancedCombatPower = (int)(Math.random()*101)+250;
                            System.out.printf(
                                    "Will %s boost %s(%d -> %d) up by %d?(Y/n): %n",
                                    this.pokeroTrainers[i].getTrainerName(),
                                    this.pokeros[i].getPokeroName(),
                                    this.pokeros[i].getCombatPower(),
                                    this.pokeros[i].getCombatPower()+enchancedCombatPower,
                                    enchancedCombatPower
                            );
                            boolean pokeroTrainerAns = sc.nextLine()
                                    .trim()
                                    .toUpperCase()
                                    .equals("Y");
                            if(pokeroTrainerAns){
                                this.pokeros[i].setCombatPower(
                                        this.pokeros[i].getCombatPower()+enchancedCombatPower
                                );
                                powerBoosterUsed[powerBoosterHead++] = new PokeroPowerBooster(
                                    this.pokeroTrainers[i], match, this.pokeros[i]
                                );
                            }
                        }
                    }
                }
                private boolean isAbleToBoostPower(PokeroTrainer pokeroTrainer){
                    for(int i=0; i<powerBoosterHead; i++){
                        if(pokeroTrainer.getTrainerName().equals(
                                powerBoosterUsed[powerBoosterHead-1]
                                        .getOwnBy()
                                        .getTrainerName()
                        )){
                            return false;
                        }
                    }
                    return true;
                }
            }
            OneOffPokeroPowerBooster ooppb = new OneOffPokeroPowerBooster();
            ooppb.boost();
            match.startMatch();
        } sc.close();
    }
    private boolean executeable(){
        return !Objects.isNull(this.matches) && this.matchHead > 0;
    }
    private int newMatchHeadFromMatches(Match[] matches){
        int newMatchHead = 0;
        for(Match match: matches){
            if(Objects.isNull(match)){
                break;
            } newMatchHead++;
        } return newMatchHead;
    }
    
    public long getMATCH_EXEUCUTOR_ID() {
        return this.MATCH_EXEUCUTOR_ID;
    }
    public int getMatchHead() {
        return this.matchHead;
    }
    public Match[] getMatches() {
        return this.matches;
    }

    public void setMatchHead(int matchHead) {
        this.matchHead = matchHead;
    }
    public void setMatches(Match[] matches) {
        this.matches = matches;
        this.matchHead = newMatchHeadFromMatches(matches);
    }
    
        
}
