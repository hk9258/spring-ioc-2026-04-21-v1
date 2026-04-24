package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestPostService;

public class ApplicationContext {

    private final TestPostRepository testPostRepository;
    private final TestPostService testPostService;

    public ApplicationContext() {
        testPostRepository = new TestPostRepository();
        testPostService = new TestPostService(testPostRepository);
    }

    public <T> T genBean(String beanName) {
        if (beanName.equals("testPostService")) {
            return (T) testPostService;
        }

        if (beanName.equals("testPostRepository")) {
            return (T) testPostRepository;
        }

        return null;
    }
}