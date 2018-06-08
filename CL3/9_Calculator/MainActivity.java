package com.example.abhishekbafna.ca;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button btnsin,btncos,btntan,btnadd,btnsub,btnmul,btndiv,btnSqrt,btnSav,btnRec,btnClr;
    private EditText etnum,etres,etnum2;
    private static double memoryValue,inputvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        btnsin=(Button)findViewById(R.id.btnSin);
        btncos=(Button)findViewById(R.id.btnCos);
        btntan=(Button)findViewById(R.id.btnTan);
        btnadd=(Button)findViewById(R.id.btnAdd);
        btnsub=(Button)findViewById(R.id.btnSub);
        btnmul=(Button)findViewById(R.id.btnMult);
        btndiv=(Button)findViewById(R.id.btnDiv);
        btnSqrt=(Button)findViewById(R.id.btnsqrt);
        btnClr=(Button)findViewById(R.id.btnclr);
        btnRec=(Button)findViewById(R.id.btnmr);
        btnSav=(Button)findViewById(R.id.btnms);
        etnum=(EditText)findViewById(R.id.etNum);
        etnum2=(EditText)findViewById(R.id.etNum2);
        etres=(EditText)findViewById(R.id.tvResult);
        btnsin.setOnClickListener(this);
        btncos.setOnClickListener(this);
        btntan.setOnClickListener(this);
        btnadd.setOnClickListener(this);
        btnsub.setOnClickListener(this);
        btnmul.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnSqrt.setOnClickListener(this);
        btnClr.setOnClickListener(this);
        btnRec.setOnClickListener(this);
        btnSav.setOnClickListener(this);
    }
    public void onClick(View view){
        String num1=etnum.getText().toString();

        switch(view.getId()){
            case R.id.btnSin:
                double sin= Math.sin(Double.parseDouble(num1));
                etres.setText(String.valueOf(sin));
                break;
            case R.id.btnCos:
                double Cos=Math.cos(Double.parseDouble(num1));
                etres.setText(String.valueOf(Cos));
                break;
            case R.id.btnTan:
                double Tan=Math.tan(Double.parseDouble(num1));
                etres.setText(String.valueOf(Tan));
                break;
            case R.id.btnSub:
                double sub=Double.parseDouble(num1)-Double.parseDouble(etnum2.getText().toString());
                etres.setText(String.valueOf(sub));
                break;
            case R.id.btnAdd:
                double add=Double.parseDouble(num1)+Double.parseDouble(etnum2.getText().toString());
                etres.setText(String.valueOf(add));
                break;
            case R.id.btnMult:
                double mul=Double.parseDouble(num1)*Double.parseDouble(etnum2.getText().toString());
                etres.setText(String.valueOf(mul));
                break;
            case R.id.btnDiv:
                double div=Double.parseDouble(num1)/Double.parseDouble(etnum2.getText().toString());
                etres.setText(String.valueOf(div));
                break;
            case R.id.btnsqrt:
                double sqrt=Math.sqrt(Double.parseDouble(num1));
                etres.setText(String.valueOf(sqrt));
                break;
            case R.id.btnclr:
                memoryValue = Double.NaN;
                etres.setText("data cleared");
                break;
            case R.id.btnmr:
                if (Double.isNaN(memoryValue)) {
                    etres.setText("no data");
                }
                else
                    etres.setText(String.valueOf((int)memoryValue));
                break;
            case R.id.btnms:
                inputvalue= Double.parseDouble(etres.getText().toString());
                if (Double.isNaN(inputvalue)){
                    etres.setText("no data");}
                else {
                    memoryValue = inputvalue;
                    etres.setText(String.valueOf(memoryValue));}
                break;


        }
    }

}