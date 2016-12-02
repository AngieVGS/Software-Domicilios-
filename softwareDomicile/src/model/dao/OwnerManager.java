package model.dao;

import java.util.ArrayList;

import exceptions.ExceptionSearchId;
import model.entity.AssignProductToOwner;
import model.entity.Owner;
import model.entity.Product;

public class OwnerManager {
	private ArrayList<Owner> ownerList;
	private ArrayList<AssignProductToOwner> assignProductList;

	public OwnerManager() {
		ownerList = new ArrayList<>();
		assignProductList = new ArrayList<>();
	}

	public static Owner createOwner(String name, String password, String url) {
		return new Owner(name, password, url);
	}
	
	public ArrayList<Owner> getOwnerList() {
		return ownerList;
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
	
	public Owner searchOwnerByName(String name) throws ExceptionSearchId {
		for (Owner owner : ownerList) {
			if (owner.getName().equals(name)) {
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

	public AssignProductToOwner createAssignProductoToOwner(Product product, Owner owner){
		return new AssignProductToOwner(product, owner);
	}
	
	public void addAssignProductoToOwner(AssignProductToOwner assignProduct) {
		assignProductList.add(assignProduct);
	}

	public ArrayList<Product> searchAssignProductoToOwner(int id) throws ExceptionSearchId {
		ArrayList<Product> products = new ArrayList<>();
		for (AssignProductToOwner assignProduct : assignProductList) {
			if (assignProduct.getOwner().getId() == id) {
				products.add(assignProduct.getProduct());
			}
			return products;
		}
		throw new ExceptionSearchId();
	}

	public void deleteAssignProduct(AssignProductToOwner assignProduct) {
		assignProductList.remove(assignProduct);
	}
}