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