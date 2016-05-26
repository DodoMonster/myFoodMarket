package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

/**
 * Created by ZZWEI on 2016/3/18.
 */
@Table(name = "apt_keyword")
public class Keyword extends Unique {
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "sequence")
    private int sequence;

    @Column(name = "hightlight")
    private int hightlight;

    public int getHightlight() {
        return hightlight;
    }

    public void setHightlight(int hightlight) {
        this.hightlight = hightlight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
