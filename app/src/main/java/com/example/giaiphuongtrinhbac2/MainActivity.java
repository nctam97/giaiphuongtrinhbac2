package com.example.giaiphuongtrinhbac2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText editA, editB, editC;
    Button btnGiai;
    TextView textKq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editA=(EditText)findViewById(R.id.editText_A);
        editB=(EditText)findViewById(R.id.editText_B);
        editC=(EditText)findViewById(R.id.editText_C);
        btnGiai=(Button)findViewById(R.id.button_giai);
        textKq=(TextView)findViewById(R.id.textView_kq);
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String soA=editA.getText().toString();
            double a=Double.parseDouble(soA);
            String soB=editB.getText().toString();
            double b=Double.parseDouble(soB);
            String soC=editC.getText().toString();
            double c=Double.parseDouble(soC);
            if(a==0){
                textKq.setText("Phương trình bậc 1");
                if(b==0){
                    if(c==0)
                        textKq.setText("Phương trình có vô số nghiệm");
                    else
                        textKq.setText("Phương trình vô nghiệm");
                }
                else {
                    textKq.setText("x = " + (-c/b));
                }
            }
            else {
                double delta = b*b - (4*a*c);
                if(delta < 0){
                    textKq.setText("Phương trình vô nghiệm");
                }
                else
                    if (delta == 0){
                        textKq.setText("Phương trình có nghiệm kép: " + (-b/(2*a)));
                    }
                    else {
                        double delta_sqrt = Math.sqrt(delta);
                        textKq.setText("x1 = " + ((b*b + delta_sqrt)/(2 * a)) +"\n" + "x2 = " + ((b*b - delta_sqrt)/(2 * a)));
                    }
            }

            }
        });
    }
}
