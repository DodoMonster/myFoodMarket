package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

import java.util.Date;
import java.util.List;

/**
 * Created by 追追 on 2016/3/16.
 */
@Table(name="apt_commodity_carousel_pic")
public class CommodityCarousel extends Unique {

    @Column(name="id")
    private String id;

    @Column(name="pic")
    private String pic;

    @Column(name="shop_id")
    private String shopId;

    @Column(name="commodity_id")
    private String commodityId;

    @Column(name="time")
    private Date time;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
