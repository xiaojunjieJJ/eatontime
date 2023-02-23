package com.xiao.common.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageSerializable;

import java.util.Collection;
import java.util.List;

/**
 * @PackageName:com.jc.oa.common.dto
 * @ClassName:PageInfoResult
 * @Description: <p> (重写pagehelper返回封装)</p>
 * @author:Pey.yang
 * @date:2022/12/29 15:41
 * ${tags}$
 */
public class PageInfoResult<T> extends PageSerializable<T> {
    private int pageNum;
    private int pageSize;

    public PageInfoResult(List<T> list) {
        super(list);
        if (list instanceof Page) {
            Page page = (Page)list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
        } else if (list instanceof Collection) {
            this.pageNum = 1;
            this.pageSize = list.size();
        }
    }


    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("PageInfoResult{");
        sb.append("pageNum=").append(this.pageNum);
        sb.append(", pageSize=").append(this.pageSize);
        sb.append('}');
        return sb.toString();
    }
}
