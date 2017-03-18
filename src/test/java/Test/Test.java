package Test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pkgLibrary.Book;
import pkgLibrary.BookException;
import pkgLibrary.Catalog;


public class Test {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void GetBook_1(){
		Catalog cat = null;
		Book b_1 = new Book("b1");
		assertTrue(cat.getBook("b1").getId().equals(cat.getId()));
	}
	
	@Test
	public void GetBook_2(){
		Catalog cat = null;
		Book b_2 = new Book("b2");
		assertNotEquals(cat.getBook("b3"),cat);
	}
	
	@Test
	public void AddBook_1(){
		Catalog cat = ReadXMLFile();
		Book b = new Book("b6", "1", "2", "3", 10.00, 20.00, new Date(), "123");
		cat.addBook("b6",b);
		assertTrue((b.getBook("b6") != null) && (b.getBook("b6").getId().equals(b.getId())));
	}

	@Test
	public void AddBook_2(){
		Catalog cat = ReadXMLFile();
		Book b = new Book("b6", "1", "2", "3", 10.00, 20.00, new Date(), "123");
		cat.addBook("b6",b);
		assertFalse((b.getBook("b9") != null) && (b.getBook("b9").equals(b)));
	
	
	
	private static Catalog ReadXMLFile() {

		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return cat;

	}
}
