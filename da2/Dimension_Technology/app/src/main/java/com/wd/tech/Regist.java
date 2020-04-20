package com.wd.tech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.tech.bean.dlzc.DlBean;
import com.wd.tech.bean.dlzc.ZcBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;
import com.wd.tech.rsa.RsaCoder;

import java.util.HashMap;
import java.util.Map;

public class Regist extends BaseActivity {
    EditText phone,name,pwd;

    TextView ca_lo;

    Button zc;
    private String sphone;
    private String spwd;
    private String sspwd;
    private String sname;

    @Override
    protected void startCoding() {

        //返回登录
        ca_lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //注册点击事件
        zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sphone = phone.getText().toString().trim();
                spwd = pwd.getText().toString().trim();
                sname = name.getText().toString().trim();

                //rsa加密

                try {
                    sspwd = RsaCoder.encryptByPublicKey(spwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                Map<String,Object> map=new HashMap<>();
                map.put("phone", sphone);
                map.put("pwd", sspwd);
                map.put("nickName", sname);
                mPresenter.startpostInfoHava(MyUrl.BASE_ZC, ZcBean.class,map);

            }
        });


    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        phone=findViewById(R.id.phone);
        pwd=findViewById(R.id.pwd);
        name=findViewById(R.id.regist_name);
        ca_lo=findViewById(R.id.call_login);
        zc=findViewById(R.id.zc);
    }

    @Override
    protected int Layout() {
        return R.layout.activity_regist;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof ZcBean){
            String status = ((ZcBean) o).getStatus();
            if(status.equals("0000")){
                Toast.makeText(this, ((ZcBean) o).getMessage(), Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, ((ZcBean) o).getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(String error) {

    }
}
