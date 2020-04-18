package com.wd.tech.mvp.api;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * 功能：ApiService类
 * 作者：闫圣豪
 * 当前日期：2020/04/17
 * 当前时间：11:56
 */
public interface ApiService {
    @GET
    Observable<ResponseBody>getInfo(@Url String url);

    @GET//get有参数 QueryParam 对应注解 @QueryMap
    Observable<ResponseBody>getInfoHava(@Url String url, @QueryMap Map<String, Object> map);

    @FormUrlEncoded
    @POST//post参数 FormParam 对应的注解@FieldMap
    Observable<ResponseBody>postInfoHava(@Url String url, @FieldMap Map<String, Object> map);

    @PUT
    Observable<ResponseBody>putInfoHava(@Url String url,@QueryMap Map<String,Object>map);

    @DELETE
    Observable<ResponseBody>deleteInfoHava(@Url String url,@QueryMap Map<String,Object>map);



    

}
