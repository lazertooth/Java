package SheetPackageTest;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;
import com.google.api.services.sheets.v4.Sheets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SheetsQuickstart {
    private static final String APPLICATION_NAME = "CSC131";
    private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"), ".credentials//sheets.googleapis.com-java-quickstart.json");
    private static FileDataStoreFactory DATA_STORE_FACTORY;
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static HttpTransport HTTP_TRANSPORT;
    private static final List<String> SCOPES = Arrays.asList( SheetsScopes.SPREADSHEETS );
    private static String spreadsheetId = "1HEkPX-wEowUAOSH3rAzwLOndnAMZ_WsCkxR_aonbyu8";
    
    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    public static Credential authorize() throws IOException {
        InputStream in = new FileInputStream("C:\\Users\\p-chandra\\Documents\\Workspace\\GoogleSheetTester\\src\\main\\resources\\client_secret.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    public static Sheets getSheetsService() throws IOException {
        Credential credential = authorize();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
    
    

    /********************* Checks if ID is in file  *****************/
    public static void inputComment(int col, String Comment, String ID)throws IOException{
    	Sheets service = getSheetsService();
    	final String range = "C2:C26";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> element = response.getValues();
        int cellRow = 0;
        for (List row : element) {
        	cellRow++;
        	if(ID.equals(row.get(0))){
        		printInfo(cellRow,col,Comment);
        		break;
        	}			
        } 
    }
    
    
    
    
    /********************* Checks if the ID matches *****************/
    public static boolean checkID(String ID)throws IOException{
    	Sheets service = getSheetsService();
    	final String range = "C2:C26";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> element = response.getValues();
        if(element == null || element.isEmpty())
            System.out.println("No data found.");
        else{
        	for (List row : element) {
        		if (ID.equals(row.get(0)))
        			return true;
        	}
        }
        return false;
    }
    
    
    /********************* Checks if the key matches *****************/
    public static boolean checkKey(int col,String Key)throws IOException{
    	Sheets service = getSheetsService();
    	final String range = "G32:P32";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> element = response.getValues();
        System.out.println(col);
        if(element == null || element.isEmpty())
            System.out.println("No data found.");
        else{
        	for (List row : element) {
        		if (Key.equals(row.get(col)))
        			return true;
        	}
        }
        return false;
    }
    
    /********************* Gets the dates col number *****************/
    public static int getCol() throws IOException{
    	Sheets service = getSheetsService();
    	List<Request> requests = new ArrayList<>();
        int count = 0;
        int cellRow = 0;
    	final String range = "G1:P1";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> element = response.getValues();
        if(element == null)
        	return 0;
        else {
        	for (List row : element) {
        		return row.size();
        	}
        } 
        
        return -1;
    }
    
    /********************* Enters date upon start of the server *****************/
    public static void inputDate(String Date)throws IOException{
    	Sheets service = getSheetsService();
    	List<Request> requests = new ArrayList<>();
        int count = 0;
        int cellRow = 0;
    	final String range = "G1:P1";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> element = response.getValues();
        if(element == null)
        	printInfo(cellRow,0,Date);
        else {
        	for (List row : element) {
        		printInfo(cellRow, row.size(),Date);
        	}
        }        
    }
    
    /********************* Stores the size of key row *****************/
    public static void inputKey(int col, String randKey)throws IOException, NullPointerException{
    	Sheets service = getSheetsService();
    	List<Request> requests = new ArrayList<>();
        int count = 0;
        int cellRow = 31;
    	final String range = "G32:P32";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> element = response.getValues();
        if(element == null)
        	printInfo(cellRow, 0,randKey);
        else {
        	for (List row : element) {
        		printInfo(cellRow, col,randKey);
        	}
        }  
    }
    
    
    /********************* Prints everything *****************/
    public static void printInfo(int row, int count, String Date) throws IOException{
    	Sheets service = getSheetsService();
    	List<Request> requests = new ArrayList<>();
        
    	List<CellData> values = new ArrayList<>();
 		values.add(new CellData().setUserEnteredValue(new ExtendedValue().setStringValue((Date))));
    	requests.add(new Request()
    		.setUpdateCells(new UpdateCellsRequest()
            .setStart(new GridCoordinate().setSheetId(0).setRowIndex(row).setColumnIndex(count+6))
            .setRows(Arrays.asList(new RowData().setValues(values)))
            .setFields("userEnteredValue,userEnteredFormat.backgroundColor")));     
    	BatchUpdateSpreadsheetRequest batchUpdateRequest = new BatchUpdateSpreadsheetRequest().setRequests(requests);
    	service.spreadsheets().batchUpdate(spreadsheetId, batchUpdateRequest).execute();
    }
    
    
   
    public static void updateSheet(String Date)throws IOException{
    }
    
    
    public static void main(String[] args) throws IOException {
           	
    }
}
