package com.example.mvp_androidx.model.modelmpl;

import com.example.mvp_androidx.app.Config;
import com.example.mvp_androidx.app.base.RxSchedelers;
import com.example.mvp_androidx.inter.IViewListener;
import com.example.mvp_androidx.model.Model;
import com.example.mvp_androidx.model.bean.MainBean;
import com.google.gson.Gson;

import okhttp3.ResponseBody;

/**
 * Description:
 */
public class MainModelmpl {

    public void checkData(int id, final IViewListener<MainBean> listener) {
        Model instance = Model.getInstance();
        instance.apiBase(instance.getApi().login(String.valueOf(id))).subscribe(new RxSchedelers<ResponseBody>() {
            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                super.onNext(responseBody);
                try {
                    String string = responseBody.string();
                    MainBean mainBean = new Gson().fromJson(string, MainBean.class);
                    listener.onSuccess(mainBean);
                } catch (Exception e) {
                    e.printStackTrace();
                    listener.onError(Config.GSON_JSONERROR, "解析异常");
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                listener.onError(Config.GSON_UNKNOWN_JSONERROR, "错误：" + e.getMessage());
            }
        });
    }
}
