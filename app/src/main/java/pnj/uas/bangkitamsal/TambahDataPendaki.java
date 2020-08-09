package pnj.uas.bangkitamsal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import pnj.uas.bangkitamsal.database.DatabasePendaki;

public class TambahDataPendaki extends AppCompatActivity {

    EditText edtNik, edtNama, edtJk, edtUmur, edtAlamat, edtJalur;
    TextView edtTglNaik,edtTglTurun;
    Button actionSimpan, actionHapus;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data_pendaki);
        edtNik = findViewById(R.id.edtNik);
        edtNama = findViewById(R.id.edtNama);
        edtJk = findViewById(R.id.edtJk);
        edtUmur = findViewById(R.id.edtUmur);
        edtAlamat = findViewById(R.id.edtAlamat);
        edtTglNaik = findViewById(R.id.edtTglNaik);
        edtTglTurun = findViewById(R.id.edtTglTurun);
        actionSimpan = findViewById(R.id.actionSimpan);
        actionHapus = findViewById(R.id.actionHapus);
        edtJalur = findViewById(R.id.edtJalur);



        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            actionSimpan.setText("UPDATE");
            edtNik.setEnabled(false);
            edtNik.setText(extras.getString("nik", ""));
            edtNama.setText(extras.getString("nama", ""));
            edtJk.setText(extras.getString("jk", ""));
            edtUmur.setText(extras.getString("umur", ""));
            edtAlamat.setText(extras.getString("alamat", ""));
            edtJalur.setText(extras.getString("jalur", ""));
            edtTglNaik.setText(extras.getString("tgl_naik", ""));
            edtTglTurun.setText(extras.getString("tgl_turun", ""));


        }else {
            actionHapus.setVisibility(View.GONE);
        }

        edtTglNaik.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                Calendar myCalendar = Calendar.getInstance();
                new DatePickerDialog(TambahDataPendaki.this, date, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });
        edtTglTurun.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi1")
            @Override
            public void onClick(View v) {
                Calendar myCalendar = Calendar.getInstance();
                new DatePickerDialog(TambahDataPendaki.this, date1, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });

        actionSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpan();
            }
        });
        actionHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hapus();
            }
        });

    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,month);
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

            edtTglNaik.setText(simpleDateFormat.format(calendar.getTime().getTime()));

        }
    };
    DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,month);
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

            edtTglTurun.setText(simpleDateFormat.format(calendar.getTime().getTime()));

        }
    };

    void simpan() {

        if (edtNik.getText().toString().length() > 0 && edtNama.getText().toString().length() > 0 &&
                edtJk.getText().toString().length() > 0 && edtUmur.getText().toString().length() > 0 &&
                edtAlamat.getText().toString().length() > 0 && edtJalur.getText().toString().length() > 0 &&
                edtTglNaik.getText().toString().length() > 0 && edtTglTurun.getText().toString().length() > 0) {

            database = new DatabasePendaki(this).getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                contentValues.put("nik", edtNik.getText().toString());
            }

//            contentValues.put("nim", edtNim.getText().toString());
            contentValues.put("nama", edtNama.getText().toString());
            contentValues.put("jk", edtJk.getText().toString());
            contentValues.put("umur", edtUmur.getText().toString());
            contentValues.put("alamat", edtAlamat.getText().toString());
            contentValues.put("jalur", edtJalur.getText().toString());
            contentValues.put("tgl_naik", edtTglNaik.getText().toString());
            contentValues.put("tgl_turun", edtTglTurun.getText().toString());
            if (extras == null) {

                long insert = database.insert("tb_pendaki", null, contentValues);
                if (insert != -1) {
                    Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }else{
                long update = database.update("tb_pendaki", contentValues, "nik=?", new String[]{""+edtNik.getText().toString()});
                if (update != -1) {
                    Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
            database.close();
        }
    }

    void hapus(){
        database = new DatabasePendaki(this).getWritableDatabase();
        long hapus = database.delete("tb_pendaki", "nik=?", new String[]{""+edtNik.getText().toString()});
        if (hapus != -1) {
            Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
