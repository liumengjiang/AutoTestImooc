package com.lj.nice.testcase;

import com.lj.nice.base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCourseList extends CaseBase{
    public DriverBase driver;
    public TestCourseList() {
        this.driver=InitDriverBase("chrome");
    }

    @Test
    public void CourseList(){
        driver.get("http://coding.imooc.com/");

        List<String> listString = this.listElement();
        for(int i=0;i<listString.size();i++){
            //driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")).click();
//          用selenium模拟用户单击元素时，JS有一个操作鼠标悬浮的时候会对元素进行修改
//          解决办法：用JS来操作元素
            //点击关键文本下的课程用js操作,如果直接用//driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")).click();
            //会报错,因为用selenium模拟用户单击元素时，JS有一个操作鼠标悬浮的时候会对元素进行修改
//          解决办法：用JS来操作元素
            JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
            js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            driver.back();
        }
    }

    /*
     * 获取所有的课程List
     *
     * */
    public List<String> listElement(){
        List<String> listString=new ArrayList<String>();
        // 拿到实战中的列表集合元素
        WebElement element = driver.findElement(By.className("shizhan-course-list"));
        // 拿到实战课程的元素的集合
        List<WebElement> courseList = element.findElements(By.className("shizhan-intro-box"));
        for (WebElement element2 : courseList) {
            //得到每个课程的关键信息文本并且放入集合中
            listString.add(element2.findElement(By.className("shizan-desc")).getText());
            System.out.println(element2.findElement(By.className("shizan-name")).getText());
        }
        return listString;
    }


}

