# a_series_of_framework_learning
一系列框架的学习

## 1.jackson介绍

### 1.1 **json语法规则**
```
1.简单值

"hello world"  //字符串
99 //数值
true/false //布尔类型
null

2.对象

// 对象，对象的属性名必须使用双引号，值要是字符串也必须使用双引号
{
  "name": "Andy",
  "age": 18,
  "isStudent": true,
  "isLeader": false,
  "mark": null,
  "school": {
    "name": "BIT",
    "region": "Beijing" // 这个地方不能有逗号，因为是对象的最后一个属性成员
  } // 这个地方也不可以有逗号，因为也是对象的最后一个属性成员
}

3.数组

// 示例一
["Andy", "Ruby", "Danny", "Peter", "Lisa"]
// 示例二
[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
// 示例三
[
  {"name": "Andy", "age": 18},
  {"name": "Ruby", "age": 18},
  {"name": "Danny", "age": 20}
]
// 示例四
[
  [0, 1, 2],
  [3, 4, 5],
  [6, 7, 8]
]
```
### 1.2 序列化与反序列化
**序列化(Serialization)**：把Java对象转换为字节序列的过程<br/>
**反序列化(Deserialization)**：把字节序列恢复为Java对象的过程

## 2.mybatis
### 2.1 mybatis简介

**MyBatis 是一款优秀的持久层框架，它支持自定义 SQL、存储过程以及高级映射。MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作。MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。**

### 2.2 入门

**maven构建项目**
```xml
<dependencies>
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
    </dependency>

    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
</dependencies>
```
#### 2.2.1 从 XML 中构建 SqlSessionFactory
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <mapper resource="org/mybatis/example/BlogMapper.xml"/>
  </mappers>
</configuration>
```

#### 2.2.2 不使用 XML 构建 SqlSessionFactory
```java
public class Build{
    
    public void build(){
        DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }
    
}
```