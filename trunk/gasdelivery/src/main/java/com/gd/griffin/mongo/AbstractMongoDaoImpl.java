package com.gd.griffin.mongo;

import java.net.UnknownHostException;

import com.gd.griffin.model.ObjectWithId;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class AbstractMongoDaoImpl implements AbstractMongoDao {
	MongoClient mc = null;
	DB gasDelivery = null;
	DBCollection users = null;

	public AbstractMongoDaoImpl() {
		try {
			this.mc = new MongoClient();
		} catch (UnknownHostException e) {
			System.out.println("Cannot connect to mongo");
			e.printStackTrace();
		}
		this.gasDelivery = mc.getDB("gasDelivery");
		this.users = gasDelivery.getCollection("users");
	}

	@Override
	public Object findById(String objectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectWithId save(ObjectWithId objectToSave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ObjectWithId objectToDelete) {
		// TODO Auto-generated method stub

	}

}
