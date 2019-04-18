package software.esig.todolist.util;

import org.hibernate.Session;
import org.junit.Test;

import software.esig.todolist.util.HibernateUtil;

public class HibernateUtilTest {
	
	@Test
	public void conectar() {
			Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
			sessao.close();
			HibernateUtil.getFabricaDeSessoes().close();
	}
}
