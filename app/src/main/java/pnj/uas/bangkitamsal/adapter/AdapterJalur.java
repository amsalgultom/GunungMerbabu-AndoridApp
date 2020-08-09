package pnj.uas.bangkitamsal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import pnj.uas.bangkitamsal.R;
import pnj.uas.bangkitamsal.model.ModelJalur;

public class AdapterJalur extends ArrayAdapter<ModelJalur> {
    Context context;
    int resource;

    public AdapterJalur(Context context, int resource){
        super(context,resource);
        this.context = context;
        this.resource = resource;


    }
    class Holder{
        TextView txtNama, txtJarak, txtWilayah;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Holder holder;
        if(convertView==null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(resource,parent, false);
            holder.txtNama  = convertView.findViewById(R.id.txtNama);
            holder.txtJarak  = convertView.findViewById(R.id.txtJarak);
            holder.txtWilayah  = convertView.findViewById(R.id.txtWilayah);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }

        holder.txtNama.setText("Nama : "+   getItem(position).getNama());
        holder.txtJarak.setText("Jarak : "+   getItem(position).getJarak());
        holder.txtWilayah.setText("Wilayah : "+   getItem(position).getWilayah());
        return convertView;
    }
}
