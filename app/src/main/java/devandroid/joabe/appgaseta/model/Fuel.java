package devandroid.joabe.appgaseta.model;

import android.content.SharedPreferences;

import devandroid.joabe.appgaseta.view.GasEtaActivity;

public class Fuel {
    SharedPreferences preferences;
    SharedPreferences.Editor gasList;
    public static final String NAME_PREFERENCES = "pref_gas";
    private String nameFuel;
    private double priceFuel;
    private String recommendationFuel;

    public String getNameFuel() {
        return nameFuel;
    }

    public void setNameFuel(String nameFuel) {
        this.nameFuel = nameFuel;
    }

    public double getPriceFuel() {
        return priceFuel;
    }

    public void setPriceFuel(double priceFuel) {
        this.priceFuel = priceFuel;
    }

    public String getRecommendationFuel() {
        return recommendationFuel;
    }

    public void setRecommendationFuel(String recommendationFuel) {
        this.recommendationFuel = recommendationFuel;
    }

}
