package com.sentryc.marketplaces.constants;

public enum SellerFilter {
    EXTERNAL_ID("externalId"), NAME("name"), MARKETPLACE_ID("marketPlace");

    private String text;

    SellerFilter(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
