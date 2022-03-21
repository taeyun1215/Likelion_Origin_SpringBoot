package LikeLion7.weeks1.repository;

import LikeLion7.weeks1.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
    //CrudRepository는 첫번째로 테이블을 받고, 두번째는 인덱스 번호를 받음
}
