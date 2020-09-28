package com.github.taixiongliu.jweb.handler;

import java.util.List;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSArray;
import com.github.taixiongliu.jweb.base.JSObject;

public abstract class ListGridHandler {
	public abstract List<Field> getFields();
	public abstract List<Menu> getMenus();
	
	private boolean checkbox;
	public ListGridHandler(boolean checkbox) {
		// TODO Auto-generated constructor stub
		this.checkbox = checkbox;
	}
	public ListGridHandler() {
		// TODO Auto-generated constructor stub
		this(false);
	}
	
	public JSObject toJSObject(){
		JSObject jo = new JSObject();
		if(checkbox){
			jo.putProperty("selectOpr", new Expression("{}"));
		}
		//字段封装
		List<Field> fields = getFields();
		if(fields != null && !fields.isEmpty()){
			JSArray jsArray = new JSArray();
			int dfwidth = 100/fields.size();
			for(Field field : fields){
				JSObject temp = new JSObject();
				temp.putProperty("fieldName", field.getFieldName());
				temp.putProperty("textName", field.getTextName());
				if(field.getFieldWidth() == null){
					temp.putProperty("fieldWidth", dfwidth+"%");
				}else{
					temp.putProperty("fieldWidth", field.getFieldWidth());
				}
				jsArray.addProperty(temp);
			}
			jo.putProperty("fields", jsArray);
		}
		//菜单封装
		List<Menu> menus = getMenus();
		if(menus != null && !menus.isEmpty()){
			JSArray jsArray = new JSArray();
			for(Menu menu : menus){
				JSObject temp = new JSObject();
				temp.putProperty("text", menu.getText());
				temp.putProperty("onclick", menu.getHandler());
				if(menu.getFormat() != null){
					temp.putProperty("format", menu.getFormat());
				}
				jsArray.addProperty(temp);
			}
			jo.putProperty("menus", jsArray);
		}
		return jo;
	}
	
	public class Menu{
		private String text;
		private ItemClickHandler handler;
		private ItemClickHandler format;
		public Menu(String text, ItemClickHandler handler) {
			// TODO Auto-generated constructor stub
			this.text = text;
			this.handler = handler;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public ItemClickHandler getHandler() {
			return handler;
		}
		public void setHandler(ItemClickHandler handler) {
			this.handler = handler;
		}
		public ItemClickHandler getFormat() {
			return format;
		}
		public void setFormat(ItemClickHandler format) {
			this.format = format;
		}
	}
	
	public class Field{
		private String fieldName;
		private String textName;
		private String fieldWidth;
		public Field(String fieldName, String textName) {
			// TODO Auto-generated constructor stub
			this.fieldName = fieldName;
			this.textName = textName;
		}
		public String getFieldName() {
			return fieldName;
		}
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}
		public String getTextName() {
			return textName;
		}
		public void setTextName(String textName) {
			this.textName = textName;
		}
		public String getFieldWidth() {
			return fieldWidth;
		}
		public void setFieldWidth(String fieldWidth) {
			this.fieldWidth = fieldWidth;
		}
	}
}
