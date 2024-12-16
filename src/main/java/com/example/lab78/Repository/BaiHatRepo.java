package com.example.lab78.Repository;

import com.example.lab78.Entity.BaiHat;
import com.example.lab78.Util.HibernateConnect;
import jakarta.persistence.Query;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class BaiHatRepo {
    Session s = null;
    public BaiHatRepo(){
        s = HibernateConnect.getFACTORY().openSession();
    }
    public List getAll(){
        return s.createQuery("from bai_hat ").list();
    }
    public void add(BaiHat bh){
        s.getTransaction().begin();
        s.save(bh);
        s.getTransaction().commit();
    }
    public BaiHat getOne(int id){
        return s.get(BaiHat.class,id);
    }
    public List pagegin(int page){
        Query q  =  s.createQuery("FROM bai_hat ");
        q.setFirstResult((page-1)*5);
        q.setMaxResults(5);
        return q.getResultList();
    }
}
