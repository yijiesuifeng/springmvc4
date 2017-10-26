package com.wind.domain;

/**
 * @author Lilandong
 * @date 2017/10/25
 */
public class DemoObj {
    private Long id;
    private String name;
    private Boolean sex;

    public DemoObj() {
        super();
    }

    public DemoObj(Long id, String name,Boolean sex) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "DemoObj{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
