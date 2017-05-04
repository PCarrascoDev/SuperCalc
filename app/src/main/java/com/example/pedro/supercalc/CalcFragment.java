package com.example.pedro.supercalc;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalcFragment extends Fragment {

    private boolean isResult = false;

    public CalcFragment() {
        // Required empty public constructor
    }

    public static CalcFragment newInstance() {

        return new CalcFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calc, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //TextView
        final TextView output = (TextView) view.findViewById(R.id.inputTv);

        //Buttons
        Button oneBtn = (Button) view.findViewById(R.id.oneBtn);
        Button twoBtn = (Button) view.findViewById(R.id.twoBtn);
        Button threeBtn = (Button) view.findViewById(R.id.threeBtn);
        Button fourBtn = (Button) view.findViewById(R.id.fourBtn);
        Button fiveBtn = (Button) view.findViewById(R.id.fiveBtn);
        Button sixBtn = (Button) view.findViewById(R.id.sixBtn);
        Button sevenBtn = (Button) view.findViewById(R.id.sevenBtn);
        Button eightBtn = (Button) view.findViewById(R.id.eightBtn);
        Button nineBtn = (Button) view.findViewById(R.id.nineBtn);
        Button zeroBtn = (Button) view.findViewById(R.id.zeroBtn);
        Button divBtn = (Button) view.findViewById(R.id.divBtn);
        Button multBtn = (Button) view.findViewById(R.id.multBtn);
        Button plusBtn = (Button) view.findViewById(R.id.plusBtn);
        Button subsBtn = (Button) view.findViewById(R.id.subsBtn);
        Button equalBtn = (Button) view.findViewById(R.id.equalBtn);

        final Calc calculation = new Calc();

        //Numbers Listeners
        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isResult)
                {
                    output.setText("");
                    isResult = false;
                }
                output.setText(output.getText() + "1");
            }
        });
        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isResult)
                {
                    output.setText("");
                    isResult = false;
                }
                output.setText(output.getText() + "2");
            }
        });
        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isResult)
                {
                    output.setText("");
                    isResult = false;
                }
                output.setText(output.getText() + "3");
            }
        });
        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isResult)
                {
                    output.setText("");
                    isResult = false;
                }
                output.setText(output.getText() + "4");
            }
        });
        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isResult)
                {
                    output.setText("");
                    isResult = false;
                }
                output.setText(output.getText() + "5");
            }
        });
        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isResult)
                {
                    output.setText("");
                    isResult = false;
                }
                output.setText(output.getText() + "6");
            }
        });
        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isResult)
                {
                    output.setText("");
                    isResult = false;
                }
                output.setText(output.getText() + "7");
            }
        });
        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isResult)
                {
                    output.setText("");
                    isResult = false;
                }
                output.setText(output.getText() + "8");
            }
        });
        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isResult)
                {
                    output.setText("");
                    isResult = false;
                }
                output.setText(output.getText() + "9");
            }
        });
        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isResult)
                {
                    output.setText("");
                    isResult = false;
                }
                output.setText(output.getText() + "0");
            }
        });

        //Operation Listeners
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(output.getText() != "")
                {
                    calculation.pushValue(Float.parseFloat((String)output.getText()));
                    calculation.pushOperation('/');
                    output.setText("");
                }

            }
        });
        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (output.getText() != "")
                {
                    calculation.pushValue(Float.parseFloat((String) output.getText()));
                    calculation.pushOperation('*');
                    output.setText("");
                }

            }
        });

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (output.getText() != "")
                {
                    calculation.pushValue(Float.parseFloat((String) output.getText()));
                    calculation.pushOperation('+');
                    output.setText("");
                }

            }
        });

        subsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (output.getText() != "")
                {
                    calculation.pushValue(Float.parseFloat((String) output.getText()));
                    calculation.pushOperation('-');
                    output.setText("");
                }

            }
        });

        //Equal Listener
        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (output.getText() != "" && output.getText() != "NaN" && output.getText() != null)
                {
                    calculation.pushValue(Float.parseFloat((String) output.getText()));
                }
                else
                {
                    calculation.pushValue(0f);
                }
                //calculation.printList();
                output.setText(Float.toString(calculation.newCalc()));
                isResult = true;
            }
        });

        //Text Listener
        output.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private class Calc{
        private Queue<Float> values = new LinkedList<Float>();
        private Queue<Character> operations = new LinkedList<Character>();

        void pushValue(Float value)
        {
            values.add(value);
        }
        void pushOperation(Character operation)
        {
            operations.add(operation);
        }

        private float newCalc()
        {
            float result = 0;
            Float valueA, valueB;
            Character operation;
            while (!values.isEmpty() && operations.size() < values.size())
            {
                valueA = values.poll();
                valueB = values.poll();
                if (!operations.isEmpty())
                {
                    operation = operations.poll();

                    switch (operation)
                    {
                        case '/':
                            result += valueA/valueB;
                            break;

                        case '*':
                            result += valueA*valueB;
                            break;

                        case '+':
                            result += valueA+valueB;
                            break;

                        case '-':
                            result += valueA-valueB;
                            break;
                        default:
                            result = 0;
                            break;
                    }
                }
            }
            return result;
        }

        /*public void printList()
        {
            String conc = "";
            for (int i = 0; i < values.size(); i++)
            {
                conc = conc + values.poll();
                conc = conc + operations.poll();
            }
            Log.d("DATOS: ", conc);
        }*/
    }



}
