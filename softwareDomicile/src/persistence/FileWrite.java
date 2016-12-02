package persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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
		JsonArray productArray = new JsonArray();
//		restaurantObject.add(ConstantPersistence.RESTAURANT_NAME, gson.toJsonTree(ownerList));
		for (AssignProductToOwner owner : ownerList) {
//			JsonObject createOwnerObject = new JsonObject();
			ownerObject.addProperty(ConstantPersistence.RESTAURANT_NAME, owner.getOwner().getName());
			ownerObject.addProperty(ConstantPersistence.RESTAURANT_PASSWORD, owner.getOwner().getPassword());
			ownerObject.addProperty(ConstantPersistence.RESTAURANT_IMAGE, owner.getOwner().getUrl());
			ownerObject.add(ConstantPersistence.RESTAURANT_PRODUCT_LIST, productArray);
			JsonObject productsObjetc = new JsonObject();
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_NAME, owner.getProduct().getName());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_DESCRIPTION, owner.getProduct().getDescription());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_PRICE, owner.getProduct().getPrice());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_IMAGE, owner.getProduct().getImg());
			productsObjetc.addProperty(ConstantPersistence.PRODUCT_STATE, String.valueOf(owner.getProduct().getState()));
			
			productArray.add(productsObjetc);
		}

//		FileWriter fileWriter = new FileWriter(archivo);
		BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
		bufferedWriter.write(restaurantObject.toString());
		bufferedWriter.close();
	}

}
