# 基于Java的官方镜像
FROM openjdk:21-jdk

# 设置工作目录
WORKDIR /app

# 将JAR文件复制到工作目录
COPY my-project-1.0-SNAPSHOT-jar-with-dependencies.jar /app/

# 设置运行时容器监听的端口号
EXPOSE 8080

# 容器启动时执行的命令
ENTRYPOINT ["java", "-jar", "my-project-1.0-SNAPSHOT-jar-with-dependencies.jar"]