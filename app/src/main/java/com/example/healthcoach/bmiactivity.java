package com.example.healthcoach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmiactivity extends AppCompatActivity {
    android.widget.Button mrecalculatebmi;

    TextView mbmidisplay, mbmicategory,mgender;
    Intent intent;
    ImageView mimsgeview;
    String mbmi;
    Float intbmi;

    String height;
    String weight;
    Float intheight,intweight;
    RelativeLayout mbackground;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font colour=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable ColorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(ColorDrawable);

        intent=getIntent();
        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicategory=findViewById(R.id.bmicategory);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);

        mimsgeview=findViewById(R.id.imageview);
        mrecalculatebmi=findViewById(R.id.Recalculatebmi);

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;

        intbmi=intweight/(intheight*intheight);

        mbmi=Float.toString(intbmi);

        if (intbmi<16)
        {
            mbmicategory.setText("severe Thiness- contact doctor");
            mbackground.setBackgroundColor(Color.RED);
            mimsgeview.setImageResource(R.drawable.crosss);
        }
        else if(intbmi<16.9&& intbmi>16)
        {
            mbmicategory.setText("Moderate Thiness- eat good");
            mbackground.setBackgroundColor(Color.RED);
            mimsgeview.setImageResource(R.drawable.warning);
        }

        else if(intbmi<18.4&& intbmi>17)
        {
            mbmicategory.setText("Mild Thiness- eat good");
            mbackground.setBackgroundColor(Color.RED);
            mimsgeview.setImageResource(R.drawable.warning);

        }
        else if (intbmi<25&&intbmi>18.4)
        {
            mbmicategory.setText("Every thing is normal");
            mimsgeview.setImageResource(R.drawable.ok);
        }

        else if (intbmi<29.4&&intbmi>25)
        {
            mbmicategory.setText("Overweight-Do regular exercise ");
            mbackground.setBackgroundColor(Color.RED);
            mimsgeview.setImageResource(R.drawable.warning);
        }
        else
        {
            mbmicategory.setText("Severe Obesity- Contact Doctor");
            mbackground.setBackgroundColor(Color.RED);
            mimsgeview.setImageResource(R.drawable.warning);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);








        getSupportActionBar().hide();
        mrecalculatebmi=findViewById(R.id.Recalculatebmi);
        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bmiactivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}