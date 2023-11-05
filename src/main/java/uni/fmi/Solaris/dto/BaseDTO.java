package uni.fmi.Solaris.dto;

import lombok.Getter;
import lombok.Setter;
import uni.fmi.Solaris.models.MainModel;
@Getter
@Setter
public abstract class BaseDTO<U extends MainModel> {

    private long id;

    public BaseDTO(U entity) {
        convertToDTO(entity);
    }

    public abstract BaseDTO<U> convertToDTO(U entity);

}
