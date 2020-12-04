import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class InventoryGUI implements ActionListener, ItemListener {
	static JButton B;
	static ActionListener AL = new InventoryGUI();
	static InventoryGUI IL = new InventoryGUI();
	static JFrame frm;
	static JFrame frm2;
	static JFrame frm3;
	static Container contentPane;
	static JTextField newCategory;
	static JTextField newName;
	static JTextField newPrice;
	static JTextField newId;
	static JTextField newQuantity;
	static JTextField searchBar;
	static JScrollPane scrollPane;
	static JLabel message = new JLabel("", JLabel.CENTER);
	static JLabel message2 = new JLabel("", JLabel.CENTER);
	static JScrollPane tmp;
	static item sort = new item();
	static item inventory = new item();
	static int searchID = 0;
	static int categoryNum = 0;
	static String[][] searchData = new String[1][5];
	static String[][] categoryData;
	static String[][] inventoryData = new String[inventory.getSize() + 1][5];
	static String[] columnName = {"Category", "Name", "Price", "ID", "Quantity"};
	static String[] category = new String[categoryNum];
	static String[] holder = new String[50];
	static JComboBox<String> viewCategory = new JComboBox<>(category);
	static JTable abtable;
	static node search = null;
	static boolean use = false;
	
	// creates the Inventory management start menu
	public static void Start(item arr)
	{
		//hold = 0;
	    //counter = 0;
		inventory = arr;
	    frm = new JFrame("Inventory Management");
		Container contentPane = frm.getContentPane();
		contentPane.setLayout(new BorderLayout());
	    contentPane.add(new JLabel("<html><font size=5><b>Use The Buttons below to Manage Contacts</b></html>",JLabel.CENTER) , BorderLayout.NORTH);
	    JPanel two = new JPanel(new GridLayout(2,2));
	    two.add(B = new JButton("Add To Inventory"));
	    B.addActionListener(AL);
	    two.add(B = new JButton("View Inventory"));
	    B.addActionListener(AL);
	    two.add(B = new JButton("Search to Edit/Delete"));
	    B.addActionListener(AL);
	    two.add(B = new JButton("Exit"));
	    B.addActionListener(AL);
	    contentPane.add(two, BorderLayout.SOUTH);
		frm.pack();
		frm.setSize(900,500);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);

	}
	//Creates the second window
	public static void createFrame()
	{
		frm.setVisible(false);
        frm2 = new JFrame("Inventory Management");
		contentPane = frm2.getContentPane();
		contentPane.setLayout(new BorderLayout());
		frm2.pack();
		frm2.setSize(900,500);
		frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm2.setVisible(true);
	}
	
	//Performs actions based on the buttons pushed
	public void actionPerformed(ActionEvent e)
	{
		String c = e.getActionCommand();
		switch(c)
		{
			case "Add To Inventory":
				createFrame();
				message.setText("");
				JPanel make = new JPanel(new GridLayout(5,2));
		        JPanel make2 = new JPanel(new GridLayout(2,1));
		        JPanel layout = new JPanel(new GridLayout(1,4));
		        make.add(new JLabel("Category",JLabel.RIGHT));
		        make.add(newCategory = new JTextField());
		        make.add(new JLabel("Name",JLabel.RIGHT));
		        make.add(newName = new JTextField());
		        make.add(new JLabel("Price",JLabel.RIGHT));
		        make.add(newPrice = new JTextField());
		        make.add(new JLabel("ID",JLabel.RIGHT));
		        make.add(newId = new JTextField());
		        make.add(new JLabel("Quantity",JLabel.RIGHT));
		        make.add(newQuantity = new JTextField());
		        contentPane.add(make,BorderLayout.CENTER);
		        layout.add(new JLabel());
		        layout.add(B = new JButton("Add"));
		        B.addActionListener(AL);
		        layout.add(B = new JButton("Top Menu"));
		        B.addActionListener(AL);
		        layout.add(new JLabel());
		        make2.add(message);
		        make2.add(layout);
		        contentPane.add(make2,BorderLayout.SOUTH);
		        break;
		         
			case "Add":
				int count = 0;
				double i = 0;
				int j = 0;
				int k = 0;
				String check;
				boolean priceError = false;
				boolean idError = false;
				boolean quantityError = false;
				try {
				      i = Double.parseDouble(newPrice.getText());
				    } catch (NumberFormatException f) {
				    	priceError = true;
				    	count++;
				    }
				try {
					  j = Integer.parseInt(newId.getText());
					} catch (NumberFormatException f) {
						idError = true;
					    count++;
				}
				try {
				      k = Integer.parseInt(newQuantity.getText());
					}catch (NumberFormatException f) {
						quantityError = true;
						count++;
					}
				check = newCategory.getText();
				if (check.isEmpty() == true)
				{
					//inventory.print();
				}
				if (count != 0)
				{
					checkError(priceError, idError, quantityError);
				}
				else if(inventory.searchIf(j) == true)
				{
					message.setText("Item with ID " + j + " already exists, please enter a different ID");
				}
				else
				{
					message.setText("Item with Category:" + newCategory.getText() + ", Name:" + newName.getText() + ", Price:" + i + ", ID: " + j + ", Quantity:" + k + " was added to Inventory");
					node add = new node(newCategory.getText(), newName.getText(), i, j, k);
					inventory.addItem(add);
					newCategory.setText("");
					newName.setText("");
					newPrice.setText("");
					newId.setText("");
					newQuantity.setText("");
				}
				break;
			
			case "Search to Edit/Delete":
				createFrame();
				contentPane.add(new JLabel("<html><font size=5><b>Search items from inventory and then edit or delete them(if necessary)</b></html>",JLabel.CENTER) , BorderLayout.NORTH);
		        scrollPane = new JScrollPane();
		        contentPane.add(scrollPane,BorderLayout.CENTER);
		        searchData = new String[1][5];
		        abtable = new JTable(searchData, columnName);
		        tmp = new JScrollPane(abtable);
		        scrollPane.setViewport(tmp.getViewport()); 
		        JPanel delete = new JPanel(new GridLayout(2,3));
		        delete.add(new JLabel("<html><font size=5><b>Please enter the item's ID</b></html>",JLabel.CENTER));
		        delete.add(searchBar = new JTextField());
		        delete.add(B = new JButton("Search"));
		        B.addActionListener(AL);
		        delete.add(B = new JButton("Delete"));
		        B.addActionListener(AL);
		        message.setText("");
		        delete.add(message);
		        delete.add(B = new JButton("Top Menu"));
		        B.addActionListener(AL);
		        contentPane.add(delete, BorderLayout.SOUTH);
		        JPanel makeChanges = new JPanel(new GridLayout(5,2));
		        JPanel editDescription = new JPanel(new GridLayout(2,1));
		        JPanel submitButton = new JPanel(new GridLayout(2,1));
		        JPanel makeChangesLayout = new JPanel(new BorderLayout());
		        editDescription.add(new JLabel("Edit items in the inventory here"));
		        editDescription.add(new JLabel("(Anything left blank is unedited)"));
		        makeChangesLayout.add(editDescription, BorderLayout.NORTH);
		        makeChanges.add(new JLabel("Category",JLabel.RIGHT));
		        makeChanges.add(newCategory = new JTextField());
		        makeChanges.add(new JLabel("Name",JLabel.RIGHT));
		        makeChanges.add(newName = new JTextField());
		        makeChanges.add(new JLabel("Price",JLabel.RIGHT));
		        makeChanges.add(newPrice = new JTextField());
		        makeChanges.add(new JLabel("ID",JLabel.RIGHT));
		        makeChanges.add(newId = new JTextField());
		        makeChanges.add(new JLabel("Quantity",JLabel.RIGHT));
		        makeChanges.add(newQuantity = new JTextField("", 8));
		        submitButton.add(message2);
		        submitButton.add(B = new JButton("Submit Changes"));
		        makeChangesLayout.add(submitButton, BorderLayout.SOUTH);
		        B.addActionListener(AL);
		        makeChangesLayout.add(makeChanges, BorderLayout.CENTER);
		        contentPane.add(makeChangesLayout, BorderLayout.WEST);
				break;
				
				
			case "Search":
				boolean error = false;
				use = true;
				searchID = 0;
				try {
				    	searchID = Integer.parseInt(searchBar.getText());
					}catch(NumberFormatException g){
						error = true;
					}
				if(error == true)
				{
					checkError(false, error, false);
				}
				else
				{
					if(inventory.searchIf(searchID) == true)
					search = inventory.search(searchID);
					else
					{
						search = null;
						searchData = new String[1][5];
						message.setText("Item with ID " + searchID + " does not exist");
					}
				}
				if(search != null)
				{
					searchData = new String[1][5];
					searchData[0][0] = search.getCategory();
					searchData[0][1] = search.getName();
					searchData[0][2] = "" + search.getPrice();
					searchData[0][3] = "" + search.getID();
					searchData[0][4] = "" + search.getQuantity();
					
				}
				abtable = new JTable(searchData, columnName);
		        tmp = new JScrollPane(abtable);
		        scrollPane.setViewport(tmp.getViewport());
				break;
				
			case "Delete":
				if(search != null && use == true)
				{
					searchData = new String[1][5];
					inventory.delete(searchID);
					abtable = new JTable(searchData, columnName);
			        tmp = new JScrollPane(abtable);
			        scrollPane.setViewport(tmp.getViewport());
			        use = false;
				}
				break;
				
			case "Submit Changes":
				if(search != null && use == true)
				{
					priceError = false;
					idError = false;
					quantityError = false;
					double adjustPrice = 0;
					int adjustID = 0;
					int adjustQuantity = 0;
					if(newCategory.getText().isBlank() == false)
					{
						search.setCategory(newCategory.getText());
					}
					if(newName.getText().isBlank() == false)
					{
						search.setName(newName.getText());
					}
					if(newPrice.getText().isBlank() == false)
					{
						try {
						adjustPrice = Double.parseDouble(newPrice.getText());;
						}catch(NumberFormatException f){
							priceError = true;
						}
						if(priceError == false)
						{
							search.setPrice(adjustPrice);
						}
					}
					if(newId.getText().isBlank() == false)
					{
						try {
							adjustID = Integer.parseInt(newId.getText());;
							}catch(NumberFormatException f){
								idError = true;
							}
						if(idError == false)
						{
							if(inventory.searchIf(adjustID) == true && adjustID != searchID)
								message2.setText("item with ID " + adjustID + " already exists");
							else
							{
								search.setID(adjustID);
								message2.setText("");
							}
						}
					}
					if(newQuantity.getText().isBlank() == false)
					{
						try {
						adjustQuantity = Integer.parseInt(newQuantity.getText());;
						}catch(NumberFormatException f){
							quantityError = true;
						}
						if(quantityError == false)
						{
							search.setQuantity(adjustQuantity);
						}
					}
					if(priceError == true || idError == true || quantityError == true)
					checkError(priceError, idError, quantityError);
					searchData = new String[1][5];
					searchData[0][0] = search.getCategory();
					searchData[0][1] = search.getName();
					searchData[0][2] = "" + search.getPrice();
					searchData[0][3] = "" + search.getID();
					searchData[0][4] = "" + search.getQuantity();
					abtable = new JTable(searchData, columnName);
			        tmp = new JScrollPane(abtable);
			        scrollPane.setViewport(tmp.getViewport());
					inventory.change(search, searchID);
				}
					break;
				
			case "View Inventory":
				createFrame();
				contentPane.add(new JLabel("<html><font size=5><b>View Inventory</b></html>",JLabel.CENTER) , BorderLayout.NORTH);
		        scrollPane = new JScrollPane();
		        contentPane.add(scrollPane,BorderLayout.CENTER);
		        int size = inventory.getSize();
		        int num = 0;
		        boolean copy = false;
		        node temp = inventory.getFirst();
		        node temp2 = inventory.getFirst();
		        inventoryData = new String[size + 1][5];
		        while(temp != null && num < size) 
		        {
		            inventoryData[num][0] = temp.getCategory();
					inventoryData[num][1] = temp.getName();
		            inventoryData[num][2] = "" + temp.getPrice();
		            inventoryData[num][3] = "" + temp.getID();
		            inventoryData[num][4] = "" + temp.getQuantity();
		            temp = temp.getLink();
		            num++;
		        }
		        abtable = new JTable(inventoryData, columnName);
		        tmp = new JScrollPane(abtable);
		        scrollPane.setViewport(tmp.getViewport());
		        JPanel menu = new JPanel();
		        menu.add(B = new JButton("Top Menu"));
		        B.addActionListener(AL);
		        contentPane.add(menu,BorderLayout.SOUTH);
		        num = 1;
		        holder[0] = "none";
		        while(temp2 != null)
		        {
		        	for(int l = 1; l < num; l++)
		        	{
		        		if(holder[l].equalsIgnoreCase(temp2.getCategory().trim()))
		        		copy = true;
		        	}
		        	if(copy == false)
		        	{
		        		holder[num] = temp2.getCategory();
		        		num++;
		        	}
		        	temp2 = temp2.getLink();
		        	copy = false;
		        	categoryNum = num;
		        	category = new String[categoryNum];
		        }
		        for(int w = 0; w < num; w++)
		        {
		        	category[w] = holder[w];
		        }
		        
		        viewCategory = new JComboBox<>(category);
		        viewCategory.addItemListener(IL);
		        JPanel categoryLayout = new JPanel(new FlowLayout());
		        categoryLayout.add(viewCategory);
		        contentPane.add(categoryLayout, BorderLayout.WEST);
				break;
				
				
			case "Close":
				frm3.dispose();
				break;
			
			case "Top Menu":
				search = null;
				frm2.dispose();
				frm.setVisible(true);
				break;
			
			case "Exit":
				System.exit(0);
				break;
						

		}
	}
	
	public void itemStateChanged(ItemEvent f)
	{
		if(f.getSource() == viewCategory)
		{
			int size = inventory.getSize();
			int num = 0;
			node temp = inventory.getFirst();
			String check = "";
			check = "" + viewCategory.getSelectedItem();
			if(check.equalsIgnoreCase("none"))
			{
				abtable = new JTable(inventoryData, columnName);
		        tmp = new JScrollPane(abtable);
		        scrollPane.setViewport(tmp.getViewport());
			}
			else
			{
				categoryData = new String[size + 1][5];
				while(temp != null && num < size) 
		        {
					if(check.equalsIgnoreCase(temp.getCategory().trim()))
					{
						categoryData[num][0] = temp.getCategory();
						categoryData[num][1] = temp.getName();
						categoryData[num][2] = "" + temp.getPrice();
						categoryData[num][3] = "" + temp.getID();
						categoryData[num][4] = "" + temp.getQuantity();
						num++;
					}
		            temp = temp.getLink();
		        }
				 abtable = new JTable(categoryData, columnName);
			     tmp = new JScrollPane(abtable);
			     scrollPane.setViewport(tmp.getViewport());
			}
		}
	}
	
	//creates an error screen based on invalid user input
	public void checkError(boolean priceError, boolean idError, boolean quantityError)
	{
		//frm.setVisible(false);
        frm3 = new JFrame("Inventory Management");
		contentPane = frm3.getContentPane();
		contentPane.setLayout(new BorderLayout());
		frm3.pack();
		frm3.setSize(900,500);
		frm3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm3.setVisible(true);
		contentPane.add(new JLabel("<html><font size=5><b>Error</b></html>",JLabel.CENTER) , BorderLayout.NORTH);
		JPanel make = new JPanel(new GridLayout(6,1));
		contentPane.add(make);
		JPanel make2 = new JPanel(new GridLayout(1,3));
		make2.add(B = new JButton ("Close"));
		B.addActionListener(AL);
		contentPane.add(make2, BorderLayout.SOUTH);
		if(priceError == true)
		{
			make.add(new JLabel("<html><font size=5><b>Please input a valid price</b></html>"));
		}
		if(idError == true)
		{
			make.add(new JLabel("<html><font size=5><b>Please input a valid id #</b></html>"));
		}
		if(quantityError == true)
		{
			make.add(new JLabel("<html><font size=5><b>Please input a valid quantity</b></html>"));
		}
	}
}

