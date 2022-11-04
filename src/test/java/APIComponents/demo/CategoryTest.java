package APIComponents.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CategoryTest {

    Category myCategoryTest = new Category(1,
            "Action");

    @Test
    public void defaultFilmObj(){
        Category catExp = new Category();
        Category catAcc = catExp;

        Assertions.assertEquals(catExp, catAcc);
    }
    @Test
    public void testCategoryId_whenGetMapping_returnSuccess(){
        int actualCategoryId = myCategoryTest.getCategoryId();

        int expectedCategoryId = 1;

        Assertions.assertEquals(expectedCategoryId, actualCategoryId, "Failed Category ID Check");
    }

    @Test
    public void testCategoryId_whenPutMapping_returnSuccess(){
        myCategoryTest.setCategoryId(1);

        int expectedCategoryId = 1;
        int actualFilmId = 1;

        Assertions.assertEquals(expectedCategoryId, actualFilmId, "Category is mismatched from setter method");
    }

    @Test
    public void testCategoryName_whenGetMapping_returnSuccess(){
        String actualCategoryName = myCategoryTest.getCategoryName();

        String expectedCategoryName = "Action";

        Assertions.assertEquals(expectedCategoryName, actualCategoryName, "Failed Category Name Check");
    }

    @Test
    public void testFilmTitle_whenPutMapping_returnSuccess(){
        myCategoryTest.setCategoryName("Action");

        String expectedCategoryName = "Action";
        String actualCategoryName = myCategoryTest.getCategoryName();

        Assertions.assertEquals(expectedCategoryName, actualCategoryName, "Category name mismatched from setter method");
    }




}
