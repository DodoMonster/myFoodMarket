package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

import java.util.Date;

/**
 * Created by ZZWEI on 2016/3/18.
 */
@Table(name = "apt_commodity_comment")
public class CommodityComment extends Unique{
    @Column(name = "id")
    private  String id;

    @Column(name = "user_id")
    private  String userId;

    @Column(name = "commodity_id")
    private  String commodityId;

    @Column(name = "comment")
    private  String comment;

    @Column(name = "score")
    private  int score;

    @Column(name = "seller_reply")
    private  String sellerReply;

    @Column(name = "time")
    private Date time;

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime(){return time;}

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSellerReply() {
        return sellerReply;
    }

    public void setSellerReply(String sellerReply) {
        this.sellerReply = sellerReply;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
