package org.lanqiao.dao;

import org.lanqiao.entity.TypeInfo;

import java.util.List;

public interface TypeInfoDao {
    //通过一级菜单的编号找到所有的二级菜单
    public List<TypeInfo> ShowTypeTwo(int typeId);

    //通过二级菜单编号找到一级菜单对象(通过list传)
    public List<TypeInfo> ShowFirstMenu(int typeId);

    //通过二级菜单编号找到二级菜单对象(通过list传)
    public List<TypeInfo> ShowSecondMenu(int typeId);

    //根据菜单内容找到菜单编号
    public int ShowTypeId(String Content);


    public List<TypeInfo> getSecondMenuTypeName(int typeId);
    public List<TypeInfo> getFirstMenuTypeName();
}