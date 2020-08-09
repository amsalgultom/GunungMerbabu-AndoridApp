package pnj.uas.bangkitamsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pnj.uas.bangkitamsal.adapter.AdapterJalur;
import pnj.uas.bangkitamsal.model.ModelJalur;
import pnj.uas.bangkitamsal.utils.Config;

public class DataJalurActivity extends AppCompatActivity {
    ListView listView;
    AdapterJalur adapterJalur;
    Button actionTambahJalur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_jalur);

        listView = findViewById(R.id.listview);
        adapterJalur = new AdapterJalur(this, R.layout.item_list_jalur);
        listView.setAdapter(adapterJalur);
        actionTambahJalur = findViewById(R.id.actionTambahJalur);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ModelJalur jalurModel = (ModelJalur) parent.getAdapter().getItem(position);
                Intent intent = new Intent(DataJalurActivity.this, DetailActivity.class);
                intent.putExtra("id", jalurModel.getId());
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ModelJalur modelJalur = (ModelJalur) parent.getAdapter().getItem(position);
                Intent intent = new Intent(DataJalurActivity.this, HapusDataActivity.class);
                intent.putExtra("id", modelJalur.getId());
                startActivity(intent);
                return true;
            }
        });

        actionTambahJalur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataJalurActivity.this, TambahDataActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                Config._LIST_JALUR, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("RESPONSE", "" + response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("jalur");

                    ArrayList<ModelJalur> datas = new ArrayList<>();

                    for(int i=0; i < jsonArray.length(); i++) {
                        JSONObject item = jsonArray.getJSONObject(i);

                        ModelJalur modelJalur = new ModelJalur();
                        modelJalur.setId(item.getString("id"));
                        modelJalur.setNama(item.getString("nama"));
                        modelJalur.setJarak(item.getString("jarak"));
                        modelJalur.setWilayah(item.getString("wilayah"));

                        datas.add(modelJalur);

                    }
                    adapterJalur.clear();
                    adapterJalur.addAll(datas);
                    adapterJalur.notifyDataSetChanged();

                }catch (JSONException ex){
                    Log.e("RESPONSE", "" + ex.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("RESPONSE", "" + error.getMessage());
            }
        });

        requestQueue.add(stringRequest);

    }
}

