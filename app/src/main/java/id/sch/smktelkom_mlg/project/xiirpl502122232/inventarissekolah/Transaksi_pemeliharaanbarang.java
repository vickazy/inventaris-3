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

public class Transaksi_pemeliharaanbarang extends AppCompatActivity implements View.OnClickListener {

    Button buttonSubmit;
    private EditText noUrutBarang;
    private EditText kodeInventaris;
    private EditText kodeLokasi;
    private EditText baik;
    private EditText rusak;
    private EditText hilang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi_pemeliharaanbarang);
        noUrutBarang = (EditText) findViewById(R.id.noUrutBarang);
        kodeInventaris = (EditText) findViewById(R.id.kodeInventaris);
        kodeLokasi = (EditText) findViewById(R.id.kodeLokasi);
        baik = (EditText) findViewById(R.id.editTextBaik);
        rusak = (EditText) findViewById(R.id.editTextRusak);
        hilang = (EditText) findViewById(R.id.editTextHilang);
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
        final String kodelokasi = kodeLokasi.getText().toString().trim();
        final String kondisiBaik = baik.getText().toString().trim();
        final String kondisiRusak = rusak.getText().toString().trim();
        final String kondisiHilang = hilang.getText().toString().trim();


        class TambahData extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Transaksi_pemeliharaanbarang.this, "Proses Kirim Data...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Transaksi_pemeliharaanbarang.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();
                // Sesuaikan bagian ini dengan field di tabel Mahasiswa
                params.put(Config.KEY_PEMELIHARAANBARANG_NOURUT, nourutbarang);
                params.put(Config.KEY_PEMELIHARAANBARANG_KODEINVENTARIS, kodeinventaris);
                params.put(Config.KEY_PEMELIHARAANBARANG_KODELOKASI, kodelokasi);
                params.put(Config.KEY_PEMELIHARAANBARANG_KONDISIBAIK, kondisiBaik);
                params.put(Config.KEY_PEMELIHARAANBARANG_KONDISIRUSAK, kondisiRusak);
                params.put(Config.KEY_PEMELIHARAANBARANG_KONDISIHILANG, kondisiHilang);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.TRANSAKSI_PEMELIHARAAN, params);
                return res;
            }
        }
        // Jadikan Class TambahData Sabagai Object Baru
        TambahData ae = new TambahData();
        ae.execute();
    }
}
