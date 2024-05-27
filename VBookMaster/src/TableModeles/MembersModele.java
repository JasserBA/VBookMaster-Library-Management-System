package TableModeles;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import metier.Member;

public class MembersModele extends AbstractTableModel{
	
	private List<Member>member=new ArrayList<>();
	private String[] titles= {"id","CIN","Username","Birthday","Gender","MemberType","Password"};

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
		case 1:return member.get(l).getCIN();
		case 2:return member.get(l).getUsername();
		case 3:return member.get(l).getBirthday();
		case 4:return member.get(l).getGender();
		case 5:return member.get(l).getMemberType();
		case 6:return member.get(l).getPassword();
		}
		return null;
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return titles[column];
	}
	
	public void charger(List<Member>l)
	{
		this.member=l;
		fireTableDataChanged();
	}

}
