package com.example.demo;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SeleniumPlaygroundPage {

    public SelenideElement simpleFormDemo = $x("//a[contains(text(),'Simple Form Demo')]");
    public SelenideElement enterMessageTextBox = $x("//input[@id='user-message']");
    public SelenideElement getCheckedCTA = $x("//button[@id='showInput']");
    public SelenideElement message = $x("//p[@id='message']");


    public SelenideElement dragAndDrop =$(By.linkText("Drag & Drop Sliders"));
    public SelenideElement dragMe = $(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/input[1]"));
    public SelenideElement rangeSuccess = $(By.cssSelector("#rangeSuccess"));


    public SelenideElement inputFormSubmit =$(By.linkText("Input Form Submit"));
    public SelenideElement submitButton = $(By.xpath("//button[contains(text(),'Submit')]"));
    public SelenideElement name = $(By.cssSelector("#name"));
    public SelenideElement email = $(By.cssSelector("#inputEmail4"));
    public SelenideElement password = $(By.cssSelector("#inputPassword4"));
    public SelenideElement company = $(By.cssSelector("#company"));
    public SelenideElement website = $(By.cssSelector("#websitename"));
    public SelenideElement country = $(By.tagName("select"));
    public SelenideElement city = $(By.cssSelector("#inputCity"));
    public SelenideElement address1 = $(By.cssSelector("#inputAddress1"));
    public SelenideElement address2 = $(By.cssSelector("#inputAddress2"));
    public SelenideElement state = $(By.cssSelector("#inputState"));
    public SelenideElement zip = $(By.cssSelector("#inputZip"));
    public SelenideElement hiddenMessage = $(By.xpath("//p[@class='success-msg hidden']"));
}
