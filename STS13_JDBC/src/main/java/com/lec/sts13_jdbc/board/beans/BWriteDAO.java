package com.lec.sts13_jdbc.board.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lec.sts13_jdbc.board.C;

public class BWriteDAO {
	JdbcTemplate template;
	
	public BWriteDAO() {
		this.template=C.template;
	}
	
	
	
	//전체 SELECT
	public List<BWriteDTO> select(){
		
		//이 쿼리문으로부터 나온걸 DTO의 getter/setter name과 매핑해서 하나로 묶어 List로 return한다.  
		return template.query(C.SQL_WRITE_SELECT
				, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
	}
	
	//글쓰기
	public int insert(final BWriteDTO dto) {	//익명클래스 내부에서 쓰일것은 effective final여야함
		
		//1. update()+PreparedStatementSetter()
		/*return template.update(C.SQL_WRITE_INSERT, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getContent());
				ps.setString(3, dto.getName());	
			}
		});
		*/

		//2. update()+PreparedStatementCreator()
		return template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement ps=con.prepareStatement(C.SQL_WRITE_INSERT);
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getContent());
				ps.setString(3, dto.getName());
				
				return ps;
			}
		});
	}
	
	
	
	
	
}
