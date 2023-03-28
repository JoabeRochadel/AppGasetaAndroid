package devandroid.joabe.appgaseta.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import devandroid.joabe.appgaseta.model.Fuel;

public class GasEtaDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "gaseta.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public GasEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SqlTableFuel = "CREATE TABLE FUEL (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "                           nameFuel TEXT, " +
                "                           priceFuel REAL, " +
                "                           recommendationFuel TEXT )";

        db.execSQL(SqlTableFuel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveObject(String table, ContentValues data) {
        db.insert(table, null, data);
    }

    public List<Fuel> ListData() {
        List<Fuel> listFuel = new ArrayList<>();
        Fuel reg;

        String sSql = "SELECT * FROM FUEL";

        cursor = db.rawQuery(sSql, null);

        if (cursor.moveToFirst()) {

            do {
                reg = new Fuel();

                reg.setId(cursor.getInt(0));
                reg.setRecommendationFuel(cursor.getString(1));
                reg.setPriceFuel(cursor.getDouble(2));
                reg.setNameFuel(cursor.getString(3));

                listFuel.add(reg);
            }
            while (cursor.moveToNext());
        } else {

        }
        return listFuel;
    }

    public void AlterData(String table, ContentValues data){
        int id = data.getAsInteger("id");

        db.update(table, data, "id=?", new String[]{Integer.toString(id)});
    }

    public void DeleteData(String table, int id){


        db.delete(table, "id=?", new String[]{Integer.toString(id)});
    }
}
