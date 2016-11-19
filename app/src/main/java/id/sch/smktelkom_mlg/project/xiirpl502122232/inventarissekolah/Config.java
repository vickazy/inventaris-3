package id.sch.smktelkom_mlg.project.xiirpl502122232.inventarissekolah;

public class Config {
    //URL to our login.php file
    public static final String LOGIN_URL = "http://inventarissekolah.16mb.com/login.php";

    public static final String URL_LAPORAN = "http://inventarissekolah.16mb.com/create_laporan.php";

    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    // Filed yang digunakan untuk dikirimkan ke Database, sesuaikan saja dengan Field di Tabel
    public static final String KEY_LAPORAN_DESKRIPSI = "deskripsi";
    public static final String KEY_LAPORAN_KELAS = "kelas";
    public static final String KEY_LAPORAN_ID = "id";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "myloginapp";

    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "email";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";
}