package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

/**
 * Created by 追追 on 2016/3/16.
 */
@Table(name="apt_commodity_pic")
public class CommodityPic extends Unique {
    @Column(name = "id")
    private String id;

    @Column(name = "pic")
    private String pic;

    @Column(name = "commodity_id")
    private String commodityId;

    @Column(name = "sequence")
    private Integer sequence;

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

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}
