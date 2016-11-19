package id.sch.smktelkom_mlg.project.xiirpl502122232.inventarissekolah;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

public class Master_lokasipenempatanbarang extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_lokasipenempatanbarang);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Master_lokasipenempatanbarang.this, Master_lokasipenempatanbarang_form.class);
                startActivity(intent);
            }
        });
    }
}
