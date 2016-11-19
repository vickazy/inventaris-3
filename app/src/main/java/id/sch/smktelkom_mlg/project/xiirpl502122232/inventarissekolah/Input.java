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

public class Input extends AppCompatActivity implements View.OnClickListener {

    //Mendefinisikan View Edit Text
    private EditText editTextTipeBarang;
    private EditText editTextKelas;
    private EditText editTextID;

    // Mendefinisikan View Button
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        editTextTipeBarang = (EditText) findViewById(R.id.editTextTipeBarang);
        editTextKelas = (EditText) findViewById(R.id.editTextKelas);
        editTextID = (EditText) findViewById(R.id.editTextID);
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

    private void TambahData() {
        // Ubah setiap View EditText ke tipe Data String
        final String tipe_barang = editTextTipeBarang.getText().toString().trim();
        final String kelas = editTextKelas.getText().toString().trim();
        final String id = editTextID.getText().toString().trim();
        // Pembuatan Class AsyncTask yang berfungsi untuk koneksi ke Database Server

        class TambahData extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Input.this, "Proses Kirim Data...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Input.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();
                // Sesuaikan bagian ini dengan field di tabel Mahasiswa
                params.put(Config.KEY_INPUT_TIPE_BARANG, tipe_barang);
                params.put(Config.KEY_INPUT_KELAS, kelas);
                params.put(Config.KEY_INPUT_ID, id);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                return res;
            }
        }
        // Jadikan Class TambahData Sabagai Object Baru
        TambahData ae = new TambahData();
        ae.execute();
    }

    public void onClick(View v) {
        if (v == buttonSubmit) {
            TambahData();
        }
    }
}
