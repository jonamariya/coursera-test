package com.java.application.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class GenericDAOService<T, PK extends Serializable> {
	@Autowired
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void save(T entity){
		if(getSessionFactory()!=null){
		try{
		Session session = getSessionFactory().getCurrentSession();
		session.save(entity);
		}catch(HibernateException he){
			he.printStackTrace();
		}
		
		}else
			System.out.println("session factory is null");
	}
	@Transactional
	public void merge(T entity){
		if(getSessionFactory()!=null){
		try{
		Session session = getSessionFactory().getCurrentSession();
		session.merge(entity);
		}catch(HibernateException he){
			he.printStackTrace();
		}
		
		}else
			System.out.println("session factory is null");
	}
	
	@SuppressWarnings("unchecked")
	public T get(Class clsName,final PK id) {
		final T result = ( (T) getSessionFactory().openSession().get(clsName, id));
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List get(Class clsName) {
		Query query = getSessionFactory().openSession().createQuery("from "+clsName.getName());
		System.out.println("Query>>>>>>"+query.toString());
		return  (List) query.list();
	}
	
	@Transactional
	public void delete(T entity){
		try{
		getSessionFactory().getCurrentSession().delete(entity);
		}catch(HibernateException he){
			he.printStackTrace();
		}
	}
	public String getCount(){
		Query query=getSessionFactory().openSession().createQuery("select count(*) from StudentDetails");
		return (query.uniqueResult().toString());
	}
}
