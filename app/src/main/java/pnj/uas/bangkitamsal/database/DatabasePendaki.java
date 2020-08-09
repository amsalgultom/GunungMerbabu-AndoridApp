package pnj.uas.bangkitamsal.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabasePendaki extends SQLiteOpenHelper {


    public DatabasePendaki(@Nullable Context context) {
        super(context, "db_pendaki", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tb_pendaki (nik TEXT PRIMARY KEY, nama TEXT, " +
                "jk TEXT, umur TEXT, alamat TEXT, jalur TEXT, tgl_naik TEXT, " +
                "tgl_turun TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
