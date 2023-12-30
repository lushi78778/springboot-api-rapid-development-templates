# rapid-development-templates

### 简介
基于spring boot的接口快速开发模板

### 开发环境
Java 11 MySQL 8.0 maven<br>
兼容Java 8 MySQL 5.5 <br>

### 技术栈
1. springboot 2.6.2 <br>
   https://spring.io/projects/spring-boot
2. springfox-boot-starter 3.0.0 开源的API Doc的框架<br>
   https://github.com/springfox/springfox
3. hutool 小而全的Java工具类库 <br>
   https://hutool.cn/
4. druid Java语言中最好的数据库连接池 <br>
   https://github.com/alibaba/druid
5. lombok <br>
   https://projectlombok.org/

    
### 设计信息

#### 交互风格
一律ajax请求,要求hander携带token去拦截器验签再执行。（token是jwt）

#### 返回格式示例

```json
{
   "code": 200,
   "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJ1c2VySW5mbyI6IndnZWh5dGplaHdlcnlydGhyIiwiaWF0IjoxNjQ2MzkwMTczLCJleHAiOjE2NDYzOTA3NzN9.SOKuLQ0NkV2lV3o4ix7v1BJknyuX-OE0cwJ2Rs8sPZVKZ7BDkIkg4qJCXpAWYmgE",
   "request_id": "9ad8877d-86b1-42ed-9532-54fbb9a13818",
   "object": "demo api"
}
```

```json
{
   "code": 401,
   "token": null,
   "request_id": "8fa70565-5af1-425e-95cf-4ece4b1cd739",
   "object": "请hander附带正确token"
}
```

### 联系方式
lushi78778@ewlgc.top
