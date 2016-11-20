package id.sch.smktelkom_mlg.project.xiirpl502122232.inventarissekolah;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Laporan extends AppCompatActivity implements View.OnClickListener {

    //Mendefinisikan View Edit Text
    private EditText editTextBagian;
    private EditText editTextBarang;
    private EditText editTextDeskripsi;

    // Mendefinisikan View Button
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);

        editTextBagian = (EditText) findViewById(R.id.editTextKodeBagian);
        editTextBarang = (EditText) findViewById(R.id.editTextKodeBarang);
        editTextDeskripsi = (EditText) findViewById(R.id.editTextDeskripsi);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        if (v == buttonSubmit) {
            Lapordata();
        }
    }

    private void Lapordata() {
        // Ubah setiap View EditText ke tipe Data String
        final String deskripsi = editTextDeskripsi.getText().toString().trim();
        final String barang = editTextBarang.getText().toString().trim();
        final String bagian = editTextBagian.getText().toString().trim();
        // Pembuatan Class AsyncTask yang berfungsi untuk koneksi ke Database Server

        class Lapordata extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Laporan.this, "Proses Kirim Data...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Laporan.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();
                // Sesuaikan bagian ini dengan field di tabel Mahasiswa
                params.put(Config.KEY_LAPORAN_DESKRIPSI, deskripsi);
                params.put(Config.KEY_LAPORAN_BARANG, barang);
                params.put(Config.KEY_LAPORAN_BAGIAN, bagian);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.LAPORAN, params);
                return res;
            }
        }
        // Jadikan Class TambahData Sabagai Object Baru
        Lapordata ae = new Lapordata();
        ae.execute();
    }


}

