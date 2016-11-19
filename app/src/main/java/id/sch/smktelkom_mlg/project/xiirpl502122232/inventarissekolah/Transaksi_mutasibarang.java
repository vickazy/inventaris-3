package id.sch.smktelkom_mlg.project.xiirpl502122232.inventarissekolah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Transaksi_mutasibarang extends AppCompatActivity implements View.OnClickListener {

    Button buttonSubmit;
    private EditText noUrutBarang;
    private EditText kodeInventaris;
    private EditText lokasiBaru;
    private EditText lokasiLama;
    private EditText jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi_mutasibarang);
        noUrutBarang = (EditText) findViewById(R.id.noUrutBarang);
        kodeInventaris = (EditText) findViewById(R.id.kodeInventaris);
        lokasiBaru = (EditText) findViewById(R.id.lokasiBaru);
        lokasiLama = (EditText) findViewById(R.id.lokasiLama);
        jumlah = (EditText) findViewById(R.id.jumlah);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public void onClick(View v) {
        if (v == buttonSubmit) {
            TambahData();
        }
    }

    private void TambahData() {
        final String nourutbarang = noUrutBarang.getText().toString().trim();
        final String kodeinventaris = kodeInventaris.getText().toString().trim();
        final String lokasibaru = lokasiBaru.getText().toString().trim();
        final String lokasilama = lokasiLama.getText().toString().trim();
        final String jum = jumlah.getText().toString().trim();
    }
}
