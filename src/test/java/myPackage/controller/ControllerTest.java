package myPackage.controller;

import myPackage.bean.User;
import myPackage.model.MyModel;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import myPackage.view.View;

import static myPackage.bean.UserUtils.getTestUser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@Ignore
public class ControllerTest {

    @Mock
    MyModel myModel;

    @Mock
    View view;

    @Test
    public void testController(){
        // Тут например протестируем, что контроллер передает данные из MyModel во View без изменений
        User user = getTestUser();
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);

//        user.setLastName("sd");

        myModel = mock(MyModel.class);
        when(myModel.getModelData()).thenReturn(user);

        view = mock(View.class);

        MyController myController = new ControllerImpl();
        myController.setView(view);
        myController.setMyModel(myModel);
        myController.generateHTML();

        verify(view).update(argument.capture());

        assertThat(argument.getValue()).isEqualToComparingFieldByField(getTestUser());
    }

}
