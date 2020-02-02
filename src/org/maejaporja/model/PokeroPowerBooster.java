/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.model;

/**
 *
 * @author NATWORPONGLOYSWAI
 */
public class PokeroPowerBooster {
    private final PokeroTrainer ownBy;
    private final Match ownByMatch;
    private final Pokero powerupFor;
    
    public PokeroPowerBooster(PokeroTrainer ownBy, Match ownByMatch, 
            Pokero powerupFor){
        this.ownBy = ownBy;
        this.ownByMatch = ownByMatch;
        this.powerupFor = powerupFor;
    }

    public PokeroTrainer getOwnBy() {
        return this.ownBy;
    }
    public Match getOwnByMatch() {
        return this.ownByMatch;
    }
    public Pokero getPowerupFor() {
        return this.powerupFor;
    }
 
}
