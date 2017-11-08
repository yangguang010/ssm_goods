package cn.yangguang.ssm.entity;

/**
 * Created by songyangguang on 2017/11/3.
 */
public class User {
    private Integer id;//用户ID号
    private String phone;//用户电话号码
    private String username;//用户名
    private String password;//密码
    private String qq;//qq号
    private String createAt;//创建日期
    private Integer goodsNum;//商品数量
    private Byte power;//权限
    private String lastLogin;//最后一次登录时间
    private Byte status;//状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Byte getPower() {
        return power;
    }

    public void setPower(Byte power) {
        this.power = power;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
