package com.example.pathvarialbesplit.domain;

public class Symbol {
    private int symbolId;
    private String name;
    private String excode;

    public Symbol(SymbolBuild build) {
        this.symbolId = build.symbolId;
        this.name = build.name;
        this.excode = build.excode;
    }

    public int getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(int symbolId) {
        this.symbolId = symbolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExcode() {
        return excode;
    }

    public void setExcode(String excode) {
        this.excode = excode;
    }

    public static class SymbolBuild {
        private int symbolId;
        private String name;
        private String excode;

        public SymbolBuild symbolId(int symbolId) {
            this.symbolId = symbolId;
            return this;
        }

        public SymbolBuild name(String name) {
            this.name = name;
            return this;
        }

        public SymbolBuild excode(String excode) {
            this.excode = excode;
            return this;
        }

        public Symbol build() {
            return new Symbol(this);
        }
    }
}
