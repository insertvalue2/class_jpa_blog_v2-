package com.tenco.blog_v2.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Component  // IOC
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired // DI 처리
    private LoginInterceptor loginInterceptor;

    /**
     * 인터셉터를 등록하고 적용할 URL 패턴을 설정하는 메서드이다.
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 로그인 인터셉터 등록
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/protected/**")  // 인터셉터를 적용할 경로 패턴 설정
                .excludePathPatterns("/public/**", "/login", "/logout"); // 인터셉터를 제외할 경로 패턴 설정

        // 관리자용 인터셉터 등록
    }
}
