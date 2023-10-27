package com.example.android_fragment_change;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

import java.io.FileDescriptor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button moddleOne,moddleTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moddleOne=findViewById(R.id.main_moddleOne);
        moddleTwo=findViewById(R.id.main_moddleTwo);
        moddleOne.setOnClickListener(this);
        moddleTwo.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.main_moddleTwo){
            replaceFragment(new ItemFragment());
        }
        if (view.getId() == R.id.main_moddleOne) {
            replaceFragment(new MapsFragment());
        }

    }

    //动态切换fragment
    private void replaceFragment(Fragment fragment) {
        //创建碎片管理器
        FragmentManager fragmentManager=getSupportFragmentManager();
        //创建transaction,也就是切换动作
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment,fragment);
        //改变在栈中的存储方式
        //让fragment以堆积的形式存放在栈中而非覆盖
        transaction.addToBackStack(null);
        transaction.commit();
    }
}