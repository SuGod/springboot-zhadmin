package cn.zzdee.zhadmin.entity;


import cn.zzdee.zhadmin.common.enums.Sex;

public class User extends BaseEntity {

    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private Integer age;

    private Sex sex;


    public User() {
        super();
    }

    public User(String username, String password, String nickname, Integer age, Sex sex) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.age = age;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
