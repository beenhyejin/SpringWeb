package com.newlecture.webapp.dao.spring;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.newlecture.webapp.dao.NoticeDao;
import com.newlecture.webapp.entity.Notice;
import com.newlecture.webapp.entity.NoticeView;

public class SpringNoticeDao implements NoticeDao {
	
	@Autowired
	private JdbcTemplate template;
	
	/*//Transaction을 처리하는 방법 1)
	 * TransactionManager를 직접 사용하는 방법
	 * @Autowired
	private PlatformTransactionManager transactionManager;*/
	
	//Transaction을 처리하는 방법 2)
	/*@Autowired
	private TransactionTemplate transactionTemplate;
	*/
	
	
	/*//@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}*/

	@Override
	public List<NoticeView> getList(int page, String field, String query) {
		String sql = "select * from NoticeView where "+field+" like ? order by regDate desc limit ?,10;";
		List<NoticeView> list = template.query(sql, new Object[]{"%"+query+"%",(page-1)*10}, BeanPropertyRowMapper.newInstance(NoticeView.class));
		//System.out.println("page/filed/query : "+page+field+query);
		return list;
	}

	@Override
	public int getCount() {
		String sql = "select count(id) `count` from Notice";
		int count = template.queryForObject(sql,Integer.class);

		return count;
	}

	@Override
	public NoticeView get(String id) {
		String sql = "select * from Notice where id= ? "; // 구현하는 내용
		
/* RowMapping방법 1)직접 쓰지마
 * NoticeView notice = template.queryForObject(sql,new Object[] {id}, new RowMapper<NoticeView>() {
			@Override
			public NoticeView mapRow(ResultSet rs, int rowNum) throws SQLException {
					NoticeView notice = new NoticeView();
					notice.setId(rs.getString("id"));
					notice.setTitle(rs.getString("title")+"매렁");
					notice.setWriterId(rs.getString("content"));
					notice.setHit(0);
				return notice;
			}
		});*/ 
// RowMapping방법 2)간접 추천		
		NoticeView notice = template.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(NoticeView.class));//정해진 id가 아닌 변수에 따라 다르게 
//		NoticeView notice = template.queryForObject(sql, BeanPropertyRowMapper.newInstance(NoticeView.class)); //하나 cf)여러개는
		
		/* dataSource를 service.xml에 통합 시켜줌
		 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(
				"jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&useSSL=false&characterEncoding=UTF-8");
		dataSource.setUsername("sist");
		dataSource.setPassword("cclass");

		JdbcTemplate template = new JdbcTemplate(); // 구현하는 틀
		template.setDataSource(dataSource);
																*/									// queryforList..
		return notice;
	}

	@Override
	public int update(String id, String title, String content) {
		String sql = "update Notice set title=?, content=? where id=?";
		int result = template.update(sql, title, content,id);
		return result;
	}
//----------------------------------------------> notice 삽입 <-------------------------------------------------------------------------------
	@Override
	public int insert(String title, String content, String writerId) {
		return insert(new Notice(title, content,writerId));
	}
 //Transaction을 처리하는 방법 3)AOP이용 4)(@Transactional)
	@Override
	@Transactional
	public int insert(Notice notice) {
		String sql = "insert into Notice(id, title, content, writerId) values(?,?,?,?)";
		String sql1 = "update Member set point=point+1 where id =?";
		int result = 0;
		template.update(sql
								, getNextId()
								, notice.getTitle()
								, notice.getContent()
								, notice.getWriterId());
		template.update(sql1,notice.getWriterId());	
	/*	//transaction3)4)처리할때 	
	 * template.update(sql
					, getNextId()
					, notice.getTitle()
					, notice.getContent()
					, notice.getWriterId());
			template.update(sql1,notice.getWriterId());	
	*/		
		return result;
	}
	
	/*//Transaction을 처리하는 방법 2)
	// * TransactionTemplate를 사용하는 방법
	@Override
	public int insert(Notice notice) {
		String sql = "insert into Notice(id, title, content, writerId) values(?,?,?,?)";
		String sql1 = "update Member set point=point+1 where id =?";
		int result = 0;
		
		result = (int)transactionTemplate.execute(new TransactionCallbackWithoutResult(){
					@Override
					protected void doInTransactionWithoutResult(TransactionStatus arg0) {
						template.update(sql
								, getNextId()
								, notice.getTitle()
								, notice.getContent()
								, notice.getWriterId());
						template.update(sql1,notice.getWriterId());
					}});
		return result;
	}*/
	/*//Transaction을 처리하는 방법 1)
	 * TransactionManager를 직접 사용하는 방법
	 * @Override
	public int insert(Notice notice) {
		String sql = "insert into Notice(id, title, content, writerId) values(?,?,?,?)";
		String sql1 = "update Member set point=point+1 where id =?";
		int result = 0;
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus state = transactionManager.getTransaction(def);
		try {
			result = template.update(sql
					, getNextId()
					, notice.getTitle()
					, notice.getContent()
					, notice.getWriterId());
			result += template.update(sql1,notice.getWriterId());
			transactionManager.commit(state);
		}
		catch (Exception e) {
			transactionManager.rollback(state);
			throw e;
		}
		//직접 db에 작성해야 하는 경우 - 거의 사용X
		 * int result = template.update(sql,new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement st) throws SQLException {
				st.setString(1,notice.getTitle());
				st.setString(2, notice.getContent());
				st.setString(3, notice.getId());
			}
		});
		return result;
	}
*/
//--------------------------------------->notice 이전번호,이후번호<----------------------------------------------------------
	@Override
	public NoticeView getPrev(String id) {

		return null;
	}

	@Override
	public NoticeView getNext(String id) {

		return null;
	}
	
//----------------------------------->notice 등록을 위해 필요한 notice_id찾기<---------------------------------------------------------------
	@Override
	public String getNextId() {
		String sql = "select ifnull(max(cast(id as unsigned)),0) +1 from Notice";
		String nextId = template.queryForObject(sql,String.class);//정해진 id가 아닌 변수에 따라 다르게 	
		return nextId;
	}

}
