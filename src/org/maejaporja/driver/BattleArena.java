/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.driver;

import org.maejaporja.controller.MatchExecutor;
import org.maejaporja.model.Match;
import org.maejaporja.model.Pokero;
import org.maejaporja.model.PokeroTrainer;
import org.maejaporja.model.storage.ApplicationStorage;
import org.maejaporja.utils.ApplicationConfig.MatchConfig;



/**
 *
 * @author NATWORPONGLOYSWAI
 */
public class BattleArena {
    
    private static final ApplicationStorage STORAGE = 
            ApplicationStorage.getStorage();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        prepareBattleArena();
        /////////////////////////////////////////////////////////////////////////
        PokeroTrainer[] pokeroTrainers = BattleArena.STORAGE.getPokeroTrainers();
        Pokero[] pokeros = BattleArena.STORAGE.getPokeros();
        MatchExecutor executor = BattleArena.STORAGE.getMatchExecutors()[0];
        Match[] matches = BattleArena.STORAGE.getMatches();
        /////////////////////////////////////////////////////////////////////////
        Pokero pkr1 = pokeros[0];
        Pokero pkr2 = pokeros[1];
        Pokero pkr3 = pokeros[2];
        Pokero pkr4 = pokeros[3];
        Pokero pkr5 = pokeros[4];
        Pokero pkr6 = pokeros[5];
        /////////////////////////////////////////////////////////////////////////
        PokeroTrainer pp1 = pokeroTrainers[0];
        PokeroTrainer pp2 = pokeroTrainers[1];
        pp1.adoptPokero(pkr1);
        pp1.adoptPokero(pkr2);
        pp1.adoptPokero(pkr3);
        pp2.adoptPokero(pkr4);
        pp2.adoptPokero(pkr5);
        pp2.adoptPokero(pkr6);
        /////////////////////////////////////////////////////////////////////////
        Match match1 = matches[0];
        Match match2 = matches[1];
        Match match3 = matches[2];
        Match match4 = matches[3];
        match1.setVersus(new Pokero[]{pkr1, pkr4});
        match2.setVersus(new Pokero[]{pkr2, pkr5});
        match3.setVersus(new Pokero[]{pkr3, pkr6});
        /////////////////////////////////////////////////////////////////////////
        executor.setMatches(matches);
        executor.execute();
    }
    
    private static void prepareBattleArena(){
        double begin = System.currentTimeMillis()/1000.0;
        System.out.println("BattleArena: Preparing state...");
        prepareMatch();
        prepareMatchExecutor();
        preparePokero();
        preparePokeroTrainer();
        double end = System.currentTimeMillis()/1000.0;
        System.out.printf("BattleArena: Finished in %.2f seconds%n", end-begin);
        System.out.printf("BattleArena: Ready and open for all!%n%n");
    }
    private static void prepareMatch(){
        Match[] matches = new Match[50];
        //////////////////////////////////////////////////
        for(int i=0; i<5; i++){
            Match match = new Match(String.format("TEFPME-%d", i));
            match.setCondition(MatchConfig.defaultCondition);
            match.setFight(MatchConfig.defaultFight);
            matches[i] = match;
        }
        //////////////////////////////////////////////////
        BattleArena.STORAGE.setMatches(matches);
    }
    private static void prepareMatchExecutor(){
        MatchExecutor[] matchExecutors = new MatchExecutor[1];
        //////////////////////////////////////////////////
        MatchExecutor matchExecutor = new MatchExecutor();
        //////////////////////////////////////////////////
        matchExecutors[0] = matchExecutor;
        //////////////////////////////////////////////////
        BattleArena.STORAGE.setMatchExecutors(matchExecutors);
        
    }
    private static void preparePokero(){
        Pokero[] pokeros = new Pokero[50];
        //////////////////////////////
        Pokero pp1 = new Pokero("ゲンガー");
        Pokero pp2 = new Pokero("サイドン");
        Pokero pp3 = new Pokero("ギャラドス");
        Pokero cp1 = new Pokero("ラプラス");
        Pokero cp2 = new Pokero("サンダース");
        Pokero cp3 = new Pokero("ミュウツー");
        //////////////////////////////
        pokeros[0] = pp1;
        pokeros[1] = pp2;
        pokeros[2] = pp3;
        pokeros[3] = cp1;
        pokeros[4] = cp2;
        pokeros[5] = cp3;
        //////////////////////////////
        BattleArena.STORAGE.setPokeros(pokeros);
    }
    private static void preparePokeroTrainer(){
        PokeroTrainer[] pokeroTrainers = new PokeroTrainer[50];
        //////////////////////////////
        PokeroTrainer ppt1 = new PokeroTrainer("PorJaMaeJa", 'X', true);
        PokeroTrainer cpt1 = new PokeroTrainer("COM1");
        //////////////////////////////
        pokeroTrainers[0] = ppt1;
        pokeroTrainers[1] = cpt1;
        //////////////////////////////
        BattleArena.STORAGE.setPokeroTrainers(pokeroTrainers);
    }
    
}
