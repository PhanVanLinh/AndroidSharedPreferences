package toong.vn.androidsharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import toong.vn.androidsharedpreferences.api.SharedPreferenceApi;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferenceApi sharedPreferenceApi = new SharedPreferenceApi(this);
        sharedPreferenceApi.put(SharedPreferenceApi.PREFS_USER_NAME, "PhanVanLinh");
        sharedPreferenceApi.put(SharedPreferenceApi.PREFS_PASS_WORD, "Password");
        sharedPreferenceApi.put(SharedPreferenceApi.PREFS_PASS_WORD, null);
    }
}
