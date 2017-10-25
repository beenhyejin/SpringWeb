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
	
	/*//Transaction�� ó���ϴ� ��� 1)
	 * TransactionManager�� ���� ����ϴ� ���
	 * @Autowired
	private PlatformTransactionManager transactionManager;*/
	
	//Transaction�� ó���ϴ� ��� 2)
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
		String sql = "select * from Notice where id= ? "; // �����ϴ� ����
		
/* RowMapping��� 1)���� ������
 * NoticeView notice = template.queryForObject(sql,new Object[] {id}, new RowMapper<NoticeView>() {
			@Override
			public NoticeView mapRow(ResultSet rs, int rowNum) throws SQLException {
					NoticeView notice = new NoticeView();
					notice.setId(rs.getString("id"));
					notice.setTitle(rs.getString("title")+"�ŷ�");
					notice.setWriterId(rs.getString("content"));
					notice.setHit(0);
				return notice;
			}
		});*/ 
// RowMapping��� 2)���� ��õ		
		NoticeView notice = template.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(NoticeView.class));//������ id�� �ƴ� ������ ���� �ٸ��� 
//		NoticeView notice = template.queryForObject(sql, BeanPropertyRowMapper.newInstance(NoticeView.class)); //�ϳ� cf)��������
		
		/* dataSource�� service.xml�� ���� ������
		 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(
				"jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&useSSL=false&characterEncoding=UTF-8");
		dataSource.setUsername("sist");
		dataSource.setPassword("cclass");

		JdbcTemplate template = new JdbcTemplate(); // �����ϴ� Ʋ
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
//----------------------------------------------> notice ���� <-------------------------------------------------------------------------------
	@Override
	public int insert(String title, String content, String writerId) {
		return insert(new Notice(title, content,writerId));
	}
 //Transaction�� ó���ϴ� ��� 3)AOP�̿� 4)(@Transactional)
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
	/*	//transaction3)4)ó���Ҷ� 	
	 * template.update(sql
					, getNextId()
					, notice.getTitle()
					, notice.getContent()
					, notice.getWriterId());
			template.update(sql1,notice.getWriterId());	
	*/		
		return result;
	}
	
	/*//Transaction�� ó���ϴ� ��� 2)
	// * TransactionTemplate�� ����ϴ� ���
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
	/*//Transaction�� ó���ϴ� ��� 1)
	 * TransactionManager�� ���� ����ϴ� ���
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
		//���� db�� �ۼ��ؾ� �ϴ� ��� - ���� ���X
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
//--------------------------------------->notice ������ȣ,���Ĺ�ȣ<----------------------------------------------------------
	@Override
	public NoticeView getPrev(String id) {

		return null;
	}

	@Override
	public NoticeView getNext(String id) {

		return null;
	}
	
//----------------------------------->notice ����� ���� �ʿ��� notice_idã��<---------------------------------------------------------------
	@Override
	public String getNextId() {
		String sql = "select ifnull(max(cast(id as unsigned)),0) +1 from Notice";
		String nextId = template.queryForObject(sql,String.class);//������ id�� �ƴ� ������ ���� �ٸ��� 	
		return nextId;
	}

}
