package com.example.money_exchange;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static  double CALCULO;
    ArrayList<DivisaM> divisaM = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.divisas);
        setDivisaM();
        DivisaAdapter adapter = new DivisaAdapter(this,divisaM);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        double NoVip = 0.98;

        TextView resultado = findViewById(R.id.converison);
        EditText euros = findViewById(R.id.inputEuros);
        Switch vip = findViewById(R.id.vip);
        Button convertir = findViewById(R.id.calcular);

        convertir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (vip.isChecked()) {
                    resultado.setText(CALCULO * Double.parseDouble(euros.getText().toString()) + "");
                } else {
                    resultado.setText(CALCULO * NoVip * Double.parseDouble(euros.getText().toString()) + "");
                }


            }
        });
    }
    private void setDivisaM(){
        String[] NombreDivisa = getResources().getStringArray(R.array.pais);
        String[] PrecioDivisa = getResources().getStringArray(R.array.cambio);
        TypedArray typeArray = getResources().obtainTypedArray(R.array.img_pais);
        Drawable[] LogoDivisa = new Drawable[typeArray.length()];


        for (int i = 0; i < typeArray.length(); i++) {
            int id = typeArray.getResourceId(i, 0);
            if (id != 0) {
                LogoDivisa[i] = ContextCompat.getDrawable(this, id);

            }
        }
        typeArray.recycle();

        for(int i = 0;i< NombreDivisa.length;i++){
            divisaM.add(new DivisaM(
                    NombreDivisa[i],
                    PrecioDivisa[i],
                    LogoDivisa[i]



            ));
        }
    }


}