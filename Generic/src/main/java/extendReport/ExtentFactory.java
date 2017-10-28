package extendReport;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {

    public static ExtentReports getInstance(String pathForReport){
        ExtentReports extentReports;
        String path = pathForReport+".html";
        extentReports = new ExtentReports(path,true);
        extentReports.addSystemInfo("host","md m hossain").addSystemInfo("enviornMent","QA").addSystemInfo("frameWork","hyBrid");
        return extentReports;
    }
}


