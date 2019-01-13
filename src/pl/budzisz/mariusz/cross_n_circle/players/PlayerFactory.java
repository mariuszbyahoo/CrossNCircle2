package pl.budzisz.mariusz.cross_n_circle.players;

import pl.budzisz.mariusz.cross_n_circle.Data;
import pl.budzisz.mariusz.cross_n_circle.figures.Figures;

public class PlayerFactory {

    public static Player getInstance(Figures type, Data data, boolean isOpponent, boolean isHuman){
        if(isOpponent){
            if (isHuman){
                return getOpponentHumanInstance(type , data);
            } else {
                return getOpponentAiInstance(type , data);
            }
        }
        else {
            /**
             * Te ify są tutaj do dokończenia żeby to zawrzeć w jednej metodzie i potem wywoływać ją
             * w CrossNCircleGame i przekazywać po prostu konkretne argumenty do metody.
             */
            if(isHuman){
                return getHumanInstance(type , data);
            } else {
                return getAiInstance(type, data);
            }
        }
    }

    public static Player getAiInstance(Figures type, Data data){
        Player instance;
        instance = new PlayerHuman(type, data);
        return instance;
    }
    public static Player getHumanInstance(Figures type, Data data){
        Player instance;
        instance = new PlayerHuman(type,data);
        return instance;
    }
    public static Player getOpponentHumanInstance(Figures type, Data data){
        Player instance;
        if (type.equals(Figures.CROSS)) {
            instance = new PlayerHuman(Figures.CIRCLE, data);
        } else {
            instance = new PlayerHuman(Figures.CROSS, data);
        }
        return instance;
    }
    public static Player getOpponentAiInstance(Figures type, Data data){
        Player instance;
        if (type.equals(Figures.CROSS)) {
            instance = new PlayerAI(Figures.CIRCLE, data);
        } else {
            instance = new PlayerAI(Figures.CROSS, data);
        }
        return instance;
    }
}
