# 基于Java的官方镜像
FROM openjdk:21-jdk

## 设置工作目录
WORKDIR /home/starla/app
#
# 将JAR文件复制到工作目录
COPY my-project-1.0-SNAPSHOT-jar-with-dependencies.jar /home/starla/app/

# Copy wait-for-it.sh script to the image
COPY wait-for-it.sh /home/starla/app/

# Assign proper permissions to the script to make it executable
RUN chmod +x /home/starla/app/wait-for-it.sh

# 设置运行时容器监听的端口号
EXPOSE 8080

# 容器启动时执行的命令
ENTRYPOINT ["/home/starla/app/wait-for-it.sh", "mysql:3306", "--", "java", "-jar", "/home/starla/app/my-project-1.0-SNAPSHOT-jar-with-dependencies.jar"]