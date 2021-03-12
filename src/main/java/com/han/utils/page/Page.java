package com.han.utils.page;

import lombok.Data;

import java.util.List;

/**
 * @author kurt
 * @version 1.0.0
 * @ClassName Page.java
 * @Description TODO
 * @createTime 2021年03月09日 21:55:00
 */
@Data
public class Page<T> {
    private List<T> list;//T类型的对象链表
    private int pageNum; //当前页码
    private int pageSize;//每页数量
    private int pageCount;//总页数
}
