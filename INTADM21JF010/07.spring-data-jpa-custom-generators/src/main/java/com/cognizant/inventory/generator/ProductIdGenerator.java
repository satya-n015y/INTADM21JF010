package com.cognizant.inventory.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ProductIdGenerator implements IdentifierGenerator {
	private String prefix = "RF-";
	private int suffix = 0;
	private String pkValue="";
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Connection dbcon = session.connection();
		try {
			Statement st = dbcon.createStatement();
			String sql = "select count(*) from PRODUCT_DTLS";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				suffix = rs.getInt(1);
				System.out.println("------"+ suffix+" --------");
			}
			
			pkValue = prefix+(suffix+1001);
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		return pkValue;
	}

}
