package com.example.softwareengineering.entity;

import javax.persistence.Entity;

@Entity
public class SearchTerm {
    private String Term;
    private Integer Items;
    private Integer Page;
    public SearchTerm(String term, Integer items, Integer page){
        Term = term;
        Items = items;
        Page = page;
    }

    public Integer getItems() {
        return Items;
    }
    public void setItems(Integer items) {
        Items = items;
    }
    public Integer getPage() {
        return Page;
    }
    public void setPage(Integer page) {
        Page = page;
    }
    public String getTerm() {
        return Term;
    }
    public void setTerm(String term) {
        Term = term;
    }
}
