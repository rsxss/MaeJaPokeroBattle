/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.model.storage;

import java.util.Objects;
import org.maejaporja.controller.MatchExecutor;
import org.maejaporja.model.Match;
import org.maejaporja.model.Pokero;
import org.maejaporja.model.PokeroPowerBooster;
import org.maejaporja.model.PokeroTrainer;

/**
 *
 * @author NATWORPONGLOYSWAI
 */
public class ApplicationStorage implements Storage {
    
    private PokeroTrainer[] pokeroTrainers;
    private PokeroPowerBooster[] pokeroPowerBoosters;
    private Pokero[] pokeros;
    private MatchExecutor[] matchExecutors;
    private Match[] matches;
    private static ApplicationStorage instance;
    
    
    private ApplicationStorage(){
        this.pokeroTrainers = new PokeroTrainer[50];
        this.pokeroPowerBoosters = new PokeroPowerBooster[50];
        this.pokeros = new Pokero[50];
        this.matchExecutors = new MatchExecutor[50];
        this.matches = new Match[50];
    }

    
    public PokeroTrainer[] getPokeroTrainers() {
        return this.pokeroTrainers;
    }
    public PokeroPowerBooster[] getPokeroPowerBoosters() {
        return this.pokeroPowerBoosters;
    }
    public Pokero[] getPokeros() {
        return this.pokeros;
    }
    public MatchExecutor[] getMatchExecutors() {
        return this.matchExecutors;
    }
    public Match[] getMatches() {
        return this.matches;
    }

    public void setPokeroTrainers(PokeroTrainer[] pokeroTrainers) {
        this.pokeroTrainers = pokeroTrainers;
    }
    public void setPokeroPowerBoosters(PokeroPowerBooster[] pokeroPowerBoosters) {
        this.pokeroPowerBoosters = pokeroPowerBoosters;
    }
    public void setPokeros(Pokero[] pokeros) {
        this.pokeros = pokeros;
    }
    public void setMatchExecutors(MatchExecutor[] matchExecutors) {
        this.matchExecutors = matchExecutors;
    }
    public void setMatches(Match[] matches) {
        this.matches = matches;
    }
   
    
    public static ApplicationStorage getStorage(){
        if(Objects.isNull(ApplicationStorage.instance)){
            ApplicationStorage.instance = new ApplicationStorage();
        } return ApplicationStorage.instance;
    }
    
    @Override
    public boolean clearStorage() {
        this.pokeroTrainers = new PokeroTrainer[50];
        this.pokeroPowerBoosters = new PokeroPowerBooster[50];
        this.pokeros = new Pokero[50];
        this.matchExecutors = new MatchExecutor[50];
        this.matches = new Match[50];
        
        return true;
    }
    
}
