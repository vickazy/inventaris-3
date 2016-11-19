package id.sch.smktelkom_mlg.project.xiirpl502122232.inventarissekolah;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class Master extends TabActivity {

    TabHost TabHostWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        //Assign id to Tabhost.
        TabHostWindow = (TabHost) findViewById(android.R.id.tabhost);

        //Creating tab menu.
        TabSpec TabMenu1 = TabHostWindow.newTabSpec("First tab");
        TabSpec TabMenu2 = TabHostWindow.newTabSpec("Second Tab");
        TabSpec TabMenu3 = TabHostWindow.newTabSpec("Third Tab");

        //Setting up tab 1 name.
        TabMenu1.setIndicator("Sumber Pengadaan Barang");
        //Set tab 1 activity to tab 1 menu.
        TabMenu1.setContent(new Intent(this, Master_sumberpengadaanbarang.class));

        //Setting up tab 2 name.
        TabMenu2.setIndicator("Barang");
        //Set tab 3 activity to tab 1 menu.
        TabMenu2.setContent(new Intent(this, Master_barang.class));

        //Setting up tab 2 name.
        TabMenu3.setIndicator("Lokasi Penempatan Barang");
        //Set tab 3 activity to tab 3 menu.
        TabMenu3.setContent(new Intent(this, Master_lokasipenempatanbarang.class));

        //Adding tab1, tab2, tab3 to tabhost view.

        TabHostWindow.addTab(TabMenu1);
        TabHostWindow.addTab(TabMenu2);
        TabHostWindow.addTab(TabMenu3);

    }
}