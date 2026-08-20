# 📚 微服务学习实践 - 库存服务 + 订单服务

## 📌 项目简介
这是一个基于 **Spring Boot 4.1 + Nacos + MyBatis-Plus** 的微服务学习项目。模拟了“图书下单扣库存”的业务场景，实现了服务注册与发现、远程调用、乐观锁防超卖。

## 🛠️ 技术栈
- Spring Boot 4.1.0
- Spring Cloud Alibaba 2025.1.0.0
- Nacos 3.2.3（服务注册与发现）
- MyBatis-Plus 3.5.15
- H2 Database（内存数据库）
- Lombok

## 📦 模块说明
| 模块 | 端口 | 说明 |
|------|------|------|
| `book-stock` | 8081 | 库存服务，提供图书查询和扣库存接口 |
| `order-service` | 8082 | 订单服务，通过 Nacos 调用库存服务 |

## 🚀 快速启动
### 1. 启动 Nacos
进入 `nacos/bin/` 目录，双击 `startup.cmd`（Windows）或执行 `./startup.sh -m standalone`（Mac/Linux）。
访问 `http://localhost:8080/nacos`，用户名/密码：`nacos`/`nacos`

### 2. 启动 book-stock
在 IDEA 中运行 `BookStockApplication`

### 3. 启动 order-service
在 IDEA 中运行 `OrderServiceApplication`

## 🧪 测试接口
```bash
curl -X POST "http://localhost:8082/create?bookId=1&quantity=1"