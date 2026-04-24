package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

public class ApplicationContext {

    private final TestPostRepository testPostRepository;
    private final TestPostService testPostService;
    private final TestFacadePostService testFacadePostService;

    public ApplicationContext() {
        testPostRepository = new TestPostRepository();
        testPostService = new TestPostService(testPostRepository);

        // ✅ 추가
        testFacadePostService =
                new TestFacadePostService(testPostService, testPostRepository);
    }

    public <T> T genBean(String beanName) {
        if (beanName.equals("testPostService")) {
            return (T) testPostService;
        }

        if (beanName.equals("testPostRepository")) {
            return (T) testPostRepository;
        }

        if (beanName.equals("testFacadePostService")) {
            return (T) testFacadePostService;
        }

        return null;
    }
}