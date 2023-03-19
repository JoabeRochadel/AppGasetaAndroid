package devandroid.joabe.appgaseta.util;

public class UtilGasEta {

    public static String getBestOptionGasEta(double gas, double eta){

        double bestPrice = gas * 0.7;
        String messageReturn;

        if (eta <= bestPrice){
            messageReturn = "Abastecer com etanol!";
        } else{
          messageReturn = "Abastecer com Gasolina!";
        }

        return messageReturn;
    }
}
