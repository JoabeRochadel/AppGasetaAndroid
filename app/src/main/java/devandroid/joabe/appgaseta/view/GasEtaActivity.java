package devandroid.joabe.appgaseta.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.joabe.appgaseta.R;
import devandroid.joabe.appgaseta.controller.FuelController;
import devandroid.joabe.appgaseta.model.Fuel;
import devandroid.joabe.appgaseta.util.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {

    EditText editGas;
    EditText editEthanol;

    TextView txtCalc;

    Button buttonCalc;
    Button buttonClean;
    Button buttonSave;
    Button buttonFinish;

    double priceGas;
    double priceEtha;
    String resultCalc;
    Fuel gasoline;
    Fuel ethanol;
    FuelController fuelController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        editGas = findViewById(R.id.editGas);
        editEthanol = findViewById(R.id.editEthanol);

        txtCalc = findViewById(R.id.txtCalc);

        buttonCalc = findViewById(R.id.buttonCalc);
        buttonClean = findViewById(R.id.buttonClean);
        buttonSave = findViewById(R.id.buttonSave);
        buttonFinish = findViewById(R.id.buttonFinish);

        fuelController = new FuelController(GasEtaActivity.this);

        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isOk = true;

                if (TextUtils.isEmpty(editGas.getText())) {
                    editGas.setError("* Obrigatório");
                    editGas.requestFocus();
                    isOk = false;
                }
                if (TextUtils.isEmpty(editEthanol.getText())) {
                    editEthanol.setError("* Obrigatório");
                    editEthanol.requestFocus();
                    isOk = false;
                }

                if (isOk) {
                    priceGas = Double.parseDouble(editGas.getText().toString());
                    priceEtha = Double.parseDouble(editEthanol.getText().toString());

                    resultCalc = UtilGasEta.getBestOptionGasEta(priceGas, priceEtha);

                    txtCalc.setText(resultCalc);

                    buttonSave.setEnabled(true);
                } else {
                    Toast.makeText(GasEtaActivity.this, "Digite os valores obrigatórios", Toast.LENGTH_LONG).show();

                    buttonSave.setEnabled(false);
                }

            }
        });
        buttonClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editGas.setText("");
                editEthanol.setText("");
                txtCalc.setText("");

                buttonSave.setEnabled(false);

                fuelController.clean();
            }
        });
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gasoline = new Fuel();
                ethanol = new Fuel();

                gasoline.setNameFuel("Gasolina");
                gasoline.setPriceFuel(priceGas);
                gasoline.setRecommendationFuel(resultCalc);

                ethanol.setNameFuel("Etanol");
                ethanol.setPriceFuel(priceEtha);
                ethanol.setRecommendationFuel(resultCalc);

                fuelController.save(gasoline);
                fuelController.save(ethanol);
            }
        });
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasEtaActivity.this, "Finalizando o app GasEta...", Toast.LENGTH_LONG).show();
                finish();
            }
        });


    }
}
