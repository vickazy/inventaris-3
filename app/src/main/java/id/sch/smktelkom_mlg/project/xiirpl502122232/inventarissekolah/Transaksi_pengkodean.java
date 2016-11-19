package id.sch.smktelkom_mlg.project.xiirpl502122232.inventarissekolah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Transaksi_pengkodean extends AppCompatActivity implements View.OnClickListener {
    Button buttonSubmit;
    private EditText noUrutBarang;
    private EditText kodeSumber;
    private EditText keterangan;
    private EditText kodeBarang;
    private EditText namaBarang;
    private EditText kodeInventaris;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi_pengkodean);
        noUrutBarang = (EditText) findViewById(R.id.noUrutBarang);
        kodeSumber = (EditText) findViewById(R.id.kodeSumber);
        keterangan = (EditText) findViewById(R.id.keterangan);
        kodeBarang = (EditText) findViewById(R.id.kodeBarang);
        namaBarang = (EditText) findViewById(R.id.namaBarang);
        kodeInventaris = (EditText) findViewById(R.id.kodeInventaris);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonSubmit) {
            TambahData();
        }
    }

    private void TambahData() {
        final String nourutbarang = noUrutBarang.getText().toString().trim();
        final String kodesumber = kodeSumber.getText().toString().trim();
        final String ket = keterangan.getText().toString().trim();
        final String kodebarang = kodeBarang.getText().toString().trim();
        final String namabarang = namaBarang.getText().toString().trim();
        final String kodeinventaris = kodeInventaris.getText().toString().trim();
    }
}
