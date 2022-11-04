package APIComponents.demo;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.jupiter.api.Assertions;

public class CategoryTest {

    Category myCategoryTest = new Category(1,
            "Action");

    @Test
    public void testCategoryId_whenGetMapping_returnSuccess(){
        int actualCategoryId = myCategoryTest.getCategoryId();

        int expectedCategoryId = 1;

        Assertions.assertEquals(expectedCategoryId, actualCategoryId);
    }

    @Test
    public void testCategoryName_whenGetMapping_returnSuccess(){
        String actualCategoryName = myCategoryTest.getCategoryName();

        String expectedCategoryName = "Action";

        Assertions.assertEquals(expectedCategoryName, actualCategoryName);
    }

}
