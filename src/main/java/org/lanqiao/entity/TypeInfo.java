package org.lanqiao.entity;

public class TypeInfo {
    public TypeInfo() {

    }

    public TypeInfo(String typeName, int typeFather) {
        this.typeName = typeName;
        this.typeFather = typeFather;
    }

    public TypeInfo(int typeId, String typeName, int typeFather) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.typeFather = typeFather;
    }

    private int typeId;
    private String typeName;
    private int typeFather;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getTypeFather() {
        return typeFather;
    }

    public void setTypeFather(int typeFather) {
        this.typeFather = typeFather;
    }

    @Override
    public String toString() {
        return "TypeInfo{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", typeFather=" + typeFather +
                '}';
    }
}
