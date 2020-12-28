package dz.com.cerist.artisanat.service.base;

import dz.com.cerist.artisanat.entite.base.BaseEntity;
import dz.com.cerist.artisanat.entite.base.IEntity;



/**
 * Service interface for service with no concrete Entity behind.
 * 
 * @author Ignas
 * 
 */
public interface IVariableTypeService {
    
    /**
     * Loads entity by its id.
     * 
     * @param entityClass
     *            Concrete Entity class.
     * @param id
     *            Entity ID
     * @return Loaded Entity.
     */
    BaseEntity findById(Class<? extends IEntity> entityClass, Long id);

}
