package com.ketaipl.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 27.02.13
 * Time: 13:50
 * To change this template use File | Settings | File Templates.
 */

@DatabaseTable(tableName = "transit")
public class Transit {

    @DatabaseField(id = true)
    private String id;
    @DatabaseField
    private String startLocation;
    @DatabaseField
    private String endLocation;

    public Transit() {
        // ORMLite needs a no-arg constructor
    }
    public Transit(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
