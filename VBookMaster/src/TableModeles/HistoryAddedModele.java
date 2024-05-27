package TableModeles;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import metier.Member;
import metierHistory.History;

public class HistoryAddedModele extends AbstractTableModel{
	
	private List<History>member=new ArrayList<>();
	private String[] titles= {"id","BookID","CIN","Category","CoverPath"};

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return member.size();
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
		case 0:return member.get(l).getId();
		case 1:return member.get(l).getBookID();
		case 2:return member.get(l).getCin();
		case 3:return member.get(l).getCategory();
		case 4:return member.get(l).getCoverPath();		
		}
		return null;
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return titles[column];
	}
	
	public void charger(List<History>l)
	{
		this.member=l;
		fireTableDataChanged();
	}

}
