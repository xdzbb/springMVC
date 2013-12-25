package com.mvc.util;

import java.util.ArrayList;
import java.util.List;

public class Pager {
	private int dataSize = 0;
	private String pageUrl = "";// 访问每个分页的基准链接
	private int totalRows = 0;// 记录总数

	private int totalPages = 0; // 总页数

	private int pageSize = 10;

	// 每页显示数据条数，默认为10条记录
	private int currentPage = 1; // 当前页数

	private boolean hasPrevious = false; // 是否有上一页

	private boolean hasNext = false; // 是否有下一页

	private boolean hasFirst = false; // 是否显示第一页

	private boolean hasLast = false; // 是否显示最后一页
	private boolean hasCurrent = true;// 是否显示当前页面

	// « 第一页 ... < 上一页 2 3 4 5 6 下一页 > ... 最后页 »
	private int navigationCount = 2;// 导航条上显示的最多的分页的个数为navigationCount*2+1 个

	private List data;

	private List<String> prePages = new ArrayList<String>();

	private List<String> postPages = new ArrayList<String>();
	
	private String isThisCollege="0";
	
	private List<Object[]> thirdMenu=new ArrayList<Object[]>();

	/**
	 * 
	 */

	public Pager() {
	}

	/**
	 * Initialize Pager
	 * 
	 * @param totalRows
	 *            total record rows
	 * @param pageSize
	 *            total record is hold by every page
	 */
	public void init(int totalRows, int pageSize) {
		this.totalRows = totalRows;
		this.pageSize = pageSize;
		totalPages = ((totalRows + pageSize) - 1) / pageSize;
		refresh(); // 刷新当前页面信息
	}

	public void init(int totalRows, int curpage, int pageSize) {
		this.totalRows = totalRows;
		this.pageSize = pageSize;
		this.currentPage = curpage;
		this.totalPages = ((totalRows + pageSize) - 1) / pageSize;
		refresh(); // 刷新当前页面信息
	}

	/**
	 * @return Returns the currentPage.
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage
	 *            current page
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		refresh();
	}

	/**
	 * @return Returns the pageSize.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            The pageSize to set.
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		refresh();
	}

	/**
	 * @return Returns the totalPages.
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages
	 *            The totalPages to set.
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
		refresh();
	}

	/**
	 * @return Returns the totalRows.
	 */
	public int getTotalRows() {
		return totalRows;
	}

	/**
	 * @param totalRows
	 *            The totalRows to set.
	 */
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
		refresh();
	}

	// 跳到第一页
	public void first() {
		currentPage = 1;

		this.setHasPrevious(false);
		refresh();
	}

	// 取得上一页（重新设定当前页面即可）
	public void previous() {
		currentPage--;
		refresh();
	}

	// 取得下一页
	public void next() {

		//System.out.println("next: totalPages: " + totalPages + " currentPage: " + currentPage);

		if (currentPage < totalPages) {
			currentPage++;
		}
		refresh();
	}

	// 跳到最后一页
	public void last() {
		currentPage = totalPages;

		this.setHasNext(false);
		refresh();
	}

	public boolean isHasNext() {
		return hasNext;
	}

	/**
	 * @param hasNext
	 *            The hasNext to set.
	 */
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public boolean isHasPrevious() {
		return hasPrevious;
	}

	/**
	 * @param hasPrevious
	 *            The hasPrevious to set.
	 */
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	// 刷新当前页面信息
	public void refresh() {

		if (totalPages <= 1) {
			hasPrevious = false;
			hasNext = false;
			this.hasFirst = false;
			this.hasLast = false;
			this.hasCurrent = false;
			return;
		} else if (currentPage == 1) {
			hasPrevious = false;
			hasNext = true;
		} else if (currentPage == totalPages) {
			hasPrevious = true;
			hasNext = false;
		} else {
			hasPrevious = true;
			hasNext = true;
		}
		if (this.totalPages > this.navigationCount * 2 + 1) {
			if (currentPage - navigationCount > 1) {
				this.hasFirst = true;
			} else {
				this.hasFirst = false;
			}
			if (this.currentPage + navigationCount < totalPages) {
				this.hasLast = true;
			} else {
				this.hasLast = false;
			}

			this.prePages.clear();
			this.postPages.clear();
			int preCount = navigationCount;
			int postCount = navigationCount;
			if (this.currentPage - this.navigationCount < 1) {
				preCount = this.currentPage - 1;
				postCount = this.navigationCount * 2 - preCount;
			} else if (this.currentPage + this.navigationCount > this.totalPages) {
				postCount = this.totalPages - this.currentPage;
				preCount = this.navigationCount * 2 - postCount;
			}

			for (int i = preCount; i >= 1; i--) {
				if (this.currentPage - i > 0) {
					this.prePages.add(String.valueOf(currentPage - i));
				}
			}
			for (int j = 1; j <= postCount; j++) {
				if (this.currentPage + j <= this.totalPages)
					this.postPages.add(String.valueOf(this.currentPage + j));
			}

		} else {
			this.hasFirst = false;
			this.hasLast = false;
			this.prePages.clear();
			this.postPages.clear();
			for (int i = 1; i < this.currentPage; i++) {
				this.prePages.add(String.valueOf(i));
			}
			for (int j = this.currentPage + 1; j <= this.totalPages; j++) {
				this.postPages.add(String.valueOf(j));
			}

		}

	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
		if(data!=null)
			this.dataSize = data.size();
	}

	public boolean isHasFirst() {
		return hasFirst;
	}

	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}

	public boolean isHasLast() {
		return hasLast;
	}

	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}

	public int getNavigationCount() {
		return navigationCount;
	}

	public void setNavigationCount(int navigationCount) {
		this.navigationCount = navigationCount;
	}

	public List getPostPages() {
		return postPages;
	}

	public void setPostPages(ArrayList<String> postPages) {
		this.postPages = postPages;
	}

	public List getPrePages() {
		return prePages;
	}

	public void setPrePages(ArrayList<String> prePages) {
		this.prePages = prePages;
	}

	public boolean isHasCurrent() {
		return hasCurrent;
	}

	public void setHasCurrent(boolean hasCurrent) {
		this.hasCurrent = hasCurrent;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public int getDataSize() {
		return dataSize;
	}

	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}
	
	public String getIsThisCollege() {
		return isThisCollege;
	}

	public void setIsThisCollege(String isThisCollege) {
		this.isThisCollege = isThisCollege;
	}

	public List<Object[]> getThirdMenu() {
		return thirdMenu;
	}

	public void setThirdMenu(List<Object[]> thirdMenu) {
		this.thirdMenu = thirdMenu;
	}

}