package org.lanqiao.dao;

import org.lanqiao.entity.TypeInfo;

import java.util.List;

public interface TypeInfoDao {
    //通过一级菜单的编号找到所有的二级菜单
    public List<TypeInfo> ShowTypeTwo(int typeId);

    //根据菜单内容找到菜单编号
    public int ShowTypeId(String Content);
}