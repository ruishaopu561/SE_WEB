# spring boot + vue实例demo
## vue
这是第一次用vue写项目，虽然这里的代码全是copy的，不过还是有一些值得记录的东西。  
### create vue project
```
vue init webpack project-name
```
### run vue
```
npm run dev
```
### build vue
指生成静态文件，并且是放到spring boot里的东西
```
npm run build
```
生成的文件会在```dist```文件夹里，将该文件夹里的内容copy到spring boot的resources的static文件夹中，就完成了前端的任务。

## Spring boot
这是一个新学的后端框架，后端java代码主要在```main/java/...```文件夹中
terminal运行指令:
```
mvn spring-boot:run
```
后端处理的中心是Controller文件，其他的java文件是一个计算上的辅助，Controller负责接收和反馈。

## Reference
- [Spring Boot+Vue从零开始](https://segmentfault.com/a/1190000014211773)
