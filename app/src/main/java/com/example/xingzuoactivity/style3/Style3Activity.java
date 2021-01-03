package com.example.xingzuoactivity.style3;

import android.content.Intent;
import android.os.Bundle;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.xingzuoactivity.BlankFragment;
import com.example.xingzuoactivity.PersonFragment;
import com.example.xingzuoactivity.R;
import com.example.xingzuoactivity.SignActivity;
import com.example.xingzuoactivity.fragment.OneFragment;
import com.example.xingzuoactivity.fragment.ThreeFragment;
import com.example.xingzuoactivity.fragment.TwoFragment;
import com.example.xingzuoactivity.toastutil.ToastUtil;

public class Style3Activity extends AppCompatActivity {

    private RadioGroup mTabRadioGroup;
    private SparseArray<Fragment> mFragmentSparseArray;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style3);
        initView();
        Intent intent = getIntent();
        String msg = intent.getStringExtra("data_tag");
        ToastUtil.ShowMsg(Style3Activity.this,msg);
    }

    private void initView() {
        mTabRadioGroup = findViewById(R.id.tabs_rg);
        mFragmentSparseArray = new SparseArray<>();
        mFragmentSparseArray.append(R.id.today_tab, OneFragment.newInstance());
        mFragmentSparseArray.append(R.id.record_tab, TwoFragment.newInstance());
        mFragmentSparseArray.append(R.id.contact_tab, ThreeFragment.newInstance());
        mFragmentSparseArray.append(R.id.settings_tab, PersonFragment.newInstance());
        mTabRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 具体的fragment切换逻辑可以根据应用调整，例如使用show()/hide()
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        mFragmentSparseArray.get(checkedId)).commit();
            }
        });
        // 默认显示第一个
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                mFragmentSparseArray.get(R.id.today_tab)).commit();
        findViewById(R.id.sign_iv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Style3Activity.this, SignActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
