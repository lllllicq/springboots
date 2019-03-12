package com.suock.pub.helper.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:apiFilePath.properties")
@ConfigurationProperties(prefix = "api.file.path")
public class ApiFilePath {

    private String supplyCloud;
    private String poFile;
    private String gsmSupply;

    public String getGsmSupply() {
        return gsmSupply;
    }

    public void setGsmSupply(String gsmSupply) {
        this.gsmSupply = gsmSupply;
    }

    public String getSupplyCloud() {
        return supplyCloud;
    }

    public void setSupplyCloud(String supplyCloud) {
        this.supplyCloud = supplyCloud;
    }
    public String getPoFile() {
        return poFile;
    }
    public void setPoFile(String poFile) {
        this.poFile = poFile;
    }
}
