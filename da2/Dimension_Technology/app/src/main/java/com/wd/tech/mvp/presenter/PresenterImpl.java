package com.wd.tech.mvp.presenter;



import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.contract.Contract;
import com.wd.tech.mvp.model.Model;

import java.util.Map;

/**
 * 功能：Presenter类
 * 作者：闫圣豪
 * 当前日期：2020/04/17
 * 当前时间：14:17
 */
public class PresenterImpl extends BasePresenter {

    public Contract.IModel model;
    @Override
    protected void initModel() {
        model=new Model();
    }

    @Override
    public void startgetInfo(String url, Class cls) {
        model.getInfo(url, cls, new Contract.ModelCallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }

    @Override
    public void startgetInofHava(String url, Class cls, Map<String, Object> map) {
        model.getInfoHava(url, cls, map, new Contract.ModelCallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }

    @Override
    public void startpostInfoHava(String url, Class cls, Map<String, Object> map) {
        model.postInfoHava(url, cls, map, new Contract.ModelCallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }

    @Override
    public void startputInfoHava(String url, Class cls, Map<String, Object> map) {
        model.putInfoHava(url, cls, map, new Contract.ModelCallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }

    @Override
    public void startdeleteInfoHava(String url, Class cls, Map<String, Object> map) {
        model.deleteInfoHava(url, cls, map, new Contract.ModelCallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}
