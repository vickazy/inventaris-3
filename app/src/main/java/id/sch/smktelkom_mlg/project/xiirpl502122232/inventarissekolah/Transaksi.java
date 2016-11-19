package id.sch.smktelkom_mlg.project.xiirpl502122232.inventarissekolah;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Transaksi extends AppCompatActivity implements View.OnClickListener {

    Button pengadaanbarang, pengkodean, penempatanbarang, mutasibarang, pemeliharaanbarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);

        pengadaanbarang = (Button) findViewById(R.id.buttonpengadaanbarang);
        pengkodean = (Button) findViewById(R.id.buttonpengkodean);
        penempatanbarang = (Button) findViewById(R.id.buttonpenempatanbarang);
        mutasibarang = (Button) findViewById(R.id.buttonmutasibarang);
        pemeliharaanbarang = (Button) findViewById(R.id.buttonpemeliharaanbarang);

        pengadaanbarang.setOnClickListener(this);
        pengkodean.setOnClickListener(this);
        penempatanbarang.setOnClickListener(this);
        mutasibarang.setOnClickListener(this);
        pemeliharaanbarang.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == pengadaanbarang) {
            startActivity(new Intent(this, Transaksi_pengadaanbarang.class));
        }

        if (v == pengkodean) {
            startActivity(new Intent(this, Transaksi_pengkodean.class));
        }

        if (v == penempatanbarang) {
            startActivity(new Intent(this, Transaksi_penempatanbarang.class));
        }

        if (v == mutasibarang) {
            startActivity(new Intent(this, Transaksi_mutasibarang.class));
        }

        if (v == pemeliharaanbarang) {
            startActivity(new Intent(this, Transaksi_pemeliharaanbarang.class));
        }
    }
}
