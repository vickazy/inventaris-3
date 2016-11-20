package id.sch.smktelkom_mlg.project.xiirpl502122232.inventarissekolah;

public class Config {
    //LOGIN
    //URL to our login.php file
    public static final String LOGIN_URL = "http://inventarissekolah.16mb.com/inventaris/login.php";

    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "myloginapp";

    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "email";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";

    //LAPORAN
    public static final String LAPORAN = "http://inventarissekolah.16mb.com/inventaris/create_laporan.php";
    // Filed yang digunakan untuk dikirimkan ke Database, sesuaikan saja dengan Field di Tabel
    public static final String KEY_LAPORAN_BAGIAN = "kode_bgn";
    public static final String KEY_LAPORAN_BARANG = "kode_brg";
    public static final String KEY_LAPORAN_DESKRIPSI = "deskripsi";

    //INPUT MASTER BARANG
    public static final String MASTER_BARANG_URL = "http://inventarissekolah.16mb.com/inventaris/input_master_barang.php";
    public static final String KEY_KODE_BARANG = "kode";
    public static final String KEY_NAMA_BARANG = "nama";
    public static final String KEY_JENIS_BARANG = "jenis";

    //INPUT MASTER SUMBER PENGADAAN BARANG
    public static final String MASTER_SUMBER_URL = "http://inventarissekolah.16mb.com/inventaris/input_master_sumberpengadaan.php";
    public static final String KEY_KODE_SUMBER = "kode";
    public static final String KEY_KETERANGAN = "ket";

    //INPUT MASTER LOKASI PENEMPATAN BARANG
    public static final String MASTER_LOKASI_URL = "http://inventarissekolah.16mb.com/inventaris/input_master_lokasipenempatan.php";
    public static final String KEY_KODE_BGN = "kode_bgn";
    public static final String KEY_NAMA_BGN = "nama_bgn";

    //INPUT TRANSAKSI PENGADAAN DONE
    public static final String TRANSAKSI_PENGADAAN = "http://inventarissekolah.16mb.com/inventaris/input_transaksi_pengadaanbarang.php";
    public static final String KEY_PENGADAANBARANG_NOURUT = "no_urut";
    public static final String KEY_PENGADAANBARANG_KODESUMBER = "kode";
    public static final String KEY_PENGADAANBARANG_MERKBARANG = "merk";
    public static final String KEY_PENGADAANBARANG_SPEK = "spesifikasi";
    public static final String KEY_PENGADAANBARANG_KODEBARANG = "kode_brg";
    public static final String KEY_PENGADAANBARANG_JUMLAH = "jumlah";
    public static final String KEY_PENGADAANBARANG_TAHUN = "tahun";

    //INPUT TRANSAKSI MUTASI DONE
    public static final String TRANSAKSI_MUTASI = "http://inventarissekolah.16mb.com/inventaris/input_transaksi_mutasibarang.php";
    public static final String KEY_MUTASIBARANG_NOURUT = "no_urut";
    public static final String KEY_MUTASIBARANG_KODEINVENTARIS = "kode_akhir";
    public static final String KEY_MUTASIBARANG_LOKASIBARU = "lok_baru";
    public static final String KEY_MUTASIBARANG_LOKASILAMA = "lok_lama";
    public static final String KEY_MJUTASIBARANG_JUMLAH = "jumlah";

    //INPUT TRANSAKSI PENGKODEAN DONE
    public static final String TRANSAKSI_PENGKODEAN = "http://inventarissekolah.16mb.com/inventaris/input_transaksi_pengkodean.php";
    public static final String KEY_PENGKODEAN_NOURUT = "no_urut";
    public static final String KEY_PENGKODEAN_KODESUMBER = "kode";
    public static final String KEY_PENGKODEAN_KODEBARANG = "kode_brg";
    public static final String KEY_PENGKODEAN_KODEINVENTARIS = "kode_akhir";

    //INPUT TRANSAKSI PEMELIHARAAN
    public static final String TRANSAKSI_PEMELIHARAAN = "http://inventarissekolah.16mb.com/inventaris/input_transaksi_pemeliharaanbarang.php";
    public static final String KEY_PEMELIHARAANBARANG_NOURUT = "no_urut";
    public static final String KEY_PEMELIHARAANBARANG_KODEINVENTARIS = "kode";
    public static final String KEY_PEMELIHARAANBARANG_KODELOKASI = "kd_bgn";
    public static final String KEY_PEMELIHARAANBARANG_KONDISIBAIK = "kon_baik";
    public static final String KEY_PEMELIHARAANBARANG_KONDISIRUSAK = "kon_rusak";
    public static final String KEY_PEMELIHARAANBARANG_KONDISIHILANG = "kon_hilang";

    //INPUT TRANSAKSI PENEMPATAN DONE
    public static final String TRANSAKSI_PENEMPATAN = "http://inventarissekolah.16mb.com/inventaris/input_transaksi_penempatanbarang.php";
    public static final String KEY_PENEMPATANBARANG_NOURUT = "no_urut";
    public static final String KEY_PENEMPATANBARANG_KODEINVENTARIS = "kode_akhir";
    public static final String KEY_PENEMPATANBARANG_KODELOKASI = "kode_bgn";
    public static final String KEY_PENEMPATANBARANG_JUMLAH = "jumlah";


    //READ MASTER BARANG
    public static final String READ_MASTER_BARANG = "http://inventarissekolah.16mb.com/inventaris/read_master_barang.php";
    // Tags Format JSON
    public static final String TAG_JSON_ARRAY = "result";
    public static final String TAG_KODE_BRG = "kode_brg";
    public static final String TAG_NAMA_BRG = "nama_brg";
    public static final String TAG_JENIS_BRG = "jenis_brg";

    //READ MASTER LOKASI PENEMPATAN BARANG
    public static final String READ_MASTER_LOKASIPENEMPATAN = "http://inventarissekolah.16mb.com/inventaris/read_master_lokasipenempatanbarang.php";
    // Tags Format JSON
    public static final String TAG_JSON_LOKASI = "result";
    public static final String TAG_KODEAKHIR = "kode_akhir";
    public static final String TAG_KODEBGN = "kode_bgn";
    public static final String TAG_JUMLAH = "jumlah";

    //READ MASTER SUMBER PENGADAAN
    public static final String READ_MASTER_SUMBERPENGADAAN = "http://inventarissekolah.16mb.com/inventaris/read_master_sumberpengadaanbarang.php";
    // Tags Format JSON
    public static final String TAG_JSON_SUMBER = "result";
    public static final String TAG_KODE = "kode";
    public static final String TAG_KET = "ket";
}