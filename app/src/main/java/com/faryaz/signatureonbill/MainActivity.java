package com.faryaz.signatureonbill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button signatureButton;
    ImageView signImage;
    CheckBox checkBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signatureButton = (Button) findViewById(R.id.getSign);
        signImage = (ImageView) findViewById(R.id.imageView1);
        signatureButton.setOnClickListener(onButtonClick);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        //disable button if checkbox is not checked else enable button
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    signatureButton.setEnabled(true);
                }
                else{
                    signatureButton.setEnabled(false);
                }
            }
        });
        //to get imagepath from SignatureActivity and set it on ImageView
        String image_path = getIntent().getStringExtra("imagePath");
        Bitmap bitmap = BitmapFactory.decodeFile(image_path);
        signImage.setImageBitmap(bitmap);
    }

    Button.OnClickListener onButtonClick = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if (checkBox.isChecked()){
                Intent i = new Intent(MainActivity.this, SignatureActivity.class);
                startActivity(i);
            }
            else {
                signatureButton.setEnabled(false);
            }

        }
    };
}
