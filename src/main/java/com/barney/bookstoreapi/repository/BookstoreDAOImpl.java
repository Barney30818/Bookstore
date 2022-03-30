package com.barney.bookstoreapi.repository;

import com.barney.bookstoreapi.bean.BookVO;
import com.esb.est.bean.transaction.AccountTransactionMapper;
import com.esb.est.service.common.log.logger.EsunLogger;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class BookstoreDAOImpl implements BookstoreDAO{
	
	private JdbcTemplate jdbcTemplate;
	
    @Override
    public void createBook(BookVO bookVO) {
    	try {
	    	getJdbcTemplate().setResultsMapCaseInsensitive(true);
	        SimpleJdbcCall callGetBusinessData = new SimpleJdbcCall(this.getJdbcTemplate()).withProcedureName("EST_SP_UPDATE_ACCOUNT_TX_CASE")
	                .returningResultSet("accountTxOID", new AccountTransactionMapper())
	        		.declareParameters(
	        				new SqlParameter("caseOid", Types.NVARCHAR)
	                ,new SqlParameter("inCstmrAccount", Types.NVARCHAR)
	                ,new SqlParameter("inAccount", Types.NVARCHAR)
	                ,new SqlParameter("outCstmrAccount", Types.NVARCHAR)
	                ,new SqlParameter("outAccount", Types.NVARCHAR)
	                ,new SqlParameter("currency", Types.NVARCHAR));
	        MapSqlParameterSource inSqlParms = new MapSqlParameterSource();
	        inSqlParms.addValue("caseOid", accountTxVO.getAccountTxOid());
	        inSqlParms.addValue("inCstmrAccount", accountTxVO.getDesc());
	        inSqlParms.addValue("inAccount", accountTxVO.getDesc());
	        inSqlParms.addValue("outCstmrAccount", accountTxVO.getDesc());
	        inSqlParms.addValue("outAccount", accountTxVO.getDesc());
	        inSqlParms.addValue("currency", accountTxVO.getDesc());
	        
	        callGetBusinessData.execute(inSqlParms);
    	} catch (Exception e) {
            EsunLogger.info(e, "搜尋DAO有誤");
            throw e;
        }
    }

    @Override
    public String updateBookInfo(BookVO bookVO) {
        return null;
    }

    @Override
    public List<BookVO> searchAllBook() {
        return null;
    }

    @Override
    public String deleteBook(String ISBN) {
        return null;
    }
    
    protected JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	protected void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
