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

import model.entity.AssignProductToOwner;
import model.entity.Owner;
import model.entity.Product;
import model.entity.State;
import model.entity.User;

public class FileRead {

	private ArrayList<User> readUsers() {
		return null;
	}

	public ArrayList<AssignProductToOwner> readAssignProductToOwner() throws IOException {
		ArrayList<AssignProductToOwner> assignProductToOwnerList = new ArrayList<>();
		InputStream in = getClass().getResourceAsStream("/data/owner.json"); 
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

	private Owner readOwner(JsonObject owner) {
		return new Owner(owner.getAsJsonObject().get(ConstantPersistence.OWNER_NAME).getAsString(),
				owner.getAsJsonObject().get(ConstantPersistence.OWNER_PASSWORD).getAsString(),
				owner.getAsJsonObject().get(ConstantPersistence.OWNER_IMAGE).getAsString());
	}

//	public static void main(String[] args) {
//		FileRead fileRead = new FileRead();
//		try {
//			System.out.println(fileRead.readAssignProductToOwner().toString());
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//	}
}