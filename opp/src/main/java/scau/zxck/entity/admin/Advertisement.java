package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

import java.util.Date;

/**
 * Created by YWY on 2016/3/18.
 */
@Table(name="apt_advertisement")
public class Advertisement extends Unique {

    @Column(name="id")
    private String id;

    @Column(name="pic")
    private String pic;

    @Column(name="commodity_id")
    private String commodityId;

    @Column(name="shop_id")
    private String shopId;

    @Column(name="position")
    private Integer position;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}