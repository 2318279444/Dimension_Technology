package com.wd.tech.mvp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;


import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wd.tech.mvp.api.ApiService;
import com.wd.tech.mvp.app.MyApp;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 功能：NetUtil类
 * 作者：闫圣豪
 * 当前日期：2020/04/17
 * 当前时间：12:03
 */
public class NetUtil {

    private SharedPreferences yan;
    private final ApiService apiService;
    private String userId;
    private String sessionId;

    public NetUtil(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        yan = MyApp.context.getSharedPreferences("yan", Context.MODE_PRIVATE);
                        userId = yan.getString("userId", "");
                        sessionId = yan.getString("sessionId", "");
                        if(TextUtils.isEmpty(userId)||TextUtils.isEmpty(sessionId)){
                            return chain.proceed(chain.request());
                        }
                        Request request = chain.request().newBuilder()
                                .addHeader("userId", userId)
                                .addHeader("sessionId", sessionId)
                                .build();
                        return chain.proceed(request);
                    }
                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyUrl.base)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);

    }
    private static class NetUrl{
        private static NetUtil netUtil=new NetUtil();
    }
    public static NetUtil getInstance(){
        return NetUrl.netUtil;
    }



    //get无参数
    public void getInfo(String url,Class cls,NetCallBack callBack){
        apiService.getInfo(url).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callBack != null) {
                            callBack.onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //get有参数
    public void getInfoHava(String url, Class cls, Map<String,Object>map,NetCallBack callBack){
        apiService.getInfoHava(url, map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                        try {
                            Object o = gson.fromJson(responseBody.string(), cls);
                            if (callBack != null) {
                                callBack.onSuccess(o);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callBack != null) {
                            callBack.onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    //post有参数
    public void postInfoHava(String url,Class cls,Map<String,Object>map,NetCallBack callBack){
        apiService.postInfoHava(url, map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                        try {
                            Object o = gson.fromJson(responseBody.string(), cls);
                            if (callBack != null) {
                                callBack.onSuccess(o);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callBack != null) {
                            callBack.onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    //put有参数
    public void putInfoHava(String url,Class cls,Map<String,Object>map,NetCallBack callBack){
        apiService.putInfoHava(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                        try {
                            Object o = gson.fromJson(responseBody.string(), cls);
                            if (callBack != null) {
                                callBack.onSuccess(o);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callBack != null) {
                            callBack.onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    //delete有参数
    public void deleteInfoHava(String url,Class cls,Map<String,Object>map,NetCallBack callBack){
        apiService.deleteInfoHava(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                        try {
                            Object o = gson.fromJson(responseBody.string(), cls);
                            if (callBack != null) {
                                callBack.onSuccess(o);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callBack != null) {
                            callBack.onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }





    public interface NetCallBack<T>{
        void onSuccess(T t);
        void onError(String error);
    }

}
