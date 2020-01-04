项目介绍
===
>项目主要是用来学习spring cloud和分布式事务的消息驱动和事件溯源模型。包含config server、eureke server。
主要用到的技术有spring cloud、eureka、gateway、mysql、MongoDB、redis、kafka、
>docker。

## 1.项目架构
* common <strong>公共类，主要包含实体类和util</strong>
* configserver <strong>config server</strong>
* eurekaserver <strong>eureka server</strong>
* user <strong>service user</strong>
* gateway <strong>gateway网关</strong>
* distributed <strong>try => commit => cancel</strong>
* websocket <strong>learn MongoDB and websocket</strong>

### 1.1.common
> 项目定义了公共返回值，数据库mysql和MongoDB实体类等等
### 1.2.configserver
> config server 统一配置中心
### 1.3.user
> user服务。用户服务，主要使用了mybatis。在配置上，Mapper支持xml和JavaBean。<br />
>* JavaBean动态sql，既可以通过**\<script>**标签
>来拼写动态SQL，也可以通过provider来写，主要是使用@SelectProvider、@UpdateProvider等来实现，type为provider类，method为方法。
> ??Provider既可以使用StringBuffer等形式去拼接，也可以使用<strong>SQL</strong>这个类来拼接，
>* logback [logback大致使用教程参考这个blog](https://juejin.im/post/5b128f326fb9a01e8b7814c4#heading-5)
>* Hystric 断路器 @HystrixCommand注解fallbackMethod的方法参数要和注解下面的参数类型保持一致
## 2 Spring cloud
### 2.1 eureka server
> eurekaserver启动类上添加<code>@EnableEurekaServer</code>注解，项目依赖如下
>```
>spring-cloud-starter-netflix-eureka-server
>```
>* DockerFile使用

### 2.2 openfeign
>[openfeign CSDN博客](https://blog.csdn.net/naxieren1992/article/details/100750303) <br />
>[openfeign官方文档](https://cloud.spring.io/spring-cloud-static/spring-cloud-openfeign/2.1.2.RELEASE/multi/multi_spring-cloud-feign.html)

### 2.3 gateway
>gateway学习是参考官方文档的，比较通俗易懂。和eureka整合，主要是设置
>```
>spring.cloud.gateway.discovery.locator = true
>```
### MongoDB
websocket项目主要是使用的MongoDB，同时使用了learn和msg两个database。
-[ ] MongoDB
-[ ] websocket配置

### 个人信息
> * [csdn blog -- naxieren1992](https://blog.csdn.net/naxieren1992)
> * email **1623631899@qq.com**
> * <code>别问原理，问就是不会</code>

