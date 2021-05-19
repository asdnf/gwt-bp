package org.ppk.gwt.server.dao;

import org.ppk.gwt.server.entity.DataObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataObjectRepository extends CrudRepository<DataObject, Integer> {
}
