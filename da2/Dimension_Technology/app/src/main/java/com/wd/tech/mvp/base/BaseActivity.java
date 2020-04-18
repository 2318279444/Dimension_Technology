package com.wd.tech.mvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.wd.tech.mvp.contract.Contract;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 功能：BaseActivity类
 * 作者：闫圣豪
 * 当前日期：2020/04/17
 * 当前时间：14:38
 */
public abstract class BaseActivity <P extends BasePresenter>extends AppCompatActivity implements Contract.IView {

    public P mPresenter;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Layout()!=0){
            setContentView(Layout());
            mPresenter=initPresenter();
            if (mPresenter != null) {
                mPresenter.Attch(this);
            }
            bind = ButterKnife.bind(this);
            initView();
            startCoding();
        }


    }

    protected abstract void startCoding();

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract int Layout();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onEnd();
        }
    }
}
