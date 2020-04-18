package com.wd.tech.mvp.base;



import com.wd.tech.mvp.contract.Contract;

import java.lang.ref.WeakReference;

/**
 * 功能：BasePresenter类
 * 作者：闫圣豪
 * 当前日期：2020/04/17
 * 当前时间：14:10
 */
public abstract class BasePresenter <V extends Contract.IView>implements Contract.IPresenter{

    private WeakReference<V> vWeakReference;

    public BasePresenter(){
        initModel();
    }

    protected abstract void initModel();

    public void Attch(V iView){
        vWeakReference = new WeakReference<>(iView);
    }
    public void onEnd(){
        if (vWeakReference != null) {
            vWeakReference.clear();
            vWeakReference=null;
        }
    }
    public V getView(){
        return vWeakReference.get();
    }


}
