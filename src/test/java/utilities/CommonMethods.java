package utilities;

import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class CommonMethods  {

    public static WebDriver driver;
    private static PropertyLoader propertyLoader = new PropertyLoader();

//    public static WebDriver getDriver(){
//        return appHooks.getDriver();
//    }
    public static void enterUrl(String url) {
        driver.get(url);
    }
    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static void getURL(){
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Please check Hooks setup.");
        }
        String url = propertyLoader.getProperty("LMSUrl"); // Retrieve the URL from properties
        driver.get(url); // Open the URL
    }

    public static String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String elementGetText(WebElement element) {
        String text = element.getText();
        return text;
    }

    public static void elementClick(WebElement element) {
        element.click();
    }

    public static void elementSendkeysEnter(WebElement element, String data) {
        element.sendKeys(data, Keys.ENTER);
    }

    public static void elementSendkeys(WebElement element,String data) {
        element.sendKeys(data);
    }

    public static String getActiveElementAttribute(WebDriver driver) {
        WebElement activeElement = driver.switchTo().activeElement();
        String message = activeElement.getAttribute("validationMessage");
        System.out.println("Actual message appeared on the screen is: " + message);
        return message;
    }

    public static String getAttributeValue(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public static String getPlaceholderValue(WebElement element) {
        return getAttributeValue(element, "placeholder");
    }
    public static boolean isElementPresent(WebElement element) {
        try {
            boolean isPresent = element.isDisplayed();
            return isPresent;
        } catch (NoSuchElementException e) {
            return false;
        }

    }
    /*
    public static void getURL(String url){
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Please check Hooks setup.");
        }
        String invalidURL = propertyLoader.getProperty("LMSUrl2"); // Retrieve the URL from properties
        driver.get(url); // Open the URL
    }

     */


    public static void retriveStatusCode(Integer expectedStatusCode) {
        try {
            // Assuming you want to check the page being tested
            String currentUrl = driver.getCurrentUrl();
            URL url = new URL(currentUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            Assert.assertEquals(responseCode, expectedStatusCode.intValue(),
                    "Expected HTTP status code 404, but got: " + responseCode);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An error occurred while checking the HTTP status code: " + e.getMessage());
        }
    }

    public static void findBrokenLink(WebDriver driver, WebElement element, Integer elt) throws IOException {
        List<WebElement>  links = driver.findElements(By.tagName("a"));
//        System.out.println("Total number of links: " + links.size());

        for(WebElement linkElement : links){
            String hrefattValue = linkElement.getAttribute("href");

            //converting string into url format to hit the server
            URL linkURL = new URL(hrefattValue);
            //open connection to the server
            HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
            //connect to server and sent request to the server
            conn.connect();

            if(conn.getResponseCode()>=400){
                System.out.println(hrefattValue + "===> Broken link");
            }
            else {
                System.out.println("not a broken link");
            }

        }
    }
        }
