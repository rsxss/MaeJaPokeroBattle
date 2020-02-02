/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.utils;

import org.maejaporja.model.Callback;
import org.maejaporja.model.Match;
import org.maejaporja.model.Pokero;

/**
 *
 * @author Student
 */
public class ApplicationConfig {

    public static class MatchConfig {

        public static Callback defaultCondition = new Callback() {
            @Override
            public Boolean call(Object... args) {
                return true;
            }
        };

        public static Callback defaultFight = new Callback() {
            @Override
            public Pokero call(Object... args) {
                Match match = (Match) args[0];
                Pokero[] pokeros = match.getVersus();
                if (pokeros[1].getCombatPower() > pokeros[0].getCombatPower()) {
                    match.setWinner(pokeros[1]);
                    match.setLoser(pokeros[0]);
                } else {
                    match.setWinner(pokeros[0]);
                    match.setLoser(pokeros[1]);
                }
                return match.getWinner();
            }
        ;
    };
}

}
