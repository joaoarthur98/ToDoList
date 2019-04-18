package software.esig.todolist.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import software.esig.todolist.util.HibernateUtil;

public abstract class AbstractDAO<Entidade> {
	private Class<Entidade> classe;

	// Construtor para descobrir, em tempo de execução, qual o tipo de entidade
	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
			transacao.commit();
		} catch (RuntimeException err) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw err;
		} finally {
			sessao.close();
		}
	}

	public List<Entidade> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<Entidade> consulta = builder.createQuery(classe);
			consulta.from(classe);

			return sessao.createQuery(consulta).getResultList();

		} catch (Exception err) {
			throw err;
		} finally {
			sessao.close();
		}
	}

	public Entidade buscarPorCodigo(long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			return sessao.find(classe, codigo);

		} catch (Exception err) {
			throw err;
		} finally {
			sessao.close();
		}
	}

	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		} catch (RuntimeException err) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw err;
		} finally {
			sessao.close();
		}
	}
	
	public void atualizar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();
		} catch (RuntimeException err) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw err;
		} finally {
			sessao.close();
		}
	}
	
	public void merge(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
			transacao.commit();
		} catch (RuntimeException err) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw err;
		} finally {
			sessao.close();
		}
	}
}
