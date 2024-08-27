package ru.kazhelandovskiy.library.parts;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import jakarta.annotation.PostConstruct;
import ru.kazhelandovskiy.library.model.User;
import ru.kazhelandovskiy.library.service.ApiService;

public class UserPart {
	private Table table;

	@PostConstruct
	public void createComposite(Composite parent) {
		System.out.println("createComposite samplePArt");

		ApiService apiService = new ApiService();
		
        table = new Table(parent, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
        table.setLinesVisible(true);
        table.setHeaderVisible(true);

        String[] titles = { "ID", "Name", "Gender", "Age"};
        for (String title : titles) {
            TableColumn column = new TableColumn(table, SWT.NONE);
            column.setText(title);
        }

        try {
            List<User> users = apiService.getUsers();

            for (User user : users) {
                TableItem item = new TableItem(table, SWT.NONE);
                item.setText(new String[]{user.getId().toString(), user.getName(), user.getGender(), String.valueOf(user.getAge())});
            }

            for (TableColumn column : table.getColumns()) {
                column.pack();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}