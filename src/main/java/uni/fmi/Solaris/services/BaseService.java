package uni.fmi.Solaris.services;

import org.springframework.data.jpa.repository.JpaRepository;
import uni.fmi.Solaris.dto.BaseDTO;
import uni.fmi.Solaris.models.MainModel;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseService<U extends MainModel> {

    protected abstract JpaRepository<U,Long> getRepo();
    public List<BaseDTO<U>> getAll() {
        List<U> categories = getRepo().findAll();

        return categories
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
	public Optional<U> getById(Long id){
		return getRepo().findById(id);
	}


    public BaseDTO<U> getBy(Long id) {
        Optional<U> entity = getRepo().findById(id);
        //Category byId = categoryRepo.getById(id);
        final BaseDTO<U> result;
        if (entity.isPresent()) {
            result = convert(entity.get());
        } else {
            result = null;
        }

        return result;
    }

    public Optional<U> getEntity(Long id){
        return getRepo().findById(id);
    }

    public BaseDTO<U> create(BaseDTO<U> baseDTO){
        U entity = convertDTOtoModel(baseDTO);
		entity.setCreatedAt(LocalDateTime.now());
        U savedEntity = getRepo().save(entity);

        return convert(savedEntity);
    }

    protected abstract U convertDTOtoModel(BaseDTO<U> baseDTO);

    public BaseDTO<U> update(BaseDTO<U> dto){
        long id = dto.getId();
        Optional<U> optionalEntity = getRepo().findById(id);
        if(optionalEntity.isPresent()){
            U entity = optionalEntity.get();
			entity.setUpdatedAt(LocalDateTime.now());
            updateEntity(entity, dto);
            return convert(getRepo().save(entity));
        }
        return null;
    }

    protected abstract void updateEntity(U entity, BaseDTO<U> categoryDTO);


    public boolean remove(long id) {
        Optional<U> optionalCategory = getRepo().findById(id);
        if(optionalCategory.isPresent()){
            getRepo().delete(optionalCategory.get());
            return true;
        }
        return false;
    }

    protected abstract BaseDTO<U> convert(U entity);
}
