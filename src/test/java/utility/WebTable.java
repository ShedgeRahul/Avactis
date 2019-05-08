package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

public class WebTable 
{
	private WebElement webTable;
    //WebTable table = new WebTable(driver.findElement(By.id("users"))
	//Select make = new Select(driver.findElement(By.id("make"))
	public WebTable(WebElement webTable) {
		  String tagName = webTable.getTagName();

		    if (null == tagName || !"table".equals(tagName.toLowerCase())) {
		      throw new UnexpectedTagNameException("table", tagName);
		    }

		    this.webTable = webTable;

		
		//this.webTable = webTable;
	//	this.webTable = webTable.findElement(By.tagName("tbody"));
	}

	public WebElement get_webTable() {
		return webTable;
	}

	public void set_webTable(WebElement webTable) {
		this.webTable = webTable;
	}
	
	public List<WebElement> getAllDataRows() {		
		return webTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));		
	}

	public int getRowCount() {
	    List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
	    return tableRows.size();
	}
	
	public int getDataRowCount() {
	    WebElement tbody = webTable.findElement(By.tagName("tbody"));
	    List<WebElement> dataRows = tbody.findElements(By.tagName("tr"));
	    return dataRows.size();
	}
	
	public int getColumnCount() {
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		WebElement headerRow = tableRows.get(0);
		List<WebElement> tableCols = headerRow.findElements(By.tagName("td"));
		return tableCols.size();
	}
	
	
	//table.getCellData(2,2)
	public String getCellData(int rowIdx, int colIdx) {
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		WebElement currentRow = tableRows.get(rowIdx-1);
		List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
		WebElement cell = tableCols.get(colIdx-1);
		return cell.getText();		
	}


}
