项目介绍
===
>项目主要是用来学习spring cloud和分布式事务的消息驱动和事件溯源模型。包含config server、eureke server.
主要用到的技术有spring cloud、eureka、mysql、MongoDB、redis、kafka.

## 1.项目架构
* common 公共类，主要包含实体类和util
* configserver config server
* eurekaserver eureka server
* user service user
* distributed try => commit => cancel

### 1.1.common
> 项目定义了公共返回值，数据库mysql和MongoDB实体类等等
### 1.2.configserver
> config server 统一配置中心






