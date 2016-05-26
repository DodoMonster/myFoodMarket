package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

import java.util.Date;

/**
 * Created by ZZWEI on 2016/3/18.
 */
@Table(name = "apt_carousel_pic")
public class CarouselPic extends Unique {
    @Column(name = "id")
    private String id;

    @Column(name = "pic")
    private String pic;

    @Column(name = "commodity_id")
    private String commodityId;

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    @Column(name = "time")
    private Date time;

    @Column(name = "shop_id")
    private String shopId;

    public String getId() {
        return id;
    }

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
