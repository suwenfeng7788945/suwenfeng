package com.suwf.batch.listenter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.stereotype.Component;

@Component
public class CommonItemProcessListener implements ItemProcessListener {
    @Override
    public void beforeProcess(Object o) {
        System.out.println("before process");
    }

    @Override
    public void afterProcess(Object o, Object o2) {
        System.out.println("after process");
    }

    @Override
    public void onProcessError(Object o, Exception e) {
        System.out.println(JSONObject.toJSONString(o, SerializerFeature.WRITE_MAP_NULL_FEATURES));
    }
}
