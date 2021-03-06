package com.school.pojo;

import java.util.List;

/**
 * 
 * <p>Title: ItemsQueryVo</p>
 * <p>Description:商品包装对象 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-13下午3:22:36
 * @version 1.0
 */
public class ItemsQueryVo {
	
	//商品信息
	private Items items;
	
	//为了系统 可扩展性，对原始生成的po进行扩展
	private ItemsCustom itemsCustom;
	
	//批量商品信息
	private List<ItemsCustom> itemsList;
	
	//用户信息
	//private UserCustom userCustom;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}
	
	

}
