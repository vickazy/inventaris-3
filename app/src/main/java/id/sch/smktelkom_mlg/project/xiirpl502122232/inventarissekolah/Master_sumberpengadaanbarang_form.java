package id.sch.smktelkom_mlg.project.xiirpl502122232.inventarissekolah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Master_sumberpengadaanbarang_form extends AppCompatActivity implements View.OnClickListener {

    Button buttonSubmit;
    private EditText editTextKodeSumber;
    private EditText editTextKeterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_sumberpengadaanbarang_form);

        editTextKodeSumber = (EditText) findViewById(R.id.editTextKodeSumber);
        editTextKodeSumber = (EditText) findViewById(R.id.editTextKeterangan);
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
        final String kodeSumber = editTextKodeSumber.getText().toString().trim();
        final String keterangan = editTextKeterangan.getText().toString().trim();
    }
}
