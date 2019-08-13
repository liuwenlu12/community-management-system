package com.oaec.cms.util;

import org.springframework.util.DigestUtils;

public class MD5Util {

    public static String getMd5(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

}
