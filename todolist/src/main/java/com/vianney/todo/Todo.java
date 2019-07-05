/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vianney.todo;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todotbl")

/**
 *
 * @author MISHIKO
 */
public class Todo implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "Id")
    private int  Id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Category")
    private String Category;
    @Column(name = "Description")
    private String Description;
    @Column(name = "Due_Date")
    private Date Duedate;
    @Column(name = "Complete/Incomplete")
    private Boolean completeflag;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getDuedate() {
        return Duedate;
    }

    public void setDuedate(Date Duedate) {
        this.Duedate = Duedate;
    }
/* 
    */
    public Boolean getCompleteflag() {
        return completeflag;
    }

    public void setCompleteflag(Boolean completeflag) {
        this.completeflag = completeflag;
    }

    public void setUpdateDate(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
