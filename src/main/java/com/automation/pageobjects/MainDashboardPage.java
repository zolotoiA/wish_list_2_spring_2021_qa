package com.automation.pageobjects;

import com.automation.components.CardComponent;
import com.automation.components.EditFormComponent;
import com.automation.components.NewWishlistFormComponent;
import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

@Getter
public class MainDashboardPage extends AbstractPage {
    private EditFormComponent editFormComponent;
    private NewWishlistFormComponent newWishlistFormComponent;
    private List<CardComponent> listOfCardItems;

    @FindBy(className = "primary-btn")
    private WebElement newWishlistButton;

    public MainDashboardPage(WebDriver driver) {
        super(driver);
    }

    public CardComponent getExistingWishlistByTitle(String wishlistTitle) {
        return listOfCardItems.stream()
                .filter(e -> e.getItemCardTitle().equals(wishlistTitle))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No such wishlist card found"));
    }

    public int cardsQuantity() {
        int i = 0;
        for (CardComponent card : listOfCardItems) {
            i++;
        }
        return i;
    }
}
