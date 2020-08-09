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
import pnj.uas.bangkitamsal.model.PendakiModel;

public class AdapterPendaki extends ArrayAdapter<PendakiModel> {

    Context context;
    int resource;

    public AdapterPendaki(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Holder holder;
        if(convertView==null){
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
            holder.txtNik = convertView.findViewById(R.id.txtNik);
            holder.txtNama = convertView.findViewById(R.id.txtNama);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        holder.txtNik.setText("Nik : "+ getItem(position).getNik());
        holder.txtNama.setText("Nama Pendaki : "+ getItem(position).getNama());

        return convertView;
    }
    class Holder {
        TextView txtNik, txtNama;
    }
}
