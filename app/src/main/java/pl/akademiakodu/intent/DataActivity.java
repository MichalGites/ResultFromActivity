package pl.akademiakodu.intent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DataActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonBack;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        buttonBack = (Button) findViewById(R.id.buttonBack);
        text = (EditText) findViewById(R.id.editText);
        buttonBack.setOnClickListener(this);
    }

    // zrobiliśmy hinta sobie - podpowiedź znika po kliknięciu i nie trzeba tekstu w polu usuwać bo to tylko podpowiedź jest
    // pole tekst w xml musimy wtedy dać jako puste żeby działało

    @Override
    public void onClick(View view) {
        // mamy jeden przycisk wiec warunek na klikniecie danego przycisku jest zbedny
        Intent intent = new Intent();
        // wsadzamy wartość o kluczu name do inetntu - wartość to co wpisał użytkownik
        intent.putExtra("name", text.getText().toString());
        // ustawiamy rezultat - czy sie powiódł i dane czyli intent
        setResult(Activity.RESULT_OK, intent);
        // żeby zadziałało kończymy tutaj activity chyba :)
        finish();
    }
}
