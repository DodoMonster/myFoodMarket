package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

/**
 * Created by 追追 on 2016/3/16.
 */
@Table(name="apt_collecting_shop")
public class CollectionShop extends Unique {

    @Column(name="id")
    private String id;

    @Column(name="user_id")
    private String userId;

    @Column(name="shop_id")
    private String shopId;

    @Column(name="classification")
    private String classification;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
