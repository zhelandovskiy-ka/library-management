package ru.kazhelandovskiy.library.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import ru.kazhelandovskiy.library.service.ApiService;

public class DeleteHandler {

	@Execute
	public void delete(MPart part) {
		Table table = getTableFromPart(part);
		if (table != null) {
			int selectedIndex = table.getSelectionIndex();
			if (selectedIndex != -1) {
				TableItem selectedItem = table.getItem(selectedIndex);
				String idValue = getColumnValue(selectedItem, "ID");

				ApiService apiService = new ApiService();
				String label = part.getLabel();

				switch (label) {
				case "Users": {
					apiService.deleteUser(Long.parseLong(idValue));
					break;
				}
				case "Books": {
					apiService.deleteBook(Long.parseLong(idValue));
					break;
				}
				case "Book Transaction": {
					apiService.deleteBookTransaction(Long.parseLong(idValue));
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + label);
				}
				table.remove(selectedIndex);
			}
		}
	}

	private Table getTableFromPart(MPart part) {
		Object partContent = part.getWidget();
		if (partContent instanceof Composite) {
			Composite composite = (Composite) partContent;
			for (Control control : composite.getChildren()) {
				if (control instanceof Table) {
					return (Table) control;
				}
			}
		}
		return null;
	}

	private String getColumnValue(TableItem item, String columnName) {
		Table table = item.getParent();
		int columnIndex = -1;
		for (int i = 0; i < table.getColumnCount(); i++) {
			TableColumn column = table.getColumn(i);
			if (columnName.equals(column.getText())) {
				columnIndex = i;
				break;
			}
		}

		if (columnIndex != -1) {
			return item.getText(columnIndex);
		}
		return null;
	}
}
