package com.rad.kit.dsappsvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "DEMO_MESSAGE")
public class DemoMessage {

    @Id
    @GeneratedValue
    @Column(name = "MESSAGE_ID", nullable = false, columnDefinition = "int")
    private int id;

    @Column(name = "MESSAGE", nullable = false, columnDefinition = "varchar(256)")
    private String message;

    @Column(name = "REC_MODIFIED_DT_TM", nullable = false, columnDefinition = "timestamp")
    private Date lastModifiedDate;

    public DemoMessage(int id, String message, Date lastModifiedDate) {
        this.id = id;
        this.message = message;
        this.lastModifiedDate = lastModifiedDate;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }
}
