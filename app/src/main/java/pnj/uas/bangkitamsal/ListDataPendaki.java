package pnj.uas.bangkitamsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import pnj.uas.bangkitamsal.adapter.AdapterPendaki;
import pnj.uas.bangkitamsal.database.DatabasePendaki;
import pnj.uas.bangkitamsal.model.PendakiModel;

public class ListDataPendaki extends AppCompatActivity {

    ListView listView;
    AdapterPendaki adapterPendaki;
    SQLiteDatabase database;
    Button actionTambahPendaki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data_pendaki);
        listView = findViewById(R.id.listView);
        actionTambahPendaki = findViewById(R.id.actionTambahPendaki);
        adapterPendaki = new AdapterPendaki(this, R.layout.item_pendaki);
        listView.setAdapter(adapterPendaki);

        actionTambahPendaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListDataPendaki.this, TambahDataPendaki.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PendakiModel model = (PendakiModel) parent.getAdapter().getItem(position);
                Intent intent = new Intent(ListDataPendaki.this, TambahDataPendaki.class);
                intent.putExtra("nik", model.getNik());
                intent.putExtra("nama", model.getNama());
                intent.putExtra("jk", model.getJk());
                intent.putExtra("umur", model.getUmur());
                intent.putExtra("alamat", model.getAlamat());
                intent.putExtra("jalur", model.getJalur());
                intent.putExtra("tgl_naik", model.getTgl_naik());
                intent.putExtra("tgl_turun", model.getTgl_turun());

                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        getdata();
    }
    void getdata(){

        database = new DatabasePendaki(this).getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM tb_pendaki", null);
        ArrayList<PendakiModel> data = new ArrayList<>();
        adapterPendaki.clear();
        data.clear();

        if(cursor.moveToFirst()) {
            do{
                PendakiModel model = new PendakiModel();
                model.setNik(cursor.getString(0));
                model.setNama(cursor.getString(1));
                model.setJk(cursor.getString(2));
                model.setUmur(cursor.getString(3));
                model.setAlamat(cursor.getString(4));
                model.setJalur(cursor.getString(5));
                model.setTgl_naik(cursor.getString(6));
                model.setTgl_turun(cursor.getString(7));

                data.add(model);

            }while (cursor.moveToNext());
            cursor.close();
            database.close();

            adapterPendaki.addAll(data);

        }

    }
}