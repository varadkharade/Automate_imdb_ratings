package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        // Navigate to Url  https://www.imdb.com/chart/top
        driver.get("https://www.imdb.com/chart/top");

        //Find and create Select object for sort by dropdown  Using Locator "XPath" //select[@id='sort-by-selector']
        WebElement sortdropdown = driver.findElement(By.xpath("//select[@id='sort-by-selector']"));
        Select sort = new Select(sortdropdown);
        
        // Select IMDb rating  Using Locator "Link Text" selectByVisibleText(String "IMDb rating")
        sort.selectByVisibleText("IMDb rating");
        Thread.sleep(2000);
        
        // Store names of listed movies in List Using Locator "XPath" selectByVisibleText(String "IMDb rating"
        List<WebElement> ImbdSort = driver.findElements(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//a"));
        
        // Print first name  using sysout("highest rated movie on IMDb is "get(0);
        String highRated = ImbdSort.get(0).getText();
        System.out.println("\nHighest rated movie on IMDb is "+highRated);
        
        // Print How many movies are included in the table?  using sysout("How many movies are included in the table?"getsize();
        System.out.println("Total Number of Movies in Table are: "+Integer.toString(ImbdSort.size()));
        
        // Select Release date  in sort  selectByVisibleText(String "Release dateg")
        sort.selectByVisibleText("Release date");
        Thread.sleep(2000);
        
        // Store names of listed movies in List Using Locator "XPath" //a/h3
        List<WebElement> Releasedt = driver.findElements(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//a"));
        
        // Print last name  using sysout("What is the oldest movie on the list?"+get(getsize());
        System.out.println("Oldest Movie in table is :"+Releasedt.get(Releasedt.size()-1).getText());
       
        // Print first name   using sysout(What is the most recent movie on the list?)+get(0)
        System.out.println("Most Recent movie on the List is :"+Releasedt.get(0).getText());
       
        // Select Number of ratings  selectByVisibleText(String "Number of ratings")
        sort.selectByVisibleText("Number of ratings");
       
        // Store names of listed movies in List Using Locator "XPath" //a/h3
        List<WebElement> rating = driver.findElements(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//a"));
       
        // Print first name  using sysout("Which movie has the most user ratings? "get(0);)
        System.out.println("Movie with the most user Rating is "+rating.get(0).getText());
        
        System.out.println("\nend Test case: testCase02");
    }


}
