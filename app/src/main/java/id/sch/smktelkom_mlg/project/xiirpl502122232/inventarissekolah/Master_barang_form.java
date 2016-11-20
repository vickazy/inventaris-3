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

public class Master_barang_form extends AppCompatActivity implements View.OnClickListener {

    Button buttonSubmit;
    private EditText editTextKodeBarang;
    private EditText editTextNamaBarang;
    private EditText editTextJenisBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_barang_form);

        editTextKodeBarang = (EditText) findViewById(R.id.editTextKodeBarang);
        editTextNamaBarang = (EditText) findViewById(R.id.editTextNamaBarang);
        editTextJenisBarang = (EditText) findViewById(R.id.editTextJenisBarang);
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
        final String kodeBarang = editTextKodeBarang.getText().toString().trim();
        final String namaBarang = editTextNamaBarang.getText().toString().trim();
        final String jenisBarang = editTextJenisBarang.getText().toString().trim();

        // Pembuatan Class AsyncTask yang berfungsi untuk koneksi ke Database Server
        class TambahData extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Master_barang_form.this, "Proses Kirim Data...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Master_barang_form.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();
                // Sesuaikan bagian ini dengan field di tabel Mahasiswa
                params.put(Config.KEY_KODE_BARANG, kodeBarang);
                params.put(Config.KEY_NAMA_BARANG, namaBarang);
                params.put(Config.KEY_JENIS_BARANG, jenisBarang);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.MASTER_BARANG_URL, params);
                return res;
            }
        }
        // Jadikan Class TambahData Sabagai Object Baru
        TambahData ae = new TambahData();
        ae.execute();
    }
}
