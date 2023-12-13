package com.zhourx.rxapiclientsdk;

import com.zhourx.rxapiclientsdk.client.RxApiClient;

/**
 * @Author: zhourx
 * @Description:
 * @Date: 2023/12/10
 */
public class Test {
    public static void main(String[] args) {
        RxApiClient client = new RxApiClient("6329e9f3481967f6f8ba885fd0581f26", "9d2953d211dfff9bb5adac8c013093e3");
        String zhourx = client.getNameByGet("zhourx");
        System.out.println(zhourx);

    }
}
