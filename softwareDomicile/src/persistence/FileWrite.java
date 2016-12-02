package persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import model.entity.AssignOrderToUser;
import model.entity.AssignProductToOrder;
import model.entity.AssignProductToOwner;

public class FileWrite {
	
	public void fileWriteReportOwner(ArrayList<AssignProductToOwner> ownerList) throws IOException{

		File  fileFolder = new File(System.getProperty("user.dir")+"\\"+"Report");
		File   file=new File(fileFolder.getAbsolutePath()+"\\"+"owner.json");
		fileFolder.mkdirs();
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, false));
		JsonObject restaurantObject = new JsonObject();
		JsonObject ownerObject = new JsonObject();
		restaurantObject.add(ConstantPersistence.RESTAURANT_LISIT, ownerObject);
//		JsonArray productArray = new JsonArray();
//		restaurantObject.add(ConstantPersistence.RESTAURANT_NAME, gson.toJsonTree(ownerList));
		for (AssignProductToOwner owner : ownerList) {
//			JsonObject createOwnerObject = new JsonObject();
			ownerObject.addProperty(ConstantPersistence.RESTAURANT_NAME, owner.getOwner().getName());
			ownerObject.addProperty(ConstantPersistence.PASSWORD, owner.getOwner().getPassword());
			ownerObject.addProperty(ConstantPersistence.RESTAURANT_IMAGE, owner.getOwner().getUrl());
			JsonObject productsObjetc = new JsonObject();
			ownerObject.add(ConstantPersistence.PRODUCT_LIST, productsObjetc);
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_NAME, owner.getProduct().getName());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_DESCRIPTION, owner.getProduct().getDescription());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_PRICE, owner.getProduct().getPrice());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_IMAGE, owner.getProduct().getImg());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_STATE, String.valueOf(owner.getProduct().getState()));
			
//			productArray.add(productsObjetc);
		}

//		FileWriter fileWriter = new FileWriter(archivo);
		BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
		bufferedWriter.write(restaurantObject.toString());
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
//		JsonArray productArray = new JsonArray();
//		restaurantObject.add(ConstantPersistence.RESTAURANT_NAME, gson.toJsonTree(ownerList));
		for (AssignProductToOrder assignProductToOrder : assignProductToOrderList) {
//			JsonObject createOwnerObject = new JsonObject();
			orderObject.addProperty(ConstantPersistence.ORDER_STATE, String.valueOf(assignProductToOrder.getOrder().getState()));
			orderObject.addProperty(ConstantPersistence.ORDER_DIRECTION, assignProductToOrder.getOrder().getDirection());
			JsonObject productsObjetc = new JsonObject();
			orderObject.add(ConstantPersistence.PRODUCT_LIST, productsObjetc);
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_NAME, assignProductToOrder.getProduct().getName());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_DESCRIPTION, assignProductToOrder.getProduct().getDescription());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_PRICE, assignProductToOrder.getProduct().getPrice());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_IMAGE, assignProductToOrder.getProduct().getImg());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_STATE, String.valueOf(assignProductToOrder.getProduct().getState()));
			
//			productArray.add(productsObjetc);
		}

//		FileWriter fileWriter = new FileWriter(archivo);
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
//		JsonArray orderArray = new JsonArray();
//		restaurantObject.add(ConstantPersistence.RESTAURANT_NAME, gson.toJsonTree(ownerList));
		for (AssignOrderToUser assignOrderToUser : assignOrderToUserList) {
//			JsonObject createOwnerObject = new JsonObject();
			userObject.addProperty(ConstantPersistence.USER_NAME, assignOrderToUser.getUser().getName());
			userObject.addProperty(ConstantPersistence.PASSWORD, assignOrderToUser.getUser().getPassword());
			userObject.addProperty(ConstantPersistence.USER_STATE, assignOrderToUser.getUser().isState());
			JsonObject orderObjetc = new JsonObject();
			userObject.add(ConstantPersistence.ORDER_LIST, orderObjetc);
			orderObjetc.addProperty(ConstantPersistence.ORDER_STATE, String.valueOf(assignOrderToUser.getOrder().getState()));
			orderObjetc.addProperty(ConstantPersistence.ORDER_DIRECTION, assignOrderToUser.getOrder().getDirection());
//			orderObjetc.add(ConstantPersistence.ORDER_LIST, orderObjetc);
			
//			orderArray.add(orderArray);
		}

//		FileWriter fileWriter = new FileWriter(archivo);
		BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
		bufferedWriter.write(restaurantObject.toString());
		bufferedWriter.close();
	}
}
