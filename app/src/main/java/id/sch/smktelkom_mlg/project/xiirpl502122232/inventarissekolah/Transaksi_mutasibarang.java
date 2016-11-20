package id.sch.smktelkom_mlg.project.xiirpl502122232.inventarissekolah;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

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
        final String kodeinventaris = kodeInventaris.getText().toString().trim();
        final String lokasibaru = lokasiBaru.getText().toString().trim();
        final String lokasilama = lokasiLama.getText().toString().trim();
        final String jum = jumlah.getText().toString().trim();

        class TambahData extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Transaksi_mutasibarang.this, "Proses Kirim Data...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Transaksi_mutasibarang.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();
                // Sesuaikan bagian ini dengan field di tabel Mahasiswa
                params.put(Config.KEY_MUTASIBARANG_NOURUT, nourutbarang);
                params.put(Config.KEY_MUTASIBARANG_KODEINVENTARIS, kodeinventaris);
                params.put(Config.KEY_MUTASIBARANG_LOKASIBARU, lokasibaru);
                params.put(Config.KEY_MUTASIBARANG_LOKASILAMA, lokasilama);
                params.put(Config.KEY_MJUTASIBARANG_JUMLAH, jum);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.TRANSAKSI_MUTASI, params);
                return res;
            }
        }
        // Jadikan Class TambahData Sabagai Object Baru
        TambahData ae = new TambahData();
        ae.execute();
    }

}
