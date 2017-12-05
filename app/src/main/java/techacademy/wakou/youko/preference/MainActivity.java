package techacademy.wakou.youko.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    SharedPreferences mPreference;
    EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreference = PreferenceManager.getDefaultSharedPreferences(this);
        mEditText = (EditText)findViewById(R.id.editText);

        Button putButton = (Button)findViewById(R.id.putButton);
        putButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Editor editor = mPreference.edit();
                editor.putString("TEXT",mEditText.getText().toString());
                editor.commit();
            }
        });

        Button getButton = (Button)findViewById(R.id.getButton);
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
            mEditText.setText(mPreference.getString("TEXT","まだ保存されていません"));
            }
        });

    }
}
