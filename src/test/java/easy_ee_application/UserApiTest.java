package easy_ee_application;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.vsamarin.easy_ee_application.dto.UserDto;
import ru.vsamarin.easy_ee_application.rest.UserApi;
import ru.vsamarin.easy_ee_application.rest.client.LoggingFilter;
import ru.vsamarin.easy_ee_application.rest.exception.EntityNotFoundException;

import java.util.List;

@Ignore
public class UserApiTest {

    @Test
    public void create() throws EntityNotFoundException {
        UserApi proxy = getUserApiProxy();

        UserDto dto = new UserDto();
        dto.setName("Самарин Владислав Сергеевич");
        dto.setLogin("vsamarin");
        dto.setPassword("123456");
        Long id = proxy.create(dto);
        Assert.assertNotNull(id);

        UserDto responseDto = proxy.getById(id);
        Assert.assertEquals(dto.getName(), responseDto.getName());
        Assert.assertEquals(dto.getLogin(), responseDto.getLogin());
    }

    @Test
    public void list() {
        UserApi proxy = getUserApiProxy();
        List<UserDto> dtoList = proxy.list();
        dtoList.forEach(dto -> System.out.println(dto.getLogin()));
    }

    private UserApi getUserApiProxy() {
        final String apiUri = "http://localhost:8080/application/rest/";
        ResteasyClient client = new ResteasyClientBuilder()
                .register(new LoggingFilter())
                .build();
        ResteasyWebTarget target = client.target(apiUri);
        return target.proxy(UserApi.class);
    }

}
