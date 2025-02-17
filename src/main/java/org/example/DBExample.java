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
import java.util.Properties;

public class DBExample {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = DBExample.class.getClassLoader().getResourceAsStream("database.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            System.out.println("Load database.properties error" + ex);
        }
    }

    public void mybatisTest() {
        String resource = "mybatis-config.xml";
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
        String username = properties.getProperty("mongo.username");
        String password = properties.getProperty("mongo.password");
        String db = properties.getProperty("mongo.database");
//        String clientURI = String.format("mongodb://%s:%s@mongodb:27017", username, password);  //for docker
        String clientURI = String.format("mongodb://%s:%s@localhost:27017", username, password);    // localhost
        System.out.println("mongo clientURI----" + clientURI);
        MongoClient mongoClient = MongoClients.create(clientURI);
        MongoDatabase database = mongoClient.getDatabase(db);
        MongoCollection<Document> collection = database.getCollection("mycollection");

        // 创建游标来遍历集合中的文档
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println(doc.toJson());
            }
        }
    }
}