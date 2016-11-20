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
    public static final String URL_LAPORAN = "http://inventarissekolah.16mb.com/create_laporan.php";
    // Filed yang digunakan untuk dikirimkan ke Database, sesuaikan saja dengan Field di Tabel
    public static final String KEY_LAPORAN_DESKRIPSI = "deskripsi";
    public static final String KEY_LAPORAN_KELAS = "kelas";
    public static final String KEY_LAPORAN_ID = "id";

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
}