package org.lanqiao.dao;

import org.lanqiao.entity.TypeInfo;

import java.util.ArrayList;
import java.util.List;

public class TypeInfoDaoImpl extends BaseDao<TypeInfo> implements TypeInfoDao {
    //通过一级菜单的编号找到所有的二级菜单
    public List<TypeInfo> ShowTypeTwo(int typeId){
        return executeQuery("SELECT * FROM TypeInfo Where typeFather = ?",
                new Object[]{typeId});
    }

    //根据菜单内容找到菜单编号
    public int ShowTypeId(String Content){
        List<TypeInfo> list = new ArrayList<TypeInfo>();
        list = executeQuery("Select typeId from TypeInfo where typeName = ?",
                new Object[]{Content});
        return list.get(0).getTypeId();
    }

    public static void main(String[] args){
        TypeInfoDaoImpl typeInfoDao = new TypeInfoDaoImpl();
        List<TypeInfo> list = new ArrayList<TypeInfo>();
        list = typeInfoDao.ShowTypeTwo(1);
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getTypeId() + " " + list.get(i).getTypeName());
        }

        int ret = typeInfoDao.ShowTypeId("动画");
        System.out.println(ret + "888888888");
    }
}
