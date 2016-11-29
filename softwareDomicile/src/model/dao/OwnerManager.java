package model.dao;

import java.util.ArrayList;

import exceptions.ExceptionSearchId;
import model.entity.AssignProduct;
import model.entity.Owner;
import model.entity.Product;

public class OwnerManager {
	private ArrayList<Owner> ownerList;
	private ArrayList<AssignProduct> assignProductList;

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

	public AssignProduct createAssignProductoToOwner(Product product, Owner owner){
		return new AssignProduct(product, owner);
	}
	
	public void addAssignProductoToOwner(AssignProduct assignProduct) {
		assignProductList.add(assignProduct);
	}

	public AssignProduct searchAssignProductoToOwner(int id) throws ExceptionSearchId {
		for (AssignProduct assignProduct : assignProductList) {
			if (assignProduct.getOwner().getId() == id) {
				return assignProduct;
			}
		}
		throw new ExceptionSearchId();
	}

	public void deleteAssignProduct(AssignProduct assignProduct) {
		assignProductList.remove(assignProduct);
	}
}