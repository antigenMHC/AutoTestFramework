package cn.antigenmhc.test.extentx;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Locale;
import java.util.ResourceBundle;

public class ExtentManager {
    private static ExtentReports extent;
    private static BaseInfo baseInfo;

    public static ExtentReports getInstance(String filePath) {
        if (extent == null) {
            createInstance(filePath);
        }
        return extent;
    }

    public static void createInstance(String filePath) {
        baseInfo = new BaseInfo();

        extent = new ExtentReports();
        extent.setSystemInfo("os", System.getProperty("os.name"));
        extent.attachReporter(createHtmlReporter(filePath), createExtentxReporter());
    }

    public static ExtentHtmlReporter createHtmlReporter(String filePath){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
        //报表位置
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        //使报表上的图表可见
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(filePath);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("测试报告");
        return htmlReporter;
    }

    public static ExtentXReporter createExtentxReporter() {
        ExtentXReporter extentx = new ExtentXReporter(baseInfo.getMongoHost(), baseInfo.getMongoPort());
        extentx.config().setProjectName(baseInfo.getProjectName());
        extentx.config().setReportName(baseInfo.getReportName());
        extentx.config().setServerUrl(baseInfo.getServerUrl());
        return extentx;
    }
}


class BaseInfo {
    private String serverUrl;
    private String mongoHost;
    private int mongoPort;
    private String projectName;
    private String reportName;

    public BaseInfo() {
        ResourceBundle bundle = ResourceBundle.getBundle("properties/extentx", Locale.CHINA);
        serverUrl = bundle.getString("server.url");
        String mongoUrl = bundle.getString("mongodb.url");
        mongoHost = mongoUrl.split(":")[0];
        mongoPort = Integer.parseInt(mongoUrl.split(":")[1]);
        projectName = bundle.getString("projectName");
        reportName = bundle.getString("reportName");
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public String getMongoHost() {
        return mongoHost;
    }

    public int getMongoPort() {
        return mongoPort;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getReportName() {
        return reportName;
    }
}