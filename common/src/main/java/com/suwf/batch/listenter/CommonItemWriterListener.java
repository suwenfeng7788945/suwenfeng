package com.suwf.batch.listenter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommonItemWriterListener implements ItemWriteListener {
    @Override
    public void beforeWrite(List list) {
        System.out.println("before write");
    }

    @Override
    public void afterWrite(List list) {
        System.out.println("after wirte");
    }

    @Override
    public void onWriteError(Exception e, List list) {
        System.out.println(JSONObject.toJSONString(list, SerializerFeature.WRITE_MAP_NULL_FEATURES));
    }
}
