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
**数据源配置**
```properties
#数据源配置
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/essm?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false
spring.datasource.username=root
spring.datasource.password=root
```

**mybatis的一些配置**
```properties
mybatis.mapper-locations=classpath:mapper/*Mapper.xml
#控制台打印sql语句
mybatis.configuration.log-impl= org.apache.ibatis.logging.stdout.StdOutImpl
```

**作用域和生命周期**
```markdown
1.SqlSessionFactoryBuilder
这个类可以被实例化、使用和丢弃，一旦创建了 SqlSessionFactory，就不再需要它了。 因此 SqlSessionFactoryBuilder 实例的最佳作用域是方法作用域（也就是局部方法变量）。

2.SqlSessionFactory
SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，没有任何理由丢弃它或重新创建另一个实例。

3.SqlSession
最佳的作用域是请求或方法作用域
```

**类的属性和表的字段名对应**
```xml
    <!--如果列名和属性名不能匹配上，可以在 SELECT 语句中设置列别名-->
    <select id="selectUsers" resultType="User">
        select
               表的字段名             类的属性名
            user_id             as "id",
            user_name           as "userName",
            hashed_password     as "hashedPassword"
        from some_table
        where id = #{id}
    </select>

        <!--类属性名和表的列名对应-->
    <resultMap id="userResultMap" type="User">
        <id property="id" column="user_id" />
        <result property="username" column="user_name"/>
        <result property="password" column="hashed_password"/>
    </resultMap>

    <select id="selectUsers" resultMap="userResultMap">
        select user_id, user_name, hashed_password
        from some_table
        where id = #{id}
    </select>
```

