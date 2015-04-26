package com.yaohoo.be.dao;

import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.yaohoo.be.config.DBType;

public class DynamicDataSource  extends AbstractRoutingDataSource{

	    @Override
	    protected Object determineCurrentLookupKey() {
	        DBType key = ContextHolder.getDbType();//获得当前数据源标识符
	        return key;
	    }

		public Logger getParentLogger() throws SQLFeatureNotSupportedException {
			// TODO Auto-generated method stub
			return null;
		}
}
