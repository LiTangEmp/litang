此项目为纯后端项目，仅用于面试

项目亮点：

1.在一个普通的Maven项目下添加spring框架创建Spring项目

2.使用jwt在用户每次登录时产生一个token用于身份验证

3.使用Encrypt加密类对密码进行动态加密以及校验

4.采用redis缓存用户的token，防止密码更改后原token依然生效

5.编写拦截器使用户在未登录的情况下没有权限访问未放开的接口以实现类似spring security的功能

6.使用Tread存放业务数据

7.使用集成JDBC的Mybatis对数据库进行操作

8.JPA的简单使用实例

9.三种多线程创建使用方式的简单实例

10.引入lombok简化操作

11.创建异步线程池并使用@Async注解实现spring下进行异步线程操作

12.使用RabbitMQ进行异步消息处理

13.引入fastjson依赖将MQ传送的消息体转换为JSON格式更加贴切生产实际

14.项目使用的mysql、redis、RabbitMQ均架设在云服务器的linux环境下，更加符合实际生产开发的环境
