package co.edu.unimagdalena.appmoviles.tallerunimag2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText dx1,dy1,dx2,dy2;
    Button puntoM,Pendi,cuadra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dx1 = findViewById(R.id.edt1);
        dy1 = findViewById(R.id.edt2);
        dx2 = findViewById(R.id.edt3);
        dy2 = findViewById(R.id.edt4);
        puntoM = findViewById(R.id.btnpuntomedio);
        Pendi = findViewById(R.id.btnpendiente);
        cuadra = findViewById(R.id.btncuadrante);
        puntoM.setOnClickListener(this);
        Pendi.setOnClickListener(this);
        cuadra.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.m1:
                double x1 = Double.parseDouble(dx1.getText().toString());
                double x2 = Double.parseDouble(dx2.getText().toString());
                double y1 = Double.parseDouble(dy1.getText().toString());
                double y2 = Double.parseDouble(dy2.getText().toString());
                double D;
                D = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
                Toast.makeText(getApplicationContext(),"La Distancia entre los puntos es: "+D,Toast.LENGTH_LONG).show();
                break;
            case R.id.m2:
                dx1.setText(aleatorio());
                dy1.setText(aleatorio());
                dx2.setText(aleatorio());
                dy2.setText(aleatorio());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if(TextUtils.isEmpty(dx1.getText().toString()) || TextUtils.isEmpty(dx2.getText().toString()) ||  TextUtils.isEmpty(dy1.getText().toString()) ||
                TextUtils.isEmpty(dy2.getText().toString())){
            Toast.makeText(getApplicationContext(), "Datos invalidos", Toast.LENGTH_LONG).show();
        }else {
            double x1 = Double.parseDouble(dx1.getText().toString());
            double x2 = Double.parseDouble(dx2.getText().toString());
            double y1 = Double.parseDouble(dy1.getText().toString());
            double y2 = Double.parseDouble(dy2.getText().toString());
            double puntoMy,puntoMx,M;
            switch (view.getId()){
                case R.id.btnpuntomedio:
                    puntoMy = (x2+x1)/2;
                    puntoMx = (y2+y1)/2;
                    Toast.makeText(getApplicationContext(),"El punto Medio es: ("+puntoMx+" , "+puntoMy+")",Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnpendiente:
                    M = (y2-y1)/(x2-x1);
                    Toast.makeText(getApplicationContext(),"La Pendiente es: "+M,Toast.LENGTH_LONG).show();
                    break;
                case R.id.btncuadrante:
                    puntoMy = (x2+x1)/2;
                    puntoMx = (y2+y1)/2;

                    if(puntoMx>0 && puntoMy >0){
                        Toast.makeText(getApplicationContext(),"Se encuentra en el cuadrante  1",Toast.LENGTH_LONG).show();
                    }else if(puntoMx < 0 && puntoMy > 0){
                        Toast.makeText(getApplicationContext(),"Se encuentra en el cuadrante  2",Toast.LENGTH_LONG).show();
                    }else if(puntoMx < 0 && puntoMy < 0){
                        Toast.makeText(getApplicationContext(),"Se encuentra en el cuadrante  3",Toast.LENGTH_LONG).show();
                    }else if(puntoMx > 0 && puntoMy < 0){
                        Toast.makeText(getApplicationContext(),"Se encuentra en el cuadrante  4",Toast.LENGTH_LONG).show();
                    }
                    break;

            }
        }
    }

    public String aleatorio(){
        int maxi = 50, mini = -50;
        Random random = new Random();
        int a = random.nextInt((maxi-mini)+1)+mini;
        String aleatorio = ""+a;
        return aleatorio;
    }
}