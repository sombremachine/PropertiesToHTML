package myPackage.dao;

import myPackage.bean.User;
import org.apache.log4j.helpers.LogLog;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static myPackage.bean.UserUtils.getTestUser;
import static org.assertj.core.api.Assertions.assertThat;

@Ignore
public class DaoTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @BeforeClass
    public static void disableLogging(){
        LogLog.setQuietMode(true);
    }

    @Test
    public void testFileNotFound(){
        String fileName = "./nofile.properties";
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Файл " + fileName + " не найден");
        UserDAOFactory.getUserDAO(fileName).getUserData();
    }

    @Test
    public void testNoFileName(){
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Не задано имя входного файла.");
        UserDAOFactory.getUserDAO(null).getUserData();
    }

    @Test
    public void testIniFile(){
        String fileName = "./nofile.ini";
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Поддержка ini файлов еще не реализована.");
        UserDAOFactory.getUserDAO(fileName).getUserData();
    }


    @Test
    public void testUnknownFile(){
        String fileName = "./nofile.exe";
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Неизвестный формат файла.");
        UserDAOFactory.getUserDAO(fileName).getUserData();
    }

    @Test
    public void testValidFile(){
        User actual = UserDAOFactory.getUserDAO(this.getClass().getResource("/test_data.properties").getFile()).getUserData();
        assertThat(actual).isEqualToComparingFieldByField(getTestUser());
    }
}
