package cn.yangguang.ssm.entity;

/**
 * Created by songyangguang on 2017/11/7.
 */

public class Goods {
    private Integer id;//商品id

    private Integer catelogId;//商品分类

    private Integer userId;//用户id

    private String name;//商品名称

    private Float price;//出售价格

    private Float realPrice;//真实价格

    private String startTime;//发布时间

    private String endTime;//下架时间

    private String polishTime;//擦亮时间，按该时间进行查询，精确到分秒

    private Integer commetNum;//评论回复数量

    private String describle;//商品描述信息

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCatelogId() {
        return catelogId;
    }

    public void setCatelogId(Integer catelogId) {
        this.catelogId = catelogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Float realPrice) {
        this.realPrice = realPrice;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Integer getCommetNum() {
        return commetNum;
    }

    public void setCommetNum(Integer commetNum) {
        this.commetNum = commetNum;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle == null ? null : describle.trim();
    }

    public String getPolishTime() {
        return polishTime;
    }

    public void setPolishTime(String polishTime) {
        this.polishTime = polishTime;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", catelogId=" + catelogId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", realPrice=" + realPrice +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", polishTime='" + polishTime + '\'' +
                ", commetNum=" + commetNum +
                ", describle='" + describle + '\'' +
                '}';
    }
}