package pl.akademiakodu.intent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // ćwiczymy oczekiwanie na rezultat z innego activity

    Button buttonGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGo = (Button) findViewById(R.id.buttonGo);
        buttonGo.setOnClickListener(this);
    }

    // sposób implementacji onClicka w zależności od ilości przycisków i działań - wiem o co chodzi (klasa zagnieżdżona)

    // metoda dziedziczona z activity obsugująca rezultat z innego activity np.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==0){// sprawdzamy który rezultat do nas przyszedl po id - 0 ustawilismy
            if (resultCode== Activity.RESULT_OK){// jeżeli rezultat jest prawidłowy to wyświetlamy dane
                Toast.makeText(this, data.getStringExtra("name"), Toast.LENGTH_SHORT).show();
            }else{// jeśi rezultat jest nieprawidłowy to wyświetamy sobie że wystąpił błąd - robione jako else
                Toast.makeText(this, "Wystąpił błąd", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == buttonGo.getId()){
            Intent i = new Intent(this, DataActivity.class);
            // startActivity(i); wcześniej było
            startActivityForResult(i, 0);// uruchomienie activity z oczekiwaniem na rezultat - id wyniku zeby wiedzieć który wrócił
        }
    }
}
