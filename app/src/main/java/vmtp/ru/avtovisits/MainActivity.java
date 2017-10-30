package vmtp.ru.avtovisits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton bntSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bntSettings = (ImageButton)findViewById(R.id.btnSettings);
        bntSettings.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnSettings:
                openSettings();
                break;

            default:
                break;

        }

    }

    private void openSettings() {

        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
