package view;

import java.awt.Color;
import java.awt.Dimension;
import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;

public class ConstantsUI {

	public static final String EMPTY_STRING = "";
	public static final Color BACKGROUND_COLOR = Color.decode("#ff9900");
	public static final Color BACKGROUND_COLOR_BUTTON = Color.decode("#FF7100");
	public static final Color BACKGROUND_COLOR_BUTTON_GENERATE_ORDER = Color.decode("#6b4128");

	public static final Color BACKGROUND_COLOR_TEXTFILE = Color.decode("#F2F2F2");
	public static final Color BACKGROUND_COLOR_TOOLBAR_RESTAURANT = Color.decode("#fca919");
	public static final Color BACKGROUND_COLOR_TOOLBAR_RESTAURANT_BUTTONS = Color.decode("#DB9213");
	public static final Color FOREGROUND_LOGIN = Color.decode("#ff9900");
	public static final Color FOREGROUND_NAME_PRODUCT_SHOW_PRODUCT = Color.black;
	public static final Color FOREGROUND_NAME_OWNER_SHOW_PRODUCT = Color.decode("#F28B15");
	public static final Color FOREGROUND_PRICE_SHOW_PRODUCT = Color.decode("#FF0000");
	public static final Color BACKGROUND_COLOR_INVALID_PASSWORD = Color.decode("#FA5858");
	public static final Color BACKGROUND_COLOR_SHOW_PRODUCT_LIST = Color.decode("#fcece8");

	public static final String TIITLE = "Order Manager v1";

	public static final String TEXT_NAME = "Names:";
	public static final String TEXT_PRICE = "Price:";
	public static final String TEXT_ADD_OR_DROP_IMAGE = "Add or drop image";
	public static final String TEXT_TITLE_ADD_PRUDUCT_PRODUCT = "Add product";
	public static final String TEXT_ADD_PRODUCT = "Add product";

	// imagen
	public static final String IMAGE_DEFAULT = "src/image/ImageDefault.png";
	public static final String IMAGE_USER = "src/image/UserIcon.JPG";
	public static final String IMAGE_PASSWORD = "src/image/password.JPG";
	public static final String IMAGE_PHONE = "src/image/Phone.JPG";
	public static final String IMAGE_JOIN = "src/image/Buttons/Joinbutton.png";

	// Font
	public static final String FONT_ARIAL = "Arial";
	public static final String FONT_ARIAL_NARROW = "Arial Narrow";
	public static final String FONT_BUTTON_CREATE_PRODUCT = "Franklin Gothic Heavy";
	public static final int SIZE_FONT = 15;

	// dates
	public static final String TITLE_CREATE_ACCOUNT = "CREATE ACCOUNT";
	public static final String TITLE_CREATE_PRODUCT = "CREATE PRODUCT";
	public static final String TITLE_EDIT_PRODUCT = "EDIT PRODUCT";

	public static final String RESTAURANT_NAME = "Restaurant Name";
	public static final String PASSWORD = "Password";
	public static final String PHONE_NUMBER = "Phone";

	public static final String USER_NAME = "User Name";

	public static final String PRODUCT_NAME = "Product Name";
	public static final String DESCRIPTION_PRODUCT = "Product description...";
	public static final String BUTTON_CREATE_PRODUCT = "Create Product";
	public static final String BUTTON_EDIT_PRODUCT = "Edit Product";

	public static final Dimension SIZE_WINDOW = new Dimension(410, 720);

	public static final NumberFormatter getIntegerFormatter() {
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		return formatter;
	}
}