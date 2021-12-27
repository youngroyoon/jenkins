package com.dktechin.demo.sample.model;

public class SampleDataBean {

    public SampleDataBean(){}

    public SampleDataBean(String id, String parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    public SampleDataBean(String id, String parentId, String name, Integer depth) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.depth = depth;
    }

    /** 아이디 */
    private String id;
    /** 부모 아이디 */
    private String parentId;
    /** 이름 */
    private String name;
    /** 레벨*/
    private Integer depth;

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

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "DataBean{" + "id='" + id + '\'' + ", parentId='" + parentId + '\'' + ", name='" + name + '\'' + ", depth=" + depth + '}';
    }
}
