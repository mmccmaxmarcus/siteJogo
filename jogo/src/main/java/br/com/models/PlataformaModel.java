package br.com.models;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import br.com.HibernateUtil.HibernateUtil;
import entities.Genero;
import entities.Plataforma;

public class PlataformaModel extends AbstractModel<Plataforma> {

	public PlataformaModel() {
		super(Plataforma.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<String> buscarPorGenero(Integer id) {
		Session session = null;
		List<String> generos = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(
"select distinct g.tipoGenero.tipoGenero from Genero g where g.plataforma.id = :id");
			query.setParameter("id", id);
			generos = query.getResultList();
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();

		} finally {
			session.close();
		}
		return generos;
	}

}
