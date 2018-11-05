package controller;

import bean.User;
import model.Model;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import view.View;

import static bean.UserUtils.getTestUser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControllerTest {

    @Mock
    Model model;

    @Mock
    View view;

    @Test
    public void testController(){
        // Тут например протестируем, что контроллер передает данные из Model во View без изменений
        User user = getTestUser();
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);

//        user.setLastName("sd");

        model = mock(Model.class);
        when(model.getModelData()).thenReturn(user);

        view = mock(View.class);

        Controller controller = new ControllerImpl();
        controller.setView(view);
        controller.setModel(model);
        controller.generateHTML();

        verify(view).update(argument.capture());

        assertThat(argument.getValue()).isEqualToComparingFieldByField(getTestUser());
    }

}
