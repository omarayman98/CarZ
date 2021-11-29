package com.example.carz.Activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carz.Classes.BottomSheet;
import com.example.carz.R;
import com.google.android.material.textfield.TextInputLayout;

public class Registration extends AppCompatActivity implements BottomSheet.BottomSheetListener{
    boolean SIGNIN_MODE =false;
    Button signIn_Out_btn;
    LinearLayout terms_Layout;
    LinearLayout activationCode_PopUP;
    boolean termsCheckBox =false;
    TextInputLayout name,phoneNum,password,confirm_password;
    TextView forget_password,Page_Label,to_signIn_et,haveAccount_et;
    ImageView checkbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestration);
        checkbox=findViewById(R.id.checkbox_SignUp);
        name=findViewById(R.id.textField_name);
        phoneNum=findViewById(R.id.textField_phone);
        password=findViewById(R.id.textField_password);
        confirm_password=findViewById(R.id.textField_confirm_password);
        signIn_Out_btn=findViewById(R.id.signIn_Out_btn);
        //On Activation
        activationCode_PopUP=findViewById(R.id.ActivationPopUp);
        //Sign in Mode Labels
        Page_Label=findViewById(R.id.Page_Label);
        forget_password=findViewById(R.id.forget_password);
        terms_Layout =findViewById(R.id.linearLayout_terms);
        to_signIn_et =findViewById(R.id.to_signIn_et);
        haveAccount_et =findViewById(R.id.haveAccount_et);
        //Video
        VideoView video = findViewById(R.id.video);
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.registration_video);
        video.setVideoURI(videoPath);
        video.start();
    }


    public void InRegistration(View view) {
        switch (view.getId()){
            case R.id.checkbox_SignUp:
                if (!termsCheckBox){
                    checkbox.setImageResource(R.mipmap.checkboxfilled);
                    termsCheckBox =true;
                }else {
                    checkbox.setImageResource(R.mipmap.checkbox);
                    termsCheckBox =false;
                }
                break;

            case R.id.terms:
                Intent TermsLink = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(TermsLink);
                break;

            case R.id.signIn_Out_btn:if (SIGNIN_MODE){
                Intent  to_WashServices= new Intent(this, MainActivity.class);
                startActivity(to_WashServices);
                overridePendingTransition( R.anim.slide_in_top, R.anim.slide_out_down );
            }else{
                BottomSheet bottomSheet =new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(),"TAG");
            }


                break;

            case R.id.signIn_Out_Layout:
                if(!SIGNIN_MODE){
                    //Sign Up
                    Page_Label.setText("SIGN IN");
                    haveAccount_et.setText("Create new Account");
                    to_signIn_et.setText("SIGN UP");
                    forget_password.setText("FORGOT PASSWORD?");
                    signIn_Out_btn.setText("SIGN IN");
                    name.setVisibility(view.INVISIBLE);
                    confirm_password.setVisibility(view.INVISIBLE);
                    terms_Layout.setVisibility(view.INVISIBLE);
                    phoneNum.animate().translationYBy(-50).setDuration(100).start();
                    password.animate().translationYBy(-50).setDuration(100).start();
                    signIn_Out_btn.animate().translationYBy(-250).setDuration(100).start();
                    forget_password.animate().translationYBy(-200).setDuration(100).start();
                    SIGNIN_MODE =true;
                }else {
                    //Sign In Mode
                    forget_password.animate().translationX(0).translationY(0).setDuration(100);
                    forget_password.setText("");
                    Page_Label.setText("SIGN UP");
                    to_signIn_et.setText("SIGN UP");
                    haveAccount_et.setText("Have Account?");
                    signIn_Out_btn.setText("CREATE ACCOUNT");
                    phoneNum.animate().translationX(0).translationY(0).setDuration(100);
                    password.animate().translationX(0).translationY(0).setDuration(100);
                    signIn_Out_btn.animate().translationX(0).translationY(0).setDuration(100);
                    name.setVisibility(view.VISIBLE);
                    confirm_password.setVisibility(view.VISIBLE);
                    terms_Layout.setVisibility(view.VISIBLE);
                    SIGNIN_MODE =false;
                }
            break;
        }

    }

    @Override
    public void onButtonClicked(String text) {

    }
}