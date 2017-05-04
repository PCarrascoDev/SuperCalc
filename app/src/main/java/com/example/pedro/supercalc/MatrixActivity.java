package com.example.pedro.supercalc;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MatrixActivity extends AppCompatActivity {

    private EditText mat1Et[][] = new EditText[3][3];
    private EditText mat2Et[][] = new EditText[3][3];
    private Integer matC[][] = new Integer[3][3];
    private boolean sum = true;

    private static final int idsA[] = {R.id.m1a, R.id.m1b, R.id.m1c, R.id.m1d, R.id.m1e, R.id.m1f, R.id.m1g, R.id.m1h, R.id.m1i};
    private static final int idsB[] = {R.id.m2a, R.id.m2b, R.id.m2c, R.id.m2d, R.id.m2e, R.id.m2f, R.id.m2g, R.id.m2h, R.id.m2i};

    void setMatC ()
    {
        Integer a, b;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3 ; j++)
            {
                a = 0;
                b = 0;
                if (!Objects.equals(mat1Et[i][j].getText().toString(), ""))
                {
                    a = Integer.parseInt(mat1Et[i][j].getText().toString());

                }
                if (!Objects.equals(mat2Et[i][j].getText().toString(), ""))
                {

                    b = Integer.parseInt(mat2Et[i][j].getText().toString());

                }
                Log.d("A", String.valueOf(a));
                Log.d("B", String.valueOf(b));
                if (sum)
                {
                    matC[i][j] = a + b;
                }
                else
                {
                    matC[i][j] = a - b;
                }

            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);
        //Setting up Matrix A

        for (int i = 0, k = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                mat1Et[i][j]= (EditText) findViewById(idsA[k]);
                k++;

            }
        }


        //Setting up Matrix B



        for (int i = 0, k = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                mat2Et[i][j]= (EditText) findViewById(idsB[k]);
                k++;

            }
        }

        Button result = (Button) findViewById(R.id.resultBtn);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMatC();
                String resultA = "(" + matC[0][0] + ")" + "(" + String.valueOf(matC[0][1]) + ")" + "(" + matC[0][2] + ")";
                String resultB = "(" + matC[1][0] + ")" + "(" + String.valueOf(matC[1][1]) + ")" + "(" + matC[1][2] + ")";
                String resultC = "(" + matC[2][0] + ")" + "(" + String.valueOf(matC[2][1]) + ")" + "(" + matC[2][2] + ")";
                Log.d("Result", resultA + resultB + resultC);

                AlertDialog dialog = new AlertDialog.Builder(new ContextThemeWrapper(MatrixActivity.this, R.style.myDialog)).create();
                dialog.setTitle("Result: ");
                dialog.setMessage(resultA + "\n" + resultB + "\n" + resultC);
                dialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        SwitchCompat sumSwitch = (SwitchCompat) findViewById(R.id.sumSwt);
        final TextView sumTv = (TextView) findViewById(R.id.sumTv);
        sumSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    sumTv.setText("-");
                    sum = false;
                    Toast toast = Toast.makeText(MatrixActivity.this, "Subtraction enabled", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    sumTv.setText("+");
                    sum = true;
                    Toast toast = Toast.makeText(MatrixActivity.this, "Addition enabled", Toast.LENGTH_SHORT);
                    toast.show();

                }
            }
        });


    }
}
