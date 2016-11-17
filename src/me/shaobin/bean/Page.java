package me.shaobin.bean;

import java.util.List;

public class Page<T> {

	private boolean hasNext;
	private boolean hasPrev;
	private int currentPage;
	private int nextPage;
	private int prevPage;
	private int startNum;
	private int itemPrePage;

	public int getItemPrePage() {
		return itemPrePage;
	}

	public void setItemPrePage(int itemPrePage) {
		this.itemPrePage = itemPrePage;
	}

	private List<T> data;

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public boolean isHasPrev() {
		return hasPrev;
	}

	public void setHasPrev(boolean hasPrev) {
		this.hasPrev = hasPrev;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

}
