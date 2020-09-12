package com.vinodtiru.assignment.model;

import com.vinodtiru.assignment.validator.VersionConstraint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SoftwareVersion")
public class Version implements Comparable {

    @Id
    @GeneratedValue
    private int id;
    @VersionConstraint
    private String versionNumber;

    public Version(int id, String versionNumber) {
        this.id = id;
        this.versionNumber = versionNumber;
    }

    public Version() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    @Override
    public int compareTo(Object newVersion) {
        String[] currentVersionData = this.versionNumber.split("[.]");
        String[] newVersionData = ((Version)newVersion).getVersionNumber().split("[.]");

        int minLength = currentVersionData.length>newVersionData.length ? newVersionData.length:  currentVersionData.length;
        int i = 0;
        for (i = 0; i < minLength; i++) {
            if(newVersionData[i].compareTo(currentVersionData[i]) !=0)
            {
                return newVersionData[i].compareTo(currentVersionData[i]);
            }
        }
        if(currentVersionData.length == newVersionData.length)
            return 0;
        return currentVersionData.length>newVersionData.length? -1 : 1;
    }
}