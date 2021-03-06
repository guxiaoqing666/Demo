package com.example.springbooterror.handler;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * Created by smlz on 2019/3/19.
 */
@Component
public class TulingErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest,
                                                  boolean includeStackTrace) {
        Map<String, Object> retInfo = super.getErrorAttributes(webRequest,includeStackTrace);
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext",0);
        retInfo.put("company","tuling"); //将springboot自带json数据修改
        retInfo.put("ext",ext);
        return retInfo;
    }
}
