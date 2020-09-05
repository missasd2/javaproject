package CoreVolumeTow.chp4.jdbc;

import java.io.Serializable;

/**
 * 数据库studnets表对应的实体类
 * 属性名称和表的字段名 一一对映
 */
public class Student implements Serializable {

    private Integer id;
    private String name;
    private String sex;
    private Integer age;

    public Student() {
    }

    public Student(Integer id, String name, String sex, Integer age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
