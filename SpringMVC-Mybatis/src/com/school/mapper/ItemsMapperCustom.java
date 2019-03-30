package com.school.mapper;

import java.util.List;

import com.school.pojo.ItemsCustom;
import com.school.pojo.ItemsQueryVo;

public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}