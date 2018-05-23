package toong.vn.androidsharedpreferences;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import toong.vn.androidsharedpreferences.api.SharedPreferenceApi;

public class MainActivity extends AppCompatActivity {
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvStatus = findViewById(R.id.text_status);

        final SharedPreferenceApi sharedPreferenceApi = new SharedPreferenceApi(this);
        sharedPreferenceApi.put(SharedPreferenceApi.PREFS_PASS_WORD, "Password");
        sharedPreferenceApi.put(SharedPreferenceApi.PREFS_PASS_WORD, null);

        findViewById(R.id.button_put).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferenceApi.put(SharedPreferenceApi.PREFS_USER_NAME, "PhanVanLinh");
                tvStatus.setText("Success");
            }
        });

        findViewById(R.id.button_get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvStatus.setText(sharedPreferenceApi.get(SharedPreferenceApi.PREFS_USER_NAME, String.class));
            }
        });
    }
}
