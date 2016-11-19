package id.sch.smktelkom_mlg.project.xiirpl502122232.inventarissekolah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    }
}
