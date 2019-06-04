package br.com.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.HibernateUtil.HibernateUtil;

public abstract class AbstractModel<T> {
	private Class<T> entity;
	protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public AbstractModel(Class<T> entity) {
		this.entity = entity;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<T> list() {
		List<T> result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = session.createQuery("from " + entity.getName()).list();
			transaction.commit();

		} catch (Exception e) {
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public boolean save(T entity) {
		boolean result = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch (Exception e) {
			result = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public T find(Object id) {
		T result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = session.get(entity, (Serializable) id);
			transaction.commit();
		} catch (Exception e) {
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public boolean update(T entity) {
		boolean result = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();

		} catch (Exception e) {
			result = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public boolean delete(T entity) {
		boolean result = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(entity);
			transaction.commit();

		} catch (Exception e) {
			result = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> contains(String keyword, String atributo) {
		Session session = null;
		Transaction transaction = null;
		List<T> entities;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("from " + entity.getName() + " where " + atributo + " like :keyword");
			query.setParameter("keyword", "%" + keyword + "%");
			entities = query.getResultList();
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		return entities;

	}
}
