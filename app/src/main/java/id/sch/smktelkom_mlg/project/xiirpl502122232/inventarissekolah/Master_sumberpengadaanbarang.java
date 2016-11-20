package id.sch.smktelkom_mlg.project.xiirpl502122232.inventarissekolah;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Master_sumberpengadaanbarang extends Activity {

    // Definisikan ListView
    private ListView listView;
    // Variabel untuk format String JSON
    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_sumberpengadaanbarang);

        listView = (ListView) findViewById(R.id.listView);
        getJSON();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Master_sumberpengadaanbarang.this, Master_sumberpengadaanbarang_form.class);
                startActivity(intent);
            }
        });
    }

    // Buat Methode untuk ambil data dari Server
    private void TampilData() {
        // Data dalam bentuk Array kemudian akan kita ubah menjadi JSON Object
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_SUMBER);
            // FOR untuk ambil data
            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                // TAG_ID dan TAG_NAME adalah variabel yang ada di Class Config.java,
                String kode = jo.getString(Config.TAG_KODE);
                String ket = jo.getString(Config.TAG_KET);

                HashMap<String, String> master_barang = new HashMap<>();
                master_barang.put(Config.TAG_KODE, kode);
                master_barang.put(Config.TAG_KET, ket);
                list.add(master_barang);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Tampilkan datanya dalam Layout Lihat Data
        ListAdapter adapter = new SimpleAdapter(
                Master_sumberpengadaanbarang.this, list, R.layout.lihatdata_master_sumberpengadaanbarang,
                new String[]{Config.TAG_KODE, Config.TAG_KET},
                new int[]{R.id.kode, R.id.ket});
        // Tampilkan dalam bentuk ListView
        listView.setAdapter(adapter);
    }

    // Methode ambil data JSON yang kita definisikan dalam bentuk AsyncTask
    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Master_sumberpengadaanbarang.this, "Pengambilan Data", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                // Panggil method tampil data
                TampilData();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                // Proses nya sesuai alamat URL letak script PHP yang kita set di Class Config.java
                String s = rh.sendGetRequest(Config.READ_MASTER_SUMBERPENGADAAN);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
}
