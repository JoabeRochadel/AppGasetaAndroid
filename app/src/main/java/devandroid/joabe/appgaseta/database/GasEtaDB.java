package devandroid.joabe.appgaseta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    public void saveObject(String table, ContentValues data){
        db.insert(table, null, data);
    }
}
