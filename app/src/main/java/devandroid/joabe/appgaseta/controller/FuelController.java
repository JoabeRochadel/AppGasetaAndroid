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
        /*shared preferences*/
        gasList.putString("nameFuel", fuel.getNameFuel());
        gasList.putFloat("priceFuel", (float) fuel.getPriceFuel());
        gasList.putString("recommendationFuel", fuel.getRecommendationFuel());
        gasList.apply();

        ContentValues data = new ContentValues();

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

    public void alterData(Fuel fuel){
        ContentValues data = new ContentValues();

        data.put("id", fuel.getId());
        data.put("nameFuel", fuel.getNameFuel());
        data.put("priceFuel", (float) fuel.getPriceFuel());
        data.put("recommendationFuel", fuel.getRecommendationFuel());

        AlterData("Fuel", data);
    }

    public void delete(int id){
        DeleteData("Fuel", id);
    }

}
