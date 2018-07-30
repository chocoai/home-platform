## 简介
- [在线体验](http://www.luojie.site)

- [部署文档](http://www.luojie.site)

- [pig-ui](https://github.com/lj5635906/home-platform-config)、[pig-config](https://github.com/lj5635906/home-platform-config)

- [代码生成器](https://github.com/lj5635906/generator)

## home-platform
- 基于Spring Boot 2.0.1.RELEASE
- 基于Spring Cloud  Finchley.RELEASE
- 网关基于 Zuul
- 使用 Eureka 服务注册发现
  
 
### 已完善功能描述
- 完善登录：账号密码模式
- 单点登录：基于Srping security oAuth2 提供单点登录接口，方便其他系统对接
- 用户管理：用户是系统操作者，该功能主要完成系统用户配置。
- 菜单管理：配置系统菜单，操作权限。
- 角色管理：角色菜单权限分配。
- 动态路由：基于zuul实现动态路由，后端可配置化
- 数据权限: 使用mybatis对原查询做增强，业务代码不用控制，即可实现。
- 聚合文档：基于zuul实现 swagger各个模块的实现
- zipkin链路追踪： 数据保存MySql，图形化展示
- hystrix熔断： hystrix-dashboard熔断，图形化展示

### 待完善功能
- 短信登陆、社交登陆,后续使用 Spring Cloud Gateway
- 日志监控
- 服务监控
- 文件系统支持：FastDFS、七牛云
- 分布式任务调度
- 后续使用 Spring Cloud Gateway 网关

 ### 模块
``` lua
home-platform
├── home-authorization -- 授权服务提供
├── home-common -- 系统公共模块 
├    ├── home-common-core -- 系统公用核心模块
├    ├── home-common-web  -- 系统公用web相关
├── home-config -- 配置中心
├── home-gateway -- zuul网关
├── home-registry -- eureka注册中心
├── home-hystrix-dashboard -- 熔断服务器
├── home-modules -- 微服务模块
├    ├── home-system -- 系统模块
├          ├── home-system-client -- 系统相关接口客户端
├          ├── home-system-common -- 系统相关通用模块
└           -── home-system-server -- 系统相关服务

```

 ### UI截图
 
 <table>
     <tr>
         <td><img src="https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/9f92fd5340b915bd52f04ba0b0af5d4f50fc7cfe5bef15bec90358a8f0e987175ebf78c46f040d7827a3278c12d4bfba?pictype=scale&from=30113&version=3.3.3.3&uin=190642964&fname=4SZ_H%4035%28%40YP%28OQKJHUPD_Y.jpg&size=750"/></td>
         <td><img src="https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/725f3c483a4f69bf6f648776b881ed685b9e9b7eff823d43124a24914dc5f4d85b1cdfe2ef7830f5c2875fefe2686674?pictype=scale&from=30113&version=3.3.3.3&uin=190642964&fname=%28TH%24G%29_SV%7DT3G%29PF%298%24W9CU.jpg&size=750"/></td>
     </tr>
     <tr>
          <td><img src="https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/89d71abb973a809d050a2ed9e9de13eedc04d81972288f0bc9d4f179527173b0fd91b6821ca441c935f860ee41ec7c66?pictype=scale&from=30113&version=3.3.3.3&uin=190642964&fname=%5D%24OPZ6%29HXD99%25%7B%6063X%60H%248Q.jpg&size=750"/></td>
          <td><img src="https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/2b0e366fcd7302447ba9ee3fe07aaad8abb361955fd7aeb206fe2ef7572b36cfa57b3378e4db80bfc5dc82ce92872b6f?pictype=scale&from=30113&version=3.3.3.3&uin=190642964&fname=%24Q49DYA69J5RMTU%60X8%608L79.jpg&size=750"/></td>
     </tr>
     <tr>
           <td><img src="https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/c90334864e32cb2b63441a99b9568c5bf434fec970d0ab437ba30939fcd8fa1afa4e655b2a54ab597f8278affc248820?pictype=scale&from=30113&version=3.3.3.3&uin=190642964&fname=~%7B%25%7DR%7B9%60WE_%7DN%60O%5D%25A%5BS%2924.jpg&size=750"/></td>
           <td><img src="https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/313b2c5f50be650656751740f57685c5515ca8fd0991c8edbf9df80ab87e43fbb2c301e2ded2a7968995a1b11602406f?pictype=scale&from=30113&version=3.3.3.3&uin=190642964&fname=63%24_WLZFVEPNG2S7MGYL%289I.jpg&size=750"/></td>
     </tr>
 </table>