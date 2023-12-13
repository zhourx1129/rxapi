package com.zhourx.project.provider;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: zhourx
 * @Description:
 * @Date: 2023/12/5
 */
public interface DemoService {

    String sayHello(String name);

    String sayHello2(String name);

    default CompletableFuture<String> sayHelloAsync(String name) {
        return CompletableFuture.completedFuture(sayHello(name));
    }

}
