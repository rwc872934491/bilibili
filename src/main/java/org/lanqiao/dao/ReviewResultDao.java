package org.lanqiao.dao;

import org.lanqiao.entity.ReviewResult;

import java.util.List;

public interface ReviewResultDao {
    public List<ReviewResult> ShowData(int userId);
}
