package com.github.taixiongliu.jweb.opts;

import java.util.List;

import com.github.taixiongliu.jweb.base.JSArray;
import com.github.taixiongliu.jweb.base.JSObject;

public class MenuListOpts implements EntityOpts{
	private String icon;
	private String title;
	private List<MenuNode> children;
	private boolean expend;
	@Override
	public JSObject toJSObject() {
		// TODO Auto-generated method stub
		JSObject jo = new JSObject();
		if(icon != null){
			jo.putProperty("icon", icon);
		}
		if(title != null){
			jo.putProperty("title", title);
		}
		if(children != null && !children.isEmpty()){
			JSArray array = new JSArray();
			for(MenuNode node : children){
				if(node == null){
					continue;
				}
				JSObject temp = new JSObject();
				temp.putProperty("id", node.getId());
				temp.putProperty("selected", node.isSelected());
				if(node.getIcon() != null){
					temp.putProperty("icon", node.getIcon());
				}
				if(node.getText() != null){
					temp.putProperty("text", node.getText());
				}
				array.addProperty(temp);
			}
			jo.putProperty("children", array);
		}
		jo.putProperty("expend", expend);
		return jo;
	}
	
	public class MenuNode{
		private int id;
		private String text;
		private String icon;
		private boolean selected;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public boolean isSelected() {
			return selected;
		}
		public void setSelected(boolean selected) {
			this.selected = selected;
		}
	}
}
