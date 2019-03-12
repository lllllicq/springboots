package com.suock.csv.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_api_CsvTableCols")
public class CsvTableCols implements Serializable {

    @Id //主键
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "assigned")
    private String id;

    @Column(name = "csvFileId",nullable = true)
    private String csvFileId;

    @Column(name = "csvColName",nullable = true)
    private String csvColName;

    @Column(name = "tableColName",nullable = true)
    private String tableColName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCsvFileId() {
        return csvFileId;
    }

    public void setCsvFileId(String csvFileId) {
        this.csvFileId = csvFileId;
    }

    public String getCsvColName() {
        return csvColName;
    }

    public void setCsvColName(String csvColName) {
        this.csvColName = csvColName;
    }

    public String getTableColName() {
        return tableColName;
    }

    public void setTableColName(String tableColName) {
        this.tableColName = tableColName;
    }
}
