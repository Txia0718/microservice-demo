# 📚 微服务学习实践 - 库存服务 + 订单服务 + API 网关

## 📌 项目简介
这是一个基于 **Spring Boot 4.1 + Spring Cloud Gateway + Nacos + MyBatis-Plus** 的微服务学习项目。
模拟了“图书下单扣库存”的业务场景，实现了：
- 服务注册与发现（Nacos）
- 服务间远程调用（RestTemplate + @LoadBalanced）
- API 网关统一入口（Spring Cloud Gateway）
- 乐观锁防超卖（MyBatis-Plus @Version）

## 🛠️ 技术栈
- Spring Boot 4.1.0
- Spring Cloud Gateway 5.0.3（WebFlux 响应式网关）
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
| `gateway` | 8083 | API 网关，统一入口，路由转发 |

## 🚀 快速启动
### 1. 启动 Nacos
进入 `nacos/bin/` 目录，双击 `startup.cmd`（Windows）或执行 `./startup.sh -m standalone`（Mac/Linux）。
访问 `http://localhost:8848/nacos`，用户名/密码：`nacos`/`nacos`

### 2. 启动 book-stock
在 IDEA 中运行 `BookStockApplication`

### 3. 启动 order-service
在 IDEA 中运行 `OrderServiceApplication`

### 4. 启动 gateway
在 IDEA 中运行 `GatewayApplication`

## 🧪 测试接口（通过网关调用）

```bash
# 查询库存服务是否存活
curl "http://localhost:8083/book-stock/hello"

# 查询图书信息
curl "http://localhost:8083/book-stock/book/1"

# 下单（扣库存）
curl -X POST "http://localhost:8083/order-service/create?bookId=1&quantity=1"
