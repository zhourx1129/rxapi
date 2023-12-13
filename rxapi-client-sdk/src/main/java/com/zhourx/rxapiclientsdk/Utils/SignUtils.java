package com.zhourx.rxapiclientsdk.Utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * @Author: zhourx
 * @Description: 签名工具
 * @Date: 2023/12/5 22:31
 */
public class SignUtils {
    /**
     * 生成签名
     * @param body      车身
     * @param secretKey 密钥
     * @return {@link String}
     */
    public static String genSign(String body, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = body + "." + secretKey;
        return md5.digestHex(content);
    }
}
