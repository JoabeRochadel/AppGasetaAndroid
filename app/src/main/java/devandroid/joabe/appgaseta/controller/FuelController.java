package devandroid.joabe.appgaseta.controller;

import android.content.SharedPreferences;

import devandroid.joabe.appgaseta.model.Fuel;
import devandroid.joabe.appgaseta.view.GasEtaActivity;

public class FuelController {
    SharedPreferences preferences;
    SharedPreferences.Editor gasList;
    public static final String NAME_PREFERENCES = "pref_gas";


    public FuelController(GasEtaActivity gasEtaActivity) {
        preferences = gasEtaActivity.getSharedPreferences(NAME_PREFERENCES, 0);

        gasList = preferences.edit();
    }

    public void save(Fuel fuel){
        gasList.putString("fuel", fuel.getNameFuel());
        gasList.putFloat("price", (float) fuel.getPriceFuel());
        gasList.putString("recommendation", fuel.getRecommendationFuel());
        gasList.apply();
    }

    public void clean(){
        gasList.clear();
        gasList.apply();
    }

}
