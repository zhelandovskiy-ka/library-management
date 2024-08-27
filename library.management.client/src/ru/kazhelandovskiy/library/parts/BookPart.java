package ru.kazhelandovskiy.library.parts;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import jakarta.annotation.PostConstruct;
import ru.kazhelandovskiy.library.model.Book;
import ru.kazhelandovskiy.library.service.ApiService;

public class BookPart {
	private Table table;

	@PostConstruct
	public void createComposite(Composite parent) {
		ApiService bookService = new ApiService();
		
        table = new Table(parent, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
        table.setLinesVisible(true);
        table.setHeaderVisible(true);

        String[] titles = { "ID", "Title", "Author", "Year", "Page count" };
        for (String title : titles) {
            TableColumn column = new TableColumn(table, SWT.NONE);
            column.setText(title);
        }

        try {
            List<Book> books = bookService.getBooks();

            for (Book book : books) {
                TableItem item = new TableItem(table, SWT.NONE);
                item.setText(new String[]{
                		book.getId().toString(), 
                		book.getTitle(), 
                		book.getAuthor(), 
                		String.valueOf(book.getYear()), 
                		String.valueOf(book.getPageCount())
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