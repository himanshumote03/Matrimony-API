package com.appxbuild.matrimony.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;


@Entity
@Table(name = "phinxlog")
public class Phinxlog {

    // define fields
    @Id
    @Column(name = "version")
    private Long version;

    @Column(name = "migration_name")
    private String migrationName;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @Column(name = "breakpoint")
    private Byte breakPoint;

    // define constructor
    public Phinxlog(){

    }
    public Phinxlog(Long version, String migrationName, Timestamp startTime, Timestamp endTime, Byte breakPoint) {
        this.version = version;
        this.migrationName = migrationName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.breakPoint = breakPoint;
    }

    // define getter/setter
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getMigrationName() {
        return migrationName;
    }

    public void setMigrationName(String migrationName) {
        this.migrationName = migrationName;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Byte getBreakPoint() {
        return breakPoint;
    }

    public void setBreakPoint(Byte breakPoint) {
        this.breakPoint = breakPoint;
    }

    //define toString() method
    @Override
    public String toString() {
        return "Phinxlog{" +
                ", version=" + version +
                ", migrationName='" + migrationName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", breakPoint=" + breakPoint +
                '}';
    }
}

