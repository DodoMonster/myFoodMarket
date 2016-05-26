package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

import java.util.Date;

/**
 * Created by 追追 on 2016/3/16.
 */
@Table(name="apt_commodity")
public class Commodity extends Unique {

    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="pic")
    private String pic;

    @Column(name="number")
    private String number;

    @Column(name="old_price")
    private double oldPrice;

    @Column(name="new_pirce")
    private double newPirce;

    @Column(name="discount")
    private String discount;

    @Column(name="stock")
    private Integer stock;

    @Column(name="descrip")
    private String descrip;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Column(name="flag")
    private int flag;

    @Column(name="shop_id")
    private String shopId;

    @Column(name="sale")
    private Integer sale;

    @Column(name="comment")
    private Integer comment;

    @Column(name="sub_nav_id")
    private String subNavId;

    @Column(name="label")
    private String label;

    @Column(name="time")
    private Date time;

    @Column(name="remark")
    private String remark;

    @Column(name="min_amount")
    private int minAmount;

    @Column(name="browsing_times")
    private  int browsingTimes;

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public int getBrowsingTimes() {
        return browsingTimes;
    }

    public void setBrowsingTimes(int browsingTimes) {
        this.browsingTimes = browsingTimes;
    }

    @Override

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getNewPirce() {
        return newPirce;
    }

    public void setNewPirce(double newPirce) {
        this.newPirce = newPirce;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public String getSubNavId() {
        return subNavId;
    }

    public void setSubNavId(String subNavId) {
        this.subNavId = subNavId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
