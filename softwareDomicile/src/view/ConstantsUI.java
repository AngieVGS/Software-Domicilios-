package view;

import java.awt.Color;
import java.text.NumberFormat;

import javax.swing.text.NumberFormatter;

public class ConstantsUI {
	
	public static final String EMPTY_STRING = "";
	public static final Color BACKGROUND_COLOR = Color.decode("#ff9900");
	public static final Color BACKGROUND_COLOR_BUTTON = Color.decode("#FF8100");
	public static final Color BACKGROUND_COLOR_TEXTFILE = Color.decode("#F2F2F2");
	
	public static final String TIITLE = "Order Manager v1";
	
	public static final String TEXT_NAME = "Names:";
	public static final String TEXT_PRICE = "Price:";
	public static final String TEXT_ADD_OR_DROP_IMAGE = "Add or drop image";
	public static final String TEXT_TITLE_ADD_PRUDUCT_PRODUCT = "Add product";
	public static final String TEXT_ADD_PRODUCT = "Add product";
	
	//imagen
	public static final String IMAGE_DEFAULT = "src/image/ImageDefault.png";
	public static final Color FOREGROUND_LOGIN = Color.decode("#ff9900");
	
	public static final NumberFormatter getIntegerFormatter(){
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		return formatter;
	}
}