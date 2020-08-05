package jva_sesB;

import jva.TblEmpEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Stateless(name = "MySession7EJB")
public class MySession7Bean {
    @PersistenceContext(unitName = "bkPersistenceUnit")
    private EntityManager em;

    public MySession7Bean() {
    }

    public String sayHello() {
        return "stateless session of ur example name";
    }

    //name search with some characters
    public List<TblEmpEntity> findByName(String name) {
        TypedQuery<TblEmpEntity> query = this.em.createQuery("select emp from TblEmpEntity emp where emp.eName LIKE :employeeName", TblEmpEntity.class);
        query.setParameter("employeeName", "%" + name + "%");
        query.setMaxResults(10);
        return query.getResultList();
    }

    public void addEmp(TblEmpEntity emp) {
        em.persist(emp);
    }

    //single update and delete
        /*public void updateEmp(Integer updateId,String name)
        { TblEmpEntity emp;
          emp = em.find(TblEmpEntity.class, updateId);
          if(emp != null) {
              emp.seteName(name);
              em.persist(emp);
          }
        }*/
   /* public void deleteEmp(Integer deletedId)
    { TblEmpEntity emp;
        emp = em.find(TblEmpEntity.class, deletedId);
        if(emp != null)
        em.remove(emp);
   }*/
    public int UpdateMany(String name, Integer updateAge) {
        Query query = em.createQuery("UPDATE TblEmpEntity t SET t.eName =:upName WHERE t.eAge > :p");
        query.setParameter("upName", name);
        query.setParameter("p", updateAge);
        int updateCount = query.executeUpdate();
        return updateCount;

    }

    public int deleteMany2(Integer deleteId) {

        Query query = em.createQuery(
                "DELETE FROM TblEmpEntity t WHERE t.eId <= :p");
        query.setParameter("p", deleteId);
        int deletedCount = query.executeUpdate();
        return deletedCount;
    }

    public List<TblEmpEntity> dispAll() {
        TypedQuery<TblEmpEntity> emp2s = em.createQuery("Select a From TblEmpEntity a", TblEmpEntity.class);
        return emp2s.getResultList();
    }

    public List<TblEmpEntity> searchData(String name) {
        TypedQuery<TblEmpEntity> emp2s = em.createQuery("Select a From TblEmpEntity a where a.eName=:searchName", TblEmpEntity.class);
        emp2s.setParameter("searchName", name);
        return emp2s.getResultList();
    }

}
