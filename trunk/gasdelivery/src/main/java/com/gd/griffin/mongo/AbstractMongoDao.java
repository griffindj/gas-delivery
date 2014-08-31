package com.gd.griffin.mongo;

import com.gd.griffin.model.ObjectWithId;

public interface AbstractMongoDao {
	Object findById(String objectId);

	ObjectWithId save(ObjectWithId objectToSave);

	void delete(ObjectWithId objectToDelete);
}
