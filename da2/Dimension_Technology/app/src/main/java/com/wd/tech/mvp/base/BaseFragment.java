package com.wd.tech.mvp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.wd.tech.mvp.contract.Contract;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 功能：BaseFragment类
 * 作者：闫圣豪
 * 当前日期：2020/04/17
 * 当前时间：16:07
 */
public abstract class BaseFragment <P extends BasePresenter> extends Fragment implements Contract.IView {

    public P mPresenter;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(Layout(),container,false);
        initView(view);
        bind = ButterKnife.bind(this, view);
        mPresenter=initPresenter();
        if (mPresenter != null) {
            mPresenter.Attch(this);
        }
        startCoding();
        return view;
    }

    protected abstract void startCoding();

    protected abstract P initPresenter();

    protected abstract void initView(View view);

    protected abstract int Layout();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onEnd();
        }
    }
}
