    package proyect.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {

        Button btnEnviar;
        EditText txtPeso , txtAltura;
        ImageView img;
        TextView lbl;
        String s;
        persona p = new persona();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            txtPeso = (EditText) findViewById(R.id.etPeso);
            txtAltura = (EditText) findViewById(R.id.etAltura);
            btnEnviar = (Button) findViewById(R.id.btnEnviar) ;
            img = (ImageView) findViewById(R.id.imgPeso) ;
            lbl= (TextView) findViewById(R.id.lblIMC);




            btnEnviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    p.setPeso(Double.parseDouble(String.valueOf(txtPeso.getText())));
                    p.setEstatura (Double.parseDouble(String.valueOf(txtAltura.getText())));
                    calculoIMC calculoIMC = new calculoIMC(p.getPeso() , p.getEstatura());
                    calculoIMC.calcular();
                    CambiarImagen(calculoIMC.resul);
                }
            });



        }

        public void CambiarImagen(double total)
        {
            if(total < 18.5)
            {
                img.setImageResource(R.drawable.bajo);
            }
            else if (total >18.4 & total < 25)
            {
                img.setImageResource(R.drawable.adecuado);
            }
            else if (total >= 25 & total < 30){
                img.setImageResource(R.drawable.sobrepeso);
            }
            else if (total >= 30){
                img.setImageResource(R.drawable.obeso);
            }
            lbl.setText("IMC: " + String.valueOf(total) ) ;
        }
    }
