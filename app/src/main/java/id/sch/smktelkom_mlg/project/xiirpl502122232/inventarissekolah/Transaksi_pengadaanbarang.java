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

public class Transaksi_pengadaanbarang extends AppCompatActivity implements View.OnClickListener {
    Button buttonSubmit;
    private EditText noUrutBarang;
    private EditText kodeSumber;
    private EditText merkBarang;
    private EditText spesifikasi;
    private EditText kodeBarang;
    private EditText jumlah;
    private EditText tahun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi_pengadaanbarang);
        noUrutBarang = (EditText) findViewById(R.id.noUrutBarang);
        kodeSumber = (EditText) findViewById(R.id.kodeSumber);
        merkBarang = (EditText) findViewById(R.id.merkBarang);
        spesifikasi = (EditText) findViewById(R.id.spesifikasi);
        kodeBarang = (EditText) findViewById(R.id.kodeBarang);
        jumlah = (EditText) findViewById(R.id.jumlah);
        tahun = (EditText) findViewById(R.id.tahun);
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
        final String merkbarang = merkBarang.getText().toString().trim();
        final String spek = spesifikasi.getText().toString().trim();
        final String kodebarang = kodeBarang.getText().toString().trim();
        final String jum = jumlah.getText().toString().trim();
        final String thn = tahun.getText().toString().trim();

        class TambahData extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Transaksi_pengadaanbarang.this, "Proses Kirim Data...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Transaksi_pengadaanbarang.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();
                // Sesuaikan bagian ini dengan field di tabel Mahasiswa
                params.put(Config.KEY_PENGADAANBARANG_NOURUT, nourutbarang);
                params.put(Config.KEY_PENGADAANBARANG_KODESUMBER, kodesumber);
                params.put(Config.KEY_PENGADAANBARANG_MERKBARANG, merkbarang);
                params.put(Config.KEY_PENGADAANBARANG_SPEK, spek);
                params.put(Config.KEY_PENGADAANBARANG_KODEBARANG, kodebarang);
                params.put(Config.KEY_PENGADAANBARANG_JUMLAH, jum);
                params.put(Config.KEY_PENGADAANBARANG_TAHUN, thn);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.TRANSAKSI_PENGADAAN, params);
                return res;
            }
        }
        // Jadikan Class TambahData Sabagai Object Baru
        TambahData ae = new TambahData();
        ae.execute();
    }

}
