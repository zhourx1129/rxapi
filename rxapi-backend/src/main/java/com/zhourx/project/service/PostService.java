package com.zhourx.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhourx.rxcommon.model.entity.Post;

/**
 * @Author: zhourx
 * @Description: 帖子服务
 * @Date: 2023/12/7
 */
public interface PostService extends IService<Post> {
    /**
     * 校验
     *
     * @param post
     * @param add 是否为创建校验
     */
    void validPost(Post post, boolean add);
}
