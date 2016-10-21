package businessObject;

import java.util.List;

import dataObject.AddressItem;

public class ScanResponseClass {
	List<AddressItem> items;

	public List<AddressItem> getItems() {
		return items;
	}

	public void setItems(List<AddressItem> items) {
		this.items = items;
	}

	public ScanResponseClass(List<AddressItem> items) {
		this.items = items;
	}
}
