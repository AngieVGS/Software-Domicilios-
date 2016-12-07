package persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import model.entity.AssignOrderToUser;
import model.entity.AssignProductToOrder;
import model.entity.AssignProductToOwner;
import model.entity.Order;
import model.entity.Owner;
import model.entity.Product;
import model.entity.State;
import model.entity.User;

public class FileRead {

	private ArrayList<AssignProductToOrder> readAssignProductToOrder() throws IOException {
		ArrayList<AssignProductToOrder> assignProductToOrder = new ArrayList<>();
		InputStream in = getClass().getResourceAsStream("C:/data/owner.json"); 
		 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		JsonArray owners = gson.fromJson(bufferedReader, JsonArray.class);
		for (JsonElement jsonElement : owners) {
			assignProductToOrder.add(new AssignProductToOrder(
					readOrder(jsonElement.getAsJsonObject().get(ConstantPersistence.ORDER).getAsJsonObject()),
					readProduct(jsonElement.getAsJsonObject().get(ConstantPersistence.PRODUCT).getAsJsonObject())));
		}
		bufferedReader.close();
		return assignProductToOrder;
	}

	private ArrayList<AssignOrderToUser> readAssignOrderToUser() throws IOException {
		ArrayList<AssignOrderToUser> assignOrderToUser = new ArrayList<>();
		InputStream in = getClass().getResourceAsStream("C:/data/owner.json"); 
		 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		JsonArray owners = gson.fromJson(bufferedReader, JsonArray.class);
		for (JsonElement jsonElement : owners) {
			assignOrderToUser.add(new AssignOrderToUser(
					readOrder(jsonElement.getAsJsonObject().get(ConstantPersistence.ORDER).getAsJsonObject()),
					readUser(jsonElement.getAsJsonObject().get(ConstantPersistence.USER).getAsJsonObject())));
		}
		bufferedReader.close();
		return assignOrderToUser;
	}

	
	
	public ArrayList<AssignProductToOwner> readAssignProductToOwner() throws IOException {
		ArrayList<AssignProductToOwner> assignProductToOwnerList = new ArrayList<>();
		InputStream in = getClass().getResourceAsStream("C:/data/owner.json"); 
		 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		JsonArray owners = gson.fromJson(bufferedReader, JsonArray.class);
		for (JsonElement jsonElement : owners) {
			assignProductToOwnerList.add(new AssignProductToOwner(
					readProduct(jsonElement.getAsJsonObject().get(ConstantPersistence.PRODUCT).getAsJsonObject()),
					readOwner(jsonElement.getAsJsonObject().get(ConstantPersistence.OWNER).getAsJsonObject())));
		}
		bufferedReader.close();
		return assignProductToOwnerList;
	}

	private Product readProduct(JsonObject product) {
		return new Product(product.getAsJsonObject().get(ConstantPersistence.PRODUCT_NAME).getAsString(),
				product.getAsJsonObject().get(ConstantPersistence.PRODUCT_DESCRIPTION).getAsString(),
				product.getAsJsonObject().get(ConstantPersistence.PRODUCT_PRICE).getAsDouble(),
				State.valueOf(product.getAsJsonObject().get(ConstantPersistence.PRODUCT_STATE).getAsString()),
				product.getAsJsonObject().get(ConstantPersistence.PRODUCT_IMAGE).getAsString());
	}
	
	private Order readOrder(JsonObject order) {
		return new Order(order.getAsJsonObject().get(ConstantPersistence.ID_ORDER).getAsInt(),
				order.getAsJsonObject().get(ConstantPersistence.ORDER_DIRECTION).getAsString());
	}
	
	private User readUser(JsonObject user) {
		return new User(user.getAsJsonObject().get(ConstantPersistence.USER_NAME).getAsString(),
				user.getAsJsonObject().get(ConstantPersistence.USER_PASSWORD).getAsString(),null,
				user.getAsJsonObject().get(ConstantPersistence.USER_STATE).getAsBoolean());
	}

	private Owner readOwner(JsonObject owner) {
		return new Owner(owner.getAsJsonObject().get(ConstantPersistence.OWNER_NAME).getAsString(),
				owner.getAsJsonObject().get(ConstantPersistence.OWNER_PASSWORD).getAsString(),
				owner.getAsJsonObject().get(ConstantPersistence.OWNER_IMAGE).getAsString());
	}

	public static void main(String[] args) {
		FileRead fileRead = new FileRead();
		try {
			System.out.println(fileRead.readAssignProductToOwner().toString());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}