package com.yootk.vo;

public class News {
    private Long nid;

    private String title;

    private String content;

    public News(Long nid, String title) {
        this.nid = nid;
        this.title = title;
    }

    public News(Long nid, String title, String content) {
        this.nid = nid;
        this.title = title;
        this.content = content;
    }

    public Long getNid() {
        return nid;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}