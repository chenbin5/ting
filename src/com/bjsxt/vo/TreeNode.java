package com.bjsxt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


public class TreeNode {
    private  int id;
    private  String text;
    private  String state;
    private Map<String,String> attributes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public TreeNode() {
    }

    public TreeNode(int id, String text, String state, Map<String, String> attributes) {
        this.id = id;
        this.text = text;
        this.state = state;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", state='" + state + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
