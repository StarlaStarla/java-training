package org.example;

import com.mongodb.client.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bson.Document;
import org.example.mapper.DepartmentMapper;
import org.example.model.Department;

import java.io.IOException;
import java.io.InputStream;

public class DBExample {
    public void mybatisTest() {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream;
        SqlSession session = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
            DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
            Department department = mapper.selectByPrimaryKey(1);
            System.out.println(department.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            assert session != null;
            session.close();
        }
    }
    public void mongoTest() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("crossskill");
        MongoCollection<Document> collection = database.getCollection("myCollection");

        // 创建游标来遍历集合中的文档
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println(doc.toJson());
            }
        }
    }
}