package com.zhourx.rxapiinterface;

import com.zhourx.rxapiclientsdk.client.RxApiClient;
import com.zhourx.rxcommon.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RxapiInterfaceApplicationTests {

    @Resource
    private RxApiClient rxApiClient;

    @Test
    void contextLoads() {
        String result = rxApiClient.getNameByGet("zhourx");
        User user = new User();
        user.setUserName("zhourx");
        String usernameByPost = rxApiClient.getUsernameByPost(user);
        System.out.println(result);
        System.out.println(usernameByPost);
    }
}
