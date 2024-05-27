package TableModeles;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import metierBook.Book;

public class ReturnBooksModele extends AbstractTableModel{
	
	private List<Book>book=new ArrayList<>();
	private String[] titles= {"id","BookID","Title","Publisher","Category","CoverPath","PDFPath"};

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return book.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titles.length;
	}

	@Override
	public Object getValueAt(int l, int c) {

		switch(c)
		{
		
		case 0:return book.get(l).getId();
		case 1:return book.get(l).getBookID();
		case 2:return book.get(l).getTitle();
		case 3:return book.get(l).getPublisher();
		case 4:return book.get(l).getCategory();
		case 5:return book.get(l).getCoverPath();
		case 6:return book.get(l).getPDFPath();

		}
		return null;
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return titles[column];
	}
	
	public void charger(List<Book>l)
	{
		this.book=l;
		fireTableDataChanged();
	}
}
