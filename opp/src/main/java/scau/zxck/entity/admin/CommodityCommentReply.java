package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

import java.util.Date;

/**
 * Created by ZZWEI on 2016/3/18.
 */
@Table(name = "apt_commodity_comment_reply")
public class CommodityCommentReply extends Unique {
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "commodity_comment_id")
    private String commodityCommentId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "time")
    private Date time;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommodityCommentId() {
        return commodityCommentId;
    }

    public void setCommodityCommentId(String commodityCommentId) {
        this.commodityCommentId = commodityCommentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
