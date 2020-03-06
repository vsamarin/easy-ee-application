package easy_ee_application;

import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import ru.vsamarin.easy_ee_application.dto.UserDto;
import ru.vsamarin.easy_ee_application.entity.UserEntity;
import ru.vsamarin.easy_ee_application.mapstruct.UserMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserMapperTest {
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    public void toDto() {
        UserEntity entity = new UserEntity();
        entity.setId(1L);
        entity.setName("Самарин Владислав Сергеевич");
        entity.setName("vsamarin");
        entity.setPassword("123456");
        entity.setVersion(1L);
        UserDto dto = userMapper.toDto(entity);
        Assert.assertEquals(entity.getId(), dto.getId());
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getLogin(), dto.getLogin());
        Assert.assertEquals(null, dto.getPassword());
        Assert.assertEquals(entity.getVersion(), dto.getVersion());
    }

    @Test
    public void toDtoList() {
        UserEntity entity1 = new UserEntity();
        entity1.setId(1L);
        entity1.setName("Самарин Владислав Сергеевич");
        entity1.setName("vsamarin");
        entity1.setPassword("123456");
        entity1.setVersion(1L);

        UserEntity entity2 = new UserEntity();
        entity2.setId(2L);
        entity2.setName("Иванов Иван Иванович");
        entity2.setName("iivanov");
        entity2.setPassword("654321");
        entity2.setVersion(1L);

        List<UserEntity> entityList = new ArrayList<UserEntity>() {{
            add(entity1);
            add(entity2);
        }};

        List<UserDto> dtoList = userMapper.toDto(entityList);

        Assert.assertEquals(entityList.size(), dtoList.size());
        entityList.forEach(entity -> dtoList.forEach(dto -> {
            Assert.assertNotNull(entity.getId());
            Assert.assertNotNull(dto.getId());
            if (Objects.equals(entity.getId(), dto.getId())) {
                Assert.assertEquals(entity.getId(), dto.getId());
                Assert.assertEquals(entity.getName(), dto.getName());
                Assert.assertEquals(entity.getLogin(), dto.getLogin());
                Assert.assertEquals(null, dto.getPassword());
                Assert.assertEquals(entity.getVersion(), dto.getVersion());
            }
        }));
    }

    @Test
    public void toEntityList() {
        UserDto dto1 = new UserDto();
        dto1.setId(1L);
        dto1.setName("Самарин Владислав Сергеевич");
        dto1.setName("vsamarin");
        dto1.setPassword("123456");
        dto1.setVersion(1L);

        UserDto dto2 = new UserDto();
        dto2.setId(2L);
        dto2.setName("Иванов Иван Иванович");
        dto2.setName("iivanov");
        dto2.setPassword("654321");
        dto2.setVersion(1L);

        List<UserDto> dtoList = new ArrayList<UserDto>() {{
            add(dto1);
            add(dto2);
        }};

        List<UserEntity> entityList = userMapper.toEntity(dtoList);

        Assert.assertEquals(dtoList.size(), entityList.size());
        dtoList.forEach(dto -> entityList.forEach(entity -> {
            Assert.assertNotNull(dto.getId());
            Assert.assertNotNull(entity.getId());
            if (Objects.equals(dto.getId(), entity.getId())) {
                Assert.assertEquals(dto.getId(), entity.getId());
                Assert.assertEquals(dto.getName(), entity.getName());
                Assert.assertEquals(dto.getLogin(), entity.getLogin());
                Assert.assertEquals(dto.getPassword(), entity.getPassword());
                Assert.assertEquals(dto.getVersion(), entity.getVersion());
            }
        }));
    }

    @Test
    public void toEntity() {
        UserDto dto = new UserDto();
        dto.setId(1L);
        dto.setName("Самарин Владислав Сергеевич");
        dto.setName("vsamarin");
        dto.setPassword("123456");
        dto.setVersion(1L);
        UserEntity entity = userMapper.toEntity(dto);
        Assert.assertEquals(entity.getId(), dto.getId());
        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getLogin(), entity.getLogin());
        Assert.assertEquals(dto.getPassword(), entity.getPassword());
        Assert.assertEquals(dto.getVersion(), entity.getVersion());
    }

}
