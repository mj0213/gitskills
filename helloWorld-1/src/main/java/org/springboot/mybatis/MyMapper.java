package org.springboot.mybatis;

import org.apache.ibatis.annotations.Mapper;

/**
 * 被继承的Mapper,一般业务Mapper继承他
 * @author Administrator
 *
 */
public interface MyMapper<T> extends Mapper {
	//TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
