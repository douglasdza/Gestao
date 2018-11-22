/*
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import modelo.Venda;

public class DAOVenda{

    private static EntityManager entityManager = Fabrica.getFabrica().getEm();;
 
    public List<Venda> buscarVendasVendedor(String email) {
       
        Query query = null;
        try {
            query = entityManager.createQuery("from Venda where vendedor.email='" + email+"'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       return query.getResultList();
        
    }
}
*/