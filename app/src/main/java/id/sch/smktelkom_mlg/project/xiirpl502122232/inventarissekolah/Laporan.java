package id.sch.smktelkom_mlg.project.xiirpl502122232.inventarissekolah;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class Laporan extends AppCompatActivity implements View.OnClickListener {

    public static final String UPLOAD_URL = "http://inventarissekolah.16mb.com/upload.php";
    public static final String UPLOAD_KEY = "image";
    static final int REQUEST_IMAGE_CAPTURE = 1;

    //Mendefinisikan View Edit Text
    private EditText editTextDeskripsi;
    private EditText editTextKelas;
    private EditText editTextID;
    private ImageView ivCamera;
    private Bitmap bitmap;
    private Uri filePath;

    // Mendefinisikan View Button
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);

        editTextKelas = (EditText) findViewById(R.id.editTextKelas);
        editTextID = (EditText) findViewById(R.id.editTextID);
        editTextDeskripsi = (EditText) findViewById(R.id.editTextDeskripsi);
        ivCamera = (ImageView) findViewById(R.id.imageViewCamera);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.imageViewCamera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_IMAGE_CAPTURE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                ivCamera.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
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
            uploadImage();
        }
    }

    private void uploadImage() {
        class UploadImage extends AsyncTask<Bitmap, Void, String> {

            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Laporan.this, "Uploading...", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Bitmap... params) {
                Bitmap bitmap = params[0];
                String uploadImage = getStringImage(bitmap);

                HashMap<String, String> data = new HashMap<>();

                data.put(UPLOAD_KEY, uploadImage);
                String result = rh.sendPostRequest(UPLOAD_URL, data);

                return result;
            }
        }

        UploadImage ui = new UploadImage();
        ui.execute(bitmap);
    }

    private void Lapordata() {
        // Ubah setiap View EditText ke tipe Data String
        final String deskripsi = editTextDeskripsi.getText().toString().trim();
        final String kelas = editTextKelas.getText().toString().trim();
        final String id = editTextID.getText().toString().trim();
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
                params.put(Config.KEY_LAPORAN_KELAS, kelas);
                params.put(Config.KEY_LAPORAN_ID, id);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_LAPORAN, params);
                return res;
            }
        }
        // Jadikan Class TambahData Sabagai Object Baru
        Lapordata ae = new Lapordata();
        ae.execute();
    }


}
