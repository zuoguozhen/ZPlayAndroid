package com.zgz.zplayandroid.base.network;


import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author : lihao
 * @date : 2019-01-16 16:17
 * @description :retrofit 帮助类
 */
public class RetrofitHelper {

    private static RetrofitHelper mInstance;
    //默认为30S
    public static int READ_TIME = 30;
    public static int CONNECT_TIME = 30;
    public static int WRITE_TIME = 30;
    private ExceptInterceptor mExceptInterceptor;

    @Inject
    public RetrofitHelper() {
        mExceptInterceptor = new ExceptInterceptor();
    }


    public ExceptInterceptor getExceptInterceptor() {
        return mExceptInterceptor;
    }

    /**
     * 初始化必要对象和参数
     *
     * @param url 基础baseUrl
     * @return
     */
    public Retrofit getRetrofit(String url) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//可以设置请求过滤的水平,body,basic,headers
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        // 初始化okhttp
        OkHttpClient client = new OkHttpClient().newBuilder()
                //设置读取超时时间
                .readTimeout(READ_TIME, TimeUnit.SECONDS)
                //设置请求超时时间
                .connectTimeout(CONNECT_TIME, TimeUnit.SECONDS)
                //设置写入超时时间
                .writeTimeout(WRITE_TIME, TimeUnit.SECONDS)
                //鉴权过期拦截
                .addInterceptor(mExceptInterceptor)
                //添加打印BaseActivity
                .addInterceptor(httpLoggingInterceptor)

                //设置出现错误进行重新连接。
                .retryOnConnectionFailure(true)
                .build();
        // 初始化Retrofit
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(url)

                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ErrorConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())

                .build();
    }

    //返回一个泛型类,然后去请求接口
    public <T> T getService(Class<T> service, String BaseUrl) {
        return getRetrofit(BaseUrl).create(service);
    }


    /**
     * 例子
     * 下载单文件，该方法不支持断点下载
     *
     * @param url                  文件地址
     * @param destDir              存储文件夹
     * @param fileName             存储文件名
     * @param fileDownLoadObserver 监听回调
     */
    //   public void downloadFile(@NonNull String url, final String destDir, final String fileName, final FileDownLoadObserver<File> fileDownLoadObserver) {

//        getRetrofit("").
//                .create(BASE_API.class)
//                .downLoadFile(url)
//                .subscribeOn(Schedulers.io())//subscribeOn和ObserOn必须在io线程，如果在主线程会出错
//                .observeOn(Schedulers.io())
//                .observeOn(Schedulers.computation())//需要
//                .map(new Function<ResponseBody, File>() {
//                    @Override
//                    public File apply(@NonNull ResponseBody responseBody) throws Exception {
//                        return fileDownLoadObserver.saveFile(responseBody, destDir, fileName);
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(fileDownLoadObserver);

}
