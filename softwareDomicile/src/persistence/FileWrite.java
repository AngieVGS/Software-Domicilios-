package persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import exceptions.ExceptionSearchId;
import model.dao.OrderManager;
import model.dao.OwnerManager;
import model.dao.ProductManager;
import model.dao.UserManager;
import model.entity.AssignOrderToUser;
import model.entity.AssignProductToOrder;
import model.entity.AssignProductToOwner;
import model.entity.Order;
import model.entity.Owner;
import model.entity.State;
import model.entity.User;

public class FileWrite {
	
	public void fileWriteAssignProductToOwnerOwner(ArrayList<AssignProductToOwner> ownerList) throws IOException{
		File   file=new File("src/data/AssignProductToOwner.json");
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, false));
		JsonArray assignationsOwnerProduct = new JsonArray();
			for (AssignProductToOwner owner : ownerList) {
				JsonObject assignProductToOrder = new JsonObject();
				JsonObject ownerObject = new JsonObject();
				ownerObject.addProperty(ConstantPersistence.OWNER_NAME, owner.getOwner().getName());
				ownerObject.addProperty(ConstantPersistence.OWNER_PASSWORD, owner.getOwner().getPassword());
				ownerObject.addProperty(ConstantPersistence.OWNER_IMAGE, owner.getOwner().getUrl());
				JsonObject productsObjetc = new JsonObject();
				productsObjetc.addProperty(ConstantPersistence.PRODUCT_NAME, owner.getProduct().getName());
				productsObjetc.addProperty(ConstantPersistence.PRODUCT_DESCRIPTION, owner.getProduct().getDescription());
				productsObjetc.addProperty(ConstantPersistence.PRODUCT_PRICE, owner.getProduct().getPrice());
				productsObjetc.addProperty(ConstantPersistence.PRODUCT_IMAGE, owner.getProduct().getImg());
				productsObjetc.addProperty(ConstantPersistence.PRODUCT_STATE, String.valueOf(owner.getProduct().getState()));
				assignProductToOrder.add(ConstantPersistence.OWNER, ownerObject);
				assignProductToOrder.add(ConstantPersistence.PRODUCT, productsObjetc);
				assignationsOwnerProduct.add(assignProductToOrder);
			}
		BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
		bufferedWriter.write(assignationsOwnerProduct.toString());
		bufferedWriter.close();
	}
	
	public void fileWriteAssignProductToOrder(ArrayList<AssignProductToOrder> assignProductToOrderList) throws IOException{
//		File  fileFolder = new File(System.getProperty("user.dir")+"\\"+"Report");
		File   file=new File("src/data/assignProductToOrder.json");
//		fileFolder.mkdirs();
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, true));
		JsonArray restaurantObject = new JsonArray();
		for (AssignProductToOrder assignProductToOrder : assignProductToOrderList) {
			JsonObject assignProductToOrderWriter= new JsonObject();
			JsonObject orderObject = new JsonObject();
			orderObject.addProperty(ConstantPersistence.ID_ORDER, String.valueOf(assignProductToOrder.getOrder().getId()));
			orderObject.addProperty(ConstantPersistence.ORDER_STATE, String.valueOf(assignProductToOrder.getOrder().getState()));
			orderObject.addProperty(ConstantPersistence.ORDER_DIRECTION, assignProductToOrder.getOrder().getDirection());
			JsonObject productsObjetc = new JsonObject();
			orderObject.add(ConstantPersistence.PRODUCT, productsObjetc);
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_NAME, assignProductToOrder.getProduct().getName());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_DESCRIPTION, assignProductToOrder.getProduct().getDescription());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_PRICE, assignProductToOrder.getProduct().getPrice());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_IMAGE, assignProductToOrder.getProduct().getImg());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_STATE, String.valueOf(assignProductToOrder.getProduct().getState()));
			
			assignProductToOrderWriter.add(ConstantPersistence.PRODUCT, productsObjetc);
			assignProductToOrderWriter.add(ConstantPersistence.ORDER, orderObject);
			restaurantObject.add(assignProductToOrderWriter);
		}
		BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
		bufferedWriter.write(restaurantObject.toString());
		bufferedWriter.close();
	}
	
	public void fileWritetAssignOrderToUser(ArrayList<AssignOrderToUser> assignOrderToUserList) throws IOException{
//		File  fileFolder = new File(System.getProperty("user.dir")+"\\"+"Report");
		File   file=new File("src/data/AssignOrderToUser.json");
//		fileFolder.mkdirs();
		System.out.println(file);
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, false));
		JsonArray assignOrderToUserListWriter = new JsonArray();
		
		for (AssignOrderToUser assignOrderToUser : assignOrderToUserList) {
			JsonObject assignOrderToUserWriter = new JsonObject();
			JsonObject userObject = new JsonObject();
			userObject.addProperty(ConstantPersistence.USER_NAME, assignOrderToUser.getUser().getName());
			userObject.addProperty(ConstantPersistence.USER_PASSWORD, assignOrderToUser.getUser().getPassword());
			userObject.addProperty(ConstantPersistence.USER_STATE, assignOrderToUser.getUser().isState());
			JsonObject orderObjetc = new JsonObject();
			orderObjetc.addProperty(ConstantPersistence.ID_ORDER, String.valueOf(assignOrderToUser.getOrder().getId()));
			orderObjetc.addProperty(ConstantPersistence.ORDER_STATE, String.valueOf(assignOrderToUser.getOrder().getState()));
			orderObjetc.addProperty(ConstantPersistence.ORDER_DIRECTION, assignOrderToUser.getOrder().getDirection());
			assignOrderToUserWriter.add(ConstantPersistence.USER, userObject);
			assignOrderToUserWriter.add(ConstantPersistence.ORDER,orderObjetc);
			assignOrderToUserListWriter.add(assignOrderToUserWriter);
		}
		BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
		bufferedWriter.write(assignOrderToUserListWriter.toString());
		bufferedWriter.close();
	}
	
	public void saveOwner(ArrayList<Owner> ownerList) throws IOException {
		
		File   file=new File("src/data/owners.json");
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, false));
		BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
		JsonArray ownerWriter = new JsonArray();
		for (Owner owner : ownerList) {
			
		Gson gson = new Gson();
		JsonObject ownerObject = new JsonObject();
		ownerObject.add(ConstantPersistence.OWNER, gson.toJsonTree(owner));
		ownerWriter.add(ownerObject);
		
		}
		bufferedWriter.write(ownerWriter.toString());
		bufferedWriter.close();
	}
	
	public void saveUser(ArrayList<User> userList) throws IOException {
		
		File   file=new File("src/data/users.json");
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, false));
		JsonArray users = new JsonArray();
		for (User user : userList) {
		JsonObject userObject = new JsonObject();
		Gson gson = new Gson();
		JsonObject userWriter = new JsonObject();
		userWriter.add(ConstantPersistence.USER, gson.toJsonTree(user));
		users.add(userWriter);
		
		}
		BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
		bufferedWriter.write(users.toString());
		bufferedWriter.close();
	}
	
	public static void main(String[] args) {
		OwnerManager ownerManager = new OwnerManager();
		OrderManager orderManager = new OrderManager();
		UserManager userManager = new UserManager();
		ProductManager productManager = new ProductManager();
		ownerManager .addOwner(OwnerManager.createOwner("Mc Donalds", "s", "src/image/mcDonalds.jpg"));
		ownerManager.addOwner(OwnerManager.createOwner("El Pirata", "z", "src/image/ElPirata.jpg"));
		ownerManager.addOwner(OwnerManager.createOwner("Al Toque", "z", "src/image/AlToque.png"));
//		userManager.addUser(UserManager.createUser("Juan", "X", null, true));
//		userManager.addAssignOrderToUser(userManager.createAssignOrder(new Order(01, " ghh"), new User("love", "13", null, true)));
		productManager.addProduct(ProductManager.createProduct("Hamburguesa Dijon", "deliciosa", 3000, State.RECEIVED,
				"src/image/HamburguerProduct.png"));
		productManager.addProduct(
				ProductManager.createProduct("Gaseosa Manzana", "deliciosa", 3000, State.RECEIVED, "src/image/BebidaProducto.png"));
		productManager.addProduct(
				ProductManager.createProduct("Gaseosa Manzana", "deliciosa", 3000, State.RECEIVED, "src/image/BebidaProducto.png"));
		productManager.addProduct(ProductManager.createProduct("Hamburguesa Dijon", "deliciosa", 3000, State.RECEIVED,
				"src/image/HamburguerProduct.png"));
		try {
			ownerManager.addAssignProductoToOwner(ownerManager
					.createAssignProductoToOwner(productManager.searchProductById(0), ownerManager.searchOwner(1)));
			ownerManager.addAssignProductoToOwner(ownerManager
					.createAssignProductoToOwner(productManager.searchProductById(1), ownerManager.searchOwner(1)));
			ownerManager.addAssignProductoToOwner(ownerManager
					.createAssignProductoToOwner(productManager.searchProductById(2), ownerManager.searchOwner(1)));
			ownerManager.addAssignProductoToOwner(ownerManager
					.createAssignProductoToOwner(productManager.searchProductById(3), ownerManager.searchOwner(1)));
		
		} catch (ExceptionSearchId e) {
			e.printStackTrace();
		}
		orderManager.addAssignProductoToOrder(new AssignProductToOrder(new Order(01, "fvhgh"), ProductManager.createProduct("Gaseosa Manzana", "deliciosa", 3000, State.RECEIVED, "src/image/BebidaProducto.png")));
		orderManager.addAssignProductoToOrder(new AssignProductToOrder(new Order(01, "fvhgh"), ProductManager.createProduct("Gaseosa Manzana", "deliciosa", 3000, State.RECEIVED, "src/image/BebidaProducto.png")));
		orderManager.addAssignProductoToOrder(new AssignProductToOrder(new Order(01, "fvhgh"), ProductManager.createProduct("Gaseosa Manzana", "deliciosa", 3000, State.RECEIVED, "src/image/BebidaProducto.png")));
		FileWrite fileWrite = new FileWrite();
		try {
			fileWrite.fileWritetAssignOrderToUser(userManager.getAssingOrderToUser());
//			fileWrite.fileWriteAssignProductToOrder(orderManager.getProductsOfTheOrder());
			fileWrite.fileWriteAssignProductToOwnerOwner(ownerManager.getAssignProductList());
//			fileWrite.saveUser(userManager.getUsers());
			fileWrite.saveOwner(ownerManager.getOwnerList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}