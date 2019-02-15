# springboot-shiro-jwt

#### 介绍
springboot整合shiro和jwt做权限验证

#### 开发工具
- STS 4.x
- Maven
- springboot 2.1.2
- shiro 1.4.0
- jwt 3.4.0
- mybatisplus


#### 功能
主要实现了springboot shiro 和 jwt 的整合，采用注解方式。
用户登录成功后，返回一个token信息，每次请求时，都必须带上 token 信息
登录失败，返回错误信息
