package model.dao;

import java.util.ArrayList;

import exceptions.ExceptionSearchId;
import model.entity.Owner;

public class OwnerManager {
	private ArrayList<Owner> ownerList;

	public OwnerManager() {
		ownerList = new ArrayList<>();
	}

	public Owner createOwner(int id, String name, String password) {
		return new Owner(id, name, password);
	}

	public void addOwner(Owner owner) {
		ownerList.add(owner);
	}

	public Owner searchOwner(int id) throws ExceptionSearchId {
		for (Owner owner : ownerList) {
			if (owner.getId() == id) {
				return owner;
			}
		}
		throw new ExceptionSearchId();
	}

	public void deleteOwner(Owner owner) {
		ownerList.remove(owner);
	}

	public void editOwner(Owner owner, int id) {
		ownerList.set(id, owner);
	}

	

	
}