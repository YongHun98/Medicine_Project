package com.example.medicine_project;

public class Drug {
    private String companyName;
    private String drugName;
    private String drugEffect;
    private String take;
    private String caution;
    private String store;
    private String image;
    private String barcode;

    public Drug() {

    }

    public Drug(String drugName) {
        this.drugName = drugName;
    }
    // 생성자 더 만들어야함

    public Drug( p1, p2, p3, ...) {

    }

    public String getCompanyName() {
        return companyName;
    }
    public String getCompanyName(String drugName) {
        this.drugName = drugName;
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugEffect() {
        return drugEffect;
    }

    public void setDrugEffect(String drugEffect) {
        this.drugEffect = drugEffect;
    }

    public String getTake() {
        return take;
    }

    public void setTake(String take) {
        this.take = take;
    }

    public String getCaution() {
        return caution;
    }

    public void setCaution(String caution) {
        this.caution = caution;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
