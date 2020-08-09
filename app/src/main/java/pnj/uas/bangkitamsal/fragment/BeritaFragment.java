package pnj.uas.bangkitamsal.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import pnj.uas.bangkitamsal.DetailBeritaActivity;
import pnj.uas.bangkitamsal.R;
import pnj.uas.bangkitamsal.adapter.AdapterBerita;
import pnj.uas.bangkitamsal.model.BeritaModel;

public class BeritaFragment extends Fragment {
    ListView listView;
    AdapterBerita adapterBerita;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_berita, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listView);
        adapterBerita = new AdapterBerita(getActivity(),R.layout.item_list_berita);
        listView.setAdapter(adapterBerita);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                BeritaModel datas = (BeritaModel) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getActivity(), DetailBeritaActivity.class);
                intent.putExtra("judul", datas.getTitle());
                intent.putExtra("deskripsi", datas.getDeskrisi());
                intent.putExtra("image", datas.getImage());

                startActivity(intent);

            }
        });

        buatDataBerita();
    }

    void buatDataBerita() {
        String[] judul = {
                "Jalur Selo",
                "Jalur Suwanting",
                "Jalur Wekas",
                "Jalur Cunthel",
                "Jalur Thekelan"
        };

        String[] deskripsi = {
                "Jalur pendakian Gunung Merbabu via Selo bisa dibilang merupakan yang paling favorit. Kebanyakan pendaki Gunung Merbabu memulai pendakian dari jalur yang berada di Kabupaten Boyolali ini. Pendaki akan menjangkau Merbabu dari sisi selatan melalui jalur Selo ini. Keunggulan jalur Selo yang paling menawan adalah adanya padang sabana yang terhampar luas. Selain pemandangannya indah, pendaki juga bisa berkemah di sabana itu.Saat musim mekar bunga edelweiss, pendaki juga akan disuguhkan dengan hamparan padang edelweiss yang memesona. Namun, pendaki tidak boleh memetik bunga keabadian itu dan hanya boleh melihat atau memotretnya saja.\n",
                "Jika sudah sering mendaki Gunung Merbabu lewat jalur Selo, kamu bisa naik melalui jalur resmi lain, salah satunya adalah Suwanting. Melalui jalur ini, kamu akan menjangkau puncak Merbabu dari sisi barat. Jalur pendakian Suwanting berada di Dusun Suwanting, Desa Banyuroto, Kecamatan Sawangan, Kabupaten Magelang. Ciri khas rute ini adalah kamu harus melewati medan di tengah hutan lamtoro yang cukup panjang. Namun begitu sampai di pos III, kamu akan disuguhkan dengan panorama hamparan sabana yang membentang luas. Saat sampai di sabana, perjalanan sampai di puncak Trianggulasi sudah tidak terlalu jauh.\n",
                "Jalur pendakian Merbabu selanjutnya adalah melalui sisi utara. Jalur favorit untuk mendaki Merbabu dari selatan adalah via Wekas. Jalur ini berada di Kecamatan Pakis, Kabupaten Magelang. Jalur Wekas menjadi favorit pendakian karena memiliki tempat kemah yang luas di pos II dengan sumber air yang melimpah. Banyak orang yang hanya mendaki untuk berkemah di camping ground ini. Terus berjalan, nantinya jalur Wekas akan bertemu denga dua jalur pendakian lain, yakni Cunthel dan Thekelan. Pertemuan ketiga jalur ini berada di sekitar Pos Pemancar dan Helipad. Setelah itu jalur pendakian menjadi satu untuk menjangkau puncak dari utara.\n",
                "Kamu yang ingin menjangkau puncak Gunung Merbabu dari sisi utara bisa melakukannya via jalur Cunthel. Jalur ini berada di Dusun Cunthel, Desa Kopeng, Kecamatan Getasan, Kabupaten Semarang. Pendaki yang mendaki melalui jalur ini nantinya akan berjumpa dengan menara pemancar yang ada di Pos Pemancar. Bisa dibilang pos ini merupakan setengah perjalanan menuju puncak Merbabu. Usai Pos Pemancar, jalur ini akan bersatu dengan dua jalur lain, yakni Wekas dan Thekelan. Pendaki harus bersiap menghadapi tanjakan terjal usai melewati Pos Pemancar dan Helipad.\n",
                "Jalur pendakian resmi Merbabu terakhir adalah via Thekelan. Lokasi Basecamp Pendakian Merbabu via Thekelan berada di desa dan kecamatan yang sama dengan Basecamp Chuntel, yakni di Desa Kopeng, Kecamatan Getasan, Kabupaten Semarang. ika melewati jalur ini, kamu  akan menjumpai spot bernama Watu Gubug. Batu ini bisa dimasuki pendaki, meski terlihat kecil. Mitosnya, batu ini merupakan pintu gerbang untuk menuju dimensi lain. Selanjutnya, jalur akan menjadi satu dengan Wekas dan Chuntel. Selain harus melewati tanjakan cukup terjal, pendaki juga harus melalui rute cukup ekstrem menjelang puncak, yakni Ondorante. Rute itu akan dijumpai jika mendaki via Thekelan, Cunthel, atau Wekas.\n"
        };

        String[] image = {
                "https://asset.kompas.com/crops/hTpZZBryFNTz2xxGBTh7izJoWbc=/0x0:780x520/750x500/data/photo/2019/06/19/945530178.jpg",
                "https://asset.kompas.com/crops/9ImJMizbNTp_m9Dimucp7Tsekbc=/0x0:780x520/750x500/data/photo/2019/06/19/4181171438.jpg",
                "https://asset.kompas.com/crops/PMKh3OGlXXnx6kT9-T9HO8H_1Bo=/0x0:780x520/750x500/data/photo/2019/06/19/1740337517.jpg",
                "https://asset.kompas.com/crops/4CmrlavmrSHNu5-nFJUznP7pV70=/0x0:780x520/750x500/data/photo/2019/06/19/1965670961.jpg",
                "https://asset.kompas.com/crops/Uk2QYTIYYlheIyfXmA64B0JwHE0=/0x0:780x520/750x500/data/photo/2019/06/19/3155963236.jpg"

        };

        ArrayList<BeritaModel> data = new ArrayList<>();

        for (int i=0; i < image.length; i++) {
            BeritaModel model = new BeritaModel();
            model.setImage(image[i]);
            model.setTitle(judul[i]);
            model.setDeskrisi(deskripsi[i]);
            data.add(model);
        }

        adapterBerita.addAll(data);
        adapterBerita.notifyDataSetChanged();

    }
}
