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

public class Master_lokasipenempatanbarang_form extends AppCompatActivity implements View.OnClickListener {

    Button buttonSubmit;
    private EditText editTextKodeBagian;
    private EditText editTextNamaBagian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_lokasipenempatanbarang_form);

        editTextKodeBagian = (EditText) findViewById(R.id.editTextKodeBagian);
        editTextNamaBagian = (EditText) findViewById(R.id.editTextNamaBagian);
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
        final String kodeBagian = editTextKodeBagian.getText().toString().trim();
        final String namaBagian = editTextNamaBagian.getText().toString().trim();
        // Pembuatan Class AsyncTask yang berfungsi untuk koneksi ke Database Server
        class TambahData extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Master_lokasipenempatanbarang_form.this, "Proses Kirim Data...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Master_lokasipenempatanbarang_form.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();
                // Sesuaikan bagian ini dengan field di tabel Mahasiswa
                params.put(Config.KEY_KODE_BGN, kodeBagian);
                params.put(Config.KEY_NAMA_BGN, namaBagian);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.MASTER_LOKASI_URL, params);
                return res;
            }
        }
        // Jadikan Class TambahData Sabagai Object Baru
        TambahData ae = new TambahData();
        ae.execute();
    }
}
