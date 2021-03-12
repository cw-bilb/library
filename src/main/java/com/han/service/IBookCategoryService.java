package com.han.service;

import com.han.dao.BookCategory;
import com.han.utils.page.Page;

public interface IBookCategoryService {

    //图书类别分页查询
    public Page<BookCategory> selectBookCategoryByPageNum(int pageNum);

    int deleteBookCategoryById(int bookCategoryId);
}
