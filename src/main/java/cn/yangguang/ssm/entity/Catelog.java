package cn.yangguang.ssm.entity;

/**
 * Created by songyangguang on 2017/11/6.
 */

public class Catelog {
    private Integer id;//商品分类编号

    private String name;//分类名

    private Integer number;//该分类下的商品的数量

    private Byte status;//分类状态： 0正常，1暂用

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}