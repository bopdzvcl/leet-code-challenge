package com.example.lab78.Repository;

import com.example.lab78.Entity.CaSi;
import com.example.lab78.Util.HibernateConnect;
import org.hibernate.Session;

import java.util.List;

public class CaSiRepo {
        Session s = null;
        public CaSiRepo(){
            s = HibernateConnect.getFACTORY().openSession();
        }
        public List getAll(){
            return s.createQuery("from ca_si ").list();
        }
        public CaSi getOne(int id){
            return s.get(CaSi.class,id);
        }
}
