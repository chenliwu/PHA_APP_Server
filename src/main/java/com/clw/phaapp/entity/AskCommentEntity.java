package com.clw.phaapp.entity;

import com.clw.phaapp.common.entity.DatagridPageEntity;

public class AskCommentEntity extends DatagridPageEntity{
    /**
     * 记录号
     */
    private Long recno;

    /**
     * 类型：0评论，1回复
     */
    private Byte type;

    /**
     * 内容
     */
    private String content;

    /**
     * 用户记录号
     */
    private Long userrecno;

    /**
     * 评论目标记录号
     */
    private String targetrecno;

    /**
     * 主评论记录号
     */
    private Long primaryrecno;

    /**
     * 时间
     */
    private Long opdate;

    /**
     * 回复记录号
     */
    private Long reprecno;

    /**
     * 状态：0未读，1已读
     */
    private Byte status;

    /**
     * 记录号
     * @return recno 记录号
     */
    public Long getRecno() {
        return recno;
    }

    /**
     * 记录号
     * @param recno 记录号
     */
    public void setRecno(Long recno) {
        this.recno = recno;
    }

    /**
     * 类型：0评论，1回复
     * @return type 类型：0评论，1回复
     */
    public Byte getType() {
        return type;
    }

    /**
     * 类型：0评论，1回复
     * @param type 类型：0评论，1回复
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 内容
     * @return content 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 用户记录号
     * @return userrecno 用户记录号
     */
    public Long getUserrecno() {
        return userrecno;
    }

    /**
     * 用户记录号
     * @param userrecno 用户记录号
     */
    public void setUserrecno(Long userrecno) {
        this.userrecno = userrecno;
    }

    /**
     * 评论目标记录号
     * @return targetrecno 评论目标记录号
     */
    public String getTargetrecno() {
        return targetrecno;
    }

    /**
     * 评论目标记录号
     * @param targetrecno 评论目标记录号
     */
    public void setTargetrecno(String targetrecno) {
        this.targetrecno = targetrecno == null ? null : targetrecno.trim();
    }

    /**
     * 主评论记录号
     * @return primaryrecno 主评论记录号
     */
    public Long getPrimaryrecno() {
        return primaryrecno;
    }

    /**
     * 主评论记录号
     * @param primaryrecno 主评论记录号
     */
    public void setPrimaryrecno(Long primaryrecno) {
        this.primaryrecno = primaryrecno;
    }

    /**
     * 时间
     * @return opdate 时间
     */
    public Long getOpdate() {
        return opdate;
    }

    /**
     * 时间
     * @param opdate 时间
     */
    public void setOpdate(Long opdate) {
        this.opdate = opdate;
    }

    /**
     * 回复记录号
     * @return reprecno 回复记录号
     */
    public Long getReprecno() {
        return reprecno;
    }

    /**
     * 回复记录号
     * @param reprecno 回复记录号
     */
    public void setReprecno(Long reprecno) {
        this.reprecno = reprecno;
    }

    /**
     * 状态：0未读，1已读
     * @return status 状态：0未读，1已读
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 状态：0未读，1已读
     * @param status 状态：0未读，1已读
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}