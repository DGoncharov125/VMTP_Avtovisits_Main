package vmtp.ru.avtovisits;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    final String SAVE_BASE_USERLOGIN = "SAVE_BASE_USERLOGIN";
    final String SAVE_BASE_USERPASSWORD = "SAVE_BASE_USERPASSWORD";

    Button btnSaveConnectionSettings;
    EditText edtUserName, edtUserPassword;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        /// Инициализация данных
        edtUserName = (EditText) findViewById(R.id.edtUserName);
        edtUserPassword = (EditText) findViewById(R.id.edtUserPassword);
        btnSaveConnectionSettings = (Button) findViewById(R.id.btnSaveConnectionSettings);
        btnSaveConnectionSettings.setOnClickListener(this);

        loadConnectionSettings();

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnSaveConnectionSettings:
                saveConnectionSettings();
                break;

            default:
                break;

        }

    }

    private void saveConnectionSettings() {

        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor sPrefEdit = sharedPreferences.edit();
            sPrefEdit.putString(SAVE_BASE_USERLOGIN, edtUserName.getText().toString());
            sPrefEdit.putString(SAVE_BASE_USERPASSWORD, edtUserPassword.getText().toString());
        sPrefEdit.commit();

        Toast.makeText(SettingsActivity.this, "Настройки подключения успешно сохранены", Toast.LENGTH_SHORT).show();


    }

    private void loadConnectionSettings() {

        sharedPreferences = getPreferences(MODE_PRIVATE);

        String userName = sharedPreferences.getString(SAVE_BASE_USERLOGIN,"");
        String userPassword = sharedPreferences.getString(SAVE_BASE_USERPASSWORD,"");

        edtUserName.setText(userName);
        edtUserPassword.setText(userPassword);

        Toast.makeText(SettingsActivity.this, "Настройки успешно загружены", Toast.LENGTH_SHORT).show();
    }
}
