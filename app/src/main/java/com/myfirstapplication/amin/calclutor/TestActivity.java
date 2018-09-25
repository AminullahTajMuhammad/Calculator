package com.myfirstapplication.amin.calclutor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    double number1, number2;
    boolean addition;
    boolean subtract;
    boolean division;
    boolean multiplication;
    String statement, NewString;
    String CheckZero;
    char[] Back;
    int checkForMinusButton = 0;
    int temp,iTemp, TempPM = 1;
    int checkForBackButton = 0;
    int checkForArithmaticButton = 0;
    private TextView tvText;
    int forclearMinus = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button btnDot = findViewById(R.id.btnDot);
        Button btnZero = findViewById(R.id.btnZero);
        Button btnOne = findViewById(R.id.btnOne);
        Button btnTwo = findViewById(R.id.btnTwo);
        Button btnThree = findViewById(R.id.btnThree);
        Button btnFour = findViewById(R.id.btnFour);
        Button btnFive = findViewById(R.id.btnFive);
        Button btnSix = findViewById(R.id.btnSix);
        Button btnSeven = findViewById(R.id.btnSeven);
        Button btnEight = findViewById(R.id.btnEight);
        Button btnNine = findViewById(R.id.btnNine);

        Button btnClear = findViewById(R.id.btnClear);
        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnMinus = findViewById(R.id.btnMinus);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnMulti = findViewById(R.id.btnMulti);
        Button btnPlusMinus = findViewById(R.id.btnPlusMinus);
        Button btnEqual = findViewById(R.id.btnEqual);
        Button btnBack = findViewById(R.id.btnBack);
        tvText = findViewById(R.id.tvText);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvText.setText("");
                temp = 0;
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = 0;
                statement = tvText.getText().toString();
                if(checkForBackButton == 1) {
                    statement = "";
                    tvText.setText(statement);
                    checkForBackButton = 0;
                }
                Back = statement.toCharArray();
                if(Back.length > 0) {
                    NewString = statement.substring(0,Back.length-1);
                    statement = NewString;
                    tvText.setText(statement);
                }
                else {
                    tvText.setText("");
                }
            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckZero = tvText.getText().toString();
                if(CheckZero.equals("")) {
                    tvText.setText(tvText.getText().toString()+"");
                } else {
                    tvText.setText(tvText.getText().toString()+"0");
                }
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvText.setText(tvText.getText().toString()+"1");
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvText.setText(tvText.getText().toString()+"2");
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvText.setText(tvText.getText().toString()+"3");
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvText.setText(tvText.getText().toString()+"4");
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvText.setText(tvText.getText().toString()+"5");
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvText.setText(tvText.getText().toString()+"6");
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvText.setText(tvText.getText().toString()+"7");
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvText.setText(tvText.getText().toString()+"8");
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvText.setText(tvText.getText().toString()+"9");
            }
        });


        btnPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = tvText.getText().toString();
                //Minus Shift after Arithmatic Operation perform like(+,-,x,/)
                if (checkForMinusButton == 0) {
                    st1 = new StringBuffer(st1).insert(0, "-").toString();
                    tvText.setText(st1);
                    checkForMinusButton = 1;
                } else {
                    st1 = new StringBuffer(st1).deleteCharAt(0).toString();
                    tvText.setText(st1);
                    checkForMinusButton = 0;
                }
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String CheckPoint = tvText.getText().toString();
                //After Press one dot. Dot btn does not work
                //Set Point condition of First input
                if(temp == 0) {
                    if(CheckPoint.equals("")) {
                        tvText.setText("0.");
                        temp = 1;
                    }
                    else {
                        tvText.setText(tvText.getText()+".");
                        temp = 1;
                    }
                }

                //After Any Arithmatic button pressed like (+,-,x,/)
                //Set Point condition of second input
                if(iTemp == 1) {
                    String CheckSecondPoint = Double.toString(number2);
                    if(CheckSecondPoint.equals("")) {
                        tvText.setText("0.");
                        temp = 1;
                    } else {
                        tvText.append(".");
                        temp = 1;
                    }
                    iTemp = 0;
                }

                //After one point pressed this if Works
                if(temp == 1) {
                    tvText.append("");
                }

            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iTemp = 1;
                String strAdd=tvText.getText().toString();
                if(forclearMinus == 0) {
                    tvText.setText(null);
                    forclearMinus = 1;
                }
                if(strAdd.equals("")) {
                    tvText.setText(null);
                }
                if(tvText.getText().length() > 0) {
                   // tvText.append(tvText.getText());
//                    number1 = Double.parseDouble(tvText.getText() + "");
                    if(TempPM == 1) {
                        tvText.setText(tvText.getText()+"+");
                        TempPM = 0;
                    } else if(checkForArithmaticButton == 1) {
                        tvText.setText(tvText.getText()+"+");
                        TempPM = 0;
                        checkForArithmaticButton = 0;
                    } else {
                        tvText.append("");
                    }
                }
                else {
                    tvText.setText(tvText.getText()+"");
                }
                addition = true;
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iTemp = 1;
                String strSub = tvText.getText().toString();
                if(strSub.isEmpty()) {
                    forclearMinus = 0;
                    tvText.append("");
                } else {
                    number1 = Double.parseDouble(tvText.getText()+"");
                    tvText.setText(tvText.getText()+"-");
                    subtract = true;
                }
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iTemp = 1;
                String strMulti = tvText.getText().toString();
                if (strMulti.equals("")) {
                    tvText.setText(null);
                }
                if (tvText.getText().length() > 0) {
                    if(TempPM == 1) {
                        tvText.setText(tvText.getText()+"x");
                        TempPM = 0;
                        checkForArithmaticButton = 0;
                    } else if(checkForArithmaticButton == 1) {
                        tvText.setText(tvText.getText()+"x");
                        TempPM = 0;
                        checkForArithmaticButton = 0;
                    } else {
                        tvText.append("");
                    }
                }
                else {
                    tvText.setText(tvText.getText()+"");
                }
                multiplication = true;
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iTemp = 1;
                String strDiv=tvText.getText().toString();
                if(forclearMinus == 0) {
                    tvText.setText(null);
                    forclearMinus = 1;
                }
                if(strDiv.equals("")) {
                    tvText.setText(null);
                }
                if(tvText.getText().length() > 0) {
                    if(TempPM == 1) {
                        tvText.setText(tvText.getText()+"/");
                        TempPM = 0;
                        checkForArithmaticButton = 0;
                    } else if(checkForArithmaticButton == 1) {
                        tvText.setText(tvText.getText()+"/");
                        TempPM = 0;
                        checkForArithmaticButton = 0;
                    } else {
                        tvText.append("");
                    }
                }
                else {
                    tvText.setText(tvText.getText()+"");
                }
                division = true;
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForBackButton = 1;
                checkForArithmaticButton = 1;
                statement = tvText.getText().toString();
                if(addition) {
                    String[] parts = statement.split("\\+");
                    String part1 = parts[0];
                    String part2 = parts[1];
                    tvText.setText(null);
                    number1 = Double.parseDouble(part1);
                    number2 = Double.parseDouble(part2);
                    number1 = number1 + number2;
                    tvText.setText(number1+"");
                    addition = false;
                }
                if (subtract) {
                    String[] parts = statement.split("\\-");
                    String part1 = parts[0];
                    String part2 = parts[1];
                    tvText.setText(null);
                    number1 = Double.parseDouble(part1);
                    number2 = Double.parseDouble(part2);
                    number1 = number1 - number2;
                    tvText.setText(number1+"");
                    subtract = false;
                }
                if (multiplication) {
                    //String statement = tvText.getText().toString();
                    String[] parts = statement.split("x");
                    String part1 = parts[0];
                    String part2 = parts[1];
                    tvText.setText(null);
                    number1 = Double.parseDouble(part1);
                    number2 = Double.parseDouble(part2);
                    number1 = number1 * number2;
                    tvText.setText(number1+"");
                    multiplication = false;
                }
                if(division) {
                    //String statement = tvText.getText().toString();
                    String[] parts = statement.split("/");
                    String part1 = parts[0];        //first number
                    String part2 = parts[1];        // second number
                    tvText.setText(null);
                    number1 = Double.parseDouble(part1);
                    number2 = Double.parseDouble(part2);
                    number1 = number1 / number2;
                    tvText.setText(number1+"");
                    division = false;
                }
            }
        });
    }
}