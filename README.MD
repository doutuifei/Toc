# 一键生成MarkDown目录

## 一.Jar使用

下载[Jar](http://gitlab.ekwing.com/mird/Android/library/tocPlugin/blob/master/res/toc.jar)

1. 单个文件 
```java
java -jar toc.jar xxx.md
```

2. 目录下所有文件
```java
java -jar toc.jar path
```

## 二.Plugin使用

>仅支持单个文件生成Toc

### 安装
1. 下载[Plugin](http://gitlab.ekwing.com/mird/Android/library/tocPlugin/blob/master/res/plugin.zip)
2. 安装 File -> Settings -> Plugins -> Install Plugin from Disk... -> 重启IDEA

### 使用
在MarkDown文件上右击 -> Toc