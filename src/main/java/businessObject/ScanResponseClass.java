package businessObject;

import java.util.List;

import dataObject.ContentItem;

public class ScanResponseClass {
	List<ContentItem> items;

	public List<ContentItem> getItems() {
		return items;
	}

	public void setItems(List<ContentItem> items) {
		this.items = items;
	}

	public ScanResponseClass(List<ContentItem> items) {
		this.items = items;
	}
}
