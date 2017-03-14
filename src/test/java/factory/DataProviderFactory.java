package factory;

import dataprovider.configDataProvider;
import dataprovider.excelDataProvider;

public class DataProviderFactory {

	public static configDataProvider getConfig()
	{
		configDataProvider config=new configDataProvider();
		return config;
	}
	
	public static excelDataProvider getexcel()
	{
		excelDataProvider config=new excelDataProvider();
		return config;
	}
	
}
