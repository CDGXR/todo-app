# Todo App

![Java](https://img.shields.io/badge/Java-17-orange)
![GitHub last commit](https://img.shields.io/github/last-commit/CDGXR/todo-app)

> 一个用 Java 写的命令行待办清单工具。

---

## 功能

- 添加任务
- 查看所有任务
- 完成任务
- 删除任务
- 数据保存到本地文件，重启不丢失

## 如何运行

### 环境要求

- JDK 17 或以上

### 编译

```bash
javac -encoding UTF-8 TodoApp.java
```

### 运行

```bash
java TodoApp
```

## 使用说明

运行后会显示菜单：

```text
===== 待办清单 =====
1. 添加任务
2. 查看所有任务
3. 完成任务
4. 删除任务
5. 退出
请选择：
```

输入数字选择操作，输入 `5` 退出。

## 数据存储

任务保存在 `tasks.txt`，格式为：

```text
状态|任务内容
```

- `0` = 未完成
- `1` = 已完成

## 项目结构

```text
todo-app/
├── TodoApp.java    # 主程序
├── README.md       # 项目说明
└── .gitignore      # 忽略编译产物和运行时数据
```

## 学习记录

这个项目是我学习 Java 和 Git 的练习作品，用于练习：

- Java 文件读写
- 控制台交互
- Git 仓库管理
- GitHub 作品集展示

## 联系方式

- GitHub：[@CDGXR](https://github.com/CDGXR)