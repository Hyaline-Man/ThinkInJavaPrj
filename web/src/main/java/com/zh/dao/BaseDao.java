package com.zh.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Repository;

/**
 * Author: Administrator <br/>
 * Date: 2018-07-18 <br/>
 */
@Repository
public class BaseDao implements BeanNameAware {

    private Logger logger = Logger.getLogger(BaseDao.class);

    @Override
    public void setBeanName(String s) {
        logger.info(this.getClass().getSimpleName());
    }
}
