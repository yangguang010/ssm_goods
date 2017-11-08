package cn.yangguang.ssm.entity;

/**
 * Created by songyangguang on 2017/11/7.
 */

public class Notice {
    private Integer id;//系统信息主键

    private Integer userId;//用户id

    private String createAt;//推送信息时间

    private Byte status;//状态：0未读，1已读

    private String context;//信息内容

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt == null ? null : createAt.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }
}