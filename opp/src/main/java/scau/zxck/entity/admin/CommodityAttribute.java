package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

/**
 * Created by YWY on 2016/3/18.
 */
@Table(name="apt_commodity_attribute")
public class CommodityAttribute extends Unique {

    @Column(name="id")
    private String id;

    @Column(name="commodity_id")
    private String commodityId;

    @Column(name="attribute")
    private String attribute;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}