package com.unknown.paging;

import com.unknown.sort.Sorter;

public class PageRequest implements IPageable {

	private Integer page;
	private Integer maxPageItem;
	private Sorter sort;

	public PageRequest() {
		super();
	}

	public PageRequest(Integer page, Integer maxPageItem, Sorter sort) {
		super();
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sort = sort;
	}

	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getOffset() {
		if(this.page != null) {
			return (this.getPage() - 1) * this.getFetchNextRows();
		}
		return null;
	}

	@Override
	public Integer getFetchNextRows() {
		return this.maxPageItem;
	}

	@Override
	public Sorter getSort() {
		return this.sort;
	}

}
