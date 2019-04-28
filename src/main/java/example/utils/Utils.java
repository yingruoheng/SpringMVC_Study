package example.utils;

import org.apache.commons.codec.binary.Base64;

public class Utils {
    public static String encodeStr(String str){
        String deStr = null;
        try {
            deStr = Base64.encodeBase64String(str.getBytes("utf-8"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return deStr;
    }

    public static String decodeStr(String str){
        String result = null;
        try {
            result = new String(Base64.decodeBase64(str.getBytes()),"utf-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
