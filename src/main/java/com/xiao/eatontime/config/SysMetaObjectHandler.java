package com.xiao.eatontime.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Component
@Slf4j
public class SysMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createData = getFieldValByName("createTime",metaObject);
        Object updateDate = getFieldValByName("updateTime",metaObject);
        //获得系统时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        //将时间格式转换成符合Timestamp要求的格式
        String nowTime = sdf.format(date);
        //把时间转换
        Timestamp dates =Timestamp.valueOf(nowTime);
        if(null==createData){
            setFieldValByName("createTime",dates,metaObject);
        }
        if(null==updateDate){
            setFieldValByName("updateTime",dates,metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //获得系统时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        //将时间格式转换成符合Timestamp要求的格式
        String nowTime = sdf.format(date);
        //把时间转换
        Timestamp dates =Timestamp.valueOf(nowTime);
        setFieldValByName("updateTime",dates,metaObject);
    }
}
