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
public class PokeroTrainer {
    public static long pokeroTrainerCount;
    private long POKERO_TRAINER_ID;
    private String trainerName;
    private char trainerSex;
    private int trainerAge;
    private int ownsPokeroHead;
    private Pokero[] ownsPokero;
    private boolean isPlayer;
    
    public PokeroTrainer(){
        this("unnamedPokeroTrainer");
    }
    public PokeroTrainer(String trainerName){
        this(trainerName, 'M');
    }
    public PokeroTrainer(String trainerName, char trainerSex){
        this(trainerName, trainerSex, false);
    }
    public PokeroTrainer(String trainerName, char trainerSex, boolean isPlayer){
        this(trainerName, trainerSex, isPlayer, 20);
    }
    public PokeroTrainer(String trainerName, char trainerSex, boolean isPlayer, int trainerAge){
        this(trainerName, trainerSex, isPlayer, trainerAge, new Pokero[50]);
    }
    public PokeroTrainer(String trainerName, char trainerSex, boolean isPlayer, 
            int trainerAge, Pokero[] pokeros){
        this.trainerName = trainerName;
        this.trainerSex = trainerSex;
        this.trainerAge = trainerAge;
        this.isPlayer = isPlayer;
        this.ownsPokero = pokeros;
        this.POKERO_TRAINER_ID = PokeroTrainer.pokeroTrainerCount++;
    }

    public String getTrainerName() {
        return this.trainerName;
    }
    public long getPOKERO_TRAINER_ID(){
        return this.POKERO_TRAINER_ID;
    }
    public char getSex() {
        return this.trainerSex;
    }
    public int getAge() {
        return this.trainerAge;
    }
    public boolean getIsPlayer() {
        return this.isPlayer;
    }
    
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
    public void setSex(char trainerSex) {
        this.trainerSex = trainerSex;
    }
    public void setAge(int trainerAge) {
        this.trainerAge = trainerAge;
    }
    public Pokero[] getOwnsPokero() {
        return this.ownsPokero;
    }
    public void setOwnsPokero(Pokero[] ownsPokero) {
        this.ownsPokero = ownsPokero;
    }

    public void setIsPlayer(boolean isPlayer) {
        this.isPlayer = isPlayer;
    }
    
    public String adoptPokero(Pokero pokero){
        this.ownsPokero[ownsPokeroHead++] = pokero;   
        pokero.setOwnBy(this);
        return "";
    }
    public String adoptPokero(Pokero[] pokeros){
        // TODO
        return "";
    }
    public String releasePokero(Pokero pokero){
        // TODO
        return "";
    }
    public String releasePokero(Pokero[] pokeros){
        // TODO
        return "";
    }
}
