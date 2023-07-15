package com.blog.util;

import java.util.Random;

public class KeyUtil {

    /**
     * 随机生成密钥的工具类
     * **/
    public static String CreateNewKey(){
        String Char = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++){
            int index= random.nextInt(Char.length());
            sb.append(Char.charAt(index));
        }
        return sb.toString();
    }

}
