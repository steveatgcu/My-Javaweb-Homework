package me.shaobin.utils;

import me.shaobin.bean.Page;

public class PageUtils<T> {
	
	public Page<T> generatePage(int count,int pageNum,int prePage){
		Page<T> page = new Page<T>();
		int totalPage = count/prePage+1;
		if(totalPage<pageNum&&pageNum<0){
			pageNum = 1;
		}
		page.setCurrentPage(pageNum);
		page.setStartNum((pageNum-1)*prePage);
		page.setItemPrePage(prePage);
		if(pageNum==totalPage){
			page.setHasNext(false);
		}else{
			page.setHasNext(true);
			page.setNextPage(pageNum+1);
		}
		if(pageNum!=1){
			page.setHasPrev(true);
			page.setPrevPage(pageNum-1);
		}else{
			page.setHasPrev(false);
		}
		return page;
	}

}
