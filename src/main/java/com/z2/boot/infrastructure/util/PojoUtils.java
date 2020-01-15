package com.z2.boot.infrastructure.util;

import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 各种POJO之间相互转换工具
 *
 */
public class PojoUtils {

    protected static final Logger logger = LoggerFactory.getLogger(PojoUtils.class);


    /**
     * 将实体对象object 映射成 clazz指定的Class类型的实例
     *
     * @param object
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T map(Object object, Class<T> clazz) {
        if (object == null) {
            return null;
        }
        try {
            Constructor constructor = clazz.getConstructor();
            T target = (T) constructor.newInstance();
            BeanCopier copier = BeanCopier.create(object.getClass(), clazz, false);
            copier.copy(object, target, null);
            return target;
        } catch (Exception e) {
            logger.error("{} 转换为 [{}] 实例", object, clazz.getName());
            logger.error("XO转换", e);
        }
        return null;
    }

    /**
     * 将包含对象实现的列表中的所有对象实例转换为<br />
     * clazz指定的Class类型的实例列表
     * @see PojoUtils#map(Object, Class)
     *
     * @param collection
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> map(List collection, Class<T> clazz) {
        if (collection == null) {
            return null;
        }
        List<T> targetList = (List<T>) collection
                .stream()
                .map(e -> map(e, clazz))
                .collect(Collectors.toList());
        return targetList;
    }

    /**
     * 批量手动setter类型转换
     *
     * @param collection
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> map(List<T> collection, Function<T, R> function) {
        if (collection == null) {
            return null;
        }
        return collection
                .stream()
                .map(function)
                .collect(Collectors.toList());
    }


    
    /**
     * objList to idList
     * @param dataList
     * @param <T>
     * @return
     */
    public static <T> Set<Integer> toIdList(List<T> dataList, String methodName){
        Set<Integer> idList=new HashSet<>(dataList.size());
        dataList.forEach(t->{
            try {
                Object obj=t.getClass().getMethod(methodName).invoke(t);
                String attrName="";
                if(null!=obj){
                    attrName=obj.toString();
                }
                if(StringUtils.isNotBlank(attrName)){
                    idList.add(Integer.valueOf(attrName));
                }
            } catch (Exception e) {
                logger.error("数据list转换id异常:{}",e.getMessage());
            }
        });
        return idList;
    }

}
