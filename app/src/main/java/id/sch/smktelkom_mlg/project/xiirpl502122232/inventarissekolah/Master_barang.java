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

public class Master_barang extends Activity {

    // Definisikan ListView
    private ListView listView;
    // Variabel untuk format String JSON
    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_barang);

        listView = (ListView) findViewById(R.id.listView);
        getJSON();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Master_barang.this, Master_barang_form.class);
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
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
            // FOR untuk ambil data
            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                // TAG_ID dan TAG_NAME adalah variabel yang ada di Class Config.java,
                String kode_brg = jo.getString(Config.TAG_KODE_BRG);
                String nama_brg = jo.getString(Config.TAG_NAMA_BRG);
                String jenis_brg = jo.getString(Config.TAG_JENIS_BRG);

                HashMap<String, String> master_barang = new HashMap<>();
                master_barang.put(Config.TAG_KODE_BRG, kode_brg);
                master_barang.put(Config.TAG_NAMA_BRG, nama_brg);
                master_barang.put(Config.TAG_JENIS_BRG, jenis_brg);
                list.add(master_barang);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Tampilkan datanya dalam Layout Lihat Data
        ListAdapter adapter = new SimpleAdapter(
                Master_barang.this, list, R.layout.lihatdata_master_barang,
                new String[]{Config.TAG_KODE_BRG, Config.TAG_NAMA_BRG, Config.TAG_JENIS_BRG},
                new int[]{R.id.kode_brg, R.id.nama_brg, R.id.jenis_brg});
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
                loading = ProgressDialog.show(Master_barang.this, "Pengambilan Data", "Wait...", false, false);
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
                String s = rh.sendGetRequest(Config.READ_MASTER_BARANG);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
}
