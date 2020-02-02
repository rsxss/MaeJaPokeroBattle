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
public class Pokero {
    public static long pokeroCount;
    private long POKERO_ID;
    private String pokeroName;
    private int combatPower;
    private PokeroTrainer ownBy;
    
    public Pokero(){
        this("unnamedPokero");
    }
    public Pokero(String pokeroName){
        this(pokeroName, (int)(Math.random()*5001)+1500);
    }
    public Pokero(String pokeroName, int combatPower){
        this(pokeroName, combatPower, null);
    }
    public Pokero(String pokeroName, int combatPower, PokeroTrainer ownBy){
        this.POKERO_ID = pokeroCount++;
        this.pokeroName = pokeroName;
        this.combatPower = combatPower;
        this.ownBy = ownBy;
    }

    public static long getPokeroCount() {
        return pokeroCount;
    }
    public long getPokeroId() {
        return this.POKERO_ID;
    }
    public String getPokeroName() {
        return this.pokeroName;
    }
    public int getCombatPower() {
        return this.combatPower;
    }
    public PokeroTrainer getOwnBy() {
        return this.ownBy;
    }
    
     public void setPokeroName(String pokeroName) {
        this.pokeroName = pokeroName;
    }
    public void setCombatPower(int combatPower) {
        this.combatPower = combatPower;
    }
    public void setOwnBy(PokeroTrainer ownBy) {
        this.ownBy = ownBy;
    }
}
