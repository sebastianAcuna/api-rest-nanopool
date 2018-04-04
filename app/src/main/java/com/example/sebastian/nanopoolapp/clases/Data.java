package com.example.sebastian.nanopoolapp.clases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    private String account;
    private String unconfirmedBalance;
    private String balance;
    private String hashrate;
    private AvgHashrate avgHashrate;
    private List<Worker> workers = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUnconfirmedBalance() {
        return unconfirmedBalance;
    }

    public void setUnconfirmedBalance(String unconfirmedBalance) {
        this.unconfirmedBalance = unconfirmedBalance;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getHashrate() {
        return hashrate;
    }

    public void setHashrate(String hashrate) {
        this.hashrate = hashrate;
    }

    public AvgHashrate getAvgHashrate() {
        return avgHashrate;
    }

    public void setAvgHashrate(AvgHashrate avgHashrate) {
        this.avgHashrate = avgHashrate;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
