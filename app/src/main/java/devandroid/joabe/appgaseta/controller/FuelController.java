package devandroid.joabe.appgaseta.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import java.util.List;

import devandroid.joabe.appgaseta.database.GasEtaDB;
import devandroid.joabe.appgaseta.model.Fuel;
import devandroid.joabe.appgaseta.view.GasEtaActivity;

public class FuelController extends GasEtaDB {
    SharedPreferences preferences;
    SharedPreferences.Editor gasList;
    public static final String NAME_PREFERENCES = "pref_gas";


    public FuelController(GasEtaActivity gasEtaActivity) {
        super(gasEtaActivity);
        preferences = gasEtaActivity.getSharedPreferences(NAME_PREFERENCES, 0);

        gasList = preferences.edit();
    }

    public void save(Fuel fuel) {
        ContentValues data = new ContentValues();
        gasList.putString("fuel", fuel.getNameFuel());
        gasList.putFloat("price", (float) fuel.getPriceFuel());
        gasList.putString("recommendation", fuel.getRecommendationFuel());
        gasList.apply();

        data.put("nameFuel", fuel.getNameFuel());
        data.put("priceFuel", fuel.getPriceFuel());
        data.put("recommendationFuel", fuel.getRecommendationFuel());


        saveObject("Fuel", data);
    }

    public void clean() {
        gasList.clear();
        gasList.apply();
    }

    public List<Fuel> getListData() {
        return ListData();
    }
}
