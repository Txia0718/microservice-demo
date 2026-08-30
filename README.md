# 📚 微服务学习实践 - 库存服务 + 订单服务 + API 网关

## 📌 项目简介
这是一个基于 **Spring Boot 4.1 + Spring Cloud Gateway + Nacos + Sentinel + OpenFeign + MyBatis-Plus** 的微服务学习项目。
模拟了“图书下单扣库存”的业务场景，实现了：

- 服务注册与发现（Nacos）
- 服务间远程调用（OpenFeign + 负载均衡）
- API 网关统一入口（Spring Cloud Gateway）
- 乐观锁防超卖（MyBatis-Plus @Version）
- 流量治理与高可用防护（Sentinel 限流 + 熔断降级）

## 🛠️ 技术栈
- Spring Boot 4.1.0
- Spring Cloud Gateway 5.0.3（WebFlux 响应式网关）
- Spring Cloud Alibaba 2025.1.0.0
- Nacos 3.2.3（服务注册与发现）
- Sentinel 1.8.10（流量治理组件）
- OpenFeign 13.x（声明式远程调用）
- MyBatis-Plus 3.5.15
- H2 Database（内存数据库）
- Lombok

## 📦 模块说明
| 模块 | 端口 | 说明 |
|------|------|------|
| `book-stock` | 8081 | 库存服务，提供图书查询和扣库存接口（仅内部调用） |
| `order-service` | 8082 | 订单服务，通过 OpenFeign 远程调用库存服务，外部统一入口 |
| `gateway` | 8083 | API 网关，统一入口，仅转发 `/order-service/**` 路由 |

## 🛡️ 流量治理（Sentinel）
项目已集成 Sentinel，为核心服务提供高可用防护：

- **订单服务 (order-service)**：针对 `/create` 写接口配置了 **QPS 限流**（每秒 3 个请求）和 **熔断降级**（慢调用比例触发），保护下单链路。
- **库存服务 (book-stock)**：内部配置了 **熔断降级**，防止慢查询拖垮 Feign 调用链路。
- **Feign + Sentinel**：订单服务通过 OpenFeign 调用库存服务时，整合 Sentinel 实现调用超时熔断和降级兜底。

> ⚠️ **当前规则存储说明**：限流/熔断规则目前保存在各微服务内存中，服务重启后规则会丢失。后续将学习**规则持久化到 Nacos 配置中心**，实现生产级的规则高可用。

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
# 检查订单服务是否存活
curl "http://localhost:8083/order-service/hello"

# 查询图书信息（通过订单服务中转）
curl "http://localhost:8083/order-service/book/1"

# 下单（扣库存）
curl -X POST "http://localhost:8083/order-service/create?bookId=1&quantity=1"