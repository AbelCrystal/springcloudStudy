# This is springcloud-learning
- api-gateway：服务网关，是所有后续服务的总入口，支持代理转发、负载均衡等，本示例中通过zuulFilter和HandlerInterceptor做安全控制、spring session + redis做分布式session共享以及单点登录
- eureka-server：服务注册中心，服务注册和发现
- eureka-client：生产者1，提供接口给消费者调用，应用内可以通过spring session + redis获取当前登录人信息
- eureka-client2：生产者2，同生产者1
- eureka-customer：消费者，集成Feign完成负载均衡地对生产者进行调用，集成hystrix完成当生产者不可用时提供熔断机制，应用内可以通过spring session + redis获取当前登录人信息

## Guide
https://github.com/yjclsx/springcloud-learning.git

## What you'll need
- JDK 1.8+
- Maven 3+

## Stack
- Java
- Spring Boot
- Spring Cloud

## author
- yjclsx