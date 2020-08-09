package pnj.uas.bangkitamsal.model;

public class PendakiModel {
String nik;
    String nama;
    String jk;
    String umur;
    String alamat;
    String jalur;

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJalur() {
        return jalur;
    }

    public void setJalur(String jalur) {
        this.jalur = jalur;
    }

    public String getTgl_naik() {
        return tgl_naik;
    }

    public void setTgl_naik(String tgl_naik) {
        this.tgl_naik = tgl_naik;
    }

    public String getTgl_turun() {
        return tgl_turun;
    }

    public void setTgl_turun(String tgl_turun) {
        this.tgl_turun = tgl_turun;
    }

    String tgl_naik;
    String tgl_turun;
}
