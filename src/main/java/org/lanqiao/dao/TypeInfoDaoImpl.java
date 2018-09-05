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
    public List <TypeInfo> getSecondMenuTypeName(int typeid) {
        List <TypeInfo> list = new ArrayList <TypeInfo>();
        list = executeQuery("SELECT * FROM TypeInfo WHERE typeFather = ?",
                new Object[]{typeid});
        return list;

    }
    public List<TypeInfo> getFirstMenuTypeName(){
        List<TypeInfo> list = new ArrayList <TypeInfo>();
        list = executeQuery("SELECT * FROM TypeInfo WHERE typeFather = 0");
        return list;
    }

    //根据菜单内容找到菜单编号
    public int ShowTypeId(String Content){
        List<TypeInfo> list = new ArrayList<TypeInfo>();
        list = executeQuery("Select typeId from TypeInfo where typeName = ?",
                new Object[]{Content});
        return list.get(0).getTypeId();
    }

    //通过二级菜单编号找到一级菜单对象(通过list传)
    public List<TypeInfo> ShowFirstMenu(int typeId){
        return executeQuery("Select A.* from TypeInfo A, (Select * from TypeInfo Where typeId = ?) B Where B.typeFather = A.typeId;",
                new Object[]{typeId});
    }

    //通过二级菜单编号找到二级菜单对象(通过list传)
    public List<TypeInfo> ShowSecondMenu(int typeId){
        return executeQuery("Select * from TypeInfo Where typeId = ?",
                new Object[]{typeId});
    }

    public static void main(String[] args){
        List<TypeInfo> list = new ArrayList<TypeInfo>();
        List<TypeInfo> list1 = new ArrayList<TypeInfo>();
        TypeInfoDaoImpl typeInfoDao = new TypeInfoDaoImpl();
        list = typeInfoDao.ShowFirstMenu(3);
        list1 = typeInfoDao.ShowSecondMenu(3);
        System.out.println(list.get(0).getTypeName());
        System.out.println(list1.get(0).getTypeName());

    }

}
