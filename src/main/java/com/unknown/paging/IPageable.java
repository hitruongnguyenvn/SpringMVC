package com.unknown.paging;

import com.unknown.sort.Sorter;

public interface IPageable {
	public Integer getPage();
	public Integer getOffset();
	public Integer getFetchNextRows();
	public Sorter getSort();
}
