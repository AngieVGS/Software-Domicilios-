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
import model.dao.OwnerManager;
import model.dao.ProductManager;
import model.dao.UserManager;
import model.entity.AssignOrderToUser;
import model.entity.AssignProductToOrder;
import model.entity.AssignProductToOwner;
import model.entity.Owner;
import model.entity.State;
import model.entity.User;

public class FileWrite {
	
	public void fileWriteReportOwner(ArrayList<AssignProductToOwner> ownerList) throws IOException{
		File  fileFolder = new File("/data");
		File   file=new File(fileFolder.getAbsolutePath()+"\\"+"owner.json");
		fileFolder.mkdirs();
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
	
	public void fileWriteReportOrder(ArrayList<AssignProductToOrder> assignProductToOrderList) throws IOException{
		File  fileFolder = new File(System.getProperty("user.dir")+"\\"+"Report");
		File   file=new File(fileFolder.getAbsolutePath()+"\\"+"order.json");
		fileFolder.mkdirs();
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, false));
		JsonObject restaurantObject = new JsonObject();
		JsonObject orderObject = new JsonObject();
		restaurantObject.add(ConstantPersistence.ORDER_LIST, orderObject);
		for (AssignProductToOrder assignProductToOrder : assignProductToOrderList) {
			orderObject.addProperty(ConstantPersistence.ORDER_STATE, String.valueOf(assignProductToOrder.getOrder().getState()));
			orderObject.addProperty(ConstantPersistence.ORDER_DIRECTION, assignProductToOrder.getOrder().getDirection());
			JsonObject productsObjetc = new JsonObject();
			orderObject.add(ConstantPersistence.PRODUCT, productsObjetc);
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_NAME, assignProductToOrder.getProduct().getName());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_DESCRIPTION, assignProductToOrder.getProduct().getDescription());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_PRICE, assignProductToOrder.getProduct().getPrice());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_IMAGE, assignProductToOrder.getProduct().getImg());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_STATE, String.valueOf(assignProductToOrder.getProduct().getState()));
		}
		BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
		bufferedWriter.write(restaurantObject.toString());
		bufferedWriter.close();
	}
	
	public void fileWriteReportUser(ArrayList<AssignOrderToUser> assignOrderToUserList) throws IOException{
		File  fileFolder = new File(System.getProperty("user.dir")+"\\"+"Report");
		File   file=new File(fileFolder.getAbsolutePath()+"\\"+"user.json");
		fileFolder.mkdirs();
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, false));
		JsonObject restaurantObject = new JsonObject();
		JsonObject userObject = new JsonObject();
		restaurantObject.add(ConstantPersistence.USER, userObject);
		for (AssignOrderToUser assignOrderToUser : assignOrderToUserList) {
			userObject.addProperty(ConstantPersistence.USER_NAME, assignOrderToUser.getUser().getName());
			userObject.addProperty(ConstantPersistence.USER_PASSWORD, assignOrderToUser.getUser().getPassword());
			userObject.addProperty(ConstantPersistence.USER_STATE, assignOrderToUser.getUser().isState());
			JsonObject orderObjetc = new JsonObject();
			userObject.add(ConstantPersistence.ORDER_LIST, orderObjetc);
			orderObjetc.addProperty(ConstantPersistence.ORDER_STATE, String.valueOf(assignOrderToUser.getOrder().getState()));
			orderObjetc.addProperty(ConstantPersistence.ORDER_DIRECTION, assignOrderToUser.getOrder().getDirection());
		}
		BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
		bufferedWriter.write(restaurantObject.toString());
		bufferedWriter.close();
	}
	
	public void saveOwner(ArrayList<Owner> ownerList) throws IOException {
		
		File  fileFolder = new File(System.getProperty("user.dir")+"\\"+"Report");
		File   file=new File(fileFolder.getAbsolutePath()+"\\"+"ownerList.json");
		fileFolder.mkdirs();
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, false));
		BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
		for (Owner owner : ownerList) {
			
		Gson gson = new Gson();
		JsonObject ownerObject = new JsonObject();
		ownerObject.add(ConstantPersistence.OWNER, gson.toJsonTree(owner));
		bufferedWriter.write(ownerObject.toString());
		}
		bufferedWriter.close();
	}
	
	public void saveUser(ArrayList<User> userList) throws IOException {
		
		File  fileFolder = new File(System.getProperty("user.dir")+"\\"+"Report");
		File   file=new File(fileFolder.getAbsolutePath()+"\\"+"userList.json");
		fileFolder.mkdirs();
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, false));
		BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
		for (User user : userList) {
		Gson gson = new Gson();
		JsonObject userObject = new JsonObject();
		userObject.add(ConstantPersistence.USER, gson.toJsonTree(user));
		bufferedWriter.write(userObject.toString());
		}
		bufferedWriter.close();
	}
}