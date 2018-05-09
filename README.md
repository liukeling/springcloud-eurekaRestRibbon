# springcloud-eurekaRestRibbon
spring cloud eureka RestRibbon框架简单集成，其中包括eureka server、eureka client微服务注册以及获取微服务的url信息，RestRibbon框架的请求微服务接口

eureka是一个微服务管理的一个框架，eureka分为server和client，server可以注册client。
但是client主动去进行注册，然后server每隔一定时间间隔去跟client进行一次握手，以确保client仍在运行。
每个client都可以看做一个微服务，server就集成了这些微服务信息，以供每个服务进行查询、访问。

restribbon是一个基于http的一个客户端负载均衡工具。
他通过RestTemplate 这个类进行发送请求。

目前还在探索中，如有不同见解欢迎分享。谢谢
