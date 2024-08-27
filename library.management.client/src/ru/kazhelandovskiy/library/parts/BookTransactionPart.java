package ru.kazhelandovskiy.library.parts;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import jakarta.annotation.PostConstruct;
import ru.kazhelandovskiy.library.model.BookTransaction;
import ru.kazhelandovskiy.library.service.ApiService;

public class BookTransactionPart {
	private Table table;

	@PostConstruct
	public void createComposite(Composite parent) {

		ApiService apiService = new ApiService();
		
        table = new Table(parent, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
        table.setLinesVisible(true);
        table.setHeaderVisible(true);

        String[] titles = { "ID", "Book Id", "Author", "Title", "User Id", "Name"};
        for (String title : titles) {
            TableColumn column = new TableColumn(table, SWT.NONE);
            column.setText(title);
        }

        try {
            List<BookTransaction> bookTransactions = apiService.getBookTransactions();

            for (BookTransaction bookTransaction : bookTransactions) {
                TableItem item = new TableItem(table, SWT.NONE);
                item.setText(new String[]{
                		bookTransaction.getId().toString(), 
                		bookTransaction.getBook().getId().toString(), 
                		bookTransaction.getBook().getAuthor(), 
                		bookTransaction.getBook().getTitle(),
                		bookTransaction.getUser().getId().toString(),
                		bookTransaction.getUser().getName()
                		});
            }

            for (TableColumn column : table.getColumns()) {
                column.pack();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}