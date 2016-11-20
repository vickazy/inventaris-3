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
        kodeBarang = (EditText) findViewById(R.id.kodeBarang);
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
        final String kodebarang = kodeBarang.getText().toString().trim();
        final String kodeinventaris = kodeInventaris.getText().toString().trim();

        class TambahData extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Transaksi_pengkodean.this, "Proses Kirim Data...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Transaksi_pengkodean.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();
                // Sesuaikan bagian ini dengan field di tabel Mahasiswa
                params.put(Config.KEY_PENGKODEAN_NOURUT, nourutbarang);
                params.put(Config.KEY_PENGKODEAN_KODESUMBER, kodesumber);
                params.put(Config.KEY_PENGKODEAN_KODEBARANG, kodebarang);
                params.put(Config.KEY_PENGKODEAN_KODEINVENTARIS, kodeinventaris);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.TRANSAKSI_PENGKODEAN, params);
                return res;
            }
        }
        // Jadikan Class TambahData Sabagai Object Baru
        TambahData ae = new TambahData();
        ae.execute();
    }
}
